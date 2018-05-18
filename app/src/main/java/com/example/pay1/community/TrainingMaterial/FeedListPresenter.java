package com.example.pay1.community.TrainingMaterial;

import java.util.List;

public class FeedListPresenter {

    private final List<Feed> feedList;

    public FeedListPresenter(List<Feed> feedList) {
        this.feedList = feedList;
    }

    public void onBindFeedRowViewAtPosition(int position, FeedViewHolder rowView) {
        Feed feed = feedList.get(position);
        rowView.setIcon(feed.getIconUrl());
        rowView.setTitle(feed.getTitle());
    }

    public int getFeedListRowsCount() {
        return feedList.size();
    }



}
