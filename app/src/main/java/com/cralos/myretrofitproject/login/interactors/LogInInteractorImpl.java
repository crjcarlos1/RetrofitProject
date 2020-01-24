package com.cralos.myretrofitproject.login.interactors;

import android.content.Context;
import android.text.TextUtils;

import com.cralos.myretrofitproject.login.interfaces.LogInInteractor;
import com.cralos.myretrofitproject.login.interfaces.LogInPresenter;
import com.cralos.myretrofitproject.login.interfaces.LoginServices;
import com.cralos.myretrofitproject.login.models.LoginRequest;
import com.cralos.myretrofitproject.login.models.LoginResponse;
import com.cralos.myretrofitproject.retrofitClient.RetrofitClient;
import com.cralos.myretrofitproject.retrofitClient.RetrofitValidations;
import com.cralos.myretrofitproject.retrofitClient.StatusCodes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LogInInteractorImpl implements LogInInteractor {

    private LogInPresenter presenter;
    private Context context;
    private LoginServices loginServices;
    private Retrofit retrofit;

    public LogInInteractorImpl(LogInPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        retrofit = RetrofitClient.getRetrofitInstance();
        loginServices = retrofit.create(LoginServices.class);
    }

    @Override
    public void validateUserData(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            presenter.setMessage("Ingresa email y contraseña");
        } else {
            validateEmailFormat(email, password);
        }
    }

    private void validateEmailFormat(String email, String password) {
        boolean emailValidation = !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        if (emailValidation) {
            requestLogin(email, password);
        } else {
            presenter.setMessage("Correo electrónico no válido");
        }
    }

    private void requestLogin(String email, String password) {
        LoginRequest request = new LoginRequest(email, password);
        Call<LoginResponse> call = loginServices.login(request);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                validateLoginResponseCode(response);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                presenter.setMessage(RetrofitValidations.getOnFailureResponse(t, context));
            }
        });
    }

    private void validateLoginResponseCode(Response<LoginResponse> response) {
        if (response.code() == StatusCodes.SUCCESS_CODE) {
            getLoginData(response);
        } else {
            //presenter.setMessage(RetrofitValidations.getErrorByStatusCode(response.code(), context));  //SERVICIO FUE HECHO SOLO PARA SUCCESS REQUEST
            presenter.setMessage("Error");
        }
    }

    private void getLoginData(Response<LoginResponse> loginResponse) {
        LoginResponse response = loginResponse.body();
        if (response != null) {
            String token = response.getToken();
            presenter.successLogIn();
        } else {
            presenter.setMessage("No se obtuvo respuesta");
        }
    }

}
