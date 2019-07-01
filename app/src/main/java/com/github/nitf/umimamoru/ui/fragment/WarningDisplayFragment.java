package com.github.nitf.umimamoru.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.nitf.umimamoru.R;

public class WarningDisplayFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        boolean isOccurRipCurrent = true;
        int resource = (isOccurRipCurrent) ? R.layout.fragment_warning_display : R.layout.fragment_all_clear_display;
        return inflater.inflate(resource, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
