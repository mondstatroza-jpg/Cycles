package com.example.cycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs
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
            val epsilon = edit2.text.toString().toDoubleOrNull()
            if (x == null || epsilon == null || epsilon <= 0) {
                textResult.text = "Введите x и epsilon (например, 2 и 0.0001)"
                return@setOnClickListener
            }

            var sum = 0.0
            var i = 1
            var sign = 1.0
            var lastTerm = 0.0
            var count = 0

            while (true) {
                val power = 2 * i - 1
                lastTerm = sign * 1.0 / (power * x.pow(power))
                if (abs(lastTerm) < epsilon) break
                sum += lastTerm
                sign = -sign
                i++
                count++
            }

            textResult.text = "Сумма = $sum\nПоследнее слагаемое = $lastTerm\nКоличество повторений = $count"
        }
    }
}