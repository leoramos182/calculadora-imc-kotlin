package com.example.calculadoraimcveiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class HistoricoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        val buttonVoltar = findViewById<Button>(R.id.voltar_button)
        buttonVoltar.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
    }
    
}