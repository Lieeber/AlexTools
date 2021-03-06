package com.alex.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.alex.adapter.core.IBaseAdapter;
import com.alex.adapter.core.ListViewHolder;
import com.alex.adapter.callback.OnPositionClickListener;
import com.alex.model.ParcelableMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 作者：Alex
 * 时间：2016年09月03日    09:56
 * 简述：
 */

@SuppressWarnings("all")
public abstract class MultipleListAdapter<T> extends BaseAdapter implements IBaseAdapter<T>, OnPositionClickListener {
    protected List<T> list;
    protected Context context;
    private Map<Integer, Integer> layoutResMap;
    public MultipleListAdapter(Context context) {
        this.context = context;
        list = new ArrayList<T>();
    }

    public MultipleListAdapter(Context context, @LayoutRes int... layoutRes) {
        this(context);
        layoutResMap = new HashMap<>();
        for (int i = 0; i < layoutRes.length; i++) {
            layoutResMap.put(i, layoutRes[i]);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int layoutId = getLayoutRes(position);
        return getViewType(layoutId);
    }

    @Override
    public int getViewTypeCount() {
        return layoutResMap.size();
    }

    /**
     * 根据LayoutId获取ViewType
     */
    private int getViewType(int layoutId) {
        Iterator iter = layoutResMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer key = (Integer) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (val == layoutId) {
                return key;
            }
        }
        return 0;
    }
    /**
     * 根据 list.get(position) 的类型 获取 layoutRes
     */
    public abstract int getLayoutRes(int position);

    @Override
    public int getCount() {
        return (list == null) ? 0 : list.size();
    }

    @Override
    public T getItem(int position) {
        return (list == null) ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取数据集合
     */
    @Override
    public List getList() {
        return list;
    }

    /**
     * 在List最后一条进行追加
     *
     * @param bean
     */
    @Override
    public void addItem(T bean) {
        if ((list == null) || (bean == null)) {
            return;
        }
        list.add(bean);
        notifyDataSetChanged();
    }

    /**
     * 在List最后一条进行追加
     *
     * @param list
     */
    @Override
    public void addItem(List list) {
        if ((this.list == null) || (list == null)) {
            return;
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 在List的position之后进行追加
     *
     * @param list
     * @param position
     */
    @Override
    public void addItem(List list, int position) {
        if ((this.list == null) || (list == null) || (list.size() <= position)) {
            return;
        }
        this.list.addAll(position, list);
        notifyDataSetChanged();
    }

    /**
     * 清空数据
     */
    @Override
    public void clearItem() {
        if (list == null) {
            return;
        }
        list.removeAll(list);
        notifyDataSetChanged();
    }

    /**
     * 清空 并 刷新 list
     *
     * @param list
     */
    @Override
    public void refreshItem(List list) {
        if ((this.list == null) || (list == null)) {
            return;
        }
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 移除一条数据
     *
     * @param bean
     */
    @Override
    public void removeItem(T bean) {
        if (list == null) {
            return;
        }
        list.remove(bean);
        notifyDataSetChanged();
    }

    /**
     * 移除多条数据
     *
     * @param list
     */
    @Override
    public void removeItem(List list) {
        if ((this.list == null) || (list == null)) {
            return;
        }
        this.list.removeAll(list);
        notifyDataSetChanged();
    }

    /**
     * 移除一条数据
     *
     * @param position
     */
    @Override
    public void removeItem(int position) {
        if (list == null) {
            return;
        }
        list.remove(position);
        notifyDataSetChanged();
    }

    /**
     * 更新一条数据
     *
     * @param bean
     * @param position
     */
    @Override
    public void updateItem(T bean, int position) {
        if ((list == null) || (list.size() <= position)) {
            return;
        }
        list.set(position, bean);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder holder = ListViewHolder.getViewHolder(context, convertView, parent, getLayoutRes(position), position);
        onConvert(holder, position);
        return holder.getConvertView();
    }

    /**
     * 页面跳转
     *
     * @param intent
     */
    @Override
    public void startActivity(@NonNull Intent intent) {
        context.startActivity(intent);
    }

    /**
     * 页面跳转
     */
    @Override
    public void startActivity(@NonNull Class clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    /**
     * 页面跳转
     */
    @Override
    public <M extends ParcelableMap> void startActivity(@NonNull Class clazz, M parcelableMap) {
        Intent intent = new Intent(context, clazz);
        intent.putExtra(ParcelableMap.extraBundle, parcelableMap.getBundle());
        intent.putStringArrayListExtra(ParcelableMap.bundleKey, parcelableMap.getKeyList());
        context.startActivity(intent);
    }

    /**
     * 关联 View 和 Bean 以及 处理点击事件
     * </br>holder.setText(R.id.tv_right, bean.money);
     * </br>holder.setOnClickListener(R.id.layout_body, new MyOnClickListener(holder.position));
     */
    public abstract void onConvert(ListViewHolder holder, int position);

}

