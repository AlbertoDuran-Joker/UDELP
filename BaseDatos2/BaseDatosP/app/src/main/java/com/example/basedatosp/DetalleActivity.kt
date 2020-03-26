package com.example.basedatosp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basedatos.Data.StudentsDb
import com.example.basedatos.Data.StudentsEntity
import kotlinx.android.synthetic.main.activity_detalle.*

class DetalleActivity : AppCompatActivity() {
    val studentsDb = StudentsDb(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val position = intent.extras?.getString("ID")
        var student = StudentsEntity()
        if (position != null) {
            student = studentsDb.studentsGetOne(position.toInt())
        }
        var genero =""
        val numAlumno = ((position?.toInt()))
        txvNumeroAlumno.setText(":${numAlumno?.toInt()}")
        txvNombreDetalle.setText("${student.name.toString()}")
        txvApellidoDetalle.setText("${student.lastName.toString()}")
        txvBirthday.setText("${student.birthday.toString()}")
        if(student.gender ==1){
            genero= "Masculino"
        }else{
            genero= "Femenino"
        }
        spnGeneroDetalle.setText("$genero")
    }
}
