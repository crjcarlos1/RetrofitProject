package com.cralos.myretrofitproject.httpGet.interfaces;

import com.cralos.myretrofitproject.httpGet.models.User;

import java.util.List;

public interface GetView {
    void showLoader();

    void hideLoader();

    void showMessage(String message);

    void showUsers(List<User> users);
}
