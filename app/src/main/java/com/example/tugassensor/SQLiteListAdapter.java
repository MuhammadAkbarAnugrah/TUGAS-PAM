package com.example.tugassensor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SQLiteListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> user_id;
    private ArrayList<String> user_title;
    private ArrayList<String> user_x;
    private ArrayList<String> user_y;
    private ArrayList<String> user_z;

    SQLiteListAdapter(Context context1, ArrayList<String> ID, ArrayList<String> TITLE, ArrayList<String> X, ArrayList<String> Y, ArrayList<String> Z) {
        this.context = context1;
        this.user_id = ID;
        this.user_title = TITLE;
        this.user_x = X;
        this.user_y = Y;
        this.user_z = Z;
    }

    public class Holder {
        TextView textView_id;
        TextView textView_title;
        TextView textView_x;
        TextView textView_y;
        TextView textView_z;
    }

    @Override
    public int getCount() {
        return user_id.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        LayoutInflater inflater;

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_data_layout, null);

            holder = new Holder();

            holder.textView_id = convertView.findViewById(R.id.text_id);
            holder.textView_title = convertView.findViewById(R.id.text_title);
            holder.textView_x = convertView.findViewById(R.id.text_x);
            holder.textView_y = convertView.findViewById(R.id.text_y);
            holder.textView_z = convertView.findViewById(R.id.text_z);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.textView_id.setText(user_id.get(position));
        holder.textView_title.setText(user_title.get(position));
        holder.textView_x.setText(user_x.get(position));
        holder.textView_y.setText(user_y.get(position));
        holder.textView_z.setText(user_z.get(position));
        return convertView;
    }
}