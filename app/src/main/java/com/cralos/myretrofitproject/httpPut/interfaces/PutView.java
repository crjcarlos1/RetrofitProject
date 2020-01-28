package com.cralos.myretrofitproject.httpPut.interfaces;

import com.cralos.myretrofitproject.httpPut.models.PutResponse;

public interface PutView {
    void showLoader();

    void hideLoader();

    void showMessage(String message);

    void successPutResponse(PutResponse response);
}
