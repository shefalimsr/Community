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
        String date,time;
        date=home.getTimestamp().substring(0,8);
        time=home.getTimestamp().substring(9,14);
        rowView.setDate(date);
        rowView.setTime(time);
    }

    public int getFeedListRowsCount() {
        return homeList.size();
    }



}
