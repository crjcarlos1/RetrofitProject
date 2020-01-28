package com.cralos.myretrofitproject.httpPost.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myretrofitproject.R;
import com.cralos.myretrofitproject.components.Loader;
import com.cralos.myretrofitproject.httpPost.interfaces.PostPresenter;
import com.cralos.myretrofitproject.httpPost.interfaces.PostView;
import com.cralos.myretrofitproject.httpPost.models.PostResponse;
import com.cralos.myretrofitproject.httpPost.presenters.PostPresenterImpl;

public class FragmentPost extends Fragment implements PostView, View.OnClickListener {
    public static final String TAG = FragmentPost.class.getSimpleName();
    private PostPresenter presenter;
    private Loader loader;

    private Button btnStartPost;
    private TextView txvResultPost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        initFragmentPost(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartPost:
                presenter.postRequest("morpheus", "leader");
                break;
        }
    }

    @Override
    public void showLoader() {
        loader.show(getActivity().getSupportFragmentManager(), Loader.TGA);
    }

    @Override
    public void hideLoader() {
        loader.dismiss();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successPost(PostResponse response) {
        txvResultPost.setText("Nombre: " + response.getName() + "\nTrabajo: " + response.getJob() + "\nFecha: " + response.getCreatedAt());
    }

    private void initFragmentPost(View view) {
        txvResultPost = view.findViewById(R.id.txvResultPost);
        btnStartPost = view.findViewById(R.id.btnStartPost);
        btnStartPost.setOnClickListener(this);
        presenter = new PostPresenterImpl(this, getContext());
        loader = new Loader();
    }

}
