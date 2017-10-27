package com.example.xxsj.yuekaodemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xxsj.yuekaodemo.adapter.MyPageAdapter;

/**
 * Created by xxsj on 2017/10/25.
 */

public class ViewActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initview();
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        //关联
        tabLayout.setupWithViewPager(viewPager);
    }

    public void initview() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }
}
