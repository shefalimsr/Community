package com.example.pay1.community.TrainingMaterial;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.pay1.community.R;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    List<Feed> feedList = new ArrayList<Feed>();
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

    //-------------------------------here-------------------------------
        
        mDrawerLayout = findViewById(R.id.drawer_view);



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // this is data fro recycler view
        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        Feed fd=new Feed("Shefali","https://www.google.com","https://upload.wikimedia.org/wikipedia/commons/d/d5/Japan_small_icon.png","outside",ts);
        feedList.add(fd);
        Feed fd1=new Feed("Shefali","https://www.google.com","https://upload.wikimedia.org/wikipedia/commons/d/d5/Japan_small_icon.png","outside",ts);

        feedList.add(fd1);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. create an adapter
        FeedListPresenter feedListPresenter= new FeedListPresenter(feedList);
        FeedRecyclerAdapter mAdapter = new FeedRecyclerAdapter(feedListPresenter);

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
