package com.github.mctlab.ansight.common.network.http;

public interface HttpTask<Result> {

    public HttpTaskResult<Result> exec();

}
