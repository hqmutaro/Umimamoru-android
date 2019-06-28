package com.github.nitf.umimamoru.ui.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.github.nitf.umimamoru.R;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private int resourceId;
    private String[] regions;

    static class ViewHolder {
        Button selectButton;
    }

    public CustomAdapter(Context context, int resourceId, String[] regions) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resourceId = resourceId;
        this.regions = regions;
    }

    @Override
    public View getView(final int position, View view, final ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(resourceId, viewGroup, false);

            holder = new ViewHolder();
            holder.selectButton = view.findViewById(R.id.select);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.selectButton.setText(regions[position]);
        holder.selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListView) viewGroup).performItemClick(view, position, R.id.select);
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return regions.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
