package com.github.nitf.umimamoru.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.nitf.umimamoru.R;
import com.github.nitf.umimamoru.ui.activity.InfoDisplayActivity;
import com.github.nitf.umimamoru.ui.activity.MainActivity;
import com.github.nitf.umimamoru.ui.activity.SelectRegionActivity;
import com.github.nitf.umimamoru.ui.utils.ActivityRepsitory;

import java.util.HashMap;
import java.util.Map;

public class PreviousButtonFragment extends Fragment {

    Map<String, Class> activitiMap = new HashMap<String, Class>() {
        {
            put("Main", MainActivity.class);
            put("SelectRegion", SelectRegionActivity.class);
            put("InfoDisplay", InfoDisplayActivity.class);
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_previous_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button previousButton = (Button) view.findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent previousActivity = new Intent(PreviousButtonFragment.this.getActivity(), ActivityRepsitory.getPreviousActivityClass());
                startActivity(previousActivity);
            }
        });
     }
}
