package com.example.android_xiaoshixun.view;

import com.example.android_xiaoshixun.base.BaseMvpView;

public interface MainView extends BaseMvpView {
    void setData(String data);

    String getUserName();
    String getPsd();

    void showToast(String msg);
}
