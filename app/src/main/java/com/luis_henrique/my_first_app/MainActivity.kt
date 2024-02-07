package com.luis_henrique.my_first_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editDistance: EditText
    private lateinit var editPrice: EditText
    private lateinit var editAutonomy: EditText
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculando os componentes de UI
        editDistance = findViewById(R.id.edit_distance)
        editPrice = findViewById(R.id.edit_price)
        editAutonomy = findViewById(R.id.edit_autonomy)
        textResult = findViewById(R.id.text_result)

        val buttonCalculator: Button = findViewById(R.id.button_calculator)
        buttonCalculator.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val distance = editDistance.text.toString().toFloatOrNull() ?: 0f
        val price = editPrice.text.toString().toFloatOrNull() ?: 0f
        val autonomy = editAutonomy.text.toString().toFloatOrNull() ?: 0f

        val result = (distance / autonomy) * price

        textResult.text = getString(R.string.text_result, result)
    }
}
