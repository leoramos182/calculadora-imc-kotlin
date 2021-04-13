package com.example.calculadoraimcveiga

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val receiverPeso = findViewById<TextView>(R.id.text_view_peso)
        val receiverAltura = findViewById<TextView>(R.id.text_view_altura)

        val intent : Intent = intent

        val stringPeso = intent.getStringExtra("message_key")
        val stringAltura = intent.getStringExtra("message_key1")

        receiverPeso.text = "Peso: $stringPeso"
        receiverAltura.text = "Altura: $stringAltura"

        calcularImc(stringPeso,stringAltura)
        calcularGrau(stringPeso!!.toFloat() / (stringAltura!!.toFloat() * stringAltura.toFloat()))

        val buttonVoltar = findViewById<Button>(R.id.voltar_button)
        buttonVoltar.setOnClickListener {
            finish()
        }
    }
    @SuppressLint("SetTextI18n")
    private fun calcularImc(peso : String?, altura : String?){
        val pesoImc = peso?.toFloatOrNull()
        val alturaImc = altura?.toFloatOrNull()
        if(peso != null && altura != null){
            val imc = pesoImc!! / (alturaImc!! * alturaImc)
            text_view_imc.text = "IMC: %.2f".format(imc)
        }
    }
    @SuppressLint("SetTextI18n")
    private fun calcularGrau(imc : Float){

        if(imc < 18.5){
            text_view_grau_imc.text = "Magreza"
            text_view_grau_imc.setTextColor(resources.getColor(R.color.magreza))
        }
        else if(imc >= 18.5 && imc < 24.9 ){
            text_view_grau_imc.text = "Normal"
            text_view_grau_imc.setTextColor(resources.getColor(R.color.normal))
        }else if(imc >= 24.9 && imc < 30){
            text_view_grau_imc.text = "Sobrepeso"
            text_view_grau_imc.setTextColor(resources.getColor(R.color.sobrepeso))
        }
        else if(imc >= 30){
            text_view_grau_imc.text = "Obesidade"
            text_view_grau_imc.setTextColor(resources.getColor(R.color.obesidade))
        }
    }
}