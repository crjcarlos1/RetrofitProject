package com.cralos.myretrofitproject.httpPut.interactors;

import android.content.Context;

import com.cralos.myretrofitproject.httpPut.interfaces.PutInteractor;
import com.cralos.myretrofitproject.httpPut.interfaces.PutPresenter;
import com.cralos.myretrofitproject.httpPut.interfaces.PutServices;
import com.cralos.myretrofitproject.httpPut.models.PutRequest;
import com.cralos.myretrofitproject.httpPut.models.PutResponse;
import com.cralos.myretrofitproject.retrofitClient.RetrofitClient;
import com.cralos.myretrofitproject.retrofitClient.RetrofitValidations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PutInteractorImpl implements PutInteractor {

    private PutPresenter presenter;
    private Context context;
    private Retrofit retrofit;
    private PutServices services;

    public PutInteractorImpl(PutPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        retrofit = RetrofitClient.getRetrofitInstance();
        services = retrofit.create(PutServices.class);

    }

    @Override
    public void putRequest(String name, String job) {
        PutRequest request = new PutRequest(name, job);
        Call<PutResponse> call = services.putRequest(request);
        call.enqueue(new Callback<PutResponse>() {
            @Override
            public void onResponse(Call<PutResponse> call, Response<PutResponse> response) {
                validateResponseCode(response);
            }

            @Override
            public void onFailure(Call<PutResponse> call, Throwable t) {
                presenter.setMessage(RetrofitValidations.getOnFailureResponse(t, context));
            }
        });

    }

    private void validateResponseCode(Response<PutResponse> response) {
        if (RetrofitValidations.checkSuccessCode(response.code())) {
            successPutResponse(response);
        } else {
            presenter.setMessage(RetrofitValidations.getErrorByStatusCode(response.code(), context));
        }
    }

    private void successPutResponse(Response<PutResponse> putResponse) {
        PutResponse response = putResponse.body();
        if (response != null) {
            presenter.setPutRequest(response);
        } else {
            presenter.setMessage("No se encontraron datos de respuesta");
        }
    }

}
