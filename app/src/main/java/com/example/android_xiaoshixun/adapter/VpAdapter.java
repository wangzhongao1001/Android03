package com.example.android_xiaoshixun.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class VpAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment>flist;
    private ArrayList<String>tlist;

    public VpAdapter(FragmentManager fm, ArrayList<Fragment> flist, ArrayList<String> tlist) {
        super(fm);
        this.flist = flist;
        this.tlist = tlist;
    }

    @Override
    public Fragment getItem(int i) {
        return flist.get(i);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tlist.get(position);
    }
}
