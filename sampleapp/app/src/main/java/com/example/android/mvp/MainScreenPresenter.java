package com.example.android.mvp;

import com.example.android.mvp.data.bean.ZhDaily;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 13:24
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {

    Retrofit mRetrofit;
    MainScreenContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View view) {
        mRetrofit = retrofit;
        mView = view;
    }

    @Override
    public void loadZhDaily() {
        mRetrofit.create(ZhDailyService.class)
                .getLatestDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ZhDaily>() {
                    @Override
                    public void call(ZhDaily daily) {
                        mView.showZhDaily(daily);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        mView.showComplete();
                    }
                });
    }


    private interface ZhDailyService {
        @GET("/api/4/news/latest")
        Observable<ZhDaily> getLatestDaily();
    }
}
