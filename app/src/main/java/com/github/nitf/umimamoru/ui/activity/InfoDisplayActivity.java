package com.github.nitf.umimamoru.ui.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.github.nitf.umimamoru.R;

public class InfoDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_display);
        // TODO: StateInfoからデータを取得して情報を表示させる
        // 以下、デバッグ用の固定情報
        String region = "沖縄県名護市辺野古豊原\n" + "シーグラスビーチ" + "の波の様子";

        TextView regionView = (TextView) findViewById(R.id.regionView);
        regionView.setText(region);
    }
}
