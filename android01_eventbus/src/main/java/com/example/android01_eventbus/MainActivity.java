package com.example.android01_eventbus;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment_a());
        fragments.add(new Fragment_b());
        ArrayList<String> tit = new ArrayList<>();
        tit.add("A");
        tit.add("B");
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, tit);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);
    }
}
