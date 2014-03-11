package com.github.mctlab.ansight.common.network.api.put;

import com.github.mctlab.ansight.common.network.api.AbstractApi;
import com.github.mctlab.ansight.common.network.form.IForm;
import com.github.mctlab.ansight.common.network.http.HttpPutTask;

public abstract class AbsPutApi<FORM extends IForm, RESULT> extends AbstractApi<FORM, RESULT> {

    protected AbsPutApi(String baseUrl, FORM form) {
        super(baseUrl, form);
    }

    @Override
    protected HttpPutTask<RESULT> onCreateTask() {
        return newHttpPutTask();
    }

}
