package com.cralos.myretrofitproject.httpGet.interfaces;

import com.cralos.myretrofitproject.httpGet.models.User;

import java.util.List;

public interface GetPresenter {
    /*setDataToInteractor*/
    void getMethod();

    /*setDataToView*/
    void setUsers(List<User> users);

    void setMessage(String message);
}
