package com.example.kisilerapp.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisilerapp.data.entity.Kisiler;
import com.example.kisilerapp.room.KisilerDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDaoRepository {
    private MutableLiveData<List<Kisiler>> kisilerList;
    private KisilerDao kisilerDao;

    public KisilerDaoRepository(KisilerDao kisilerDao) {
        this.kisilerDao = kisilerDao;
        kisilerList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Kisiler>> getKisilerList() {
        return kisilerList;
    }

    public void kisiKayit(String kisiAd, String kisiTel) {
        Kisiler kisiEkle = new Kisiler(0, kisiAd, kisiTel);
        kisilerDao.kisiEkle(kisiEkle).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    public void kisiGuncelle(int kisi_id, String kisi_ad, String kisi_tel) {
        Kisiler kisiGuncelle = new Kisiler(kisi_id, kisi_ad, kisi_tel);
        kisilerDao.kisiGuncelle(kisiGuncelle).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    public void kisiAra(String aramaKelimesi) {
        kisilerDao.kisiAra(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        kisilerList.setValue(kisilers);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    public void kisiSil(int kisi_id) {
        Kisiler silinenKisi = new Kisiler(kisi_id, "", "");
        kisilerDao.kisiSil(silinenKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        tumKisileriAl();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

    public void tumKisileriAl() {
        kisilerDao.tumKisiler().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisiler>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Kisiler> kisilers) {
                        kisilerList.setValue(kisilers);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
    }

}
