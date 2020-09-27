package com.samboy.shaadoow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recording {
    @SerializedName("duration")
    @Expose
    public double duration;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("cover_img_url")
    @Expose
    public String coverImage;
    @SerializedName("recording_url")
    @Expose
    public String recordingUrl;
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("recordingId")
    @Expose
    public int recording_id;

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getRecordingUrl() {
        return recordingUrl;
    }

    public void setRecordingUrl(String recordingUrl) {
        this.recordingUrl = recordingUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRecording_id() {
        return recording_id;
    }

    public void setRecording_id(int recording_id) {
        this.recording_id = recording_id;
    }
}
