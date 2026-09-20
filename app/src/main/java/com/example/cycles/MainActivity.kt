package com.example.cycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs
import com.example.cycles.R
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
                textResult.text = "Введите положительное число (например, 0.0001)"
                return@setOnClickListener
            }

            var sum = 0.0
            var i = 1
            var lastTerm = 0.0
            var count = 0

            while (true) {
                lastTerm = 1.0 / (i * i)
                if (abs(lastTerm) < epsilon) break
                sum += lastTerm
                i++
                count++
            }

            textResult.text = "Сумма = $sum\nПоследнее слагаемое = $lastTerm\nКоличество повторений = $count"
        }
    }
}