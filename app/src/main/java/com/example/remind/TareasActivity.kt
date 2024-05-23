package com.example.remind

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
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
        //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()

        //tareaUno()
        //tareaDos()
        //tareaTres()
        salir(nombre.toString())
        inicio(nombre.toString())
        notificaciones(nombre.toString())
        cuenta(nombre.toString())
    }

    //metodos para selecionar una tarea
    /**
    private fun tareaUno(){
        val button :Button = findViewById(R.id.btnTarea1)
        button.setOnClickListener {
            Toast.makeText(this, "Tarea 1 selecionada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun tareaDos(){
        val button :Button = findViewById(R.id.btnTarea2)
        button.setOnClickListener {
            Toast.makeText(this, "Tarea 2 selecionada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun tareaTres(){
        val button :Button = findViewById(R.id.btnTarea3)
        button.setOnClickListener {
            Toast.makeText(this, "Tarea 3 selecionada", Toast.LENGTH_SHORT).show()
        }
    }
    **/
    //cierre de metodos para selecionar una tarea
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
    private fun notificaciones(nombre: String){
        val button : Button = findViewById(R.id.btnNotificaciones)
        button.setOnClickListener{
            val intent = Intent(this, NotificacionesActivity::class.java).apply {
                putExtra("nombre", nombre)
            }
            startActivity(intent)
        }
    }
    private fun cuenta(nombre: String){
        val button : Button = findViewById(R.id.btnCuenta)
        button.setOnClickListener{
            val intent = Intent(this, CuentaActivity::class.java).apply {
                putExtra("nombre", nombre)
            }
            startActivity(intent)
        }
    }
}