package com.example.kisilerapp.di;

import android.content.Context;

import androidx.room.Room;

import com.example.kisilerapp.data.repo.KisilerDaoRepository;
import com.example.kisilerapp.room.KisilerDao;
import com.example.kisilerapp.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisilerDaoRepository provideKisilerDaoRepository(KisilerDao kisilerDao){
        return new KisilerDaoRepository(kisilerDao);
    }
    @Provides
    @Singleton
    public KisilerDao provideKisilerDao(@ApplicationContext Context context){
        Veritabani vt = Room.databaseBuilder(context,Veritabani.class,"rehbers.sqlite")
                .createFromAsset("rehbers.sqlite").build();
        return vt.getKisilerDao();
    }
}
