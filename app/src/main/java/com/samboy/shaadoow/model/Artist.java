package com.samboy.shaadoow.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Artist {
    @SerializedName("artist_id")
    @Expose
    private int artistId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("names")
    @Expose
    private String names;
    @SerializedName("category")
    @Expose
    private int category;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("region_id")
    @Expose
    private String regionId;
    @SerializedName("cover_img_url")
    @Expose
    private String coverImage;
    @SerializedName("profile_img_url")
    @Expose
    private String profileImage;
    @SerializedName("published")
    @Expose
    private int published;
    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("created_at")
    @Expose
    private String createDate;
    @SerializedName("updated_at")
    @Expose
    private String updateDate;
    @SerializedName("deleted_at")
    @Expose
    @Nullable
    private String deleteDate;
    @SerializedName("profile_id")
    @Expose
    private int profileId;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("followers")
    @Expose
    private int followers;

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    @Nullable
    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(@Nullable String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
