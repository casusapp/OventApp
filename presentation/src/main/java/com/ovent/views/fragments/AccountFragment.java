package com.ovent.views.fragments;


import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ovent.R;
import com.ovent.views.custom.NotifyingScrollView;
import com.ovent.views.fragments.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public final class AccountFragment extends BaseFragment {
    public static String TAG ="##AccountFragment##";

   /* @Bind(R.id.notifyingScroll)
    NotifyingScrollView mNotifyingScrollView;*/

  /*  @Bind(R.id.title)
    TextView mTitle;*/
   /* @Bind(R.id.overlayImage)
    FrameLayout mOverlay;*/

   /* @OnClick(R.id.back)
    void back(){
        getActivity().finish();
    }*/

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance(){
        return new AccountFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, view);
     //   mOverlay.setAlpha(0);
       // mTitle.setAlpha(0);
      //  mNotifyingScrollView.setOnScrollChangedListener(mOnScrollChangedListener);
            return view;
    }

   /* private NotifyingScrollView.OnScrollChangedListener mOnScrollChangedListener = new NotifyingScrollView.OnScrollChangedListener() {
        public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
            final int headerHeight = 240 - 48;
            final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
            final int newAlpha = (int) (ratio);
            Log.d(TAG,""+newAlpha);
            mOverlay.setAlpha(newAlpha);
            mTitle.setAlpha(newAlpha);
        }
    };*/
}
