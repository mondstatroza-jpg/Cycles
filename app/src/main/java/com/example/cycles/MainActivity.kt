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
        val buttonOK = findViewById<Button>(R.id.buttonOK)
        val textResult = findViewById<TextView>(R.id.textResult)

        buttonOK.setOnClickListener {
            val n = edit1.text.toString().toIntOrNull()
            if (n == null || n <= 0) {
                textResult.text = "Введите натуральное число n"
                return@setOnClickListener
            }

            var fact = 1.0
            for (i in 1..n) {
                fact *= i
            }

            var k = 1.0
            var found = false
            while (k * (k + 1) * (k + 2) <= fact) {
                if (k * (k + 1) * (k + 2) == fact) {
                    found = true
                    break
                }
                k++
            }

            if (found) {
                textResult.text = "$n! = ${k.toInt()} * ${(k + 1).toInt()} * ${(k + 2).toInt()}"
            } else {
                textResult.text = "$n! нельзя представить в виде произведения трех последовательных чисел"
            }
        }
    }
}