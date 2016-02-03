package com.ovent.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ovent.R;
import com.ovent.models.EventModel;
import com.ovent.presentation.adapters.BaseRecyclerViewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author : Kunal Chavhan
 * Date : 19/1/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class EventListAdapter extends BaseRecyclerViewAdapter<EventModel,EventListAdapter.ViewHolder> {
    private static String TAG = "##EventListAdapter##";


    /**
     * Constructor
     *
     * @param recyclerView
     */
    public EventListAdapter(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_event_card,parent,false);
        return new ViewHolder(view);
    }

    /**
     *
     * @param holder
     * @param position of recyclerview item
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final EventModel eventModel = getItem(position);
        holder.name.setText(eventModel.getName());
        holder.eventBanner.setImageResource(R.drawable.i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.event_banner)
        ImageView eventBanner;
        @Bind(R.id.name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
