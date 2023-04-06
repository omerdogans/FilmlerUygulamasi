package com.example.filmleruygulumasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulumasi.R
import com.example.filmleruygulumasi.data.Filmler
import com.example.filmleruygulumasi.databinding.FragmentAnasayfaBinding
import com.example.filmleruygulumasi.ui.adapter.FilmlerAdapter

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)


        binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        var filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1,"Django","django",2009,7.09,"Q.Tarantino")
        val f2 = Filmler(2,"Anadoluda","anadoluda",2011,6.0,"N.B.Ceylan")
        val f3 = Filmler(3,"Inception","inception",2013,8.0,"C.Nolan")
        val f4 = Filmler(4,"Interstellar","interstellar",2008,11.0,"C.Nolan")
        val f5 = Filmler(5,"The Hateful Eight","thehatefuleight",201,13.0,"Q.Tarantino")
        val f6 = Filmler(6,"The Pianist","thepianist",2004,5.9,"R.Polanski")

        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        val adapter = FilmlerAdapter(requireContext(),filmlerListesi)
        binding.rv.adapter = adapter



        return binding.root
    }


}