/*
Nama        : Dani Herawan
NIM         : 10122331
Kelas       : P.ANDRO 4
Tanggal     : Sabtu, 17 Mei 2025
Jam Selesai : 17:24
*/
package com.example.pahlawanindonesia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pahlawanindonesia.adapter.ListHeroAdapter
import com.example.pahlawanindonesia.model.Hero
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListOfHeroes())
        showRecyclerList()
    }

    private fun getListOfHeroes(): ArrayList<Hero>{
        val dataname = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.foto)
        val listHero = ArrayList<Hero>()
        for (i in dataname.indices){
            val hero = Hero(dataname[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }

        return listHero
    }

    private fun showRecyclerList(){
        val listHeroAdapter = ListHeroAdapter(list){data ->
            showSelectedHero(data)
        }

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })


        rvHeroes.layoutManager = LinearLayoutManager(this)
        rvHeroes.adapter = listHeroAdapter
        rvHeroes.setHasFixedSize(true)

    }

    private fun showSelectedHero(hero: Hero){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("HERO_OBJECT", hero)
        startActivity(intent)
    }
}