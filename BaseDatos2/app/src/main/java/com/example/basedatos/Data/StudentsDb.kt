package com.example.basedatos.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class StudentsDb {
    private var connectionDb:ConnectionDb
    private lateinit var sqliteDataBase: SQLiteDatabase

    constructor(context: Context){
        connectionDb= ConnectionDb(context)
    }

    fun  studentAdd(student:StudentsEntity): Long{
        sqliteDataBase = connectionDb.openConnection(ConnectionDb.MODE_WRITE)

        val values = ContentValues()
        values.put(NAME,student.name)
        values.put(LASTNAME,student.lastName)
        values.put(GENDER,student.gender)
        values.put(BIRTHDAY,student.birthday)

        return sqliteDataBase.insert(ConnectionDb.TABLE_NAME_STUDENTS,null,values)
    }

    fun  studentEdit(student:StudentsEntity): Int {

        sqliteDataBase = connectionDb.openConnection(ConnectionDb.MODE_WRITE)

        val values = ContentValues()
        values.put(NAME,student.name)
        values.put(LASTNAME,student.lastName)
        values.put(GENDER,student.gender)
        values.put(BIRTHDAY,student.birthday)
        var selection = "Id=?"
        var args = arrayOf(student.id.toString())

        return sqliteDataBase.update(ConnectionDb.TABLE_NAME_STUDENTS,values,selection,args)

    }

    fun  studentDelete(idStudent:Int): Int {

        sqliteDataBase = connectionDb.openConnection(ConnectionDb.MODE_WRITE)
        var selection = "Id=?"
        var args = arrayOf(idStudent.toString())
        sqliteDataBase.delete(ConnectionDb.TABLE_NAME_STUDENTS,selection,args)
        return sqliteDataBase.delete(ConnectionDb.TABLE_NAME_STUDENTS,selection,args)

    }

    fun studentsGetAll(){
        sqliteDataBase = connectionDb.openConnection(ConnectionDb.MODE_READ)
        val fields = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY)

        val cursor = sqliteDataBase.query(ConnectionDb.TABLE_NAME_STUDENTS,fields,null,null,null,null,null)

        if(cursor.moveToFirst()){
            do {
                Log.d("UDELP","${cursor.getInt(0)} ${cursor.getString(1)} ${cursor.getString(2)} ${cursor.getInt(2)} ${cursor.getString(4)}")

            }while (cursor.moveToNext())

        }


    }

    fun studentsGetOne(idStudent:Int){
        sqliteDataBase = connectionDb.openConnection(ConnectionDb.MODE_READ)
        val fields = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY)
        var selection = "Id=?"
        var args = arrayOf(idStudent.toString())
        val cursor = sqliteDataBase.query(ConnectionDb.TABLE_NAME_STUDENTS,fields,selection,args,null,null,null)

        if(cursor.moveToFirst()){
            Log.d("UDELP","${cursor.getInt(0)} ${cursor.getString(1)} ${cursor.getString(2)} ${cursor.getInt(2)} ${cursor.getString(4)}")
        }


    }

    companion object {
        const val ID = "id"
        const val NAME = "Name"
        const val LASTNAME = "Lastname"
        const val GENDER = "Gender"
        const val BIRTHDAY = "Birthday"
    }
}