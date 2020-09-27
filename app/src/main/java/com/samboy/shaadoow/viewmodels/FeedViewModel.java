package com.samboy.shaadoow.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samboy.shaadoow.consts.SC;
import com.samboy.shaadoow.model.Artist;
import com.samboy.shaadoow.model.Feed;
import com.samboy.shaadoow.repo.ArtistRepo;
import com.samboy.shaadoow.repo.FeedRepo;

import java.util.List;

public class FeedViewModel extends ViewModel {
    private MutableLiveData<List<Feed>> mFeedList;
    private FeedRepo mRepo;

    public void init(){
        if(mFeedList != null){
            return;
        }
        mRepo = FeedRepo.getInstance();
        mFeedList = mRepo.getFeeds(SC.DEFAULT_PAGE,SC.DEFAULT_FEED_LIMIT);
    }

    public LiveData<List<Feed>> getFeeeds(){
        return  mFeedList;
    }

    public void updateFeeds(int page,int limit){
        List<Feed> mList = mFeedList.getValue();
        mList.addAll(mRepo.getFeeds(page,limit).getValue());
        mFeedList.postValue(mList);
    }
}
