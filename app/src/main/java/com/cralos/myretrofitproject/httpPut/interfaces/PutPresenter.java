package com.cralos.myretrofitproject.httpPut.interfaces;

import com.cralos.myretrofitproject.httpPut.models.PutResponse;

public interface PutPresenter {
    /*setDataToInteractor*/
    void putRequest(String name, String job);

    /*setDataToView*/
    void setMessage(String message);

    void setPutRequest(PutResponse request);
}
