package com.example.encuestas.Util

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.encuestas.R
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        btnOk.setOnClickListener {
            val user=edtNombreUsuario.text.toString()
            val password=edtContrasena.text.toString()

            if(user.equals("admin") && password.equals("root")){
                val intent = Intent(this@AuthenticationActivity,MainActivity::class.java)
                intent.putExtra("usuario", "$user");
                startActivity(intent)

            }else
            {
                Toast.makeText(this@AuthenticationActivity,"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.authentication_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.itmRegistro -> {
                val intent = Intent(this@AuthenticationActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}