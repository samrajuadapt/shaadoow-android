package com.samboy.shaadoow.rest;

import com.samboy.shaadoow.model.Feed;
import com.samboy.shaadoow.model.response.ArtistResponse;
import com.samboy.shaadoow.model.response.FeedResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("artists/auth-less/list?")
    Call<ArtistResponse> getArtists(@Query("page") int page,@Query("limit") int limit);

    @GET("posts/recommended_for_you?")
    Call<FeedResponse> getFeeds(@Query("page") int page, @Query("limit") int limit);
}
