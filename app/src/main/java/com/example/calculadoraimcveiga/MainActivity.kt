package com.example.calculadoraimcveiga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
                if(stringPeso == "" || stringAltura == ""){
                    Toast.makeText(this, "ERRO! PESO OU ALTURA VAZIA!", Toast.LENGTH_SHORT).show()
                }
                else {
                    val intent = Intent(this, ResultadoActivity::class.java)
                    intent.putExtra("message_key", stringPeso)
                    intent.putExtra("message_key1", stringAltura)
                    startActivity(intent)
                }
            }
    }
}