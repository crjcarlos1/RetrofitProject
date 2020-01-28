package com.cralos.myretrofitproject.httpPost.interactors;

import android.content.Context;

import com.cralos.myretrofitproject.httpPost.interfaces.PostInteractor;
import com.cralos.myretrofitproject.httpPost.interfaces.PostPresenter;
import com.cralos.myretrofitproject.httpPost.interfaces.PostServices;
import com.cralos.myretrofitproject.httpPost.models.PostRequest;
import com.cralos.myretrofitproject.httpPost.models.PostResponse;
import com.cralos.myretrofitproject.retrofitClient.RetrofitClient;
import com.cralos.myretrofitproject.retrofitClient.RetrofitValidations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostInteractorImpl implements PostInteractor {

    private PostPresenter presenter;
    private Context context;
    private PostServices services;
    private Retrofit retrofit;

    public PostInteractorImpl(PostPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        retrofit = RetrofitClient.getRetrofitInstance();
        services = retrofit.create(PostServices.class);
    }

    @Override
    public void postRequest(String name, String job) {
        PostRequest request = new PostRequest(name, job);
        Call<PostResponse> call = services.postMethod(request);

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                validateResponseCode(response);
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                presenter.setMessage(RetrofitValidations.getOnFailureResponse(t, context));
            }
        });
    }

    private void validateResponseCode(Response<PostResponse> response) {
        if (response.code() == 201) {  // asi responde el servicio
            getPostSuccess(response);
        } else {
            presenter.setMessage(RetrofitValidations.getErrorByStatusCode(response.code(), context));
        }
    }

    private void getPostSuccess(Response<PostResponse> postResponse) {
        PostResponse response = postResponse.body();
        if (response != null) {
            presenter.setResponse(response);
        } else {
            presenter.setMessage("No se encontraron datos");
        }
    }

}
