package com.example.pay1.community.TrainingMaterial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.pay1.community.R;
import com.example.pay1.community.TrainingMaterial.FeedViewHolder;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private final FeedListPresenter presenter;

    public FeedRecyclerAdapter(FeedListPresenter feedListPresenter) {
        this.presenter = feedListPresenter;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FeedViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(FeedViewHolder viewHolder, int position) {
       presenter.onBindFeedRowViewAtPosition(position,viewHolder);
    }


    @Override
    public int getItemCount() {
        return presenter.getFeedListRowsCount();
    }


}
