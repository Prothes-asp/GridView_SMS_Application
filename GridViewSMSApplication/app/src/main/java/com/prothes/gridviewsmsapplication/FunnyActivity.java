package com.prothes.gridviewsmsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class FunnyActivity extends AppCompatActivity {
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

        myArrayFunnyDataTable();

        AllCommonLayoutBaseAdapter allCommonLayoutBaseAdapter = new AllCommonLayoutBaseAdapter(FunnyActivity.this,arrayList,hashMap);
        listView.setAdapter(allCommonLayoutBaseAdapter);

    }

    public void myArrayFunnyDataTable(){

        hashMap = new HashMap<>();
        hashMap.put("sms","অফিসারঃ আপনার নাম কি?\n" +
                "প্রার্থী: M.P স্যার।\n" +
                "অফিসারঃ এম.পি তার মানে কি?\n" +
                "প্রার্থীঃ মোহন পাল স্যার।\n" +
                "অফিসারঃ আপনার পিতার নামকি?\n" +
                "প্রার্থীঃ এম.পি স্যার।\n" +
                "অফিসারঃ তার মানে কি?\n" +
                "প্রার্থীঃ মদন পাল স্যার।\n" +
                "অফিসারঃ আপনার যোগ্যতা?\n" +
                "প্রার্থীঃ এম.পি স্যার।\n" +
                "অফিসারঃ(রাগ করে) এইটা কি?\n" +
                "প্রার্থীঃ মেট্রিক পাস স্যার।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("sms","ব্যাটারি লো\n" +
                "আমি আমার গার্লফ্রেন্ডের নাম\n" +
                "মোবাইল ফোনে সেভ\n" +
                "করেছি ‘ব্যাটারি লো’ নামে।\n" +
                "সে যখন আমাকে ফোন করে আর\n" +
                "আমি ফোনের আশপাশে থাকি না,\n" +
                "তখন আমার মা ফোনে চার্জ নেই\n" +
                "মনে করে চার্জে বসিয়ে যায়।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("sms","কাছের পথ দুরের\n" +
                "লাগে,,\n" +
                "যদি সাথে কেউ\n" +
                "না থাকে।\n" +
                "দুরের পথ অনেক\n" +
                "কাছের লাগে,\n" +
                "যদি পিছনে একটা পাগলা কুত্তা থাকে ।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("sms","বাবা বলছেন মেয়েকে, ‘কিরে, তুই\n" +
                "তো ফোনে কথা বলা শুরু করলে দুই\n" +
                "ঘণ্টার আগে ছাড়িস না! আজ মাত্র\n" +
                "আধা ঘণ্টায়ই শেষ করলি।\n" +
                "এটা কীভাবে সম্ভব?\n" +
                "মেয়ে: রং নম্বর ছিল বাবা!\n");
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