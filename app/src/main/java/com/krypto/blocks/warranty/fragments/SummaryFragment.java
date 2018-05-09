package com.krypto.blocks.warranty.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krypto.blocks.warranty.R;
import com.krypto.blocks.warranty.adapters.SampleItem;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private FastItemAdapter fastAdapter;
    public static SummaryFragment newInstance() {
        return new SummaryFragment();
    }


    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();

        addData();
    }
    private void setupRecyclerView() {
        fastAdapter = new FastItemAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(fastAdapter);
    }

    private void addData() {
        for (int i = 0; i < 2; i++) {
            //fastAdapter.add(new SampleItem().withName("Vehicles | Item " + i));
            fastAdapter.add(new SampleItem().withName("Vehicles" +'\n'+ "Your cars,motor cycle,bicycle" ));
            fastAdapter.add(new SampleItem().withName("Electronics" +'\n'+ "Your Laptop,camera" ));
            fastAdapter.add(new SampleItem().withName("Holdhold Goods" +'\n'+ "Your Refregirator,Washer,Dryer" ));

        }
    }

    public void refreshData() {
        fastAdapter.clear();
        addData();
    }
}
