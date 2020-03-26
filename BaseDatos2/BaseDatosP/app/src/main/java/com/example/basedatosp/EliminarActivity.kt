package com.example.basedatosp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.basedatos.Data.StudentsDb.Companion.listStringIDS
import com.example.basedatos.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_eliminar.*

class EliminarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val studentsDb = StudentsDb(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar)



            if( studentsDb.studentsGetAllString().size >0){
                val miAdaptador = ArrayAdapter<String> (this@EliminarActivity, android.R.layout.simple_list_item_1,studentsDb.studentsGetAllString())

                ltvMisEstudiantes.adapter=miAdaptador

                ltvMisEstudiantes.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
                    val itemSeleccionado = adapterView.getItemAtPosition(position)

                    var idStudent =  listStringIDS[id.toInt()]
                    Toast.makeText(
                        this@EliminarActivity,

                        "Seleccionaste el $idStudent ",
                        Toast.LENGTH_SHORT
                    ).show()
                    miDialogo("Eliminar a ${idStudent.trim().toString()}",idStudent.trim().toInt()).show()

                }

            }

        }

        private fun miDialogo(texto: String, id: Int): AlertDialog {
            val studentsDb = StudentsDb(this)
            val miAlerta = AlertDialog.Builder(this@EliminarActivity)
            miAlerta.setTitle("Estar seguro que deseas eliminar?").setMessage(texto)
            miAlerta.setPositiveButton("SI"){dialog,which ->
                studentsDb.studentDelete(id)
                Toast.makeText(this@EliminarActivity,"Eliminado",Toast.LENGTH_SHORT).show()
                finish();
                startActivity(intent);
            }
            miAlerta.setNegativeButton("NO"){ dialog,which ->
                Toast.makeText(this@EliminarActivity,"No eliminado",Toast.LENGTH_SHORT).show()

            }
            return miAlerta.create()
        }


    }

