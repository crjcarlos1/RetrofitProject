package com.cralos.myretrofitproject.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cralos.myretrofitproject.R;
import com.cralos.myretrofitproject.login.view.FragmentLogIn;

public class FragmentSplash extends Fragment {

    public static final String TAG = FragmentSplash.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        executeTimer();
        return view;
    }

    private void executeTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showFragmentLogIn();
            }
        }, 3000);
    }

    private void showFragmentLogIn() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerFragments, new FragmentLogIn(), FragmentLogIn.TAG).commit();
    }

}
