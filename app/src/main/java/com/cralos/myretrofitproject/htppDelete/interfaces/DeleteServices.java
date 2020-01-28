package com.cralos.myretrofitproject.htppDelete.interfaces;

import com.cralos.myretrofitproject.htppDelete.DeleteResponse;
import com.cralos.myretrofitproject.retrofitClient.EndPoints;

import retrofit2.Call;
import retrofit2.http.DELETE;

public interface DeleteServices {
    /**
     * @return
     */
    @DELETE(EndPoints.DELETE)
    Call<DeleteResponse> delete();
}
