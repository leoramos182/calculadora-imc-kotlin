package com.example.calculadoraimcveiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalcular = findViewById<Button>(R.id.calcular_button)
        val sendTextPeso = findViewById<EditText>(R.id.edit_text_peso)
        val sendTextAltura = findViewById<EditText>(R.id.edit_text_altura)
        //CLICK LISTENER PARA ENVIAR OS DADOS DA MAIN ACTIVITY PARA A RESULTADO ACTIVITY
        buttonCalcular.setOnClickListener {
            val stringPeso = sendTextPeso.text.toString()
            val stringAltura = sendTextAltura.text.toString()
            //INTENT PARA TROCAR DE ACTIVITY E ENVIAR OS DADOS
            val intent = Intent(this,ResultadoActivity::class.java)
            intent.putExtra("message_key",stringPeso)
            intent.putExtra("message_key1", stringAltura)
            //INICIA A NOVA ACTIVITY
            startActivity(intent)
        }

    }
}