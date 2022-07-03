package com.kray.kraylimiter.service;

import com.kray.kraylimiter.model.UrlProperties;

public class LimiterService {
    private UrlProperties properties;
    public LimiterService() {
    }
    public LimiterService(UrlProperties urlProperties) {
        this.properties = urlProperties;
    }


    public void getConfig(){
        System.out.println("当前限制的url列表为： " + properties.getUrl() +
                ", 时间间隔为" + properties.getTimeInterval() + "次"
                + ", 限制次数为: " + properties.getCount());
    }
}
