package com.sitimaeturoh.androiddasar6offlinedatabase;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DetailCatatanActivity extends AppCompatActivity {

    public static final String KEY_ID = "key_id";
    RealmHelper realm;
    EditText edJudul, edJumlah, edTanggal;
    Button btnsimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catatan);

        realm = new RealmHelper(DetailCatatanActivity.this);

        int dataID = getIntent().getIntExtra(KEY_ID, 0);

        CatatanModel data = realm.showOneData(dataID);

        edJudul = findViewById(R.id.edjudul);
        edJumlah = findViewById(R.id.edjumlah);
        edTanggal = findViewById(R.id.edtanggal);
        btnsimpan = findViewById(R.id.btnsimpan);

        edJudul.setText(data.getJudul());
        edJumlah.setText(data.getJumlahhutang());
        edTanggal.setText(data.getTanggal());

        edTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //data picker
                Calendar calendar = Calendar.getInstance();
                Date NowDate = calendar.getTime();
                int nowYear  = calendar.get(Calendar.YEAR);
                int nowMonth = calendar.get(Calendar.MONTH);
                int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(DetailCatatanActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month, dayOfMonth);
                        SimpleDateFormat dataformat = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
                        edTanggal.setText(dataformat.format(cal.getTime()));
                    }
                }, nowYear, nowMonth, nowDay);
                dialog.show();
            }
        });
    }
}
