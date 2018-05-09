package com.krypto.blocks.warranty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.krypto.blocks.particletextview.MovingStrategy.Object.ParticleTextViewConfig;
import com.krypto.blocks.particletextview.MovingStrategy.View.ParticleTextView;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        plaintextview();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //OS WILL COME HERE AFTER 5000 MILLI SECONDS
                finish();
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        }, 12000);

    }
    private  void plaintextview(){

        final ParticleTextView particleTextView =  findViewById(R.id.particle);
        ParticleTextViewConfig config1 = new ParticleTextViewConfig.Builder()
                .setTargetText(new String[]{"Warranty","Recalls","Returns"})
                .setReleasing(0.2)
                .setParticleRadius(4)
                .setMiniDistance(1)
                .setTextSize(150)
                .setRowStep(9)
                .setColumnStep(9)
                .setParticleColorArray(new String[]{"#00B0FF"})
                .instance();
        particleTextView.setConfig(config1);
        particleTextView.startAnimation();
    }
}
