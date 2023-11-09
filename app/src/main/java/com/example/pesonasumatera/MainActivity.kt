package com.example.pesonasumatera

import ListHeroAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Pesona>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_pesona)
        rvHeroes.setHasFixedSize(true)

        list.addAll(listHeroes)
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }




    private val listHeroes: ArrayList<Pesona>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataJenis = resources.getStringArray(R.array.data_wisata)
            val dataAlamat = resources.getStringArray(R.array.data_address)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listHero = ArrayList<Pesona>()
            for (i in dataName.indices) {
                val hero = Pesona(dataName[i], dataDescription[i], dataPhoto[i], dataJenis[i], dataAlamat[i])
                listHero.add(hero)
            }
            return listHero
        }
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }
}
