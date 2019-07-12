package com.sitimaeturoh.androiddasar5onlinedb.retrofit;

import com.sitimaeturoh.androiddasar5onlinedb.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<ResponseMovie> ambilDataMOvie(
        @Query("api_key") String apikey
    );
}

