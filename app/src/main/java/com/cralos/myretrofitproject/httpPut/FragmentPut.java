package com.cralos.myretrofitproject.httpPut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myretrofitproject.R;

public class FragmentPut extends Fragment {
    public static final String TAG = FragmentPut.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_put, container, false);
        initFragmentPut(view);
        return view;
    }

    private void initFragmentPut(View view) {
    }

}
