package cn.mctlab.ansight.demo.api;

import cn.mctlab.ansight.demo.constant.ThisUrl;
import cn.mctlab.ansight.demo.data.ClassB;
import com.github.mctlab.ansight.common.constant.AsEmptyConst;
import com.github.mctlab.ansight.common.exception.DecodeResponseException;
import com.github.mctlab.ansight.common.json.JsonMapper;
import com.github.mctlab.ansight.common.network.api.get.AbsGetJsonArrayApi;
import org.json.JSONObject;

/**
 * @author liqiang
 */
public class GetClassBsApi extends AbsGetJsonArrayApi<AsEmptyConst.EMPTY_FORM, ClassB> {

    public GetClassBsApi() {
        super(ThisUrl.getClassBsUrl(), AsEmptyConst.EMPTY_FORM_INSTANCE);
    }

    @Override
    protected ClassB decodeJson(JSONObject obj) throws DecodeResponseException {
        return JsonMapper.parseJsonObject(obj, ClassB.class);
    }

    @Override
    protected String apiName() {
        return GetClassBsApi.class.getSimpleName();
    }
}
