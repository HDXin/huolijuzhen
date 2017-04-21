package com.sudaotech.huolijuzhen.util;

/**
 * Created by simon on 16-9-6.
 */
public interface Contains {
    interface Base {

        String encode = "utf-8";

        //消息中间件的APPID(中间件提供)
        String appId = "10002";

        String systemId="20";

        //默认token,发送用这个
        String DEFAULT_TOKEN="31iz7ggKuEKqjtTlehJ4WVgyz5ppOoboQZp8udnDD8Q8arUGRYRmJ6jAS1waNKq1kckp%2FQ2IX0%2BTy7uDD4dyNaSY3%2FcNWgfg6Kjcyi3MpYubxtV%2BI2lfvHNhUijj6msmUhH%2FjLkiIubdWHcK%2BtZ8UQ%3D%3D";

        //消息中间件注册url
        String regUrl = "http://chat.sudaotech.com/chat/notify/register";

        //消息中间件发送url
        String sendUrl = "http://chat.sudaotech.com/chat/notify/message";

        //消息中间件查询url
        String quertUrl = "http://chat.sudaotech.com/chat/notify/myMessage";

        String quertSingle = "http://chat.sudaotech.com/chat/notify/myMessageInfo";


    }
}
