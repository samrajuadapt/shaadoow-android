package com.samboy.shaadoow.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.samboy.shaadoow.model.Artist;
import com.samboy.shaadoow.model.response.ArtistResponse;
import com.samboy.shaadoow.rest.ApiService;
import com.samboy.shaadoow.rest.RetroClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistRepo {
    private static ArtistRepo instance;
    private static ApiService api;
    private List<Artist> mList = new ArrayList<>();


    public static ArtistRepo getInstance(){
        if(instance == null){
            instance = new ArtistRepo();
        }
        return instance;
    }

    private ArtistRepo(){
        api = RetroClient.getApiService();
    }

    public MutableLiveData<List<Artist>> getArtist(int page,int limit){
        MutableLiveData<List<Artist>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(mList);
        api.getArtists(page,limit).enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(Call<ArtistResponse> call, Response<ArtistResponse> response) {
                if(response.body().isSuccess()){
                    mList = response.body().getmArtistList();
                    mutableLiveData.postValue(mList);
                }
            }

            @Override
            public void onFailure(Call<ArtistResponse> call, Throwable t) {
                Log.e("TAG", "onResponse: "+t );
            }
        });

        return mutableLiveData;
    }
}
