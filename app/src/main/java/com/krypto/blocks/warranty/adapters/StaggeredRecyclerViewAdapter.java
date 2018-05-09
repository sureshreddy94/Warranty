package com.krypto.blocks.warranty.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.krypto.blocks.warranty.R;
import com.krypto.blocks.warranty.RegisterProductsActivity;
import com.krypto.blocks.warranty.SummaryActivity;
import com.krypto.blocks.warranty.fragments.HomeFragment;

import java.util.ArrayList;

/**
 * Created by Suresh on 17-04-2018.
 */

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "StaggeredRecyclerViewAd";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private HomeFragment mContext;
    public StaggeredRecyclerViewAdapter(HomeFragment context, ArrayList<String> names, ArrayList<String> imageUrls) {
        mNames = names;
        mImageUrls = imageUrls;
        mContext = context;
    }
    @Override
    public StaggeredRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StaggeredRecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        Log.d(TAG, "onBindViewHolder: called.");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(mNames.get(position));
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mNames.get(position));
                Intent intent = new Intent(mContext.getContext(),RegisterProductsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.getContext().startActivity(intent);
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageUrls.get(position));
                Log.d(TAG, "onClick: clicked on: " + mNames.get(position));
                //Toast.makeText(mContext, mNames.get(position), LENGTH_SHORT).show();
                //Intent intent = new Intent((StaggeredRecyclerViewAdapter)mContext.this,SummaryActivity.class);
                //mContext.startActivity(intent);
                //view.getContext().startActivity();
                Intent intent = new Intent(mContext.getContext(),SummaryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageview_widget);
            this.name = itemView.findViewById(R.id.name_widget);
        }

    }
}
