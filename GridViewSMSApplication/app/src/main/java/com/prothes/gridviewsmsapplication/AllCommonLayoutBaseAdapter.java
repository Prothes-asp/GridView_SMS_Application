package com.prothes.gridviewsmsapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageButton;

import java.util.ArrayList;
import java.util.HashMap;

public class AllCommonLayoutBaseAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<HashMap<String, String>> arrayList;
    private HashMap<String, String> hashMap;
    public static TextToSpeech textToSpeech;
    public AllCommonLayoutBaseAdapter(LoveActivity loveActivity, ArrayList<HashMap<String, String>> arrayList, HashMap<String, String> hashMap) {
        this.context = loveActivity;
        this.arrayList = arrayList;
        this.hashMap = hashMap;
    }
    public AllCommonLayoutBaseAdapter(FunnyActivity funnyActivity, ArrayList<HashMap<String, String>> arrayList, HashMap<String, String> hashMap) {
        this.context = funnyActivity;
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
            convertView = layoutInflater.inflate(R.layout.all_listview_base_layout_design,parent,false);
        }

        TextView display = convertView.findViewById(R.id.display);
        AppCompatImageButton copyBtn = convertView.findViewById(R.id.copyBtn);
        AppCompatImageButton soundBtn = convertView.findViewById(R.id.soundBtn);
        AppCompatImageButton shareBtn = convertView.findViewById(R.id.shareBtn);

        hashMap = arrayList.get(position);
        String getText = hashMap.get("sms");

        display.setText(""+getText);


        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = display.getText().toString();
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Text",getData);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
            }
        });


        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });


        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = display.getText().toString();
                textToSpeech.speak(getData,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });


        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = display.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,getData);
                intent.setType("text/plain");
                Intent sharedata = Intent.createChooser(intent,null);
                context.startActivity(sharedata);
            }
        });

        return convertView;
    }
}
