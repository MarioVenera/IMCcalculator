package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
 const val  Key_Resultado_IMC = "ResultActivity.Key_IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultado = intent.getFloatExtra(Key_Resultado_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = resultado.toString()

        var clasificacao: String? = null

        if(resultado <=18.5f){
            clasificacao = "MAGREZA"
        } else if(resultado >18.5f && resultado <=24.9f){
            clasificacao = "NORMAL"
        } else if(resultado >25f && resultado <=9.9f){
            clasificacao = "SOBREPESO"
        } else if(resultado >30f && resultado <=39.9f){
            clasificacao = "OBESIDADE"
        } else{
            clasificacao = "OBESIDADE GRAVE"
        }

        tvClassificacao.text = clasificacao

    }
}