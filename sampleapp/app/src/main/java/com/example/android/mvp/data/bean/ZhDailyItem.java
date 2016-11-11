package com.example.android.mvp.data.bean;

/**
 * Created by liujian (xiaojianmailbox@gmail.com) on 2016/11/11 16:23
 */

public class ZhDailyItem {
    private long id;
    private String title;
    private String[] images;
    private int type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
