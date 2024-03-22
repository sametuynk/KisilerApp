package com.example.kisilerapp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisilerapp.R;
import com.example.kisilerapp.data.entity.Kisiler;
import com.example.kisilerapp.databinding.CardTasarimBinding;
import com.example.kisilerapp.ui.fragment.AnasayfaFragment;
import com.example.kisilerapp.ui.fragment.AnasayfaFragmentDirections;
import com.example.kisilerapp.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {
    private Context context;
    private List<Kisiler> kisilerList;
    private AnasayfaViewModel viewModel;

    public KisilerAdapter(Context context, List<Kisiler> kisilerList, AnasayfaViewModel viewModel) {
        this.context = context;
        this.kisilerList = kisilerList;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        //Card tasarimi üzerindeki görsel nesnelere ulaşmamızı sağlıyor
        private CardTasarimBinding binding;

        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        CardTasarimBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerList.get(position);
        CardTasarimBinding h = holder.binding;
        h.setKisiNesnesi(kisi);

        h.textViewKisiAd.setText(kisi.getKisi_ad());
        h.textViewKisiTel.setText(kisi.getKisi_tel());

        h.imageViewSil.setOnClickListener(view ->{
            Snackbar.make(view,kisi.getKisi_ad()+" Silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET",view1->{
                        viewModel.Sil(kisi.getKisi_id());
                    }).show();
        });

        h.satirCard.setOnClickListener(view ->{
            AnasayfaFragmentDirections.KisiDetayGecis gecis =AnasayfaFragmentDirections.kisiDetayGecis(kisi);
            Navigation.findNavController(view).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {
        //veri kümesinin boyunu ister
        return kisilerList.size();
    }


}
