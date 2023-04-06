package com.example.filmleruygulumasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.filmleruygulumasi.R
import com.example.filmleruygulumasi.databinding.FragmentDetayBinding
import com.google.android.material.snackbar.Snackbar


class DetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle:DetayFragmentArgs by navArgs()
        val gelenFilm = bundle.film

        binding.toolbarDetay.title = gelenFilm.adi
        binding.ivFilmResim.setImageResource(
            resources.getIdentifier(gelenFilm.resimAdi,"drawable",requireContext().packageName))
        binding.tvFilmYonetmen.text = gelenFilm.yonetmen
        binding.tvFilmYil.text = gelenFilm.yil.toString()
        binding.tvFilmFiyat.text = "${gelenFilm.fiyat} ₺"

        binding.btnSepeteEkle.setOnClickListener {
            Snackbar.make(it,"${gelenFilm.adi} sepete eklendi",Snackbar.LENGTH_LONG).show()
        }

        return binding.root

    }


}