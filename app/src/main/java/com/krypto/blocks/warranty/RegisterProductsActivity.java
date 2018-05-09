package com.krypto.blocks.warranty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.krypto.blocks.warranty.fragments.HomeFragment;
import com.krypto.blocks.warranty.scanner.FullScannerActivity;

public class RegisterProductsActivity extends AppCompatActivity {

    public void HomeFragment() {

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, homeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    TextView scan;
ImageView bac_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_products);
        bac_btn = findViewById(R.id.back_btn);
        scan = findViewById(R.id.scany);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterProductsActivity.this,FullScannerActivity.class);
                startActivity(i);
            }
        });
        bac_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment();
            }
        });


    }
}
