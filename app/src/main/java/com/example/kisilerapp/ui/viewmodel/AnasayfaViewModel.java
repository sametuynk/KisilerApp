package com.example.kisilerapp.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kisilerapp.data.entity.Kisiler;
import com.example.kisilerapp.data.repo.KisilerDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    private KisilerDaoRepository krepo;
    public MutableLiveData<List<Kisiler>> kisilerList = new MutableLiveData();

    @Inject
    public AnasayfaViewModel(KisilerDaoRepository krepo) {
        this.krepo = krepo;
        kisileriYukle();
        kisilerList = krepo.getKisilerList();
    }

    public void ara(String araKelime) {
        krepo.kisiAra(araKelime);
    }

    public void Sil(int kisi_id) {
        krepo.kisiSil(kisi_id);
    }

    public void kisileriYukle() {
        krepo.tumKisileriAl();
    }
}
