package com.example.android.mvp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.mvp.data.bean.ZhDaily;
import com.example.android.mvp.data.bean.ZhDailyItem;
import com.example.android.mvp.data.component.DaggerMainScreenComponent;
import com.example.android.mvp.data.module.MainScreenModule;

import java.util.ArrayList;

import javax.inject.Inject;



public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    @Inject
    MainScreenPresenter mMainScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.list);

        DaggerMainScreenComponent.builder()
                .netComponent(App.NetComponentHolder.getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build()
                .inject(this);


        mMainScreenPresenter.loadZhDaily();
    }

    @Override
    public void showZhDaily(ZhDaily daily) {
        ArrayList<ZhDailyItem> items = daily.getItems();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < items.size(); i++)
            list.add(items.get(i).getTitle());
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void showError() {
        Snackbar.make(mListView, "Error", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showComplete() {
        Snackbar.make(mListView, "Complete", Snackbar.LENGTH_LONG).show();
    }
}
