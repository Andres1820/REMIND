package com.example.remind

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TareasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_tareas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val RecyclerView = findViewById<RecyclerView>(R.id.recycleView)
        val adapter = CustomAdapter()
        RecyclerView.layoutManager = LinearLayoutManager(this)
        RecyclerView.adapter = adapter
        val nombre = intent.getStringExtra("nombre")
        val proyecto = intent.getStringExtra("proyecto")
        cargarParametros(proyecto.toString())
        //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        salir(nombre.toString(), proyecto.toString())
        inicio(nombre.toString(), proyecto.toString())
        notificaciones(nombre.toString(), proyecto.toString())
        cuenta(nombre.toString(), proyecto.toString())
    }
    private fun cargarParametros(proyecto : String) {
        val myTextView = findViewById<TextView>(R.id.titulo)
        myTextView.text = proyecto
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
    private fun notificaciones(nombre: String, proyecto: String){
        val button : Button = findViewById(R.id.btnNotificaciones)
        button.setOnClickListener{
            val intent = Intent(this, NotificacionesActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", proyecto)
            }
            startActivity(intent)
        }
    }
    private fun cuenta(nombre: String, proyecto: String){
        val button : Button = findViewById(R.id.btnCuenta)
        button.setOnClickListener{
            val intent = Intent(this, CuentaActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", proyecto)
            }
            startActivity(intent)
        }
    }
}