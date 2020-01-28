package com.cralos.myretrofitproject.httpPut.view;

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
import com.cralos.myretrofitproject.httpPut.interfaces.PutPresenter;
import com.cralos.myretrofitproject.httpPut.interfaces.PutView;
import com.cralos.myretrofitproject.httpPut.models.PutResponse;
import com.cralos.myretrofitproject.httpPut.presenters.PutPresenterImpl;

public class FragmentPut extends Fragment implements PutView, View.OnClickListener {
    public static final String TAG = FragmentPut.class.getSimpleName();

    private Loader loader;
    private PutPresenter presenter;

    private Button btnStartPut;
    private TextView txvResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_put, container, false);
        initFragmentPut(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartPut:
                presenter.putRequest("morpheus", "zion resident");
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
    public void successPutResponse(PutResponse response) {
        txvResult.setText("Nombre: " + response.getName() + "\nTrabajo: " + response.getJob() + "\nDate: " + response.getUpdatedAt());
    }

    private void initFragmentPut(View view) {
        txvResult = view.findViewById(R.id.txvPutResult);
        btnStartPut = view.findViewById(R.id.btnStartPut);
        btnStartPut.setOnClickListener(this);
        loader = new Loader();
        presenter = new PutPresenterImpl(this, getContext());
    }

}
