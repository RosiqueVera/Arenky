package com.example.arenky;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TravelPayoutsApi {

    @GET("v1/city-directions?origin=MOW&currency=usd&token=98983e1f8fecec70c5231f4a367f1b7e")
    Call<PopularRoutes> getPopularRoutes();

}
