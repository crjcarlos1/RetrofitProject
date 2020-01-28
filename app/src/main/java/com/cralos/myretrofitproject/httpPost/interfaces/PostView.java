package com.cralos.myretrofitproject.httpPost.interfaces;

import com.cralos.myretrofitproject.httpPost.models.PostResponse;

public interface PostView {
    void showLoader();

    void hideLoader();

    void showMessage(String message);

    void successPost(PostResponse response);
}
