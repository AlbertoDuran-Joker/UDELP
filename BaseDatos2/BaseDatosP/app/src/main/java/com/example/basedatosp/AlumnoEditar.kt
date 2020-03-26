package com.example.basedatosp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.basedatos.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_alumnos.*

class AlumnoEditar : AppCompatActivity() {
    val studentsDb = StudentsDb(this)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno_editar)
        val ListaAlumnos = StudentsDb(this)
        var Lista2 = arrayListOf<String>()


        val miAdaptador = ArrayAdapter<String> (this@AlumnoEditar, android.R.layout.simple_list_item_1,ListaAlumnos.studentsGetAllString())

        ltvEncuestas.adapter=miAdaptador

        ltvEncuestas.setOnItemClickListener {
                adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
            val itemSeleccionado = adapterView.getItemAtPosition(position)
            //Toast.makeText(this@Alumnos,"$position $id $itemSeleccionado", Toast.LENGTH_SHORT).show()
            val idStudent =  StudentsDb.listStringIDS[position.toInt()]
            Toast.makeText(this@AlumnoEditar,"$idStudent", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@AlumnoEditar, EditartActivity::class.java)
            intent.putExtra("ID", idStudent.trim())
            startActivity(intent)

        }
    }
}


