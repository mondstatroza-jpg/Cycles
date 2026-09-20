package com.example.cycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit1 = findViewById<EditText>(R.id.edit1)
        val edit2 = findViewById<EditText>(R.id.edit2)
        val buttonOK = findViewById<Button>(R.id.buttonOK)
        val textResult = findViewById<TextView>(R.id.textResult)

        buttonOK.setOnClickListener {
            val a = edit1.text.toString().toDoubleOrNull()
            val n = edit2.text.toString().toIntOrNull()
            if (a == null || n == null || n <= 0) {
                textResult.text = "Введите a и n"
                return@setOnClickListener
            }

            var sum = 0.0
            var product = 1.0

            for (i in 1..n) {
                product *= (a + i - 1)
                sum += 1.0 / product
            }

            textResult.text = "Сумма = $sum"
        }
    }
}