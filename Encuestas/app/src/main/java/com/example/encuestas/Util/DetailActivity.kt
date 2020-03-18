package com.example.encuestas.Util

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.encuestas.Data.ListaEncuestas.Companion.listaEncuesta
import com.example.encuestas.Entity.EntityEncuesta
import com.example.encuestas.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val position = intent.extras?.getString("ID")
        // Log.d("udelp","$user")
        // Toast.makeText(this@HomeActivity,"Hola $user", Toast.LENGTH_SHORT).show()
        var encuesta = EntityEncuesta()
        encuesta = listaEncuesta[position!!.toInt()]
        var genero =""
        var viajado=""
        var frecuencia=""
        var exp=""
        var ofertas=""
        txvNombreDetalle.setText("${encuesta.nombre.toString()}")
        txvNumeroEncuesta.setText(":${position+1.toString()}")
        txvApellidoPaternoDetalle.setText("${encuesta.apellidoPaterno.toString()}")
        txvApellidoMaternoDetalle.setText("${encuesta.apellidoMaterno.toString()}")
        txvCorreoDetalle.setText("${encuesta.correo.toString()}")
        //meter if 0/1 genero
        if(encuesta.genero==1){
            genero= "Masculino"
        }else{
            genero= "Femenino"
        }
        txvGeneroDetalle.setText("$genero")
        if(encuesta.viajado==1){
            viajado= "Si ha viajadado en AeroPatito"
        }else{
            viajado= "No se como pudiste contestar , la traicion hermano"
        }
        txvViajadoDetalle.setText("$viajado")
        when(encuesta.frecuencia){
            1->{
                frecuencia = "1 a 3 veces al año"
            }
            2->{
                frecuencia = "4 a 7 veces al año"
            }
            3->{
                frecuencia = "mas de 7 veces al año"
            }
        }
        txvFrecuenciaDetalle.setText("$frecuencia")
        when(encuesta.experiencia){
            1->{
                exp="Mala"
            }
            2->{
                exp="Regular"
            }
            3->{
                exp="Buena"
            }
            4->{
                exp="Excelente servicio 5 estrellas"
            }
        }
        txvExperienciaDetalle.setText("$exp")
        //?
        txvEsquemaDetalle.setText("${encuesta.ejecutiva.toString()} ${encuesta.promo.toString()} ${encuesta.economica.toString()}")

        txvServicioDetalle.setText("${encuesta.servicio.toString()}")
        txvMejorasDetalle.setText("${encuesta.mejora.toString()}")
        if(encuesta.ofertas==true){
            ofertas = "Quiero recibir ofertas y descuentos"
        }else{
            ofertas = "No quiero recibir ofertas y descuentos"
        }
        txvOfertasDescuentosDetalle.setText("$ofertas")
    }
}