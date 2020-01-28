package com.cralos.myretrofitproject.login.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cralos.myretrofitproject.R;
import com.cralos.myretrofitproject.components.Loader;
import com.cralos.myretrofitproject.login.interfaces.LogInPresenter;
import com.cralos.myretrofitproject.login.interfaces.LogInView;
import com.cralos.myretrofitproject.login.presenters.LogInPresenterImpl;

public class FragmentLogIn extends Fragment implements View.OnClickListener, LogInView {
    public static final String TAG = FragmentLogIn.class.getSimpleName();

    private EditText edtEmail, edtPassword;
    private Button btnLogIn;
    private Loader loader;

    private LogInPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initFragmentLogIn(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogIn:
                presenter.validateUserData(edtEmail.getText().toString(), edtPassword.getText().toString());
                break;
        }
    }

    private void initFragmentLogIn(View view) {
        edtEmail = view.findViewById(R.id.edtEmail);
        edtPassword = view.findViewById(R.id.edtPassword);
        btnLogIn = view.findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(this);
        loader = new Loader();
        presenter = new LogInPresenterImpl(this, getContext());
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
    public void successLogIn() {
        FragmentManager manager=getActivity().getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
    }
}
