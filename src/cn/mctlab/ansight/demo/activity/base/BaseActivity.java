package cn.mctlab.ansight.demo.activity.base;

import android.content.Intent;
import cn.mctlab.ansight.demo.ThisApplication;
import cn.mctlab.ansight.demo.delegate.BaseActivityDelegate;
import com.github.mctlab.ansight.common.activity.AsActivity;

public abstract class BaseActivity extends AsActivity {

    @Override
    protected ThisApplication getApp() {
        return ThisApplication.getInstance();
    }

    @Override
    protected BaseActivityDelegate onCreateActivityDelegate() {
        return new BaseActivityDelegate<BaseActivity>(this);
    }

    @Override
    public void onBroadcast(Intent intent) {
    }

    protected BaseActivity getActivity() {
        return BaseActivity.this;
    }

}
