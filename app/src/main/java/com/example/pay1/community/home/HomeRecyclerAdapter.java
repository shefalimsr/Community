package com.example.pay1.community.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.pay1.community.R;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private final HomeListPresenter presenter;

    public HomeRecyclerAdapter(HomeListPresenter homeListPresenter) {
        this.presenter = homeListPresenter;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeViewHolder viewHolder, int position) {
       presenter.onBindFeedRowViewAtPosition(position,viewHolder);
    }


    @Override
    public int getItemCount() {
        return presenter.getFeedListRowsCount();
    }


}
