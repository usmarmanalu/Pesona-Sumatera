package com.example.pesonasumatera

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailPages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pages)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Detail")

        val dataPesona = intent.getParcelableExtra<Pesona>("key_pesona")

        val tvDetailName: TextView = findViewById(R.id.detail_nama_wisata)
        val tvDetailDesc: TextView = findViewById(R.id.detail_descripsi)
        val ivDetailPhoto: ImageView = findViewById(R.id.photos_detail)
        val tvJenisWst : TextView = findViewById(R.id.text_spec_display)
        val tvalamatWst : TextView = findViewById(R.id.text_spec_size)

        tvDetailName.text = dataPesona?.name
        tvDetailDesc.text = dataPesona?.description
        tvJenisWst.text = dataPesona?.jenisWst
        tvalamatWst.text = dataPesona?.alamatWst
        dataPesona?.photo?.let {
            Picasso.get().load(it).into(ivDetailPhoto)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->  {
                onBackPressed()
                return  true
            }else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}
