package com.ovent.presentation.views.activities;

import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ovent.presentation.R;
import com.ovent.presentation.adapters.ViewPagerAdapter;
import com.ovent.presentation.utils.Intents;
import com.ovent.presentation.views.fragments.Three;
import com.ovent.presentation.views.fragments.TrendingFragment;
import com.ovent.presentation.views.fragments.Two;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class HomeActivity extends BaseActivity {
    private static String TAG = "##HomeActivity##";
    @Bind(R.id.tabs)
    TabLayout mTabs;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @OnClick(R.id.fab)
    void fab(){
        startActivity(Intents.getCreateEventIntent());
    }

    @OnClick(R.id.account)
    void onAccountClick(){
        startActivity(Intents.getAccountIntent());

    }


    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setUpViewPager();
        mTabs.setupWithViewPager(mViewPager);

    }

    private void setUpViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(new TrendingFragment(), "TRENDING");
        mViewPagerAdapter.addFragment(new Two(), "TWO");
        mViewPagerAdapter.addFragment(new Three(), "THREE");
        mViewPager.setAdapter(mViewPagerAdapter);

    }

}
