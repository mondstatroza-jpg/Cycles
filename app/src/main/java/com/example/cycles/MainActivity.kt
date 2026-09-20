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
            val a = edit1.text.toString().toDoubleOrNull()
            if (a == null) {
                textResult.text = "Введите число a"
                return@setOnClickListener
            }

            if (a > 7) {
                textResult.text = "При a > 7 результат не может быть получен"
                return@setOnClickListener
            }

            var sum = 1.0
            var i = 2
            while (sum <= a) {
                sum += 1.0 / i
                i++
            }

            textResult.text = "Первое число, большее $a = $sum"
        }
    }
}