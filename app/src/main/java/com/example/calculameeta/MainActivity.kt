package com.example.calculameeta

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    val SUMA = "+"
    val RESTA = "-"
    val MULTIPLICACION = "*"
    val DIVISION = "/"
    val PORCENTAJE = "%"

    var operacionActual = ""

    var primerNumero:Double = Double.NaN
    var segundoNumero:Double = Double.NaN

    lateinit var tvTemp: TextView
    lateinit var tvResult:TextView

    lateinit var formatoDecimal:DecimalFormat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        formatoDecimal = DecimalFormat("#.##########")
        tvTemp = findViewById(R.id.tvTemp)
        tvResult = findViewById(R.id.tvResult)
    }

    fun cambiarOperador(b:View){
        val boton:Button = b as Button
        if(boton.text.toString().trim()=="/"){
            operacionActual = "/"
        }else if(boton.text.toString().trim()=="x"){
            operacionActual = "*"
        }else{
            operacionActual = boton.text.toString().trim()
        }
    }

    fun calcular(b: View){
        if(Double.NaN != primerNumero){
            segundoNumero = tvTemp.text.toString().toDouble()
            tvTemp.text=""

            when(operacionActual){
                "+"-> primerNumero =(primerNumero+segundoNumero)
                "-"-> primerNumero =(primerNumero-segundoNumero)
                "*"-> primerNumero =(primerNumero*segundoNumero)
                "/"-> primerNumero =(primerNumero/segundoNumero)
                "%"-> primerNumero =(primerNumero%segundoNumero)
            }
        }else{
            primerNumero = tvTemp.text.toString().toDouble()
        }

    }

    fun seleccionarNumero(b:View){
        val boton:Button = b as Button
        if(tvTemp.text.toString()=="0"){
            tvTemp.text=""
        }
        tvTemp.text= tvTemp.text.toString() + boton.text.toString()
    }

}
