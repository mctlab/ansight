package com.github.mctlab.ansight.common.network.api;

import com.github.mctlab.ansight.common.activity.AsActivity;
import com.github.mctlab.ansight.common.exception.ApiException;
import com.github.mctlab.ansight.common.exception.RequestAbortedException;

public interface IServerApi<R> {

    /**
     * activity can be null. but if activity == null,
     * you can not cancel Api requests by calling activity.cancelRequests()
     */
    public void call(AsActivity activity);

    public R syncCall(AsActivity activity) throws ApiException, RequestAbortedException;

    public boolean cancel();
}
