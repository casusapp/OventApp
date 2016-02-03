package com.ovent.views.custom;

import android.content.Context;
import android.util.AttributeSet;

import com.android.ex.chips.RecipientEditTextView;

/**
 * Author : Kunal Chavhan
 * Date : 23/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public class ChipsEditText extends RecipientEditTextView {

    public ChipsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onCancelPendingInputEvents() {
        super.onCancelPendingInputEvents();
    }
}
