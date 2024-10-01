package com.prothes.gridviewsmsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleActivity extends AppCompatActivity {
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

        myArrayPuzzleDataTable();

        PuzzleBaseAdapter puzzleBaseAdapter = new PuzzleBaseAdapter(PuzzleActivity.this,hashMap,arrayList);
        listView.setAdapter(puzzleBaseAdapter);
    }

    public void myArrayPuzzleDataTable(){

        hashMap = new HashMap<>();
        hashMap.put("questions","কে ১০ কেজি লোহা তুলতে পারে , কিন্তু ১ কেজি তুলা তুলতে পারে না ?");
        hashMap.put("answers","উত্তরঃ চুম্বক ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("questions","কোন বিজ্ঞানির নামের মাঝে উঠ শব্দটি আছে ?");
        hashMap.put("answers","উত্তরঃ নিউটন ।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("questions","কতর মধ্যে কত বাদ দিলে কত থাকবে ?");
        hashMap.put("answers","উত্তরঃ র");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("questions","একই প্রশ্ন কিন্তু সবাই আলাদা আলাদা উত্তর দেয় অথচ সবার উত্তরই ঠিক প্রশ্নটি কি ?");
        hashMap.put("answers","উত্তরঃ তোমার নাম কি ?");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("questions","কোন জিনিস গাছে সবুজ দোকানে কালো বাড়িতে আনলে লাল?");
        hashMap.put("answers","উত্তরঃ চা");
        arrayList.add(hashMap);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        PuzzleBaseAdapter.textToSpeech.stop();
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
        PuzzleBaseAdapter.textToSpeech.stop();
        super.onStop();
    }

    @Override
    protected void onPause() {
        PuzzleBaseAdapter.textToSpeech.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        PuzzleBaseAdapter.textToSpeech.stop();
        super.onDestroy();
    }
}