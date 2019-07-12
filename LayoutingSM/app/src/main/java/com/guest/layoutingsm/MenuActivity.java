package com.guest.layoutingsm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnlinier, btnrelative, btnframe, btnconstraint, btnscroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnlinier = findViewById(R.id.btnlinier);
        btnrelative = findViewById(R.id.btnrelative);
        btnframe = findViewById(R.id.btnframe);
        btnconstraint = findViewById(R.id.btncontraint);
        btnscroll = findViewById(R.id.btnscroll);

        btnlinier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnrelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(MenuActivity.this);
                pesan.setTitle("aler dialog");
                pesan.setMessage("ini alerdialog");
                pesan.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(MenuActivity.this, "anda memilih ok", Toast.LENGTH_SHORT).show();
                      Intent i  = new Intent(MenuActivity.this, RelativeLayout.class);
                      startActivity(i);
                    }
                });
                pesan.show();

            }
        });

        btnframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, FrameActivity.class);
                startActivity(i);
            }
        });

        btnconstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ConstraintActivity.class);
                startActivity(i);
            }
        });

        btnscroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, ScrollActivity.class);
                startActivity(i);
            }
        });
    }
}
