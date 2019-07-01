package com.github.nitf.umimamoru.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.github.nitf.umimamoru.ui.utils.ActivityRepsitory;
import com.github.nitf.umimamoru.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

public class SelectRegionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {

    private ListView listView;

    private static String[] regions;

    static class ViewHolder {
        Button selectButton;
    }

    public SelectRegionActivity() {
        SelectRegionActivity.regions = new String[]{
                "foo",
                "bar",
                "foobar",
                "hoge",
                "hogehoge"
        }; // 鯖から取得するらしい(草)
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_region);
        ActivityRepsitory.setPreviousActivity("Main");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, regions);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        listView.setTextFilterEnabled(true);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setSubmitButtonEnabled(false);
        searchView.setQueryHint("地域名");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        ActivityRepsitory.setPreviousActivity("SelectRegion");
        Intent intent = new Intent(this, InfoDisplayActivity.class);
        startActivityForResult(intent, 0);
        // regions[position] is Region Data.
    }

    @Override
    public boolean onQueryTextChange(String queryText) {
        if (TextUtils.isEmpty(queryText)) {
            listView.clearTextFilter();
        } else {
            listView.setFilterText(queryText.toString());
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }
}
