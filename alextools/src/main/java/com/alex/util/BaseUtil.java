package com.alex.util;

import android.app.Application;

import com.alex.helper.CrashHandler;

/**
 * 作者：Alex
 * 时间：2016年09月03日    09:59
 * 简述：
 */

@SuppressWarnings("all")
public class BaseUtil
{
    private static Application app;
    private static boolean debug = true;
    /**初始化 Application*/
    public static void init(Application application){
        init(application, null, true, null);
    }
    /**初始化 Application；是否处于debug模式*/
    public static void init(Application application, boolean debug){
        init(application, null, debug, null);
    }
    /**初始化 Application*/
    public static void init(Application application, String headTag){
        init(application, headTag, true, null);
    }
    /**初始化 Application；是否处于debug模式*/
    public static void init(Application application, String headTag, boolean debug){
        init(application, headTag, debug, null);
    }
    /**初始化 Application*/
    public static void init(Application application, String headTag, CrashHandler.OnCrashListener onCrashListener){
        init(application, headTag, true,onCrashListener);
    }
    /**初始化 Application*/
    public static void init(Application application, boolean debug, CrashHandler.OnCrashListener onCrashListener){
        init(application, null, true,onCrashListener);
    }
    /**初始化 Application*/
    public static void init(Application application, String headTag, boolean debug, CrashHandler.OnCrashListener onCrashListener){
        BaseUtil.app = application;
        BaseUtil.debug = debug;
        LogUtil.headTag(headTag);
        CrashHandler crashHandler = new CrashHandler(app);
        crashHandler.setOnCrashListener(onCrashListener);
    }


    /**是否处于debug模式*/
    public static void debug(boolean debug){
        BaseUtil.debug = debug;
    }
    public static Application app(){
        return app;
    }

    public static boolean debug(){
        return debug;
    }
    public static final boolean isAppNull(){
        if(BaseUtil.app() == null){
            LogUtil.e("请在 Application 中初始化 "+BaseUtil.class.getSimpleName()+" init(Application application);");
            return true;
        }
        return false;
    }
}

