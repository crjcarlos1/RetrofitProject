package com.cralos.myretrofitproject.htppDelete;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myretrofitproject.R;

public class FragmentDelete extends Fragment {
    public static final String TAG = FragmentDelete.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        initFragmentDelete(view);
        return view;
    }

    private void initFragmentDelete(View view) {
    }

}
