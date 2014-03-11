package com.github.mctlab.ansight.common.network.api.get;

import com.github.mctlab.ansight.common.network.api.AbstractApi;
import com.github.mctlab.ansight.common.network.form.IForm;
import com.github.mctlab.ansight.common.network.http.HttpGetTask;

public abstract class AbsGetApi<Form extends IForm, Result> extends AbstractApi<Form, Result> {

    protected AbsGetApi(String baseUrl, Form form) {
        super(baseUrl, form);
    }

    @Override
    protected HttpGetTask<Result> onCreateTask() {
        return newHttpGetTask();
    }

}
