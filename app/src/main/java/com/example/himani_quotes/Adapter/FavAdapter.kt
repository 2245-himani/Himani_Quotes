package com.example.soulscript.Adapter

import Qoutes_moden
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.himani_quotes.R

class FavAdapter(private val context: Context, private val favList: List<Qoutes_moden>) :
    RecyclerView.Adapter<FavAdapter.FavHolder>() {

    inner class FavHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Quotestext: TextView = itemView.findViewById(R.id.Quotestext)
        var authorName: TextView = itemView.findViewById(R.id.authirname)
        var Add_favorite: ImageView = itemView.findViewById(R.id.Add_favorite)
        // Add other views as needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.qoutes_list, parent, false)

        return FavHolder(view)
    }

    override fun getItemCount(): Int {
        return favList.size

    }

    override fun onBindViewHolder(holder: FavHolder, position: Int) {
        holder.Quotestext.text = favList[position].quotes
        holder.authorName.text = favList[position].authorName
        holder.Add_favorite.setImageResource(R.drawable.add_icon)



    }
}
