package com.samboy.shaadoow.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samboy.shaadoow.consts.SC;
import com.samboy.shaadoow.model.Artist;
import com.samboy.shaadoow.repo.ArtistRepo;

import java.util.List;

public class ArtistViewModel extends ViewModel {
    private MutableLiveData<List<Artist>> mArtistList;
    private ArtistRepo mRepo;

    public void init(){
        if(mArtistList != null){
            return;
        }
        mRepo = ArtistRepo.getInstance();
        mArtistList = mRepo.getArtist(SC.DEFAULT_PAGE,SC.DEFAULT_LIMIT);
    }

    public LiveData<List<Artist>> getArtist(){
        return  mArtistList;
    }

    public void updateArtist(int page,int limit){
        List<Artist> mList = mArtistList.getValue();
        mList.addAll(mRepo.getArtist(page,limit).getValue());
        mArtistList.postValue(mList);
    }

}
