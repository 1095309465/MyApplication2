package com.chuangrong.tourism.ui.bean;

/**
 * Created by DELL on 2017/5/10.
 */

public class ScenicBean {


    private String name;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ScenicBean{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
