package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectobase.utils.*
class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val numeroUno: EditText = findViewById(R.id.ed_opUno)
        val numeroDos: EditText = findViewById(R.id.ed_opDos)
        val txResultado: TextView = findViewById(R.id.tx_resultado_act4)
        val btnCalcular: Button = findViewById(R.id.btn_calcular)
        val spOperaciones : Spinner = findViewById(R.id.sp_operaciones)

        //creacion del primer array
        val menuSPoperaciones = listOf("Sumar", "Restar", "Multiplicar", "Dividir")

        //vamos a completar el spinner de operaciones
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            menuSPoperaciones
        )

        spOperaciones.adapter = adapter

        btnCalcular.setOnClickListener {
            var calcN1: Int = numeroUno.text.toString().toIntOrNull() ?: 0
            var calcN2: Int = numeroDos.text.toString().toIntOrNull() ?: 0

            if(spOperaciones.selectedItem =="Sumar"){
                var resultadoOP: Int = OpMatematicas.sumar(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()

            }else if(spOperaciones.selectedItem =="Restar"){
                var resultadoOP: Int = OpMatematicas.restar(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()

            }else if(spOperaciones.selectedItem =="Multiplicar"){
                var resultadoOP: Int = OpMatematicas.multiplicar(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()
            }else if(spOperaciones.selectedItem =="Dividir"){
                var resultadoOP: Int = OpMatematicas.dividir(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()
            }else{
                null
            }



        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}