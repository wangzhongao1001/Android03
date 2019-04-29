package com.example.android_xiaoshixun.callback;

import com.example.android_xiaoshixun.bean.Bean;

public interface CallBack_impl {
    void onSuccess(Bean bean);
    void onFailed(String msg);
}
