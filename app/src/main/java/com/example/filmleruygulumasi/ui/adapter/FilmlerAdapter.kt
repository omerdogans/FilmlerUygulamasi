package com.example.filmleruygulumasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmleruygulumasi.data.Filmler
import com.example.filmleruygulumasi.databinding.CardTasarimBinding
import com.example.filmleruygulumasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext:Context,var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.HolderClass>(){

    inner class HolderClass(var binding: CardTasarimBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderClass {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return HolderClass(binding)
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }

    override fun onBindViewHolder(holder: HolderClass, position: Int) {
        val film = filmlerListesi.get(position)

        val t = holder.binding

        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resimAdi,"drawable",mContext.packageName))

        t.textViewFilm.text = film.adi
        t.textViewFiyat.text = "${film.fiyat} ₺"
        t.buttonSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${film.adi} sepete eklendi", Snackbar.LENGTH_LONG).show()
        }
        t.cardViewFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.toDetay(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }


    }


}