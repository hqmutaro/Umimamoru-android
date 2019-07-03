package com.github.nitf.umimamoru.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.github.nitf.umimamoru.R;
import com.github.nitf.umimamoru.ui.adapter.item.Region;

import java.util.List;

public class RegionListAdapter extends ArrayAdapter<Region> {

    private LayoutInflater inflater;

    public RegionListAdapter(Context context, int resource, List<Region> objects) {
        super(context, resource, objects);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @SuppressLint("InflateParams")
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.region_item, null);
        }

        Region region = this.getItem(position);

        Button testButton = (Button) convertView.findViewById(R.id.testtesttesttest); // 丸い図形入れたかったやつ
        // 図形挿入出来たら消せ

        TextView textView = (TextView) convertView.findViewById(R.id.regionListTextView);
        if (textView != null) {
            assert region != null;
            textView.setText(region.getData());
        }

        return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
