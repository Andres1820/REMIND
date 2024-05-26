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
        val proyecto = intent.getStringExtra("proyecto")
        /**
        //Prueba de recepción correcta de parametros entre activity's
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        **/
        proyectoUno(nombre.toString())
        proyectoDos(nombre.toString())
        proyectoTres(nombre.toString())
        MisTareas()
        //nuevoProyecto(nombre.toString())
        notificaciones(nombre.toString(), proyecto.toString())
        cuenta(nombre.toString(), proyecto.toString())
    }
    //metodos para selecionar un proyecto
    private fun proyectoUno(nombre: String){
        val button :Button = findViewById(R.id.btnProyecto1)
        button.setOnClickListener {
            val intent = Intent(this, TareasActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", "Proyecto 1")
            }
            startActivity(intent)
        }
    }

    private fun proyectoDos(nombre: String){
        val button :Button = findViewById(R.id.btnProyecto2)
        button.setOnClickListener {
            val intent = Intent(this, TareasActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", "Proyecto 2")
            }
            startActivity(intent)
        }
    }

    private fun proyectoTres(nombre: String){
        val button :Button = findViewById(R.id.btnProyecto3)
        button.setOnClickListener {
            val intent = Intent(this, TareasActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("proyecto", "Proyecto 3")
            }
            startActivity(intent)
        }
    }

    //cierre de metodos para selecionar un proyecto
    private fun MisTareas() {
        val button: Button = findViewById(R.id.btnMTareas)
        button.setOnClickListener {
            Toast.makeText(this, "Por favor selecciona un proyecto", Toast.LENGTH_SHORT).show()
        }
    }
    //La activity no funciona y genera que la aplicación se cierre
    /**
    private fun showDialogSelProyecto(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_sel_proyecto)

        val dialogEditTextTitulo = dialog.findViewById<EditText>(R.id.Titulo)
        val dialogButtonCerrar = dialog.findViewById<Button>(R.id.btnCerrar)
        val dialogButtonProyecto1 = dialog.findViewById<Button>(R.id.btnProyecto1)
        val dialogButtonProyecto2 = dialog.findViewById<Button>(R.id.btnProyecto2)
        val dialogButtonProyecto3 = dialog.findViewById<Button>(R.id.btnProyecto3)

        dialogButtonProyecto1.setOnClickListener {
            dialogButtonProyecto1.setOnClickListener{
                val intent = Intent(this, InicioActivity::class.java)
                startActivity(intent)
            }
        }
        dialogButtonCerrar.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
    **/
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