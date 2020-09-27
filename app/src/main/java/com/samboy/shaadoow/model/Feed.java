package com.samboy.shaadoow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feed {
    @SerializedName("_id")
    @Expose
    public String id;
    @SerializedName("parent")
    @Expose
    public int parent;
    @SerializedName("created_by")
    @Expose
    public CreatedUser createdBy;
    @SerializedName("recording_details")
    @Expose
    public Recording recordingDetails;
    @SerializedName("song_details")
    @Expose
    public Song songDetails;
    @SerializedName("artist_details")
    @Expose
    public Artist artistDetails;
    @SerializedName("interactions_counter")
    @Expose
    public Interaction interactionCounter;
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("weight")
    @Expose
    public int weight;
    @SerializedName("published")
    @Expose
    public int published;
    @SerializedName("views")
    @Expose
    public int views;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("is_liked")
    @Expose
    public boolean is_liked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public CreatedUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedUser createdBy) {
        this.createdBy = createdBy;
    }

    public Recording getRecordingDetails() {
        return recordingDetails;
    }

    public void setRecordingDetails(Recording recordingDetails) {
        this.recordingDetails = recordingDetails;
    }

    public Song getSongDetails() {
        return songDetails;
    }

    public void setSongDetails(Song songDetails) {
        this.songDetails = songDetails;
    }

    public Artist getArtistDetails() {
        return artistDetails;
    }

    public void setArtistDetails(Artist artistDetails) {
        this.artistDetails = artistDetails;
    }

    public Interaction getInteractionCounter() {
        return interactionCounter;
    }

    public void setInteractionCounter(Interaction interactionCounter) {
        this.interactionCounter = interactionCounter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isIs_liked() {
        return is_liked;
    }

    public void setIs_liked(boolean is_liked) {
        this.is_liked = is_liked;
    }
}
