package com.cralos.myretrofitproject.htppDelete.presenters;

import android.content.Context;

import com.cralos.myretrofitproject.htppDelete.interactors.DeleteInteractorImpl;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeleteInteractor;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeletePresenter;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeleteView;

public class DletePresenterImpl implements DeletePresenter {

    private DeleteView view;
    private DeleteInteractor interactor;

    public DletePresenterImpl(DeleteView view, Context context) {
        this.view = view;
        interactor = new DeleteInteractorImpl(this, context);
    }

    @Override
    public void deleteRequest() {
        if (view != null) {
            view.showLoader();
            interactor.deleteRequest();
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
    public void successDelete() {
        if (view != null) {
            view.hideLoader();
            view.successDelete();
        }
    }
}
