package com.alex.alextools;

import android.app.Activity;
import android.os.Bundle;

import com.alex.util.ToastUtil;

/**
 * 作者：Alex
 * 时间：2016/9/6 10:00
 * 简述：
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtil.shortCenter("你好");
        ToastUtil.longCenter("你坏");
    }
}
