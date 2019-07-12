package com.sitimaeturoh.androiddasar6offlinedatabase;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class RealmHelper {
    private Context context;
    private Realm realm;

    public RealmHelper(Context context) {
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    //insert
    public  void  insertData (CatatanModel catatan){
        realm.beginTransaction();
        realm.copyToRealm(catatan);
        realm.commitTransaction();
        realm.addChangeListener(new RealmChangeListener<Realm>() {
            @Override
            public void onChange(Realm realm) {
                Toast.makeText(context,"Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
        realm.close();
    }

    //next id
    public  long getNextId(){
        if (realm.where(CatatanModel.class).count() != 0){
            long id = realm.where(CatatanModel.class).max("id").longValue();
            return id +1;
        } else {
            return 1;
        }
    }

    //menampilkan data
    public List<CatatanModel> showData(){
//        RealmResults<CatatanModel> datahasil = realm.where(CatatanModel.class).findAll();
//        List<CatatanModel> datalist = new ArrayList<>();
//        datalist.addAll(realm.copyFromRealm(datahasil));

        return  realm.where(CatatanModel.class).findAll();
    }
//menampilakn satu data
    public  CatatanModel showOneData(Integer id){
        CatatanModel data = realm.where(CatatanModel.class).equalTo("id" , id).findFirst();
        return data;
    }



}
