package com.example.remind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NotificacionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notificaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Se reciben y posteriormente se cargan los parametros de la activity anterior
        val nombre = intent.getStringExtra("nombre")
        //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()

        misTarea(nombre.toString())
        salir(nombre.toString())
        inicio(nombre.toString())
        cuenta(nombre.toString())
    }

    private fun misTarea(nombre: String) {
        val button : Button = findViewById(R.id.btnMTareas)
        button.setOnClickListener{
            val intent = Intent(this, TareasActivity::class.java).apply {
                putExtra("nombre", nombre)
            }
            startActivity(intent)
        }
    }

    private fun salir (nombre : String){
        val button : Button = findViewById(R.id.btnVolver)
        button.setOnClickListener{
            val intent = Intent(this, InicioActivity::class.java).apply {
                putExtra("nombre", nombre)
            }
            startActivity(intent)
        }
    }
    private fun inicio (nombre : String){
        val button : Button = findViewById(R.id.btnMenu)
        button.setOnClickListener{
            val intent = Intent(this, InicioActivity::class.java).apply {
                putExtra("nombre", nombre)
            }
            startActivity(intent)
        }
    }
    private fun cuenta(nombre : String){
        val button : Button = findViewById(R.id.btnCuenta)
        button.setOnClickListener{
            val intent = Intent(this, CuentaActivity::class.java).apply {
                putExtra("nombre", nombre)
            }
            startActivity(intent)
        }
    }
}