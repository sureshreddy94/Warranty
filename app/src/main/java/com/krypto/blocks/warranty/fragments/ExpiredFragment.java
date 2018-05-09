package com.krypto.blocks.warranty.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krypto.blocks.warranty.ExpiredActivity;
import com.krypto.blocks.warranty.LoginActivity;
import com.krypto.blocks.warranty.R;
import com.krypto.blocks.warranty.SummaryActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpiredFragment extends Fragment {

    Toolbar toolbar_exp;
    TextView details_histoy,extend_warranty,sell_expired,buy_insur;

    public void DetailsHistoryFragment() {

        DetailsHistoryFragment detailshistoryFragment = new DetailsHistoryFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, detailshistoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void ExtendWarrantyFragment() {

        ExtendWarrantyFragment extendWarrantyFragment = new ExtendWarrantyFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, extendWarrantyFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void SellFragment() {

        SellFragment sellFragment = new SellFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, sellFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    public ExpiredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expired, container, false);
        toolbar_exp = view.findViewById(R.id.toolbar_expired);
        details_histoy = view.findViewById(R.id.car_details_history);
        extend_warranty = view.findViewById(R.id.car_extend_warranty);
        buy_insur = view.findViewById(R.id.car_buy_insurance);
        sell_expired = view.findViewById(R.id.car_sell);
        initToolBar();

        toolbar_exp.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_exp.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), SummaryActivity.class);
                startActivity(intent);

            }
        });
        details_histoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsHistoryFragment();

            }
        });
        extend_warranty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExtendWarrantyFragment();

            }
        });
        buy_insur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sell_expired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SellFragment();

            }
        });

        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_exp.setTitle(R.string.toolbar_for_expied);
        toolbar_exp.setTitleTextColor(getResources().getColor(R.color.jet));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_exp);
    }
}
