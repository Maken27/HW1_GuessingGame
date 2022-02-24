package com.example.hw1_guessinggame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    var numeroAleatorio = 1

    override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rango: SeekBar = findViewById(R.id.barraRango)
        val valorRango: TextView = findViewById(R.id.txsRango)
        rango.progress = 1
        valorRango.text = "" + rango.progress
        rango.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    valorRango.text = "" + progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    val aleatorio = Random()
                    //Toast.makeText( MainActivity.this, "" + aleatorio.nextInt(seekBar.getProgress()+1), Toast.LENGTH_SHORT).show();)
                    numeroAleatorio = aleatorio.nextInt(seekBar.progress + 1)
                }
            }
        )
    }

    fun analizar(v: View?) {
        val analizar: EditText = findViewById(R.id.TextNumber)
        val numeroAnalizar = analizar.text.toString().toInt()

        if (numeroAnalizar > numeroAleatorio) {
            Toast.makeText(this, "El número es superior al número oculto ", Toast.LENGTH_SHORT)
                .show()
        }
        if (numeroAnalizar < numeroAleatorio) {
            Toast.makeText(this, "El número es inferior al número oculto ", Toast.LENGTH_SHORT)
                .show()
        }
        if (numeroAnalizar == numeroAleatorio) {
            Toast.makeText(
                this,
                "Felicidades, descubriste el número oculto",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}