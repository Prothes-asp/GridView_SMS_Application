package com.prothes.gridviewsmsapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import androidx.cardview.widget.CardView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GridLayoutBaseAdapter extends BaseAdapter {
    private Context context;
    private HashMap<String, String> hashMap;
    private ArrayList<HashMap<String, String>> arrayList;
    private LayoutInflater layoutInflater;
    public GridLayoutBaseAdapter(HomePage homePage, HashMap<String, String> hashMap, ArrayList<HashMap<String, String>> arrayList) {
        this.context = homePage;
        this.hashMap = hashMap;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        if (convertView == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.gridviews_item_design_layout,parent,false);
        }

        CardView cardView = convertView.findViewById(R.id.cardView);
        ImageView imageViews = convertView.findViewById(R.id.imageViews);
        TextView textView = convertView.findViewById(R.id.textView);
        hashMap = arrayList.get(position);
        String getText = hashMap.get("grid_item_name");
        String getImgUrl = hashMap.get("grid_item_img_url");

        textView.setText(""+getText);

        Glide.with(context)
                .load(getImgUrl)
                .placeholder(R.drawable.image_loading_loader)
                .into(imageViews);

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        textView.setTextColor(color);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    context.startActivity(new Intent(context, PuzzleActivity.class));
                } else if (position == 1) {
                    context.startActivity(new Intent(context, LoveActivity.class));
                }else if (position == 2) {
                    context.startActivity(new Intent(context, FunnyActivity.class));
                }else if (position == 3) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 4) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 5) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 6) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 7) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 8) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 9) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 10) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 11) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 12) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }else if (position == 13) {
                    Toast.makeText(context, "Upcomming", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return convertView;
    }
}
