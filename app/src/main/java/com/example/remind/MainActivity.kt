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

    var usuarios = arrayOf(
        arrayOf("adgonzalez", "12345", "Andrés Gonzalez"),
        arrayOf("Chayanne", "contrasena", "Chayanne"),
        arrayOf("David", "12345678", "David Murcia"),
        arrayOf("consulta", "consulta", "Consulta")
    )

    var nombre: String = ""

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
                //if(dialogEditTextCorreo.text.toString() == usuario["correo"] && dialogEditTextContraseña.text.toString() == usuario["contraseña"]) {
                if(validarCredenciales(dialogEditTextCorreo.text.toString(), dialogEditTextContraseña.text.toString())){
                    val intent = Intent(this, InicioActivity::class.java).apply {
                        putExtra("nombre", nombre)
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
    //Función generada para validar que el usuario se encuentre registardo
    fun validarCredenciales(correo: String, contraseña: String): Boolean {
        for (credenciales in usuarios) {
            val nombreUsuario = credenciales[0]
            val password = credenciales[1]
            nombre = credenciales[2]
            if (correo == nombreUsuario && contraseña == password) {
                return true
            }
        }
        return false
    }
    private fun showDialogRegistrarse() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_registrarse)

        val dialogEditTextNombre = dialog.findViewById<EditText>(R.id.nombre)
        val dialogEditTextCorreo = dialog.findViewById<EditText>(R.id.correo)
        //val dialogEditTextContraseña = dialog.findViewById<EditText>(R.id.contraseña)
        val dialogButtonRegistrarse = dialog.findViewById<Button>(R.id.btnRegistrarse)
        val dialogButtonCerrar = dialog.findViewById<Button>(R.id.btnCerrar)
        dialogButtonRegistrarse.setOnClickListener {
            if (!usuarioExiste(dialogEditTextCorreo.text.toString())) {
                val intent = Intent(this, InicioActivity::class.java).apply {
                    putExtra("nombre", dialogEditTextNombre.text.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "El Usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show()
            }
        }
        dialogButtonCerrar.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun usuarioExiste(correo: String): Boolean{
        for (credenciales in usuarios) {
            val nombreUsuario = credenciales[0]
            nombre = credenciales[2]
            if (correo == nombreUsuario){
                return true
            }
        }
        return false
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
