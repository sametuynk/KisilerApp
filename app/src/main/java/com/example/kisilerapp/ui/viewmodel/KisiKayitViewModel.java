package com.example.kisilerapp.ui.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.kisilerapp.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiKayitViewModel extends ViewModel {
    private KisilerDaoRepository krepo;
    @Inject
    public KisiKayitViewModel(KisilerDaoRepository krepo){
        this.krepo = krepo;
    }
    public void kayit(String kisiAd, String kisiTel) {
        krepo.kisiKayit(kisiAd,kisiTel);
    }
}
