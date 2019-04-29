package com.example.android_xiaoshixun.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_xiaoshixun.R;
import com.example.android_xiaoshixun.adapter.RlvFaAdapter;
import com.example.android_xiaoshixun.bean.Bean;
import com.example.android_xiaoshixun.serivce.MySerivce;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_A extends Fragment {
    private View view;
    private RecyclerView mRlvFa;
    ArrayList<Bean.DataBean.DatasBean>list=new ArrayList<>();
    private RlvFaAdapter rlvFaAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, null);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MySerivce.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MySerivce mySerivce = retrofit.create(MySerivce.class);
        Observable<Bean> bean = mySerivce.getBean();
        bean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        list.addAll(bean.getData().getDatas());
                        rlvFaAdapter.setBlist(list);
                        rlvFaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View inflate) {
        mRlvFa = (RecyclerView) inflate.findViewById(R.id.rlv_fa);
        mRlvFa.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rlvFaAdapter = new RlvFaAdapter(list, getActivity());
        mRlvFa.setAdapter(rlvFaAdapter);
    }
}
