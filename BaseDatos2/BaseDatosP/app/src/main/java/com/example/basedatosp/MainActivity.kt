package com.example.basedatosp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        when(item.itemId) {
            R.id.itmAlta->{
                val intent = Intent(this@MainActivity,AltaActivity::class.java)
                startActivity(intent)

            }
            R.id.itmAlumnos->{
                val intent = Intent(this@MainActivity,Alumnos::class.java)
                startActivity(intent)

            }
            R.id.itmEditar->{
                val intent = Intent(this@MainActivity,AlumnoEditar::class.java)
                startActivity(intent)

            }
            R.id.itmEliminar->{
                val intent = Intent(this@MainActivity,EliminarActivity::class.java)
                startActivity(intent)

            }

        }
        return true
    }


}
