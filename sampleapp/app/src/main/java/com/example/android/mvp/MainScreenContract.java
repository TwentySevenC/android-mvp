package com.example.android.mvp;


import com.example.android.mvp.data.bean.ZhDaily;

/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 13:16
 */

public interface MainScreenContract {
    interface View {
        void showZhDaily(ZhDaily daily);

        void showError();

        void showComplete();
    }

    interface Presenter {
        void loadZhDaily();
    }
}
