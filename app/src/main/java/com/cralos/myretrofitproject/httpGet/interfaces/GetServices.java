package com.cralos.myretrofitproject.httpGet.interfaces;

import com.cralos.myretrofitproject.httpGet.models.GetResponse;
import com.cralos.myretrofitproject.retrofitClient.EndPoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetServices {
    /**
     * @param delay
     * @return
     */
    @GET(EndPoints.GET)
    Call<GetResponse> getMethod(@Query("delay") int delay);
}
