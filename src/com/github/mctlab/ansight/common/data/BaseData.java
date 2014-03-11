package com.github.mctlab.ansight.common.data;

import com.github.mctlab.ansight.common.json.IJsonable;
import com.github.mctlab.ansight.common.json.JsonMapper;

public class BaseData implements IJsonable {

    @Override
    public String writeJson() {
        return JsonMapper.toJson(this);
    }
}
