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
        val buttonOK = findViewById<Button>(R.id.buttonOK)
        val textResult = findViewById<TextView>(R.id.textResult)

        buttonOK.setOnClickListener {
            val x = edit1.text.toString().toDoubleOrNull()
            if (x == null) {
                textResult.text = "Введите число x"
                return@setOnClickListener
            }

            var numerator = 1.0
            var denominator = 1.0

            // В задании 2, 4, 8, 16, 32, 64, 128 -> 7 множителей
            for (i in 1..7) {
                val powerOfTwo = 2.0.pow(i)
                numerator *= (x - powerOfTwo)
                denominator *= (x - (powerOfTwo - 1))
            }

            val result = numerator / denominator
            textResult.text = "Результат = $result"
        }
    }
}