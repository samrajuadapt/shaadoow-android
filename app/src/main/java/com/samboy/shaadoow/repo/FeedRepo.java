package com.samboy.shaadoow.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.samboy.shaadoow.model.Artist;
import com.samboy.shaadoow.model.Feed;
import com.samboy.shaadoow.model.response.ArtistResponse;
import com.samboy.shaadoow.model.response.FeedResponse;
import com.samboy.shaadoow.rest.ApiService;
import com.samboy.shaadoow.rest.RetroClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedRepo {

    private static FeedRepo instance;
    private static ApiService api;
    private List<Feed> mList = new ArrayList<>();


    public static FeedRepo getInstance(){
        if(instance == null){
            instance = new FeedRepo();
        }
        return instance;
    }

    private FeedRepo(){
        api = RetroClient.getApiService();
    }

    public MutableLiveData<List<Feed>> getFeeds(int page, int limit){
        MutableLiveData<List<Feed>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(mList);
        api.getFeeds(page,limit).enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                if(response.body().isSuccess()){
                    mList = response.body().getmFeedList();
                    mutableLiveData.postValue(mList);
                }
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t );
            }
        });

        return mutableLiveData;
    }
}
