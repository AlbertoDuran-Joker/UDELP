package com.example.basedatosp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basedatos.Data.StudentsDb
import com.example.basedatos.Data.StudentsEntity

import kotlinx.android.synthetic.main.activity_alta.*
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import java.util.*


class AltaActivity : AppCompatActivity() {
    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta)

        btnEditar.setOnClickListener(){
            val miAlumnos = StudentsEntity()

            if (edtNombre.text.toString().trim().isNotEmpty()) {
                var name  = edtNombre.text.toString()
                if (edtApellido.text.toString().trim().isNotEmpty()) {
                    var lastName = edtApellido.text.toString()
                    val gender = spnGenero.selectedItemPosition
                    if (gender > 0) {
                        val civil =
                            spnGenero.getSelectedItemId().toString()

                        var values = StudentsEntity(-1,name ,lastName ,gender ,"10/02/16" )
                        studentsDb.StudentAdd(values)
                        edtNombre.text.clear()
                        edtApellido.text.clear()
                        spnGenero.setSelection(0)
                        Toast.makeText(this@AltaActivity,"Guardado",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@AltaActivity,"Falta Genero",Toast.LENGTH_SHORT).show()

                    }
                }else{
                    Toast.makeText(this@AltaActivity,"Falta Apellido ",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@AltaActivity,"Falta Nombre",Toast.LENGTH_SHORT).show()
            }


            spnGenero.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                override fun onNothingSelected(parent: AdapterView<*>?) {

                    Log.d("Udelp", "Estoy en el evento onNothingSelected")

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val textoSeleccionado = parent?.getItemAtPosition(position)
                    Log.d("Udelp", "Estoy en el evento onItemSelected $textoSeleccionado")
                }


            }








        }
        //////////////////////////Calendario////////////////////
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        etPlannedDate.setOnClickListener{
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                etPlannedDate.setText(""+mDay+"/"+mMonth+"/"+mYear)
            },year,month,day)
            dpd.show()
        }
    }
}
