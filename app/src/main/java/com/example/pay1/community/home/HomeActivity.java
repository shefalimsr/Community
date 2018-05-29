package com.example.pay1.community.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pay1.community.CompUpdt.UpdateActivity;
import com.example.pay1.community.R;
import com.example.pay1.community.TrainingMaterial.FeedActivity;
import com.example.pay1.community.TrainingMaterial.FeedRecyclerAdapter;
import com.example.pay1.community.TrainingMaterial.RecyclerViewClickListener;
import com.example.pay1.community.blog.BlogActivity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class HomeActivity extends AppCompatActivity
{

    List<Home> homeList = new ArrayList<Home>();
    private DrawerLayout mDrawerLayout;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy.HH:mm");

    Date date= new Date(System.currentTimeMillis());
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_community_logo);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        mDrawerLayout = findViewById(R.id.drawer_view);

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
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

                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {

                            case R.id.trainMat :
                                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.community-training.com"));
                                startActivity(i);
                                break;
                            case R.id.compUpd :
                                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.community-update.com"));
                                startActivity(i1);
                                break;

                            case R.id.blog :
                                Intent i3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.community-blog.com"));
                                startActivity(i3);
                                break;

                            case R.id.chat :
                                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.community-aeps.com"));
                                startActivity(implicit);

                            default: return true;
                        }

                        return true;
                    }
                });

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.homeRecyclerView);

        // this is data fro recycler view

        String ts = sdf.format(date);

        Home fd=new Home("PAY1 AADHAR ATM ","https://www.youtube.com/watch?v=tzCCXnnQOBU","http://icons.iconarchive.com/icons/dtafalonso/android-lollipop/256/Youtube-icon.png","outside",ts);
        homeList.add(fd);
        Home fd1=new Home("PAY1 SWIPE","https://www.youtube.com/watch?v=ok5BMo1FWng","http://icons.iconarchive.com/icons/dtafalonso/android-lollipop/256/Youtube-icon.png","outside",ts);

        homeList.add(fd1);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. create an adapter
        HomeListPresenter homeListPresenter = new HomeListPresenter(homeList);
        HomeRecyclerAdapter mAdapter = new HomeRecyclerAdapter( homeListPresenter,new com.example.pay1.community.home.RecyclerViewClickListener(){
            @Override
            public void onItemClick(View v, int position) {
                Log.d("testing", "clicked position:" + position);
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(homeList.get(position).getTitleUrl()));
                startActivity(intent);
            }
        });

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

//            case R.id.trainMat :
        }
        return super.onOptionsItemSelected(item);
    }

}
