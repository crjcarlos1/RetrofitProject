package com.cralos.myretrofitproject.httpGet.interactors;

import android.content.Context;

import com.cralos.myretrofitproject.httpGet.interfaces.GetInteractor;
import com.cralos.myretrofitproject.httpGet.interfaces.GetPresenter;
import com.cralos.myretrofitproject.httpGet.interfaces.GetServices;
import com.cralos.myretrofitproject.httpGet.models.GetResponse;
import com.cralos.myretrofitproject.httpGet.models.User;
import com.cralos.myretrofitproject.retrofitClient.RetrofitClient;
import com.cralos.myretrofitproject.retrofitClient.RetrofitValidations;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetInteractorImpl implements GetInteractor {

    private GetPresenter presenter;
    private Retrofit retrofit;
    private GetServices services;
    private Context context;

    public GetInteractorImpl(GetPresenter presenter, Context context) {
        this.presenter = presenter;
        retrofit = RetrofitClient.getRetrofitInstance();
        services = retrofit.create(GetServices.class);
    }

    @Override
    public void getMethod() {
        int delay = 5;  /*delay 5 segundos*/
        Call<GetResponse> call = services.getMethod(delay);
        call.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                getResponse(response);
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                presenter.setMessage(RetrofitValidations.getOnFailureResponse(t, context));
            }
        });
    }

    private void getResponse(Response<GetResponse> response) {
        if (RetrofitValidations.checkSuccessCode(response.code())) {
            getSuccessResponse(response);
        } else {
            presenter.setMessage(RetrofitValidations.getErrorByStatusCode(response.code(), context));
        }
    }

    private void getSuccessResponse(Response<GetResponse> responseMethod) {
        GetResponse response = responseMethod.body();
        if (response != null) {
            List<User> users = response.getData();
            if (users != null && users.size() > 0) {
                presenter.setUsers(users);
            } else {
                presenter.setMessage("No se encontraron usuarios");
            }
        } else {
            presenter.setMessage("No se encontraron datos");
        }
    }

}
