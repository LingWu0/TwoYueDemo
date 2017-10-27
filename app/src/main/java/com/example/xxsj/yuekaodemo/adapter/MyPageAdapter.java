package com.example.xxsj.yuekaodemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.xxsj.yuekaodemo.fragment.HotFragment;
import com.example.xxsj.yuekaodemo.fragment.NewFragment;
import com.example.xxsj.yuekaodemo.fragment.ZhuanFragment;
import com.example.xxsj.yuekaodemo.fragment.ZhutiFragment;

import java.util.ArrayList;

/**
 * Created by xxsj on 2017/9/26.
 */

public class MyPageAdapter extends FragmentPagerAdapter {

    String[] titles = new String[]{"最新日报", "专栏", "热门", "主题日报"};

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        NewFragment newFragment = new NewFragment();
        ZhuanFragment zhuanFragment = new ZhuanFragment();
        HotFragment hotFragment = new HotFragment();
        ZhutiFragment zhutiFragment = new ZhutiFragment();
        //定义一个集合
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(newFragment);
        list.add(zhuanFragment);
        list.add(hotFragment);
        list.add(zhutiFragment);

        return list.get(position);
    }

    @Override
    public int getCount() {
        return titles == null ? 0 : titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
