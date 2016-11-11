package com.example.android.mvp.data.component;

import com.example.android.mvp.data.module.AppModule;
import com.example.android.mvp.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 11:05
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
