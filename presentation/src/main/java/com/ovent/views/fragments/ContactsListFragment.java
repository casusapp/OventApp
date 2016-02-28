package com.ovent.views.fragments;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ovent.R;
import com.ovent.adapters.ContactsListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public final class ContactsListFragment extends BaseFragment {
    public static String TAG = "##ContactsListFragment##";
    private LinearLayoutManager mLayoutManager;
    private ArrayList<HashMap<String, String>> mContactsList;
    private ContactsListAdapter mAdapter;

    public static ContactsListFragment newInstance() {
        // Required empty public constructor
        return new ContactsListFragment();
    }

    @Bind(R.id.contacts_list)
    RecyclerView mContactsListView;
    @Bind(R.id.back)
    ImageView mBack;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_contacts_list, container, false);
        ButterKnife.bind(this, view);
        attachListeners();
        setAdapter();
        getContacts();
        return view;
    }

    private void attachListeners(){
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }

    private void setAdapter() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mContactsListView.setLayoutManager(mLayoutManager);
        mAdapter = new ContactsListAdapter(getActivity(), mContactsListView);
        mContactsListView.setAdapter(mAdapter);
    }

    private void getContacts() {
        ContentResolver cr = getActivity().getContentResolver();
        Cursor contacts = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        HashMap<String, String> map = new HashMap<>();
        mContactsList = new ArrayList<>();
        final ArrayList<String> nameKey = new ArrayList<>();


            while (contacts.moveToNext()) {
                String name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phone = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                map.put(name, phone);
                nameKey.add(name);
                mContactsList.add(map);
            }

        mAdapter.setItemsList(mContactsList, nameKey);
    }

}
