package com.example.android01_eventbus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder_a> {
    private ArrayList<Web>wlist;
    Context context;
    private onClick onClickListener;

    public RlvAdapter(ArrayList<Web> wlist, Context context) {
        this.wlist = wlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder_a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rlv, null);

        return new ViewHolder_a(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_a viewHolder_a, final int i) {
        viewHolder_a.tv.setText(wlist.get(i).getName());
        viewHolder_a.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onClickListen(wlist.get(i).getUrl());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return wlist.size();
    }

    public class ViewHolder_a extends RecyclerView.ViewHolder {

        private TextView tv;

        public ViewHolder_a(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }

    }
    public interface onClick{
       void onClickListen(String url);
    }
    public void setOnClickListener(onClick onClickListener){

        this.onClickListener = onClickListener;
    }
}
