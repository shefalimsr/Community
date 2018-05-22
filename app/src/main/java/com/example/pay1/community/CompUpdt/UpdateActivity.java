package com.example.pay1.community.CompUpdt;

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

import com.example.pay1.community.R;
import com.example.pay1.community.TrainingMaterial.FeedActivity;
import com.example.pay1.community.blog.BlogActivity;
import com.example.pay1.community.home.HomeActivity;
import com.example.pay1.community.home.HomeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class UpdateActivity extends AppCompatActivity
{

    List<Update> updateList = new ArrayList<Update>();
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_updt);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
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
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {

                            case R.id.home :
                            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.community-home.com"));
                            startActivity(i);
                            break;

                            case R.id.trainMat :
                                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.community-training.com"));
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
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.UpdateRecyclerView);

        // this is data fro recycler view
        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        Update fd=new Update("PAY1 AADHAR ATM ","https://www.youtube.com/watch?v=tzCCXnnQOBU","https://upload.wikimedia.org/wikipedia/commons/d/d5/Japan_small_icon.png","outside","29:90");
        updateList.add(fd);
        Update fd1=new Update("PAY1 SWIPE","https://www.youtube.com/watch?v=ok5BMo1FWng","https://upload.wikimedia.org/wikipedia/commons/d/d5/Japan_small_icon.png","outside","29:90");

        updateList.add(fd1);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. create an adapter
        UpdateListPresenter updateListPresenter = new UpdateListPresenter(updateList);
       UpdateRecyclerAdapter mAdapter = new UpdateRecyclerAdapter( updateListPresenter,new com.example.pay1.community.CompUpdt.RecyclerViewClickListener(){
            @Override
            public void onItemClick(View v, int position) {
                Log.d("testing", "clicked position:" + position);
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(updateList.get(position).getTitleUrl()));
                startActivity(intent);
            }
        });



        // 4. set adapter
        recyclerView.setAdapter(mAdapter);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), VERTICAL); //vertical line add
        recyclerView.addItemDecoration(mDividerItemDecoration);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
