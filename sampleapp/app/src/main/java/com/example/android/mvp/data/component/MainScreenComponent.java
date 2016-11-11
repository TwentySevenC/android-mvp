package com.example.android.mvp.data.component;

import com.example.android.mvp.MainActivity;
import com.example.android.mvp.data.module.MainScreenModule;
import com.example.android.mvp.util.CustomScope;

import dagger.Component;

/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 13:22
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
