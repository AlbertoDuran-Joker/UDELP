package com.example.encuestas.Util

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.encuestas.Data.ListaEncuestas
import com.example.encuestas.Entity.EntityEncuesta
import com.example.encuestas.R
import com.example.encuestas.Util.ValidateEmail.Companion.isEmailValid
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_make.*

class MakeActivity : AppCompatActivity(){

    val encuesta = ListaEncuestas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make)

        btnEnviarRegistro.setOnClickListener {
            val miencuesta = EntityEncuesta()
            if (edtNombreRegistro.text.toString().trim().isNotEmpty()) {
                //Toast.makeText(this@RealizarEncuestaActivity,"Que transa si le metiste datos",Toast.LENGTH_LONG).show()
                // Snackbar.make(it, "Que transa si le metiste datos", Snackbar.LENGTH_SHORT).show()
                //Aqui marcara error hasta tener la clase kotlin encuesta
                miencuesta.nombre = edtNombreRegistro.text.toString()
                //------------------Anidando if para que si el nombre esta lleno se siga al siguiente campo
                if (edtApellidoPaternoRegistro.text.toString().trim().isNotEmpty()) {
                    miencuesta.apellidoPaterno = edtApellidoPaternoRegistro.text.toString()

                    if (edtApellidoMaternoRegistro.text.toString().trim().isNotEmpty()) {
                        miencuesta.apellidoMaterno = edtApellidoPaternoRegistro.text.toString()
                        //validando que sea email
                        if ((edtCorreoRegistro.text.toString().trim().isNotEmpty()) and (isEmailValid(edtCorreoRegistro.text.toString().trim().toString()))){
                            miencuesta.correo = edtCorreoRegistro.text.toString()
                            val generoposition = spnGeneroRegistro.selectedItemPosition

                            if (generoposition > 0){
                                miencuesta.genero = generoposition
                                val genero = spnGeneroRegistro.getSelectedItemId().toString()
                                Log.d("udelp","Seleccionaste Genero $genero")
                                val aeropatitoposition = spnViajadoRegistro.selectedItemPosition
                                if (aeropatitoposition > 0){

                                    miencuesta.viajado = aeropatitoposition

                                    val frecuenciaposition = spnFrecuenciaRegistro.selectedItemPosition

                                    if (frecuenciaposition > 0){
                                        miencuesta.frecuencia = frecuenciaposition
                                        val experienciaposition =spnExperienciaRegistro.selectedItemPosition
                                        if (experienciaposition > 0){
                                            miencuesta.experiencia = experienciaposition

                                            val selectedServicio = rdgServicio.checkedRadioButtonId
                                            if (selectedServicio != -1){
                                                when(selectedServicio){
                                                    rdbExcelente.id->{
                                                        miencuesta.servicio = "Excelente"
                                                    }
                                                    rdbBueno.id->{
                                                        miencuesta.servicio  = "Bueno"
                                                    }
                                                    rdbMalo.id->{
                                                        miencuesta.servicio  = "Malo"
                                                    }
                                                }

                                                if((ckbEconomica.isChecked) or (ckbEjecutiva.isChecked) or (ckbPromo.isChecked)){
                                                    //val encuesta.aqui ver los checkbox = True
                                                    // revisar aqui que se la validacion
                                                    //   misencuestas.agregarEncuesta()
                                                    //Toast.makeText(this@RealizarEncuestaActivity,"Se guardo el estudiante ${miencuesta}",Toast.LENGTH_SHORT).show()
                                                    Log.d("udelp",miencuesta.correo)
                                                    if(swtOfertasDescuentos.isChecked){
                                                        miencuesta.ofertas =true
                                                    }
                                                    miencuesta.mejora = edtMejoras.text.toString()
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


                            }else{
                                Snackbar.make(it, "Por favor selecciona Genero", Snackbar.LENGTH_SHORT).show()
                            }


                        }else{
                            Snackbar.make(it, "Por favor ingresa el Correo", Snackbar.LENGTH_SHORT).show()
                        }


                    } else {
                        //Toast.makeText(this@RealizarEncuestaActivity,"Te dije que le metieras datos culo",Toast.LENGTH_LONG).show()
                        Snackbar.make(it, "Por favor ingresa el Apellido Materno", Snackbar.LENGTH_SHORT).show()
                    }



                } else {
                    //Toast.makeText(this@RealizarEncuestaActivity,"Te dije que le metieras datos culo",Toast.LENGTH_LONG).show()
                    Snackbar.make(it, "Por favor ingresa el Apellido Paterno", Snackbar.LENGTH_SHORT).show()
                }


            } else {
                //Toast.makeText(this@RealizarEncuestaActivity,"Te dije que le metieras datos culo",Toast.LENGTH_LONG).show()
                Snackbar.make(it, "Por favor ingresa el nombre", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}