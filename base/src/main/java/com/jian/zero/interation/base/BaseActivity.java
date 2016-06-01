package com.jian.zero.interation.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jian.zero.interation.base.utils.ClassUtil;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public E mModel;
    public Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = ClassUtil.getT(this, 0);
        mModel = ClassUtil.getT(this, 1);
        this.initView();
        this.initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initPresenter();

}
