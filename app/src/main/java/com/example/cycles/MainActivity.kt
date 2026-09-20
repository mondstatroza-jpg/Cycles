package com.example.cycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit1 = findViewById<EditText>(R.id.edit1)
        val buttonOK = findViewById<Button>(R.id.buttonOK)
        val textResult = findViewById<TextView>(R.id.textResult)

        buttonOK.setOnClickListener {
            val epsilon = edit1.text.toString().toDoubleOrNull()
            if (epsilon == null || epsilon <= 0) {
                textResult.text = "Введите epsilon (например, 0.0001)"
                return@setOnClickListener
            }

            var sum = 0.0
            var fact = 1.0
            var i = 1
            var lastTerm = 0.0
            var count = 0

            while (true) {
                fact *= i
                lastTerm = 1.0 / fact
                if (abs(lastTerm) < epsilon) break
                sum += lastTerm
                i += 2
                count++
            }

            textResult.text = "Сумма = $sum\nПоследнее слагаемое = $lastTerm\nКоличество повторений = $count"
        }
    }
}