package com.krypto.blocks.warranty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

//import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SendActivity extends AppCompatActivity {


    IntentIntegrator qrScan;
    String QRname;
    private ZXingScannerView mScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(R.layout.activity_send);
          // Programmatically initialize the scanner view
        qrScan = new IntentIntegrator(this);


    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result != null) {
                //if qrcode has nothing in it
                if (result.getContents() == null) {
                    Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
                } else {
                    //if qr contains data
                    try {
                        //converting the data to json
                        JSONObject obj = new JSONObject(result.getContents());

                         QRname = obj.getString("name");
                        //setting values to textviews
                   // textViewName.setText(obj.getString("name"));
                      //  textViewAddress.setText(obj.getString("address"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        //if control comes here
                        //that means the encoded format not matches
                        //in this case you can display whatever data is available on the qrcode
                        //to a toast
                        Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
        //@Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }
    }



