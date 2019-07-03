package com.github.nitf.umimamoru.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.github.nitf.umimamoru.server.StatusInfo;
import com.github.nitf.umimamoru.ui.adapter.RegionListAdapter;
import com.github.nitf.umimamoru.ui.adapter.item.Region;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.nitf.umimamoru.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

        ArrayAdapter<String> occurAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, occurPlaces) {
            @Override
            public boolean isEnabled(int position) {
                return false;
            }
        };

        ListView occurListView = findViewById(R.id.occurListView);
        occurListView.setAdapter(occurAdapter);

        ListView poleListView = (ListView) findViewById(R.id.poleListView);
        List<Region> data = new ArrayList<Region>();
        RegionListAdapter regionListAdapter = new RegionListAdapter(this, 0, data);
        poleListView.setAdapter(regionListAdapter);

        Iterator<Map.Entry<String, Map<String, Integer>>> poleItr = polesMap.entrySet().iterator();
        String info;
        while (poleItr.hasNext()) {
            Map.Entry<String, Map<String, Integer>> poleEntry = poleItr.next();
            info = poleEntry.getKey() + "\n"
                    + "波の速さ " + poleEntry.getValue().get("wave.speed").toString() + "\n"
                    + "今月の離岸流発生回数: " + poleEntry.getValue().get("count.occur").toString();
            Region region = new Region();
            region.setData(info);
            data.add(region);
        }
    }
}
