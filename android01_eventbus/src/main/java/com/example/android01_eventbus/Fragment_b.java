package com.example.android01_eventbus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Fragment_b extends Fragment {
    private View view;
    private WebView mWeb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_b, null);
        initView(inflate);
        EventBus.getDefault().register(getActivity());
        return inflate;
    }

    private void initView(View inflate) {
        mWeb = (WebView) inflate.findViewById(R.id.web);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void shou(String url) {
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.loadUrl(url);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(getActivity());
    }
}
