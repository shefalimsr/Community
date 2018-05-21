package com.example.pay1.community.CompUpdt;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.pay1.community.R;

public class UpdateRecyclerAdapter extends RecyclerView.Adapter<UpdateViewHolder> {

    private final UpdateListPresenter presenter;

    public UpdateRecyclerAdapter(UpdateListPresenter updateListPresenter) {
        this.presenter = updateListPresenter;
    }

    @Override
    public UpdateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UpdateViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(UpdateViewHolder viewHolder, int position) {
       presenter.onBindFeedRowViewAtPosition(position,viewHolder);
    }


    @Override
    public int getItemCount() {
        return presenter.getFeedListRowsCount();
    }


}
