package com.github.mctlab.ansight.common.network.api.post;

import com.github.mctlab.ansight.common.network.api.AbstractApi;
import com.github.mctlab.ansight.common.network.form.IForm;
import com.github.mctlab.ansight.common.network.http.HttpTask;

public abstract class AbsPostApi<FORM extends IForm, RESULT> extends AbstractApi<IForm, RESULT> {

    protected AbsPostApi(String baseUrl, FORM form) {
        super(baseUrl, form);
    }

    @Override
    protected HttpTask<RESULT> onCreateTask() {
        return newHttpPostTask();
    }

}