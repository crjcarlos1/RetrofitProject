package com.cralos.myretrofitproject.login.interactors;

import android.content.Context;

import com.cralos.myretrofitproject.login.interfaces.LogInInteractor;
import com.cralos.myretrofitproject.login.interfaces.LogInPresenter;

public class LogInInteractorImpl implements LogInInteractor {

    private LogInPresenter presenter;
    private Context context;

    public LogInInteractorImpl(LogInPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void validateUserData(String email, String password) {

    }

}
