package com.example.kisilerapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kisilerapp.data.entity.Kisiler;

import java.util.List;


import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisilerDao {
    @Query("select * from kisiler")
    Single<List<Kisiler>> tumKisiler();
    @Query("select * from kisiler where kisi_ad like '%' || :aramaKelimesi || '%'")
    Single<List<Kisiler>> kisiAra(String aramaKelimesi);

    @Delete
    Completable kisiSil(Kisiler kisi);

    @Insert
    Completable kisiEkle(Kisiler kisi);
    @Update
    Completable kisiGuncelle(Kisiler kisi);
}
