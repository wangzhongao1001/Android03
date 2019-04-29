package com.example.android_xiaoshixun.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.android_xiaoshixun.R;

public class Fragment_B extends Fragment {
    private View view;
    private WebView mWeb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_b, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mWeb = (WebView) inflate.findViewById(R.id.web);
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.loadUrl("https://www.baidu.com");
    }
}
