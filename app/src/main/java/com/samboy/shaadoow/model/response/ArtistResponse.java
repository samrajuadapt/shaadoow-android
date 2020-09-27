package com.samboy.shaadoow.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.samboy.shaadoow.model.Artist;

import java.util.List;

public class ArtistResponse {
    @SerializedName("success")
    @Expose
    private boolean isSuccess;
    @SerializedName("message")
    @Expose
    private List<String> message;
    @SerializedName("data")
    @Expose
    private List<Artist> mArtistList;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public List<Artist> getmArtistList() {
        return mArtistList;
    }

    public void setmArtistList(List<Artist> mArtistList) {
        this.mArtistList = mArtistList;
    }
}
