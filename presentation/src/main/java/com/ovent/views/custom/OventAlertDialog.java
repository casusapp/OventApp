package com.ovent.views.custom;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ovent.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author : Kunal Chavhan
 * Date : 2/3/16.
 * Email : kunal.chavhan005@gmail.com
 */
public class OventAlertDialog extends Dialog implements View.OnClickListener {
    private static String TAG = "##HouuseAlertDialog##";

    private DialogInterface.OnClickListener mPositiveClickListener;
    private DialogInterface.OnClickListener mNegativeClickListener;
    private Context mContext;

    @Bind(R.id.header_image)
    ImageView mHeaderImage;

    @Bind(R.id.title)
    TextView mTitle;

    @Bind(R.id.content)
    TextView mContent;

    @Bind(R.id.positive_button)
    Button mPositiveButton;

    @Bind(R.id.negative_button)
    TextView mNegativeButton;

    private OventAlertDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_alert_dialog);
        mContext = context;
        ButterKnife.bind(this);
        setCancelable(false);
    }

    private void setHeader(@DrawableRes int resId) {
        mHeaderImage.setImageResource(resId);
    }

    private void setDialogTitle(final String title) {
        mTitle.setText(title);
    }

    private void setDialogContent(final String content) {
        mContent.setText(content);
    }

    private void enablePositiveButton(final String text, final DialogInterface.OnClickListener listener) {
        mPositiveClickListener = listener;
        mPositiveButton.setText(text);
        mPositiveButton.setOnClickListener(this);
    }

    private void enableNegativeButton(final String text, final DialogInterface.OnClickListener listener) {
        mNegativeClickListener = listener;
        mNegativeButton.setText(text);
        mNegativeButton.setOnClickListener(this);
        mNegativeButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.positive_button:
                mPositiveClickListener.onClick(this, R.id.positive_button);
                break;
            case R.id.negative_button:
                mNegativeClickListener.onClick(this, R.id.negative_button);
                break;
        }
    }

    public static class Builder {
        private OventAlertDialog mDialog;
        private Context mContext;
        private boolean mIsHeaderImageSet;

        /**
         * Constructor
         *
         * @param context context
         */
        public Builder(final Context context) {
            mDialog = new OventAlertDialog(context);
            mContext = context;
        }

        /**
         * set header image resource for alert dialog
         *
         * @param resId resource id of drawable
         */
        public Builder setHeaderImageResource(@DrawableRes int resId) {
            mIsHeaderImageSet = true;
            mDialog.setHeader(resId);
            return this;
        }

        /**
         * Set dialog title
         *
         * @param resId string resource id
         */
        public Builder setDialogTitle(@StringRes int resId) {
            mDialog.setDialogTitle(mContext.getString(resId));
            return this;
        }

        /**
         * Set dialog title
         *
         * @param title title string
         */
        public Builder setDialogTitle(final String title) {
            mDialog.setDialogTitle(title);
            return this;
        }

        /**
         * Set dialog content
         *
         * @param resId string resource id of dialog content
         */
        public Builder setDialogContent(@StringRes int resId) {
            mDialog.setDialogContent(mContext.getString(resId));
            return this;
        }

        /**
         * Set dialog content
         *
         * @param content dialog content
         */
        public Builder setDialogContent(final String content) {
            mDialog.setDialogContent(content);
            return this;
        }

        /**
         * Set positive action button
         *
         * @param textResId button text string resource id
         * @param listener  click listener
         */
        public Builder setPositiveButton(@StringRes int textResId, final DialogInterface.OnClickListener listener) {
            mDialog.enablePositiveButton(mContext.getString(textResId), listener);
            return this;
        }

        /**
         * Set positive action button
         *
         * @param text     button text
         * @param listener click listener
         */
        public Builder setPositiveButton(final String text, final DialogInterface.OnClickListener listener) {
            mDialog.enablePositiveButton(text, listener);
            return this;
        }

        /**
         * Set negative action button
         *
         * @param textResId button text string resource id
         * @param listener  click listener
         */
        public Builder setNegativeButton(@StringRes int textResId, final DialogInterface.OnClickListener listener) {
            mDialog.enableNegativeButton(mContext.getString(textResId), listener);
            return this;
        }

        /**
         * Set negative action button
         *
         * @param text     button text
         * @param listener click listener
         */
        public Builder setNegativeButton(final String text, final DialogInterface.OnClickListener listener) {
            mDialog.enableNegativeButton(text, listener);
            return this;
        }

        /**
         * Build alert dialog
         *
         * @return instance of AppSurferAlertDialog
         */
        public OventAlertDialog build() {
            if (!mIsHeaderImageSet)
                throw new RuntimeException("Header image resource not set");
            return mDialog;
        }
    }

    @Override
    public void show() {
        getWindow().setWindowAnimations(R.style.OventAlertDialog);
        super.show();
    }}
