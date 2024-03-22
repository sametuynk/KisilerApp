package com.example.kisilerapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisilerapp.data.repo.KisilerDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiDetayViewModel extends ViewModel {
    private KisilerDaoRepository krepo;
    @Inject
    public KisiDetayViewModel(KisilerDaoRepository krepo){
        this.krepo = krepo;
    }
    public void Guncelle(int kisi_id, String kisi_ad, String kisi_tel) {
        krepo.kisiGuncelle(kisi_id,kisi_ad,kisi_tel);
    }
}
