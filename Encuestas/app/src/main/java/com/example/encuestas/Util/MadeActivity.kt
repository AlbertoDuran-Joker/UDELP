package com.example.encuestas.Util

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.encuestas.R
import com.example.encuestas.Data.ListaEncuestas
import kotlinx.android.synthetic.main.activity_made.*

class MadeActivity : AppCompatActivity() {
    var ListaEncuestas = ListaEncuestas()
    var Lista2 = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_made)

        if(ListaEncuestas.devuelveListEncuesta().size >0){
            val miAdaptador = ArrayAdapter<String> (this@MadeActivity, android.R.layout.simple_list_item_1,ListaEncuestas.devuelveListEncuestaString())

            ltvEncuestas.adapter=miAdaptador

            ltvEncuestas.setOnItemClickListener {
                adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
                val itemSeleccionado = adapterView.getItemAtPosition(position)
                Toast.makeText(this@MadeActivity,"$position $id $itemSeleccionado",Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MadeActivity, DetailActivity::class.java)
                intent.putExtra("ID", position.toString())
                startActivity(intent)
            }
        }
    }
}