package com.example.xxsj.yuekaodemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayout;
import com.bawei.swiperefreshlayoutlibrary.SwipyRefreshLayoutDirection;
import com.example.xxsj.yuekaodemo.R;
import com.example.xxsj.yuekaodemo.adapter.NewAdapter;
import com.example.xxsj.yuekaodemo.app.MyAppllication;
import com.example.xxsj.yuekaodemo.bean.NewnewsBean;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by xxsj on 2017/9/26.
 */

public class NewFragment extends Fragment {

    private View view;
    private Banner mybanner;
    private RecyclerView recyclerView;
    private Handler handler = null;
    private SwipyRefreshLayout srl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_new, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initview();
        ArrayList<String> imgs = new ArrayList<>();
        imgs.add("https://pic3.zhimg.com/v2-9c1568aa03ca151eea4a587ee51802ea.jpg");
        imgs.add("https://pic1.zhimg.com/v2-05dc0ad139f217f283875815bc5538a0.jpg");
        imgs.add("https://pic2.zhimg.com/v2-a4ebecc5f3ac7845805b2d17688db35d.jpg");
        imgs.add("https://pic1.zhimg.com/v2-31c7577a439db633b92b2be42caf1e64.jpg");
        imgs.add("https://pic1.zhimg.com/v2-ccd5abcab2fe67c945245e1e8781d550.jpg");
        //加载数据
        handler = new Handler();
        getData("http://news-at.zhihu.com/api/4/news/latest");
        //设置是否支持刷新和加载更多
        srl.setDirection(SwipyRefreshLayoutDirection.BOTH);
        srlflashData();
        mybanner.setImageLoader(new GlideImageLoader());//加载图片
        mybanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mybanner.setImages(imgs);
        mybanner.setDelayTime(1500);
        mybanner.isAutoPlay(true);
        mybanner.start();
    }

    private void getData(String url) {
        Request request = new Request.Builder()
                .url(url)
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
                            NewnewsBean newnewsBean = gson.fromJson(string, NewnewsBean.class);
                            List<NewnewsBean.StoriesBean> list = newnewsBean.getStories();
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                            recyclerView.setLayoutManager(linearLayoutManager);
                            NewAdapter newAdapter = new NewAdapter(getActivity(), list);
                            recyclerView.setAdapter(newAdapter);

                        }
                    });

                }
            }
        });
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)//让图片进行内存缓存
                    .cacheOnDisk(true)//让图片进行sdcard缓存
                    .showImageOnLoading(R.mipmap.ic_launcher)//图片正在加载的时候显示的图片
                    .build();
            com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage((String) path, imageView, options);
        }
    }

    //刷新  和  加载的方法
    private void srlflashData() {
        srl.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh(int index) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData("http://news-at.zhihu.com/api/4/news/before/20131119");
                        srl.setRefreshing(false);
                    }
                }, 2000);
            }

            @Override
            public void onLoad(int index) {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData("http://news-at.zhihu.com/api/4/news/before/20131119");
                        srl.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    //找控件
    private void initview() {

        mybanner = (Banner) view.findViewById(R.id.mybanner);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        srl = (SwipyRefreshLayout) view.findViewById(R.id.refresh);
    }

}



