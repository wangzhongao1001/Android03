package com.example.android_xiaoshixun.serivce;

import com.example.android_xiaoshixun.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MySerivce {
    //https://www.wanandroid.com/project/list/1/json?cid=294
    String url="https://www.wanandroid.com/project/";
    @GET("list/1/json?cid=294")
    Observable<Bean>getBean();
}
