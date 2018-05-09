package com.krypto.blocks.warranty.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krypto.blocks.warranty.LoginActivity;
import com.krypto.blocks.warranty.R;
import com.krypto.blocks.warranty.SummaryActivity;
import com.krypto.blocks.warranty.adapters.StaggeredRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    Toolbar toolbar_products;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        toolbar_products = view.findViewById(R.id.toolbar_bitt);
        initToolBar();

        toolbar_products.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_products.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PaymentFragment();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/5aa5df62bfd9dcc6069d5ffe831807da.png");
        mNames.add("View products");

        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/ee184498707af7d9414860ebd802ba1e.png");
        mNames.add("Register Products");

        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/f698bccf375fd606a1894d1649fd9060.png");
        mNames.add("Register Warranty Claim");

        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/a71985fbb8457da4210c94ba9dce2e23.png");
        mNames.add("Register Recalls");


        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/e86edc05fffa4211529e129d03c6d9e1.png");
        mNames.add("Register Returns");

        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/418bf1204cac657b9f9ca6c01a9ee05e.png");
        mNames.add("Register List");


        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/1993e9f5f59a382618a4ce4eb57d7952.png");
        mNames.add("Recall List");

        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/c3f9a1728ad36e54b5fc690528e95e3f.png");
        mNames.add("Returns List");

        mImageUrls.add("https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/a71985fbb8457da4210c94ba9dce2e23.png");
        mNames.add("Warranty of Products");

        //Log.d(TAG, "initRecyclerView: initializing staggered recyclerview.");


        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter =
                new StaggeredRecyclerViewAdapter(this, mNames, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);



        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_products.setTitle(R.string.toolbar_for_products);
        toolbar_products.setTitleTextColor(getResources().getColor(R.color.jet));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_products);
    }

}
