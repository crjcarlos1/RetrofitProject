package com.cralos.myretrofitproject.login.presenters;

import android.content.Context;

import com.cralos.myretrofitproject.login.interactors.LogInInteractorImpl;
import com.cralos.myretrofitproject.login.interfaces.LogInInteractor;
import com.cralos.myretrofitproject.login.interfaces.LogInPresenter;
import com.cralos.myretrofitproject.login.interfaces.LogInView;

public class LogInPresenterImpl implements LogInPresenter {

    private LogInView view;
    private LogInInteractor inInteractor;

    public LogInPresenterImpl(LogInView view, Context context) {
        this.view = view;
        inInteractor = new LogInInteractorImpl(this, context);
    }

    @Override
    public void validateUserData(String email, String password) {
        if (view != null) {
            view.showLoader();
            inInteractor.validateUserData(email, password);
        }
    }

    @Override
    public void setMessage(String message) {
        if (view != null) {
            view.hideLoader();

            view.showMessage(message);
        }
    }

    @Override
    public void successLogIn() {
        if (view != null) {
            view.hideLoader();
            view.successLogIn();
        }
    }
}
