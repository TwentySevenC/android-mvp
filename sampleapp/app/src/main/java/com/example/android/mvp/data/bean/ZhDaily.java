package com.example.android.mvp.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 16:22
 */

public class ZhDaily {
    private String date;
    @SerializedName("stories")
    private ArrayList<ZhDailyItem> items;
    @SerializedName("top_stories")
    private ArrayList<ZhDailyItem> topItems;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ZhDailyItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ZhDailyItem> items) {
        this.items = items;
    }

    public ArrayList<ZhDailyItem> getTopItems() {
        return topItems;
    }

    public void setTopItems(ArrayList<ZhDailyItem> topItems) {
        this.topItems = topItems;
    }
}
