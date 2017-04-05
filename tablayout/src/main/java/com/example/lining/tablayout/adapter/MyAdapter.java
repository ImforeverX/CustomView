package com.example.lining.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lining.tablayout.activity.MainActivity;

import java.util.List;

/**
 * Created by 李宁 on 2017/2/17.
 */

public class MyAdapter extends FragmentPagerAdapter{
    FragmentManager fm;
    MainActivity mainActivity;
    List<Fragment> list;
    String[]  arr;
    public MyAdapter(FragmentManager fm, MainActivity mainActivity, List<Fragment> list, String[] arr) {
        super(fm);
    this.fm=fm;
        this.list=list;
        this.mainActivity=mainActivity;
    this.arr=arr;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
