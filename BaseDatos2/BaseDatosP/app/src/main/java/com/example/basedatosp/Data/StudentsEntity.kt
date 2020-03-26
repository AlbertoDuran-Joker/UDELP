package com.example.basedatos.Data

data class StudentsEntity (
    var id:Int,
    var name:String,
    var lastName:String,
    var gender:Int,
    var birthday:String

){constructor(): this(0,"","",0,"")}