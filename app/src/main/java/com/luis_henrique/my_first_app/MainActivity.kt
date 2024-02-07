package com.luis_henrique.my_first_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.luis_henrique.my_first_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculator.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            if (view.id == R.id.button_calculator) {
                calculate()
            }
        }
    }

    private fun calculate() {
        // Recuperar os valores inseridos nos campos de entrada
        val distanceText = findViewById<EditText>(R.id.edit_distance).text.toString()
        val priceText = findViewById<EditText>(R.id.edit_price).text.toString()
        val autonomyText = findViewById<EditText>(R.id.edit_autonomy).text.toString()

        // Verificar se os campos não estão vazios
        if (distanceText.isEmpty() || priceText.isEmpty() || autonomyText.isEmpty()) {
            Toast.makeText(this, R.string.check_fields, Toast.LENGTH_SHORT).show()
            return
        }

        if (distanceText.isEmpty() || priceText.isEmpty() || autonomyText.isEmpty()) {
            Toast.makeText(this, R.string.check_fields, Toast.LENGTH_SHORT).show()
            // Limpar o campo de resultado
            findViewById<TextView>(R.id.text_result).text = ""
            return
        }

        // Verificar se os campos estão vazios e, se sim, definir seus valores como zero
        val distance = if (distanceText.isEmpty()) 0f else distanceText.toFloat()
        val price = if (priceText.isEmpty()) 0f else priceText.toFloat()
        val autonomy = if (autonomyText.isEmpty()) 0f else autonomyText.toFloat()
        if (autonomy == 0f) {
            Toast.makeText(this, R.string.not_division_zero, Toast.LENGTH_SHORT).show()
        }

        // Calcular o preço
        val totalCost = (distance * price) / autonomy

        // Exibir o resultado
        val resultTextView = findViewById<TextView>(R.id.text_result)
        resultTextView.text = String.format("R$ %.2f", totalCost)
    }


}

