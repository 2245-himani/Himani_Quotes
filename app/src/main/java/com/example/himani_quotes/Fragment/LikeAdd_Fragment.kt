package com.example.soulscript.Fragment

import Qoutes_moden
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.himani_quotes.databinding.FragmentLikeAddBinding

import com.example.quotespie.DBHelper.DBhelper
import com.example.soulscript.Adapter.FavAdapter

lateinit var binding: FragmentLikeAddBinding
var quotesList = ArrayList<Qoutes_moden>()
class LikeAdd_Fragment : Fragment(){
    lateinit var db: DBhelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentLikeAddBinding.inflate(inflater, container, false)

        quotesList = ArrayList()

        rvData()
        db = DBhelper(requireContext())
        quotesList = db.getQuotes()

        return binding.root
    }
    private fun rvData() {
        var adapter = FavAdapter(requireContext(), quotesList)
        var lm = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.recyclerView.layoutManager = lm
        binding.recyclerView.adapter = adapter
    }
}