package com.ovent.utils;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ovent.R;

/**
 * Author : Kunal Chavhan
 * Date : 29/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class DialogsUtil  {
    private static final String TAG = "##DialogUtil##";

    /**
     * Constructs the basic material dialog
     *
     * @param activity
     * @param header
     * @param content
     * @param okText
     * @param cancelText
     * @return MaterialDialog.Builder
     */
    public static MaterialDialog.Builder getDialogBuilder(final Activity activity, final String header,
                                                          final String content, final String okText,
                                                          final String cancelText) {

        final MaterialDialog.Builder builder = new MaterialDialog.Builder(activity)
                .autoDismiss(false)
                .cancelable(false)
                .title(header)
                .content(content)
                .positiveColor(activity.getResources().getColor(R.color.colorPrimary))
                .positiveText(okText);

        if (!cancelText.equals("")) {
            builder.negativeText(cancelText);
            builder.negativeColor(activity.getResources().getColor(R.color.black));
        }

        return builder;
    }
}
