package com.example.android_xiaoshixun.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android_xiaoshixun.R;
import com.example.android_xiaoshixun.bean.Bean;

import java.util.ArrayList;

public class RlvFaAdapter extends RecyclerView.Adapter<RlvFaAdapter.ViewHolder_fa> {
    private ArrayList<Bean.DataBean.DatasBean>blist;
    Context context;

    public RlvFaAdapter(ArrayList<Bean.DataBean.DatasBean> blist, Context context) {
        this.blist = blist;
        this.context = context;
    }

    public void setBlist(ArrayList<Bean.DataBean.DatasBean> blist) {
        this.blist = blist;
    }

    @NonNull
    @Override
    public ViewHolder_fa onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_fa, null);
        return new ViewHolder_fa(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_fa viewHolder_fa, int i) {
        viewHolder_fa.tv_fa.setText(blist.get(i).getTitle());
        Glide.with(context).load(blist.get(i).getEnvelopePic()).into(viewHolder_fa.iv_fa);
    }

    @Override
    public int getItemCount() {
        return blist.size();
    }

    public class ViewHolder_fa extends RecyclerView.ViewHolder {

        private  ImageView iv_fa;
        private  TextView tv_fa;

        public ViewHolder_fa(@NonNull View itemView) {
            super(itemView);
            iv_fa = itemView.findViewById(R.id.iv_fa);
            tv_fa = itemView.findViewById(R.id.tv_fa);
        }
    }
}
