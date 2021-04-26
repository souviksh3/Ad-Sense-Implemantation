package com.example.demo_advertiesment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Main2Activity extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    @Override
    public void onBackPressed() {
        AdRequest adRequest = new AdRequest.Builder().build();
        //Preaper the Interstitial Ad

        interstitialAd = new InterstitialAd(Main2Activity.this);

        //Insert the Ad Unit

        interstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitialAd.loadAd(adRequest);
        //Prepare an Interstitial Ad Listener
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                //Call displayInterstitial() function
                displayInterstitial();
            }
        });

        Intent i = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(i);
        finish();

    }

    private void displayInterstitial() {
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }
}
