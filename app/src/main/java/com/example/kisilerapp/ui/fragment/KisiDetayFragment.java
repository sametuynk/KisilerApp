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
import com.example.kisilerapp.data.entity.Kisiler;
import com.example.kisilerapp.databinding.FragmentKisiDetayBinding;
import com.example.kisilerapp.ui.viewmodel.KisiDetayViewModel;
import com.example.kisilerapp.ui.viewmodel.KisiKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiDetayFragment extends Fragment {

    private FragmentKisiDetayBinding binding;
    private KisiDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_detay, container, false);

        binding.setKisiDetayFragment(this);
        binding.setKisiDetayToolbarBaslik("Kişi Detay");


        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler gelenKisi = bundle.getKisi();

        binding.setKisiNesnesi(gelenKisi);


        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiDetayViewModel.class);
    }

    public void buttonGuncelle(int kisi_id, String kisi_ad, String kisi_tel) {
        viewModel.Guncelle(kisi_id,kisi_ad,kisi_tel);
        Toast.makeText(getContext(), "KİŞİ GÜNCELLENDİ", Toast.LENGTH_SHORT).show();
    }
}