package com.example.android.mvp;

import android.app.Application;

import com.example.android.mvp.data.component.DaggerNetComponent;
import com.example.android.mvp.data.component.NetComponent;
import com.example.android.mvp.data.module.AppModule;
import com.example.android.mvp.data.module.NetModule;


/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 11:06
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NetComponent component = DaggerNetComponent.builder().appModule(new AppModule(this))
                .netModule(new NetModule("http://news-at.zhihu.com")).build();
        NetComponentHolder.setNetComponent(component);
    }

    public static class NetComponentHolder {
        private static NetComponent sNetComponent;

        public static void setNetComponent(NetComponent component) {
            sNetComponent = component;
        }

        public static NetComponent getNetComponent() {
            return sNetComponent;
        }
    }
}
