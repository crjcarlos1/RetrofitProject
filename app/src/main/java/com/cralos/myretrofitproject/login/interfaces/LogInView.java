package com.cralos.myretrofitproject.login.interfaces;

public interface LogInView {

    void showLoader();

    void hideLoader();

    void showMessage(String message);

    void successLogIn();
}
