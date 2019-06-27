package com.github.nitf.umimamoru.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.github.nitf.umimamoru.ui.utils.ActivityRepsitory;
import com.github.nitf.umimamoru.ui.utils.CustomAdapter;
import com.github.nitf.umimamoru.R;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectRegionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {

    private ListView listView;

    private static final String[] regions = {
            "foo",
            "bar",
            "foobar",
            "hoge",
            "hogehoge"
    };

    static final String ACTIVITY_NAME = "SelectRegion";

    public SelectRegionActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);
        ActivityRepsitory.setPreviousActivity("Main");

        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.row_item, regions);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setTextFilterEnabled(true);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        ActivityRepsitory.setPreviousActivity("SelectRegion");
        Intent intent = new Intent(this, InfoDisplayActivity.class);
        startActivityForResult(intent, 0);
        // regions[position] is Region Data.
    }

    @Override
    public boolean onQueryTextChange(String text) {
        if (TextUtils.isEmpty(text)) {
            listView.clearTextFilter();
        }
        else {
            listView.setFilterText(text.toString());
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}
