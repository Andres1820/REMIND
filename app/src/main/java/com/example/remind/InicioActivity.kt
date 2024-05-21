package com.example.remind

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nombre = intent.getStringExtra("nombre")
        /**
        //Prueba de recepción correcta de parametros entre activity's
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        **/
        proyectoUno()
        proyectoDos()
        proyectoTres()
        Alerta()
        //nuevoProyecto(nombre.toString())
        notificaciones(nombre.toString())
        cuenta(nombre.toString())
    }
    //metodos para selecionar un proyecto
    private fun proyectoUno(){
        val button :Button = findViewById(R.id.btnProyecto1)
        button.setOnClickListener {
            Toast.makeText(this, "Proyecto 1 selecionado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun proyectoDos(){
        val button :Button = findViewById(R.id.btnProyecto2)
        button.setOnClickListener {
            Toast.makeText(this, "Proyecto 2 selecionado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun proyectoTres(){
        val button :Button = findViewById(R.id.btnProyecto3)
        button.setOnClickListener {
            Toast.makeText(this, "Proyecto 3 selecionado", Toast.LENGTH_SHORT).show()
        }
    }
    //cierre de metodos para selecionar un proyecto
    private fun Alerta() {
        val button: Button = findViewById(R.id.btnMTareas)
        button.setOnClickListener {
            Toast.makeText(this, "Debes seleccionar un proyecto", Toast.LENGTH_SHORT).show()
        }
    }
    //La activity no funciona y genera que la aplicación se cierre
    /**
    private fun nuevoProyecto(nombre : String) {
        val button :Button = findViewById(R.id.btnNProyecto)
        button.setOnClickListener{
            val intent = Intent(this, NuevoProyectoActivity::class.java)
            startActivity(intent)
        }
    }
    **/
    private fun notificaciones(nombre : String){
        val button : Button = findViewById(R.id.btnNotificaciones)
        button.setOnClickListener{
            val intent = Intent(this, NotificacionesActivity::class.java).apply {
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