package com.example.basedatosp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.basedatos.Data.StudentsDb
import com.example.basedatos.Data.StudentsEntity
import kotlinx.android.synthetic.main.activity_alta.*
import kotlinx.android.synthetic.main.activity_alta.btnEditar
import kotlinx.android.synthetic.main.activity_alta.etPlannedDate
import kotlinx.android.synthetic.main.activity_editart.*
import java.util.*

class EditartActivity : AppCompatActivity() {
    val studentsDb = StudentsDb(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editart)
        val id = intent.extras?.getString("ID")
        var student = StudentsEntity()
        if (id != null) {
            student = studentsDb.studentsGetOne(id.toInt())
        }


        edtNombreEd.setText("${student.name.toString()}")
        edtApellidoEd.setText("${student.lastName.toString()}")



        btnEditar.setOnClickListener(){
            val miAlumnos = StudentsEntity()

            if (edtNombreEd.text.toString().trim().isNotEmpty()) {
                var name  = edtNombreEd.text.toString()
                if (edtApellidoEd.text.toString().trim().isNotEmpty()) {
                    var lastName = edtApellidoEd.text.toString()
                    val gender = spnGeneroEd.selectedItemPosition
                    if (gender > 0) {
                        val civil =
                            spnGeneroEd.getSelectedItemId().toString()

                        var values = StudentsEntity(-1,name ,lastName ,gender ,"10/02/16" )
                        studentsDb.studentEdit(values)
                        Toast.makeText(this@EditartActivity,"Editado con exito", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@EditartActivity,"Falta Genero", Toast.LENGTH_SHORT).show()

                    }
                }else{
                    Toast.makeText(this@EditartActivity,"Falta Apellido ", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@EditartActivity,"Falta Nombre", Toast.LENGTH_SHORT).show()
            }


            spnGeneroEd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

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
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    etPlannedDate.setText(""+mDay+"/"+mMonth+"/"+mYear)
                },year,month,day)
            dpd.show()
        }
    }
    }
