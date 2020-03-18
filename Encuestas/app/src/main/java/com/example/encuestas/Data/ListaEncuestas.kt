package com.example.encuestas.Data

import android.util.Log
import com.example.encuestas.Entity.EntityEncuesta

class ListaEncuestas {
    companion object {
        val listaEncuesta = arrayListOf<EntityEncuesta>()
        private val listString = arrayListOf<String>()
    }

    public fun agregarEncuesta(nombre:String,apellidoP:String,apellidoM:String,correo:String,genero:Int,viajado:Int,frecuencia:Int,
                               experiencia:Int,ejecutiva:Boolean,economica:Boolean,promo:Boolean,servicio:String,mejora:String,ofertas:Boolean){

        val encuestaR = EntityEncuesta(nombre,apellidoP,apellidoM,correo,genero,viajado,frecuencia,experiencia,ejecutiva,economica,promo,servicio,mejora,ofertas)
        listaEncuesta.add(encuestaR)
        Log.d("encuestasUDELP","$encuestaR")
    }

    public fun agregarEncuestaPRUEBA(encuestaR:EntityEncuesta): Int{

        //val encuestaR = EntityEncuesta(nombre,apellidoP,apellidoM,correo,genero,viajado,frecuencia,experiencia,ejecutiva,economica,promo,servicio,mejora,ofertas)
        listaEncuesta.add(encuestaR)

        Log.d("encuestasUDELP","$encuestaR")

        return listaEncuesta.size
    }

   /* public fun eliminarEncuesta(nombre: String){
        for((index,item)in listaEncuesta.withIndex())
        {
            if(item == nombre){
                listaEncuesta.removeAt(index)
                break
            }
        }
    }*/

    /*public fun editarEncuesta(nombre: String,viajado: Int,frecuencia: Int,experiencia: Int,ejecutiva: Boolean,economica: Boolean,
                              promo: Boolean,servicio: String,mejora: String,ofertas: Boolean,viajadoN: Int,frecuenciaN: Int,
                              experienciaN: Int,ejecutivaN: Boolean,economicaN: Boolean, promoN: Boolean, servicioN: String,
                              mejoraN: String,ofertasN: Boolean){

        for((index,item)in listaEncuesta.withIndex())
        {
            if(item == nombre){
                listaEncuesta[index] = viajadoN.toString()
                listaEncuesta[index] = frecuenciaN.toString()
                listaEncuesta[index] = experienciaN.toString()
                listaEncuesta[index] = ejecutivaN.toString()
                listaEncuesta[index] = economicaN.toString()
                listaEncuesta[index] = promoN.toString()
                listaEncuesta[index] = servicioN
                listaEncuesta[index] = mejoraN
                listaEncuesta[index] = ofertasN.toString()
            }
        }
    }*/

    public fun muestraEncuesta(){
        for((index,item) in listaEncuesta.withIndex()){
            Log.d("UDELP","$index $item")

        }
    }

    public fun devuelveListEncuesta(): Array<EntityEncuesta> {
        val elems = listaEncuesta
        return elems.toTypedArray()

    }

    public fun devuelveListEncuestaString(): Array<String> {
        listString.clear()
        for (entityEncuesta in listaEncuesta) {
            listString.add(entityEncuesta.nombre)

        }
        Log.d("Test", listString[0])
        Log.d("Ultimo", listString[listString.size -1])
        val elems = listString
        return elems.toTypedArray()

    }
}