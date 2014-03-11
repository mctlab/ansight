package com.github.mctlab.ansight.common.network.api;

import com.github.mctlab.ansight.common.exception.DecodeResponseException;
import com.github.mctlab.ansight.common.network.form.IForm;
import com.github.mctlab.ansight.common.network.http.HttpHeadTask;
import org.apache.http.HttpResponse;

public abstract class AbsHeadApi<Form extends IForm> extends AbstractApi<Form, Void> {

    protected AbsHeadApi(String baseUrl, Form form) {
        super(baseUrl, form);
    }

    @Override
    protected Void decodeResponse(HttpResponse response) throws DecodeResponseException {
        return null;
    }

    @Override
    protected HttpHeadTask onCreateTask() {
        return newHttpHeadTask();
    }

}
