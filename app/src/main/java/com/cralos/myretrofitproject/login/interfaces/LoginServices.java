package com.cralos.myretrofitproject.login.interfaces;

import com.cralos.myretrofitproject.login.models.LoginRequest;
import com.cralos.myretrofitproject.login.models.LoginResponse;
import com.cralos.myretrofitproject.retrofitClient.EndPoints;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginServices {

    /**
     * @param request
     * @return
     */
    @POST(EndPoints.LOGIN)
    Call<LoginResponse> login(@Body LoginRequest request);

}
