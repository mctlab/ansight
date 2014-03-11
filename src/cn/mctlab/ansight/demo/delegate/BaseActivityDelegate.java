package cn.mctlab.ansight.demo.delegate;

import cn.mctlab.ansight.demo.activity.base.BaseActivity;
import com.github.mctlab.ansight.common.delegate.context.AsActivityDelegate;

public class BaseActivityDelegate<T extends BaseActivity> extends AsActivityDelegate<T> {

    public BaseActivityDelegate(T activity) {
        super(activity);
    }

}
