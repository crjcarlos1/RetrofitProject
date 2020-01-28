package com.cralos.myretrofitproject.htppDelete.interfaces;

public interface DeletePresenter {
    /*setDataToInteractor*/
    void deleteRequest();

    /*setDataToView*/
    void setMessage(String message);

    void successDelete();
}
