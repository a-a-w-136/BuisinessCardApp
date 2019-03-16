package com.example.woodlee.mt_1_u3031423;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Woodlee on 1/4/17.
 */

public class BusCarAdapter extends ArrayAdapter<BusinessCard> {

    ArrayList<BusinessCard> cards;

    public BusCarAdapter(Context context, int resource, ArrayList<BusinessCard> objects) {
        super(context, resource, objects);
        cards = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.my_listview_item, parent, false);
        }

        BusinessCard card = cards.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.listItemImage);
        icon.setImageResource(card.getImageResource());

        TextView title = (TextView) convertView.findViewById(R.id.listItemName);
        title.setText(card.getName());

        TextView email = (TextView) convertView.findViewById(R.id.listItemEmail);
        email.setText(card.getEmail());

        if (position % 2 == 0){
            convertView.setBackgroundColor(Color.parseColor("#e6e6e6"));
        }else{
            convertView.setBackgroundColor(Color.parseColor("#f2f2f2"));
        }

        return convertView;
    }
}
