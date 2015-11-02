package com.veidy.nba.daily.ui.base.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * @author : veidy
 * @version : 1.0
 * @Description : ViewHolder
 * @Create Date  : 2015/11/2  14:52
 */
public class ViewHolder {
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
