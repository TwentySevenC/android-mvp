package com.example.android.mvp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.mvp.data.bean.ZhDaily;
import com.example.android.mvp.data.bean.ZhDailyItem;
import com.example.android.mvp.data.component.DaggerMainScreenComponent;
import com.example.android.mvp.data.module.MainScreenModule;

import java.util.List;

import javax.inject.Inject;



public class MainActivity extends AppCompatActivity implements MainScreenContract.View {

    private ListView mListView;

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
        ZhAdapter adapter = new ZhAdapter(daily.getItems());
        mListView.setAdapter(adapter);
    }

    @Override
    public void showError() {
        Snackbar.make(mListView, "Error", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showComplete() {
        Snackbar.make(mListView, "Complete", Snackbar.LENGTH_LONG).show();
    }


    class ZhAdapter extends BaseAdapter {
        private List<ZhDailyItem> mItems;

        public ZhAdapter(List<ZhDailyItem> items) {
            mItems = items;
        }

        @Override
        public int getCount() {
            return mItems == null ? 0 : mItems.size();
        }

        @Override
        public ZhDailyItem getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder ;
            if(convertView == null) {
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_zhdaily_item, parent, false);
                holder = new ViewHolder();
                holder.imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
                holder.textView = (TextView) convertView.findViewById(R.id.title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            ZhDailyItem item = getItem(position);
            String[] images = item.getImages();
            holder.textView.setText(item.getTitle());
            Glide.with(MainActivity.this)
                    .load(images[0])
                    .animate(R.anim.image_fade_in)
                    .placeholder(R.drawable.io_logo)
                    .into(holder.imageView);
            return convertView;
        }

        class ViewHolder {
            ImageView imageView;
            TextView textView;
        }
    }
}
