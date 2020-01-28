package com.cralos.myretrofitproject.htppDelete.interactors;

import android.content.Context;

import com.cralos.myretrofitproject.htppDelete.DeleteResponse;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeleteInteractor;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeletePresenter;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeleteServices;
import com.cralos.myretrofitproject.retrofitClient.RetrofitClient;
import com.cralos.myretrofitproject.retrofitClient.RetrofitValidations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeleteInteractorImpl implements DeleteInteractor {

    private DeletePresenter presenter;
    private Context context;
    private Retrofit retrofit;
    private DeleteServices services;

    public DeleteInteractorImpl(DeletePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        retrofit = RetrofitClient.getRetrofitInstance();
        services = retrofit.create(DeleteServices.class);
    }

    @Override
    public void deleteRequest() {
        Call<DeleteResponse> call = services.delete();
        call.enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                validateResponseCode(response);
            }

            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {
                presenter.setMessage(RetrofitValidations.getOnFailureResponse(t, context));
            }
        });
    }

    private void validateResponseCode(Response<DeleteResponse> response) {
        if (response.code() == 204)   // asi deberia responder el web service si se elimina de forma correcta
        {
            presenter.setMessage("success delete");
            presenter.successDelete();
        } else {
            presenter.setMessage(RetrofitValidations.getErrorByStatusCode(response.code(), context));
        }
    }

}
