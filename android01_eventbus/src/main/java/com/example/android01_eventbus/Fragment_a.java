package com.example.android01_eventbus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class Fragment_a extends Fragment implements RlvAdapter.onClick {
    private View view;
    private RecyclerView mRlv;
ArrayList<Web>list=new ArrayList<>();
    private RlvAdapter rlvAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, null);
        initView(inflate);

        return inflate;
    }



    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        ArrayList<Web> students = new ArrayList<>();
        students.add(new Web("百度","https://www.baidu.com"));
        students.add(new Web("新浪","https://www.sina.com.cn"));
        students.add(new Web("微博","https://open.weibo.com"));
        rlvAdapter = new RlvAdapter(list, getActivity());
        mRlv.setAdapter(rlvAdapter);
        rlvAdapter.setOnClickListener(this);
    }


    @Override
    public void onClickListen(String url) {
        initData(url);
    }

    private void initData(String url) {
        EventBus.getDefault().postSticky(url);
    }
}
