package com.example.basedatosp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.basedatos.Data.StudentsDb.Companion.listStringIDS
import com.example.basedatos.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_alumnos.*

class Alumnos : AppCompatActivity() {
    val studentsDb = StudentsDb(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        val ListaAlumnos = StudentsDb(this)
        var Lista2 = arrayListOf<String>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumnos)



                val miAdaptador = ArrayAdapter<String> (this@Alumnos, android.R.layout.simple_list_item_1,ListaAlumnos.studentsGetAllString())

                ltvEncuestas.adapter=miAdaptador

                ltvEncuestas.setOnItemClickListener {
                        adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
                    val itemSeleccionado = adapterView.getItemAtPosition(position)
                    val idStudent =  listStringIDS[position.toInt()]
                    Toast.makeText(this@Alumnos,"$idStudent", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@Alumnos, DetalleActivity::class.java)
                    intent.putExtra("ID", idStudent.trim())
                    startActivity(intent)

                }
            }
        }
