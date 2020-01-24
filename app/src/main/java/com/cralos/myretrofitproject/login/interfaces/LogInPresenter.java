package com.cralos.myretrofitproject.login.interfaces;

public interface LogInPresenter {

    /*setDataToInteractor*/
    void validateUserData(String email,String password);

    /*setDataToview*/
    void setMessage(String message);
    void successLogIn();
}
