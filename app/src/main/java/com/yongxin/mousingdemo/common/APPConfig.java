package com.yongxin.mousingdemo.common;

/**
 * Created by wunaifu on 2018/5/4.
 */
public class APPConfig {

    private static String base_url="http://192.168.0.102:8080/monitoring/";

    public static String login = base_url + "appUserLogin";
    public static String register = base_url + "add_user";


    public static String IS_LOGIN = "is_login";
    public static String ACCOUNT = "account";
    public static String PSW = "password";
    public static String USERDATA = "userData";//获取当前用户的key
    public static String TYPE = "userType";
}

