package com.cralos.myretrofitproject.httpPost.interfaces;

import com.cralos.myretrofitproject.httpPost.models.PostRequest;
import com.cralos.myretrofitproject.httpPost.models.PostResponse;
import com.cralos.myretrofitproject.retrofitClient.EndPoints;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostServices {
    /**
     * @param request
     * @return
     */
    @POST(EndPoints.POST)
    Call<PostResponse> postMethod(@Body PostRequest request);
}
