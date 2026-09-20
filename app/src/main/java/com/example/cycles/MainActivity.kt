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

            var sum = 0.0
            var fact = 1.0

            for (i in 1..n) {
                fact *= i
                sum += 1.0 / fact
            }

            textResult.text = "Сумма = $sum"
        }
    }
}