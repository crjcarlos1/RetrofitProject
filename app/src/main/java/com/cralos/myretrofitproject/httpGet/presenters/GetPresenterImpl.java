package com.cralos.myretrofitproject.httpGet.presenters;

import android.content.Context;

import com.cralos.myretrofitproject.httpGet.interactors.GetInteractorImpl;
import com.cralos.myretrofitproject.httpGet.interfaces.GetInteractor;
import com.cralos.myretrofitproject.httpGet.interfaces.GetPresenter;
import com.cralos.myretrofitproject.httpGet.interfaces.GetView;
import com.cralos.myretrofitproject.httpGet.models.User;

import java.util.List;

public class GetPresenterImpl implements GetPresenter {

    private GetView view;
    private GetInteractor interactor;

    public GetPresenterImpl(GetView view, Context context) {
        this.view = view;
        interactor = new GetInteractorImpl(this, context);
    }

    @Override
    public void getMethod() {
        if (view != null) {
            view.showLoader();
            interactor.getMethod();
        }
    }

    @Override
    public void setUsers(List<User> users) {
        if (view != null) {
            view.hideLoader();
            view.showUsers(users);
        }
    }

    @Override
    public void setMessage(String message) {
        if (view != null) {
            view.hideLoader();
            view.showMessage(message);
        }
    }
}
