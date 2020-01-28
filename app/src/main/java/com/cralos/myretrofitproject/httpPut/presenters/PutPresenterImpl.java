package com.cralos.myretrofitproject.httpPut.presenters;

import android.content.Context;

import com.cralos.myretrofitproject.httpPut.interactors.PutInteractorImpl;
import com.cralos.myretrofitproject.httpPut.interfaces.PutInteractor;
import com.cralos.myretrofitproject.httpPut.interfaces.PutPresenter;
import com.cralos.myretrofitproject.httpPut.interfaces.PutView;
import com.cralos.myretrofitproject.httpPut.models.PutResponse;

public class PutPresenterImpl implements PutPresenter {

    private PutView view;
    private PutInteractor interactor;

    public PutPresenterImpl(PutView view, Context context) {
        this.view = view;
        interactor = new PutInteractorImpl(this, context);
    }

    @Override
    public void putRequest(String name, String job) {
        if (view != null) {
            view.showLoader();
            interactor.putRequest(name, job);
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
    public void setPutRequest(PutResponse request) {
        if (view != null) {
            view.hideLoader();
            view.successPutResponse(request);
        }
    }
}
