package com.cralos.myretrofitproject.httpPost.interfaces;

import com.cralos.myretrofitproject.httpPost.models.PostResponse;

public interface PostPresenter {
    /*setDataToInteractor*/
    void postRequest(String name, String job);

    /*setDataToView*/
    void setMessage(String message);

    void setResponse(PostResponse response);
}
