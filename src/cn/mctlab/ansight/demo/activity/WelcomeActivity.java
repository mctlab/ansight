package cn.mctlab.ansight.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cn.mctlab.ansight.demo.R;
import cn.mctlab.ansight.demo.activity.base.BaseActivity;
import cn.mctlab.ansight.demo.api.GetClassAApi;
import cn.mctlab.ansight.demo.api.GetClassBsApi;
import cn.mctlab.ansight.demo.data.ClassA;
import cn.mctlab.ansight.demo.data.ClassB;
import com.github.mctlab.ansight.common.annotation.ViewId;
import com.github.mctlab.ansight.common.util.L;
import com.github.mctlab.ansight.common.util.UIUtils;

import java.util.List;

public class WelcomeActivity extends BaseActivity {

    @ViewId(R.id.view_info)
    private TextView infoView;
    @ViewId(R.id.btn_info)
    private Button infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetClassAApi(9527) {
                    @Override
                    protected void onSuccess(ClassA classA) {
                        super.onSuccess(classA);
                        String jsonA = classA.writeJson();
                        L.i(getActivity(), jsonA);
                    }
                }.call(getActivity()); // FOREGROUND
                new GetClassBsApi() {
                    @Override
                    protected void onSuccess(List<ClassB> classBs) {
                        super.onSuccess(classBs);
                        for (ClassB b : classBs) {
                            String jsonB = b.writeJson();
                            L.i("BACKGROUND", jsonB);
                        }
                    }
                }.call(null); // BACKGROUND
                UIUtils.toast(getActivity(), "click");
                infoBtn.setText("请看 log!");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

}
