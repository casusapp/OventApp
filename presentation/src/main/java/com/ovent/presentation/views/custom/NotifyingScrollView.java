package com.ovent.presentation.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.Scroller;

/**
 * Author : Kunal Chavhan
 * Date : 2/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public class NotifyingScrollView extends ScrollView {
public interface OnScrollChangedListener {
    void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
}

private OnScrollChangedListener mOnScrollChangedListener;

    public NotifyingScrollView(Context context) {
        super(context);
    }

    public NotifyingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NotifyingScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }

}

