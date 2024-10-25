package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

        val (classificacao, color) = when {
            resultado < 18.5f -> "MAGREZA" to R.color.red
            resultado > 18.5f && resultado <= 24.9 -> "NORMAL" to R.color.green
            resultado > 25.0f && resultado <= 29.9 -> "SOBREPESO" to R.color.yellow
            resultado > 30.0f && resultado <= 39.9f -> "OBESIDADE" to R.color.orange
            else -> "OBESIDADE GRAVE" to R.color.red

        }
        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(ContextCompat.getColor(this, color))

    }
}