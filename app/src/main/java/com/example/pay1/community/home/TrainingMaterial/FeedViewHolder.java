package com.example.pay1.community.home.TrainingMaterial;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedViewHolder extends RecyclerView.ViewHolder implements RowView {

    TextView title;
    ImageView icon;

    public FeedViewHolder(View itemView) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, null);
        title = itemView.findViewById();
        icon = itemView.findViewById(R.id.repoStarsCountText);
    }


    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setIcon(Bitmap bitmap) {

    }
}
