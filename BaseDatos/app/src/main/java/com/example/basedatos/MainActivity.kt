package com.example.basedatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.basedatos.Data.StudentsDb
import com.example.basedatos.Data.StudentsEntity

class MainActivity : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //son pruebas
     /*  var values = StudentsEntity(-1,"Yolanda","Martinez",0,"1986/11/16")
        var id = studentsDb.studentAdd(values)
        Log.d("UDELP","El elemento guardado es $id")

        values = StudentsEntity(-1,"Angel","Estrada",0,"1989/11/16")
        id = studentsDb.studentAdd(values)
        Log.d("UDELP","El elemento guardado es $id")

        values = StudentsEntity(-1,"Charlene","Aleman",0,"1990/11/16")
        id = studentsDb.studentAdd(values)
        Log.d("UDELP","El elemento guardado es $id")

        studentsDb.studentsGetAll()

      */


        studentsDb.studentsGetAll()

        var values = StudentsEntity(3,"Xochitl","Monfarte",0,"1986/11/16")
        studentsDb.studentEdit(values)
        //studentsDb.studentsGetOne(3)
        //studentsDb.studentDelete(2)
        //Log.d("UDELP","Despues de eliminar")
        Log.d("UDELP","Despues de editar")
        studentsDb.studentsGetAll()

    }
}
