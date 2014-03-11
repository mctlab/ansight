package cn.mctlab.ansight.demo.api;

import cn.mctlab.ansight.demo.constant.ThisUrl;
import cn.mctlab.ansight.demo.data.ClassA;
import com.github.mctlab.ansight.common.constant.AsEmptyConst;
import com.github.mctlab.ansight.common.exception.DecodeResponseException;
import com.github.mctlab.ansight.common.json.JsonMapper;
import com.github.mctlab.ansight.common.network.api.get.AbsGetJsonApi;
import org.json.JSONObject;

/**
 * @author liqiang
 */
public class GetClassAApi extends AbsGetJsonApi<AsEmptyConst.EMPTY_FORM, ClassA> {

    public GetClassAApi(int id) {
        super(ThisUrl.getClassAUrl(id), AsEmptyConst.EMPTY_FORM_INSTANCE);
    }

    @Override
    protected ClassA decodeJson(JSONObject obj) throws DecodeResponseException {
        return JsonMapper.parseJsonObject(obj, ClassA.class);
    }

    @Override
    protected String apiName() {
        return GetClassAApi.class.getSimpleName();
    }
}
