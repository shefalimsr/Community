package com.example.pay1.community.AEPS;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pay1.community.AEPS.ImagePagerAdapter;
import com.example.pay1.community.R;

import java.util.ArrayList;

public class AepsActivity extends AppCompatActivity {
    ViewPager viewPager;
    ArrayList<String> images = new ArrayList<>();
   ImagePagerAdapter myCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aeps);
        images.add("https://wallpaper-house.com/data/out/3/wallpaper2you_26892.jpg");
        images.add("https://awllpaper.com/wp-content/uploads/2018/01/naruto-mobile-wallpaper-crop.jpg");
        images.add("https://wallpaper-house.com/data/out/3/wallpaper2you_26892.jpg");
        images.add("https://awllpaper.com/wp-content/uploads/2018/01/naruto-mobile-wallpaper-crop.jpg");

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        myCustomPagerAdapter = new ImagePagerAdapter(AepsActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
    }
}