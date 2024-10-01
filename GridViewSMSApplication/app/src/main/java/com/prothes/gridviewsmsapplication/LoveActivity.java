package com.prothes.gridviewsmsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class LoveActivity extends AppCompatActivity {
    private ListView listView;
    private HashMap<String,String> hashMap = new HashMap<>();
    private ArrayList< HashMap<String,String> > arrayList;
    private NetworkConnectionCheck networkConnectionCheck = new NetworkConnectionCheck();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.all_items_activity_list_view_layout);

        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();

        myArrayLoveDataTable();

        AllCommonLayoutBaseAdapter allCommonLayoutBaseAdapter = new AllCommonLayoutBaseAdapter(LoveActivity.this,arrayList,hashMap);
        listView.setAdapter(allCommonLayoutBaseAdapter);

    }

    public void myArrayLoveDataTable(){
        hashMap = new HashMap<>();
        hashMap.put("sms","আমার হৃদয়ের ঘরে সর্বদা থেকো\n" +
                "তুমি শুভ্র সুন্দর অনাবিল,\n" +
                "আমার সারাটা দিনই ভরে থাকুক\n" +
                "নিরাপদে তোমারই স্বপ্নীল ।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("sms","খুজে দেখো মনের মাঝে, আছি আমি স্বপ্নের সাঁজে,\n" +
                "তোমার ওই চোখের তারায়, হাজার স্বপ্ন এসে দাঁড়ায়,\n" +
                "সুখের সে স্বপ্নের মাঝে পাবে তুমি আমায় ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("sms","তোমার বুকে নীলের আভা তুমিই মেঘবতী,\n" +
                "ইচ্ছে করে তোমায় ছুঁতে আকাশ হতাম যদি ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("sms","তোমাকে ভেবে পৃথিবী আমার অদেখা তবু একে যাই,\n" +
                "আমার ভেতর শুধু তুমি আর তো কিছু পায়নি ঠাই ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("sms","তোমায় দেখে মনে হয় কত পরিচিতা,\n" +
                "জানি না তোমার নাম কি ওগো পরিনিতা ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("sms","প্রথম দেখার দিনগুলো রয়েছে আমার অন্তরে,\n" +
                "লজ্জায় জড়ানো কথাগুলো এখনো বাজে কানে ।");
        arrayList.add(hashMap);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AllCommonLayoutBaseAdapter.textToSpeech.stop();
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkConnectionCheck,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkConnectionCheck);
        AllCommonLayoutBaseAdapter.textToSpeech.stop();
        super.onStop();
    }

    @Override
    protected void onPause() {
        AllCommonLayoutBaseAdapter.textToSpeech.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        AllCommonLayoutBaseAdapter.textToSpeech.stop();
        super.onDestroy();
    }

}