package com.example.xxsj.yuekaodemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xxsj.yuekaodemo.R;
import com.example.xxsj.yuekaodemo.adapter.ZhutiAdapter;
import com.example.xxsj.yuekaodemo.app.MyAppllication;
import com.example.xxsj.yuekaodemo.bean.ZhutiBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xxsj on 2017/9/26.
 */

public class ZhutiFragment extends Fragment {
  private GridLayoutManager  gridLayoutManager;
    private ZhutiAdapter zhutiAdapter;
    private View view;
    private RecyclerView zhu_recyclerview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_zhuti, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initget();

    }
    private void initget() {
        Request request = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/themes")
                .build();
        MyAppllication.okHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String string = response.body().string();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            ZhutiBean zhutiBean = gson.fromJson(string, ZhutiBean.class);
                            List<ZhutiBean.OthersBean> list = zhutiBean.getOthers();
                           gridLayoutManager = new GridLayoutManager(getActivity(),2);
                            zhu_recyclerview.setLayoutManager(gridLayoutManager);
                            zhutiAdapter = new ZhutiAdapter(getActivity(), list);
                            zhu_recyclerview.setAdapter(zhutiAdapter);

                        }
                    });

                }
            }
        });
    }

    private void initView() {
        zhu_recyclerview = (RecyclerView) view.findViewById(R.id.zhu_recyclerview);
    }
}
