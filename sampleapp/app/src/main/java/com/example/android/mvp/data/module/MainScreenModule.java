package com.example.android.mvp.data.module;

import com.example.android.mvp.MainScreenContract;
import com.example.android.mvp.util.CustomScope;

import dagger.Module;
import dagger.Provides;



/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 13:20
 */

@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View view) {
        mView = view;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }

}
