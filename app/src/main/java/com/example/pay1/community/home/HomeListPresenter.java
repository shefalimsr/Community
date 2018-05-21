package com.example.pay1.community.home;

import java.util.List;

public class HomeListPresenter {

    private final List<Home> homeList;

    public HomeListPresenter(List<Home> homeList) {
        this.homeList = homeList;
    }

    public void onBindFeedRowViewAtPosition(int position, HomeViewHolder rowView) {
        Home home = homeList.get(position);
        rowView.setIcon(home.getIconUrl());
        rowView.setTitle(home.getTitle());
        rowView.setDate(home.getTimestamp());
        rowView.setTime(home.getTimestamp());
    }

    public int getFeedListRowsCount() {
        return homeList.size();
    }



}
