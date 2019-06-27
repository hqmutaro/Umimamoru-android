package com.github.nitf.umimamoru.ui.activity;

import android.os.Bundle;

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
    private CustomAdapter adapter;

    private static final String[] regions = {
            "foo",
            "bar",
            "foobar",
            "hoge",
            "hogehoge"
    };

    public SelectRegionActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);

        listView = (ListView) findViewById(R.id.listView);
        this.adapter = new CustomAdapter(getApplicationContext(), R.layout.row_item, regions);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setTextFilterEnabled(true);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText( SelectRegionActivity.this, regions[position] + "を押したよ", Toast.LENGTH_SHORT).show();
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
