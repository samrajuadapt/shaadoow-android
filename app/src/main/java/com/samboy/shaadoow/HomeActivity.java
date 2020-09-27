package com.samboy.shaadoow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.samboy.shaadoow.adapter.ArtistAdapter;
import com.samboy.shaadoow.adapter.FeedsAdapter;
import com.samboy.shaadoow.model.Artist;
import com.samboy.shaadoow.model.Feed;
import com.samboy.shaadoow.viewmodels.ArtistViewModel;
import com.samboy.shaadoow.viewmodels.FeedViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity{

    private Dialog dialog;

    private ArtistViewModel mArtistViewModel;
    private FeedViewModel mFeedViewModel;

    private List<Artist> mArtistList;
    private List<Feed> mFeedList;

    private ArtistAdapter mArtistAdapter;
    private RecyclerView rvArtist;

    private FeedsAdapter mFeedAdapter;
    private RecyclerView rvFeeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initDialog(this);
        init();
        getIds();
        setArtistAdapters();
        setFeedAdapters();
        initViewModel();
        initObserver();
    }

    /***** TO SHOW PROGRESS DIALOG******/
    public void initDialog(Context context) {
        dialog= new Dialog(context, android.R.style.Theme_Black);
        View view = LayoutInflater.from(context).inflate(R.layout.ly_progress, null);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(R.color.transparent);
        dialog.setContentView(view);
    }

    private void init(){
        mArtistList = new ArrayList<>();
        mFeedList = new ArrayList<>();
    }
    private void getIds(){
        rvArtist = findViewById(R.id.rvArtist);
        rvFeeds = findViewById(R.id.rvFeeds);
    }

    /***** INIT VM ******/
    private void initViewModel(){
        mArtistViewModel = new ViewModelProvider(this).get(ArtistViewModel.class);
        mFeedViewModel = new ViewModelProvider(this).get(FeedViewModel.class);
        mArtistViewModel.init();
        mFeedViewModel.init();
    }

    /***** INIT OBSERVERS ******/
    private void initObserver(){
        dialog.show();
        mArtistViewModel.getArtist().observe(this,artistObserver);
        mFeedViewModel.getFeeds().observe(this,feedObserver);
    }

    /***** INIT ARTIST RV ******/
    private void setArtistAdapters(){
        mArtistAdapter  = new ArtistAdapter(mArtistList);
        GridLayoutManager lyMgr = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        rvArtist.setLayoutManager(lyMgr);
        rvArtist.setAdapter(mArtistAdapter);

    }

    /***** INIT FEEDS RV ******/
    private void setFeedAdapters(){
        mFeedAdapter  = new FeedsAdapter(mFeedList);
        GridLayoutManager lyMgr = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rvFeeds.setLayoutManager(lyMgr);
        rvFeeds.setAdapter(mFeedAdapter);

    }

    /***** LISTEN DATA CHANGES ******/
    Observer<List<Artist>> artistObserver = artists -> {
        this.mArtistList = artists;
        mArtistAdapter.updateData(this.mArtistList);
    };

    Observer<List<Feed>> feedObserver = feeds -> {
        this.mFeedList = feeds;
        mFeedAdapter.updateData(mFeedList);
        dialog.dismiss();
    };

}