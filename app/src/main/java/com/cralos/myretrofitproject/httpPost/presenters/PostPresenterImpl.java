package com.cralos.myretrofitproject.httpPost.presenters;

import android.content.Context;

import com.cralos.myretrofitproject.httpPost.interactors.PostInteractorImpl;
import com.cralos.myretrofitproject.httpPost.interfaces.PostInteractor;
import com.cralos.myretrofitproject.httpPost.interfaces.PostPresenter;
import com.cralos.myretrofitproject.httpPost.interfaces.PostView;
import com.cralos.myretrofitproject.httpPost.models.PostResponse;

public class PostPresenterImpl implements PostPresenter {

    private PostView view;
    private PostInteractor interactor;

    public PostPresenterImpl(PostView view, Context context) {
        this.view = view;
        interactor = new PostInteractorImpl(this, context);
    }

    @Override
    public void postRequest(String name, String job) {
        if (view != null) {
            view.showLoader();
            interactor.postRequest(name, job);
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
    public void setResponse(PostResponse response) {
        if (view != null) {
            view.hideLoader();
            view.successPost(response);
        }
    }
}
