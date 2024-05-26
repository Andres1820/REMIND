package com.example.remind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CuentaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cuenta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Se reciben y posteriormente se cargan los parametros de la activity anterior
        val nombre = intent.getStringExtra("nombre")
        val proyecto = intent.getStringExtra("proyecto")
        //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        cargarParametros(nombre.toString())
        misTarea(nombre.toString(), proyecto.toString())
        salir(nombre.toString(), proyecto.toString())
        inicio(nombre.toString(), proyecto.toString())
        cerrarSesion(nombre.toString(), proyecto.toString())
    }

    private fun misTarea(nombre: String, proyecto: String) {
        val button : Button = findViewById(R.id.btnMTareas)
        button.setOnClickListener{
            val intent = Intent(this, TareasActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", proyecto)
            }
            startActivity(intent)
        }
    }

    private fun cargarParametros(nombre : String) {
        val myTextView = findViewById<TextView>(R.id.Txtnombre)
        myTextView.text = nombre
    }

    private fun salir (nombre: String, proyecto: String){
        val button : Button = findViewById(R.id.btnVolver)
        button.setOnClickListener{
            val intent = Intent(this, InicioActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", proyecto)
            }
            startActivity(intent)
        }
    }
    private fun inicio (nombre: String, proyecto: String){
        val button : Button = findViewById(R.id.btnMenu)
        button.setOnClickListener{
            val intent = Intent(this, InicioActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", proyecto)
            }
            startActivity(intent)
        }
    }
    private fun cerrarSesion (nombre: String, proyecto: String){
        val button : Button = findViewById(R.id.btnCerrarSesion)
        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", proyecto)
            }
            startActivity(intent)
        }
    }
}