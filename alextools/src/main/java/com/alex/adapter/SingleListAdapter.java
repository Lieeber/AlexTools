package com.alex.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;

/**
 * 作者：Alex
 * 时间：2016年09月03日    09:56
 * 简述：
 */

@SuppressWarnings("all")
public abstract class SingleListAdapter<T> extends MultipleListAdapter<T> {
    public int layoutId;

    public SingleListAdapter(Context context) {
        super(context);
    }
    public SingleListAdapter(Context context, int layoutId) {
        super(context, new int[]{layoutId});
        this.layoutId = layoutId;
    }

    public SingleListAdapter(Context context, @LayoutRes int... layoutRes) {
        super(context, layoutRes);
    }
    /**
     * 根据 list.get(position) 的类型 获取 layoutRes
     */
    @Override
    public int getLayoutRes(int position) {
        return this.layoutId;
    }
}

