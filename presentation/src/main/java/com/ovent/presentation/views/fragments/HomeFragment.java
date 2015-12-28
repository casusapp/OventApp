package com.ovent.presentation.views.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ovent.presentation.R;

/**
 * A placeholder fragment containing a simple view.
 */
public final class HomeFragment extends BaseFragment {
    public static String TAG = "##HomeFragment##";
    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
