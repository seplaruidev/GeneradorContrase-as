package com.seplarui.generadorcontrasenyas

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var myEditText: EditText
    private lateinit var myButton: Button
    private lateinit var bnCopyPaste: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myEditText = findViewById(R.id.txtEdit)
        myButton = findViewById(R.id.btnGenContrasenya)
        bnCopyPaste = findViewById<ImageButton>(R.id.imgCopyContrasenya)

        myButton.setOnClickListener{
            cambiarTexto(generarLetraAleatoria().toString())
        }

        bnCopyPaste.setOnClickListener{
            val textToCopy = myEditText.text.toString();
            copiarPortapapeles(this, textToCopy)
        }

    }

    private fun cambiarTexto(texto:String) {
        myEditText.setText(texto)
    }

    private fun generarLetraAleatoria(): String {
        val letras = ('A'..'Z') + ('a'..'z') +('0'..'9') + listOf(
            '¡', '!', '·', '\\', '@', '€', '#', '~', '$', '%', '&', '/', '(', ')', '=', '\'',
            '?', '¿', '+', '*', '-', '_', ':', ';', '.', ',', '<', '>', '^', '[', ']', '{', '}', '\\', '|'
        )

        val numeros = ('0'..'1')
        return (1..30).map { letras.random() }.joinToString("")
    }

    private fun toastMessage(mensaje:String) {
        //val text = "Contraseña copiada al portapapeles"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this, mensaje, duration) // in Activity
        toast.show()

    }

    private fun copiarPortapapeles(context: Context, texto:String) {
        if (texto.toString() == "") {
            toastMessage("No hay contraseña para copiar")
        } else {
            val clipBoard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", texto)
            clipBoard.setPrimaryClip(clip)
            toastMessage("Contraseña copiada al portapapeles de manera correcta")
        }
    }

}
