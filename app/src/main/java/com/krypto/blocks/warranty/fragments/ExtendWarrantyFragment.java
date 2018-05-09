package com.krypto.blocks.warranty.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krypto.blocks.warranty.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtendWarrantyFragment extends Fragment {


    Toolbar toolbar_extend_warranty;

    public void ExpiredFragment() {

        ExpiredFragment expiredFragment= new ExpiredFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, expiredFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public ExtendWarrantyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extend_warranty, container, false);
        toolbar_extend_warranty = view.findViewById(R.id.toolbar_extendwarranty);
        initToolBar();

        toolbar_extend_warranty.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar_extend_warranty.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExpiredFragment();


            }
        });
        return view;
    }
    public void initToolBar() {

        //  toolbar_bitcoin = findViewById(R.id.toolbar_bit);
        toolbar_extend_warranty.setTitle(R.string.toolbar_for_extend_warranty);
        toolbar_extend_warranty.setTitleTextColor(getResources().getColor(R.color.jet));
        //setSupportActionBar(toolbar_bitcoin);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar_extend_warranty);
    }
}
