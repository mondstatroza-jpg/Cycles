package com.example.cycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit1 = findViewById<EditText>(R.id.edit1)
        val edit2 = findViewById<EditText>(R.id.edit2)
        val buttonOK = findViewById<Button>(R.id.buttonOK)
        val textResult = findViewById<TextView>(R.id.textResult)

        buttonOK.setOnClickListener {
            val x = edit1.text.toString().toDoubleOrNull()
            val n = edit2.text.toString().toIntOrNull()
            if (x == null || n == null || n <= 0) {
                textResult.text = "Введите x и n"
                return@setOnClickListener
            }

            var sum = 0.0
            for (i in 1..n) {
                sum += x / 4.0.pow(i) + x / 5.0.pow(i + 2)
            }

            textResult.text = "Сумма = $sum"
        }
    }
}