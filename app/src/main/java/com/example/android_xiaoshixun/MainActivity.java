package com.example.android_xiaoshixun;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.android_xiaoshixun.adapter.VpAdapter;
import com.example.android_xiaoshixun.fragment.Fragment_A;
import com.example.android_xiaoshixun.fragment.Fragment_B;
import com.example.android_xiaoshixun.fragment.Fragment_C;
import com.example.android_xiaoshixun.serivce.DongTaiReceiver;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTool;
    private ViewPager mVp;
    private TabLayout mTab;
    private NavigationView mNv;
    private DongTaiReceiver dongTaiReceiver;
    private LocalBroadcastManager localBroadcastManager;
//王中澳 H1809A
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //动态广播  获取广播管理器
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        mNv = (NavigationView) findViewById(R.id.nv);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment_A());
        fragments.add(new Fragment_B());
        fragments.add(new Fragment_C());
        ArrayList<String> title = new ArrayList<>();
        title.add("A");
        title.add("B");
        title.add("C");
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, title);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.call:
                        callphone();
                        break;
                    case R.id.borad:
                        Intent intent1 = new Intent("dongtai");//action 需要与 onResume 方法中注册时的action一直
                        intent1.putExtra("item2","传送的动态内容");
                        localBroadcastManager.sendBroadcast(intent1);
                        break;
                    case R.id.pop:
                        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop, null, false);
                        final PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                        
                        break;
                }
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //动态注册  需要在此方法中注册
        dongTaiReceiver = new DongTaiReceiver();
        //获取意图
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("dongtai");
        localBroadcastManager.registerReceiver(dongTaiReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //动态注销  有注册就有注销
        localBroadcastManager.unregisterReceiver(dongTaiReceiver);
    }
    private void callphone() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"下载");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
