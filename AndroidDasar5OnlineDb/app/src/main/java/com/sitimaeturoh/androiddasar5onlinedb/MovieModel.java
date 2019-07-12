package com.sitimaeturoh.androiddasar5onlinedb;

import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("title")
    private String judulFilm;

    @SerializedName("poster_path")
    private  String posterFilm;

    //setter and getter
    //klik kanan  generate > getter dan setter


    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public String getPosterFilm() {
        return posterFilm;
    }

    public void setPosterFilm(String posterFilm) {
        this.posterFilm = posterFilm;
    }
}
