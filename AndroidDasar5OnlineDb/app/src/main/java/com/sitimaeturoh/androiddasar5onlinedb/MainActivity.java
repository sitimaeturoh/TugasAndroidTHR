package com.sitimaeturoh.androiddasar5onlinedb;

import android.app.ProgressDialog;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sitimaeturoh.androiddasar5onlinedb.model.ResponseMovie;
import com.sitimaeturoh.androiddasar5onlinedb.model.ResultsItem;
import com.sitimaeturoh.androiddasar5onlinedb.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<ResultsItem> dataMovie = new ArrayList<>();
    RecyclerView rectycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rectycler = findViewById(R.id.recyclerView);

        //1 layout
        //2 model datanya
        //dummy data
//        MovieModel moviel = new MovieModel();
//        moviel.setJudulFilm("judul Film");
//        moviel.setPosterFilm("https://image.tmdb.org/t/p/w185_and_h278_bestv2/rIZX6X0MIHYEebk6W4LABT9VP2c.jpg");
//
//        for (int i = 0; i < 20; i++) {
//            dataMovie.add(moviel);
//        }

        getDataOnline();
        //3 adapter
        rectycler.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
        //4 layout manager
        rectycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
    }

    private void getDataOnline() {
        final ProgressDialog progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("Waiting.....");
        progress.show();
        Call<ResponseMovie> request = RetrofitConfig.getApiService().ambilDataMOvie("4f755c93d6da7ccbe4fbefff1e7548cd");
        request.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                progress.dismiss();
                if (response.isSuccessful()){
                    dataMovie = response.body().getResults();
                    rectycler.setAdapter(new MovieAdapter(MainActivity.this, dataMovie));
                } else {
                    Toast.makeText(MainActivity.this, "Request Not Succes", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request Failure"+t.getMessage(),Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }
}
