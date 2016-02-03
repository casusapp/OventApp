package com.ovent.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ovent.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author : Kunal Chavhan
 * Date : 23/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ViewHolder> {
    private static String TAG = "##ContactsListAdpater##";
    private HashMap<String,String> mContactsMap;
    private ArrayList<HashMap<String,String>> mContactsItems;
    private ArrayList<String> mNameKey;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public ContactsListAdapter(Context context,RecyclerView recyclerView){
        this.mContext   = context;
        this.mRecyclerView = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_contacts_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            mContactsMap = mContactsItems.get(position);
            holder.name.setText(mNameKey.get(position));
            holder.contact.setText(mContactsMap.get(mNameKey.get(position)));
    }

    @Override
    public int getItemCount() {
        if(mContactsItems == null)
            return 0;

        return mContactsItems.size() -1;
    }

    public void setItemsList(final ArrayList<HashMap<String,String>> items, final ArrayList<String> nameList){
        this.mContactsItems = items;
        this.mNameKey = nameList;
        Collections.sort(mNameKey.subList(1,mNameKey.size()));
        notifyDataSetChanged();

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.contact)
        TextView contact;
        @Bind(R.id.check)
        CheckBox check;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
