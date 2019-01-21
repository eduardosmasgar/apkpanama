package com.example.john_pc.prueba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter_events extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<obj_events> items;

    public adapter_events(Activity activity, ArrayList<obj_events> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.personalization, null);

        }

        obj_events item = items.get(position);

        if(item.estado_evento == 0){

            TextView id = vi.findViewById(R.id.tvIdEvent);
            id.setText(""+item.getId());

            TextView values = vi.findViewById(R.id.tvKeyValue);
            values.setText(item.getVariable());

            TextView startDate = vi.findViewById(R.id.tvDateEventBegin);
            startDate.setText(item.getFecha_inicio());

            TextView endDate = vi.findViewById(R.id.tvDateEventEnd);
            endDate.setText(item.getFecha_fin());

            if (item.id_from == 2){

                ImageView ivImage0003 = vi.findViewById(R.id.iv0003);
                ivImage0003.setImageResource(R.drawable.usuario);

                TextView tv0003 = vi.findViewById(R.id.tv0003);
                tv0003.setText("" + item.getNumero_persona());

                ImageView ivImage0004 = vi.findViewById(R.id.iv0004);
                ivImage0004.setImageResource(R.drawable.container);

                TextView tv0004 = vi.findViewById(R.id.tv0004);
                tv0004.setText("" + item.getNumero_container());

            } else {

                ImageView ivImage0003 = vi.findViewById(R.id.iv0003);
                ivImage0003.setVisibility(View.GONE);

                TextView tv0003 = vi.findViewById(R.id.tv0003);
                tv0003.setVisibility(View.GONE);

                ImageView ivImage0004 = vi.findViewById(R.id.iv0004);
                ivImage0004.setVisibility(View.GONE);

                TextView tv0004 = vi.findViewById(R.id.tv0004);
                tv0004.setVisibility(View.GONE);

            }

        }

        return vi;
    }
}
