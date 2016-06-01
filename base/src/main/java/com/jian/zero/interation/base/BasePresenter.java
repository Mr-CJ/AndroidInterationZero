package com.jian.zero.interation.base;

import android.content.Context;

public abstract class BasePresenter<E, T> {
    public Context context;
    public E mModel;
    public T mView;

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public abstract void onStart();

    public void onDestroy() {}
}
