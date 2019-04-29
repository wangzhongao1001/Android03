package com.example.android_xiaoshixun.base;

import java.util.ArrayList;

public abstract class BasePresenter <V extends BaseMvpView>{
    protected V mMvpView;
    protected ArrayList<BaseModel>mModels=new ArrayList<>();
    public BasePresenter(){
        initModel();
    }
    protected abstract void initModel();

    public void bind(V view){
        this.mMvpView=view;
    }
    public void onDestory(){
        mMvpView=null;
        if (mModels.size()>0){
            for (BaseModel mModel : mModels) {
                mModel.onDestory();
            }
            mModels.clear();
        }
    }
}
