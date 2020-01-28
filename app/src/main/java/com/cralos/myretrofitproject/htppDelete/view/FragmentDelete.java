package com.cralos.myretrofitproject.htppDelete.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myretrofitproject.R;
import com.cralos.myretrofitproject.components.Loader;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeletePresenter;
import com.cralos.myretrofitproject.htppDelete.interfaces.DeleteView;
import com.cralos.myretrofitproject.htppDelete.presenters.DletePresenterImpl;

public class FragmentDelete extends Fragment implements DeleteView, View.OnClickListener {
    public static final String TAG = FragmentDelete.class.getSimpleName();

    private Button btnStartDelete;
    private DeletePresenter presenter;
    private Loader loader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        initFragmentDelete(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartDelete:
                presenter.deleteRequest();
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
    public void successDelete() {
        Log.e("DELETE", "SUCCESS DELETE");
    }

    private void initFragmentDelete(View view) {
        btnStartDelete = view.findViewById(R.id.btnStartDelete);
        btnStartDelete.setOnClickListener(this);
        loader = new Loader();
        presenter = new DletePresenterImpl(this, getContext());
    }

}
