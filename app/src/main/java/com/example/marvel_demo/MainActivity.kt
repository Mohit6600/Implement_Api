package com.example.marvel_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_demo.adapter.MarvelAdapter
import com.example.marvel_demo.retrofit.RetrofitHelper
import com.example.marvel_demo.retrofit.response.marvelResponse.Superhero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//https://github.com/SurajKumar854/RetrofitDemo

class MainActivity : AppCompatActivity() {

    lateinit var marvelAdapter: MarvelAdapter
    lateinit var marvel_rv: RecyclerView
    var marvelList: ArrayList<Superhero> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        marvel_rv = findViewById(R.id.recyclerView)
        marvel_rv.layoutManager = LinearLayoutManager(this)
        marvelAdapter = MarvelAdapter(this, marvelList)



        marvel_rv.adapter = marvelAdapter


        CoroutineScope(Dispatchers.IO).launch {
            val list = RetrofitHelper.getInstance().getProduct().superheros as ArrayList<Superhero>
            marvelList.clear()
            marvelList.addAll(list)

            withContext(Dispatchers.Main){
                marvelAdapter.notifyDataSetChanged()
            }
            Log.d("coding", marvelList.size.toString())
        }

    }

}
