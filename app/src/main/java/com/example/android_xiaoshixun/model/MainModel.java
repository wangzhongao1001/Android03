package com.example.android_xiaoshixun.model;

import com.example.android_xiaoshixun.base.BaseModel;
import com.example.android_xiaoshixun.bean.Bean;
import com.example.android_xiaoshixun.callback.CallBack_impl;
import com.example.android_xiaoshixun.serivce.MySerivce;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void setbean(final CallBack_impl callBack_impl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MySerivce.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
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
                        callBack_impl.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack_impl.onFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
