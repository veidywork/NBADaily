package com.veidy.nba.daily.ui.base.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : NBADaily
 * @Create Date  : 2015/11/2  14:49
 */
public class BaseVAdapter<T> extends BaseAdapter {

    protected Context mContext;

    protected List<T> mLists = new ArrayList<T>();

    public BaseVAdapter(Context mContext, List<T> mLists) {
        this.mContext = mContext;
        this.mLists = mLists;
    }

    @Override
    public int getCount() {
        return mLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
