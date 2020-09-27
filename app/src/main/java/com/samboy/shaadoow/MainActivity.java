package com.samboy.shaadoow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIds();
        setImage();
        startTimer();
    }


    private void getIds(){
        imgSplash = findViewById(R.id.imgSplash);
    }

    private void setImage(){
        Glide.with(this).load(R.drawable.sh_logo).into(imgSplash);
    }

    private void startTimer(){
        new Handler().postDelayed(this::gotoHome,3000);
    }
    private void gotoHome(){
        if(!isFinishing()){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }
    }
}