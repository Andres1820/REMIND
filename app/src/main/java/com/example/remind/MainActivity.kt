package com.example.remind

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.LayoutInflater
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ingresar()
        registrarse()
    }
    private fun ingresar()
    {
        val button: Button = findViewById(R.id.btnIngresar)
        button.setOnClickListener{
            showDialogIngresar()
        }
    }
    private fun registrarse()
    {
        val button: Button = findViewById(R.id.btnRegistrarse)
        button.setOnClickListener{
            showDialogRegistrarse()
        }
    }
    private fun showDialogIngresar() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_ingresar)

        val dialogEditTextCorreo = dialog.findViewById<EditText>(R.id.correo)
        val dialogEditTextContraseña = dialog.findViewById<EditText>(R.id.contraseña)
        val dialogButtonIngresar = dialog.findViewById<Button>(R.id.btnIngresar)
        val dialogButtonCerrar = dialog.findViewById<Button>(R.id.btnCerrar)

        dialogButtonIngresar.setOnClickListener {
            dialogButtonIngresar.setOnClickListener{
                val inputText = dialogEditTextCorreo.text.toString()
                if(dialogEditTextCorreo.text.toString() == "adgonzalez" && dialogEditTextContraseña.text.toString() == "12345678") {
                    val intent = Intent(this, InicioActivity::class.java).apply {
                        putExtra("nombre", "Andrés González")
                    }
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
        dialogButtonCerrar.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showDialogRegistrarse() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_registrarse)

        val dialogEditTextNombre = dialog.findViewById<EditText>(R.id.nombre)
        val dialogEditTextCorreo = dialog.findViewById<EditText>(R.id.correo)
        val dialogEditTextContraseña = dialog.findViewById<EditText>(R.id.contraseña)
        val dialogButtonRegistrarse = dialog.findViewById<Button>(R.id.btnRegistrarse)
        val dialogButtonCerrar = dialog.findViewById<Button>(R.id.btnCerrar)

        dialogButtonRegistrarse.setOnClickListener {
            val inputText = dialogEditTextNombre.text.toString()
            dialogButtonRegistrarse.setOnClickListener{
                val intent = Intent(this, InicioActivity::class.java).apply {
                    putExtra("nombre", dialogEditTextNombre.text.toString())
                }
                startActivity(intent)
            }
        }
        dialogButtonCerrar.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    /**
     //Función de ingresar antes de configurar el customDialog
    private fun ingresar(){
        val button :Button = findViewById(R.id.btnIngresar)
        button.setOnClickListener{
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }
    }
    //Función de ingresar antes de configurar el customDialog
    private fun registrarse(){
        val button :Button = findViewById(R.id.btnRegistrarse)
        button.setOnClickListener{
            Toast.makeText(this, "Dialogo de registro", Toast.LENGTH_SHORT).show()
        }
    }
    **/
}