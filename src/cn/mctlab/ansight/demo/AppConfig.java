package cn.mctlab.ansight.demo;

import com.github.mctlab.ansight.common.AsAppConfig;

public class AppConfig extends AsAppConfig {

    public static void init() {
        if (me == null) {
            synchronized (AsAppConfig.class) {
                if (me == null) {
                    me = new AppConfig();
                }
            }
        }
    }

    public static AppConfig getInstance() {
        return (AppConfig) AsAppConfig.getInstance();
    }

}

