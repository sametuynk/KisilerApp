package com.example.kisilerapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kisilerapp.R;
import com.example.kisilerapp.databinding.FragmentKisiKayitBinding;
import com.example.kisilerapp.ui.viewmodel.KisiKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiKayitFragment extends Fragment {

    private FragmentKisiKayitBinding binding;
    private KisiKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false);

        binding.setKisiKayitToolbarBaslik("Kişi Kayıt");
        binding.setKisiKayitFragment(this);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiKayitViewModel.class);
    }

    public void buttonKayit(String kisiAd, String kisiTel) {
        viewModel.kayit(kisiAd,kisiTel);
        Toast.makeText(getContext(), "KİŞİ KAYIT EDİLDİ", Toast.LENGTH_SHORT).show();
    }
}