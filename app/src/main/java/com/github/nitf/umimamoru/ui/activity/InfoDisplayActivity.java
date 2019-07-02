package com.github.nitf.umimamoru.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.github.nitf.umimamoru.server.StatusInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.nitf.umimamoru.R;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InfoDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_display);
        // TODO: StatusInfoからデータを取得して情報を表示させる
        Intent intent = getIntent();
        String regionName = intent.getStringExtra("RegionData");
        StatusInfo statusInfo = new StatusInfo(regionName);

        // 以下、デバッグ用の固定情報
        String region_debug = "沖縄県名護市辺野古豊原\n" + "シーグラスビーチ" + "の波の様子";
        String[] occurPlaces = {
                "・1番ポール",
                "・2番ポール",
                "・3番ポール",
                "・4番ポール"
        };
        Map<String, Map<String, Integer>> polesMap = new LinkedHashMap<String, Map<String, Integer>>(){
            {
                put("1番ポール", new HashMap<String, Integer>() {
                    {
                        put("wave.speed", 3); // 3m/s
                        put("count.occur", 8); // 今月8回起きた
                    }
                });
                put("2番ポール", new HashMap<String, Integer>() {
                    {
                        put("wave.speed", 5); // 5m/s
                        put("count.occur", 4); // 今月4回起きた
                    }
                });
                put("3番ポール", new HashMap<String, Integer>() {
                    {
                        put("wave.speed", 4); // 4m/s
                        put("count.occur", 6); // 今月6回起きた
                    }
                });
                put("4番ポール", new HashMap<String, Integer>() {
                    {
                        put("wave.speed", 4); // 4m/s
                        put("count.occur", 2); // 今月2回起きた
                    }
                });
            }
        }; // TODO: StatusInfoから取得させる
        // ここまでデバッグ用

        TextView regionView = (TextView) findViewById(R.id.regionView);
        regionView.setText(region_debug);

        ArrayAdapter<String> occurAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, occurPlaces);

        ListView occurListView = findViewById(R.id.occurListView);
        occurListView.setAdapter(occurAdapter);

        String[] poles = new String[polesMap.size()];
        int i = 0;
        for (Map.Entry<String, Map<String, Integer>> poleEntry : polesMap.entrySet()) {
            poles[i] = poleEntry.getKey() + "\n"
                    + "波の速さ " + poleEntry.getValue().get("wave.speed").toString() + "\n"
                    + "今月の離岸流発生回数: " + poleEntry.getValue().get("count.occur").toString();
            i++;
        } // TODO: Iteratorを使う

        // 今はListViewで実装する
        // 後々仕様変更を行う
        ArrayAdapter<String> poleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, poles);

        ListView poleListView = findViewById(R.id.poleListView);
        poleListView.setAdapter(poleAdapter);
    }
}
