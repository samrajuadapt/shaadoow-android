package com.samboy.shaadoow.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.samboy.shaadoow.model.Artist;
import com.samboy.shaadoow.model.Feed;

import java.util.List;

public class FeedResponse {
    @SerializedName("success")
    @Expose
    private boolean isSuccess;
    @SerializedName("message")
    @Expose
    private List<String> message;
    @SerializedName("data")
    @Expose
    private List<Feed> mFeedList;

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

    public List<Feed> getmFeedList() {
        return mFeedList;
    }

    public void setmFeedList(List<Feed> mFeedList) {
        this.mFeedList = mFeedList;
    }
}
