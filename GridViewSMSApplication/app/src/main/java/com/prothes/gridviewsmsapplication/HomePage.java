package com.prothes.gridviewsmsapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;

public class HomePage extends AppCompatActivity {
    private NetworkConnectionCheck networkConnectionCheck = new NetworkConnectionCheck();
    private GridView gridView;
    private HashMap<String,String> hashMap = new HashMap<>();
    private ArrayList< HashMap<String,String> > arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.home_page);

        gridView = findViewById(R.id.gridView);
        arrayList = new ArrayList<>();

        myGridItemsDataTable();

        GridLayoutBaseAdapter gridLayoutBaseAdapter = new GridLayoutBaseAdapter(HomePage.this,hashMap,arrayList);
        gridView.setAdapter(gridLayoutBaseAdapter);

    }

    //================================================================================================================
    //================================================================================================================
    //================================================================================================================
    //================================================================================================================

    public void myGridItemsDataTable(){

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Puzzle");
        hashMap.put("grid_item_img_url","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSU6elG5BPoNLPo-SBuDgai_c3v0SZAwuufg&s");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Love");
        hashMap.put("grid_item_img_url","https://play-lh.googleusercontent.com/EcpQTfdUWWJzISEWyJrtwwLqdPQVLXHPUbh7MCnONBjJ_EuNTZc3lYYM2yp0hMMbqx8");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Funny");
        hashMap.put("grid_item_img_url","https://sde.thinksai.com/stock-photo-preview/107249447/350/inh_47129_62186.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Birthday");
        hashMap.put("grid_item_img_url","https://media.istockphoto.com/id/114337790/photo/birthday-cake.jpg?s=612x612&w=0&k=20&c=9SMREMlvvYFy0pT3gIFBe8uZj9CJz6WJiFMR_rGFYg0=");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Poem");
        hashMap.put("grid_item_img_url","https://media.istockphoto.com/id/1411135668/vector/ovid-a-roman-poet.jpg?s=612x612&w=0&k=20&c=uFtLxocZz-Lbmt5ZHOwpqp2ALHNhFyMN2DcEyfuaYoA=");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Java");
        hashMap.put("grid_item_img_url","https://st3.depositphotos.com/1688079/17309/i/450/depositphotos_173096816-stock-photo-java-premium-purple-round-button.jpg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Xml");
        hashMap.put("grid_item_img_url","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXNv8MZAnoR2BHlvYbK_nCjfvTjFXJItQb2A&s");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Sql");
        hashMap.put("grid_item_img_url","data:image/jpeg;base64,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");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Firebase");
        hashMap.put("grid_item_img_url","data:image/jpeg;base64,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");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Html");
        hashMap.put("grid_item_img_url","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbDKMtTTCoULCZ0T_If1s9uDPIo5X_VRW9hQ&s");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Css");
        hashMap.put("grid_item_img_url","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5YsuE5q1iv-naVRwRQlR2zRwibcPEFEr9nQ&s");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Bootstrap");
        hashMap.put("grid_item_img_url","data:image/png;base64,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");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Wordpress");
        hashMap.put("grid_item_img_url","data:image/png;base64,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");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("grid_item_name","Python");
        hashMap.put("grid_item_img_url","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSo_a3LW7i_8DKhJ7yEAXMvj6tq9_Ilm8oNqw&s");
        arrayList.add(hashMap);
    }


    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            AlertDialog alertDialog = new AlertDialog.Builder(HomePage.this)
                    .setTitle("Warning !")
                    .setMessage("Do you want to exit this app ?")
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.sky));
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.sky));
        }else{
            super.onBackPressed();
        }
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
        super.onStop();
    }
}