package com.example.astronomypictureoftheday;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APODService {
    @GET("planetary/apod")
    Call<APOD> getAPODData(@Query("api_key") String apiKey, @Query("date") String date);
}
