package com.example.xxsj.yuekaodemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xxsj.yuekaodemo.adapter.XiangqingAdapter;
import com.example.xxsj.yuekaodemo.app.MyAppllication;
import com.example.xxsj.yuekaodemo.bean.XiangqingBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;


public class XiangqingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private XiangqingAdapter xiangqingAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_xiangqing);
        getData();
    }

    private void getData() {
        Request request = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/theme/11")
                .build();
        MyAppllication.okHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String string = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            XiangqingBean xiangqingBean = gson.fromJson(string, XiangqingBean.class);
                            List<XiangqingBean.StoriesBean> list = xiangqingBean.getStories();
                            linearLayoutManager = new LinearLayoutManager(XiangqingActivity.this);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            xiangqingAdapter = new XiangqingAdapter(list);
                            recyclerView.setAdapter(xiangqingAdapter);
                        }
                    });

                }
            }
        });
    }
}
