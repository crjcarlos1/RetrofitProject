package com.cralos.myretrofitproject.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cralos.myretrofitproject.R;

public class FragmentMenu extends Fragment implements View.OnClickListener {
    public static final String TAG = FragmentMenu.class.getSimpleName();

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button btnGet, btnPost, btnDelete, btnPut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        initFragmentMenu(view);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGET:
                showFragmentGet();
                break;
            case R.id.btnPOST:
                showFragmentPost();
                break;
            case R.id.btnPUT:
                showFragmentPut();
                break;
            case R.id.btnDELETE:
                showFragmentDelete();
                break;
        }
    }

    private void initFragmentMenu(View view) {
        btnDelete = view.findViewById(R.id.btnDELETE);
        btnPost = view.findViewById(R.id.btnPOST);
        btnPut = view.findViewById(R.id.btnPUT);
        btnGet = view.findViewById(R.id.btnGET);
        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnPut.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
    }

    private void showFragmentDelete() {
    }

    private void showFragmentPut() {
    }

    private void showFragmentPost() {
    }

    private void showFragmentGet() {
    }


}
