package com.example.kisilerapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisilerapp.R;
import com.example.kisilerapp.data.entity.Kisiler;
import com.example.kisilerapp.databinding.FragmentAnasayfaBinding;
import com.example.kisilerapp.ui.adapter.KisilerAdapter;
import com.example.kisilerapp.ui.viewmodel.AnasayfaViewModel;
import com.example.kisilerapp.ui.viewmodel.KisiKayitViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false);

        binding.setAnasayfaFragment(this);
        binding.setAnasayfaToolbarBaslik("Kişiler");
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarAnasayfa);


        viewModel.kisilerList.observe(getViewLifecycleOwner(), liste -> {
            KisilerAdapter adapter = new KisilerAdapter(requireContext(), liste, viewModel);
            binding.setKisilerAdapter(adapter);
        });


        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(AnasayfaFragment.this);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    public void fabTikla(View view) {
        Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.kisileriYukle();
    }
}