package com.samboy.shaadoow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interaction {
    @SerializedName("comments")
    @Expose
    public int comments;
    @SerializedName("likes")
    @Expose
    public int likes;
    @SerializedName("points")
    @Expose
    public int points;

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
