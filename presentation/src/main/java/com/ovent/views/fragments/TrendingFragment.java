package com.ovent.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.ovent.R;
import com.ovent.adapters.EventListAdapter;
import com.ovent.models.EventModel;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public final class TrendingFragment extends BaseFragment {
    public static String TAG = "##TrendingFragment##";

    public TrendingFragment() {
        // Required empty public constructor
    }

    @Bind(R.id.trending_list)
    RecyclerView mTrendingListView;

    private EventListAdapter mEventListAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_trending, container, false);
        ButterKnife.bind(this, view);
        setUpAdapter();
        populateList();
        return view;
    }

    private void setUpAdapter() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTrendingListView.setLayoutManager(mLayoutManager);
        mEventListAdapter = new EventListAdapter(mTrendingListView);
        mTrendingListView.setAdapter(mEventListAdapter);
    }

    private void populateList(){
        final ArrayList<EventModel> eventModels = new ArrayList<>();
        final EventModel eventModel1 = new EventModel();
        final EventModel eventModel2 = new EventModel();
        final EventModel eventModel3 = new EventModel();
        final EventModel eventModel4 = new EventModel();
        final EventModel eventModel5 = new EventModel();
        final EventModel eventModel6 = new EventModel();
        final EventModel eventModel7 = new EventModel();
        final EventModel eventModel8 = new EventModel();
        final EventModel eventModel9 = new EventModel();
        final EventModel eventModel10 = new EventModel();


        eventModel1.setName("PyCon");
        eventModels.add(eventModel1);

        eventModel2.setName("Android Conference");
        eventModels.add(eventModel2);

        eventModel3.setName("Swift Conference");
        eventModels.add(eventModel3);

        eventModel4.setName("RxJava Talk");
        eventModels.add(eventModel4);

        eventModel5.setName("RxSwift Talk");
        eventModels.add(eventModel5);

        eventModel6.setName("RxPython");
        eventModels.add(eventModel6);

        eventModel7.setName("Dhole's brother's marriage");
        eventModels.add(eventModel7);

        eventModel8.setName("Kunal's marriage");
        eventModels.add(eventModel8);

        eventModel9.setName("Rahul's chudai");
        eventModels.add(eventModel9);

        eventModel10.setName("Prasad's chudai");
        eventModels.add(eventModel10);

        mEventListAdapter.setItemArrayList(eventModels);

    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
}
