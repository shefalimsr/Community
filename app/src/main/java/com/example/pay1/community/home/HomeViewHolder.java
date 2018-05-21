package com.example.pay1.community.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pay1.community.R;

import java.io.InputStream;

public class HomeViewHolder extends RecyclerView.ViewHolder implements RowView {

    TextView title , time , date;
    ImageView icon;

    public HomeViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.home_item_title);
        time = itemView.findViewById(R.id.home_item_time);
        date = itemView.findViewById(R.id.home_item_date);
        icon = itemView.findViewById(R.id.home_item_icon);
    }


    @Override
    public void setTitle(String titlee) {
        title.setText(titlee);
    }

    @Override
    public void setIcon(String imageUrl) {
        new DownloadImageTask(icon)
                .execute(imageUrl);

    }

    @Override
    public void setDate(String dat) {
        date.setText(dat);

    }

    @Override
    public void setTime(String tim) {
        time.setText(tim);

    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
