package com.example.quotespie.DBHelper

import Qoutes_moden
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(context: Context) :SQLiteOpenHelper(context,"Quotes_pi",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE Quotes(id INTEGER PRIMARY KEY AUTOINCREMENT, quotespi TEXT, auother TEXT)"
        db!!.apply {
            execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun addQuotes(modal: Qoutes_moden){
        val db = readableDatabase
        val cn = ContentValues()

        cn.put("quotes",modal.quotes)
        cn.put("author",modal.authorName)
        db.insert("Quotes",null,cn)
    }

    @SuppressLint("Range")
    fun getQuotes():ArrayList<Qoutes_moden>{
        var db = readableDatabase
        var query = "SELECT * FROM Quotes"
        var cursor = db.rawQuery(query,null)
        var detail = ArrayList<Qoutes_moden>()
        if (cursor.moveToFirst()){
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var qoutes_pie = cursor.getString(cursor.getColumnIndex("quotes"))
                var qoutes_authorname = cursor.getString(cursor.getColumnIndex("author"))

                var modal = Qoutes_moden(id,qoutes_pie,qoutes_authorname,true,0)
                detail.add(modal)
            }while (cursor.moveToNext())
        }
        return detail
    }

}