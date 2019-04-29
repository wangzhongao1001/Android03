package com.example.android_xiaoshixun.serivce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DongTaiReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String item = intent.getStringExtra("item2");
        Toast.makeText(context,"动态：" + item, Toast.LENGTH_SHORT).show();
    }
}
