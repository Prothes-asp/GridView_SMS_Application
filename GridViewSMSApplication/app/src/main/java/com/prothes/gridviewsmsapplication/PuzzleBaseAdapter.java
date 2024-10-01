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

public class PuzzleBaseAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private HashMap<String, String> hashMap;
    private ArrayList<HashMap<String, String>> arrayList;
    public static TextToSpeech textToSpeech;
    public PuzzleBaseAdapter(PuzzleActivity puzzleActivity, HashMap<String, String> hashMap, ArrayList<HashMap<String, String>> arrayList) {
        this.context = puzzleActivity;
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
            convertView = layoutInflater.inflate(R.layout.puzzle_base_layout_design,parent,false);
        }

        TextView display = convertView.findViewById(R.id.display);
        AppCompatImageButton copyBtn = convertView.findViewById(R.id.copyBtn);
        AppCompatImageButton answerBtn = convertView.findViewById(R.id.answerBtn);
        AppCompatImageButton soundBtn = convertView.findViewById(R.id.soundBtn);
        AppCompatImageButton shareBtn = convertView.findViewById(R.id.shareBtn);

        hashMap = arrayList.get(position);
        String getQuestion = hashMap.get("questions");
        String getAnswer = hashMap.get("answers");

        display.setText(""+getQuestion);

        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTxt = display.getText().toString();
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("",getTxt);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
            }
        });

        answerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTag = answerBtn.getTag().toString();
                if (getTag.equals("answer")) {
                    display.setText(""+getAnswer);
                    answerBtn.setTag("question");
                } else if (getTag.equals("question")) {
                    display.setText(""+getQuestion);
                    answerBtn.setTag("answer");
                }
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
                String getTxt = display.getText().toString();
                textToSpeech.speak(getTxt,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTxt = display.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,getTxt);
                intent.setType("text/plain");
                Intent shareTxt = Intent.createChooser(intent,null);
                context.startActivity(shareTxt);
            }
        });

        return convertView;
    }
}
