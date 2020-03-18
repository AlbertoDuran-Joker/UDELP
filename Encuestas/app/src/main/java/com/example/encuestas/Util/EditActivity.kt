package com.example.encuestas.Util

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.encuestas.Data.ListaEncuestas
import com.example.encuestas.Data.ListaEncuestas.Companion.listaEncuesta
import com.example.encuestas.Entity.EntityEncuesta
import com.example.encuestas.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity(){
    val encuesta = ListaEncuestas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val position = intent.extras?.getString("ID")
        var miencuesta = EntityEncuesta()
        miencuesta = listaEncuesta[position!!.toInt()]
        var genero =""
        var viajado=""
        var frecuencia=""
        var exp=""
        var ofertas=""

        txvNombreEditar.setText("${miencuesta.nombre.toString()}")
        txvApellidoPaternoEditar.setText("${miencuesta.apellidoPaterno.toString()} ${miencuesta.apellidoMaterno.toString()}")
        txvCorreoEditar.setText("${miencuesta.correo.toString()}")

        if(miencuesta.genero==1){
            genero= "Masculino"
        }else{
            genero= "Femenino"
        }
        txvGeneroEditar.setText("$genero")

        val aeropatitoposition = spnViajadoEditar.selectedItemPosition
        if (aeropatitoposition > 0){

            miencuesta.viajado = aeropatitoposition

            val frecuenciaposition = spnFrecuenciaEditar.selectedItemPosition

            if (frecuenciaposition > 0){
                miencuesta.frecuencia = frecuenciaposition
                val experienciaposition =spnExperienciaEditar.selectedItemPosition
                if (experienciaposition > 0){
                    miencuesta.experiencia = experienciaposition

                    val selectedServicio = rdgServicioEditar.checkedRadioButtonId
                    if (selectedServicio != -1){
                        when(selectedServicio){
                            rdbExcelenteEditar.id->{
                                miencuesta.servicio = "Excelente"
                            }
                            rdbBuenoEditar.id->{
                                miencuesta.servicio  = "Bueno"
                            }
                            rdbMaloEditar.id->{
                                miencuesta.servicio  = "Malo"
                            }
                        }

                        if((ckbEconomicaEditar.isChecked) or (ckbEjecutivaEditar.isChecked) or (ckbPromoEditar.isChecked)){
                            //val encuesta.aqui ver los checkbox = True
                            // revisar aqui que se la validacion
                            //   misencuestas.agregarEncuesta()
                            //Toast.makeText(this@RealizarEncuestaActivity,"Se guardo el estudiante ${miencuesta}",Toast.LENGTH_SHORT).show()
                            Log.d("udelp",miencuesta.correo)
                            if(swtOfertasDescuentosEditar.isChecked){
                                miencuesta.ofertas =true
                            }
                            miencuesta.mejora = edtMejorasEditar.text.toString()
                            Log.d("tamañoLISTA",encuesta.agregarEncuestaPRUEBA(miencuesta).toString())


                            // Toast.makeText(this@RealizarEncuestaActivity,"Se guardo el estudiante ${miencuesta}",Toast.LENGTH_SHORT).show()

                        }else{
                            Snackbar.make(it,"Selecciona que tipo de esquema usaste ",Snackbar.LENGTH_SHORT).show()
                        }

                    }else{
                        Snackbar.make(it,"Selecciona como es nuestro servicio",Snackbar.LENGTH_SHORT).show()
                    }


                }else{
                    Snackbar.make(it,"Selecciona tu experiencia",Snackbar.LENGTH_SHORT).show()
                }

            }else{
                Snackbar.make(it, "Por favor selecciona la frecuencia", Snackbar.LENGTH_SHORT).show()
            }

        }else{
            Snackbar.make(it, "Por favor selecciona si has viajado con nosotros", Snackbar.LENGTH_SHORT).show()
        }
    }
}