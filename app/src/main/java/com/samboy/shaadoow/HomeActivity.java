package com.samboy.shaadoow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.samboy.shaadoow.model.Artist;
import com.samboy.shaadoow.viewmodels.ArtistViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements Observer<List<Artist>> {

    private ArtistViewModel mArtistViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        initObserver();
    }

    private void initViews(){
        mArtistViewModel = new ViewModelProvider(this).get(ArtistViewModel.class);
        mArtistViewModel.init();
    }


    private void initObserver(){
        mArtistViewModel.getArtist().observe(this,this);
    }

    private void getIds(){

    }
    private void setAdapters(){

    }

    /***** OBSERVE ARTIST CHANGE ******/
    @Override
    public void onChanged(List<Artist> artists) {
        for(Artist a:artists){
            Log.e("TAG", "onChanged: "+a.getNames() );
        }
    }
}