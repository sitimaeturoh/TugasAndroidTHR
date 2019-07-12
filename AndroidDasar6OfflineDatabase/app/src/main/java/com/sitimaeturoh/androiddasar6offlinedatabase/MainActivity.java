package com.sitimaeturoh.androiddasar6offlinedatabase;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    RealmHelper realm;

    List<CatatanModel> dataCatatan = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahCatatanActivity.class));
            }
        });


        realm = new RealmHelper(MainActivity.this);

        //1 membuat layput per item
        //membuat data model

//        CatatanModel catatan1 = new CatatanModel();
//        catatan1.setId("1");
//        catatan1.setJudul("Hutang ke A");
//        catatan1.setJumlahhutang("2000");
//        catatan1.setTanggal("05-05-2018");
//
//        for (int i = 0; i <20; i++) {
//            datacatatan.add(catatan1);
//
//
//        }


        //get datadari realm

        dataCatatan = realm.showData();


        //2 adapter
        recycler = findViewById(R.id.recyclerView);
        recycler.setAdapter(new CatatanAdapter(MainActivity.this, dataCatatan));
        //3 layout manager
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(MainActivity.this, 1));



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
