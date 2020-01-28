package com.cralos.myretrofitproject.httpPut.interfaces;

import com.cralos.myretrofitproject.httpPut.models.PutRequest;
import com.cralos.myretrofitproject.httpPut.models.PutResponse;
import com.cralos.myretrofitproject.retrofitClient.EndPoints;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface PutServices {

    /**
     * @param request
     * @return
     */
    @PUT(EndPoints.PUT)
    Call<PutResponse> putRequest(@Body PutRequest request);

}
