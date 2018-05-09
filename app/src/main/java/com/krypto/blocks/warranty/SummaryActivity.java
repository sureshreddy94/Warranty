package com.krypto.blocks.warranty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.krypto.blocks.warranty.adapters.TabLayoutAdapter;
import com.krypto.blocks.warranty.fragments.ExpiredFragment;
import com.krypto.blocks.warranty.fragments.HomeFragment;
import com.krypto.blocks.warranty.fragments.SummaryFragment;
import com.krypto.blocks.warranty.model.TabIt;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SummaryActivity extends AppCompatActivity {

    public void ExpiredFragment() {

        ExpiredFragment expiredFragment = new ExpiredFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, expiredFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void HomeFragment() {

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.pager)
    ViewPager mViewPager;

    @BindView(R.id.item_image)
    ImageView mImage;

    @BindView(R.id.item_image_alpha)
    ImageView mImageAlpha;

    @BindView(R.id.item_progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.app_bar)
    AppBarLayout mAppBar;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        ButterKnife.bind(this);

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExpiredActivity.class);
                startActivity(intent);
            }
        });

        mImageAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExpiredActivity.class);
                startActivity(intent);
            }
        });



        // Init
        setupInit();

        // Tab Layout
        setupTabLayout();

        // Image View
        setupImage("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/e89c2c0158142a123af77074c757188f.png");

        // Swipe Refresh
        setupSwipeRefresh();
    }

    private void setupInit() {
        // Toolbar
        setSupportActionBar(mToolbar);
        setTitle("");

        mToolbarTitle.setText("<- Summary");
        mToolbarTitle.setTextColor(Color.BLACK);
        mImageAlpha.getBackground().setAlpha(100);
        mToolbarTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               HomeFragment();
                //Intent i = new Intent(SummaryActivity.this,MainActivity.class);
                //startActivity(i);
            }
        });
    }

    private void setupTabLayout() {
        ArrayList<TabIt> favoritesItemArrayList = new ArrayList<>();

        for (int i = 1; i < 2; i++)
            favoritesItemArrayList.add(new TabIt("15" +'\n'+ "Products" ));
            favoritesItemArrayList.add(new TabIt("2" +'\n'+ "Warranty Expired"));
            favoritesItemArrayList.add(new TabIt("10" +'\n'+ "Insurance"));
            //favoritesItemArrayList.add(new TabIt("10          Insurance" + 10));


        mViewPager.setAdapter(new TabLayoutAdapter(getSupportFragmentManager(), favoritesItemArrayList));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupImage(String url) {
        Glide.with(this).load(url).into(mImageAlpha);
        if (mProgressBar != null){
            mProgressBar.setVisibility(View.GONE);
    }



    }

    private void setupSwipeRefresh() {
        mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i == 0) {
                    mSwipeRefreshLayout.setEnabled(true);
                } else {
                    mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                SummaryFragment fragment = (SummaryFragment) mViewPager.getAdapter().instantiateItem(mViewPager, mViewPager.getCurrentItem());
                fragment.refreshData();

                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
