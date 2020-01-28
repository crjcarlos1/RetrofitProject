package com.cralos.myretrofitproject.httpGet.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cralos.myretrofitproject.R;
import com.cralos.myretrofitproject.components.Loader;
import com.cralos.myretrofitproject.httpGet.adapters.GetAdapter;
import com.cralos.myretrofitproject.httpGet.interfaces.GetPresenter;
import com.cralos.myretrofitproject.httpGet.interfaces.GetView;
import com.cralos.myretrofitproject.httpGet.interfaces.OnClickUserCardView;
import com.cralos.myretrofitproject.httpGet.models.User;
import com.cralos.myretrofitproject.httpGet.presenters.GetPresenterImpl;

import java.util.List;

public class FragmentGet extends Fragment implements View.OnClickListener, GetView, OnClickUserCardView {
    public static final String TAG = FragmentGet.class.getSimpleName();

    private Button btnGet;
    private RecyclerView rvGet;
    private GetAdapter adapter;

    private Loader loader;
    private GetPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get, container, false);
        initFragmentGet(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStartGet:
                presenter.getMethod();
                break;
        }
    }

    private void initFragmentGet(View view) {
        btnGet = view.findViewById(R.id.btnStartGet);
        rvGet = view.findViewById(R.id.rvGet);
        btnGet.setOnClickListener(this);
        presenter = new GetPresenterImpl(this, getContext());
        loader = new Loader();
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
    public void showUsers(List<User> users) {
        btnGet.setEnabled(false);
        rvGet.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GetAdapter(getContext(), users);
        adapter.setOnClickUserCardView(this);
        rvGet.setAdapter(adapter);
    }

    @Override
    public void onClickUserCard(int id, String name) {
        Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
    }
}
