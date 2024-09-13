package com.seplarui.generadorcontrasenyas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var myEditText: EditText
    private lateinit var myButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myEditText = findViewById(R.id.txtGenerarContrasenya)
        myButton = findViewById(R.id.bnGenerarContrasenya)

        myButton.setOnClickListener{
            cambiarTexto(generarLetraAleatoria().toString())
        }
    }

    private fun cambiarTexto(texto:String) {
        myEditText.setText(texto)
    }

    private fun generarLetraAleatoria(): String {
        val letras = ('A'..'Z') + ('a'..'z') +('0'..'9')// Letras mayúsculas y minúsculas
        val numeros = ('0'..'2')
        return (1..numeros.random().code).map { letras.random() }.joinToString("")
    }

}
