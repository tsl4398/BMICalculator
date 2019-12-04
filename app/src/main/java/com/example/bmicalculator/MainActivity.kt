package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewProfile = findViewById<ImageView>(R.id.imageViewProfile)

        imageViewProfile.setImageResource(R.drawable.empty)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            calculateBMI(it)
        }

        val buttonReset = findViewById<Button>(R.id.buttonReset)

        buttonReset.setOnClickListener {
            resetButton(it)
        }
    }

    private fun calculateBMI(viewThatIsClicked: View)
    {
        // Get Weight

        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)

        val weight = editTextWeight.text.toString().toDouble()

        // Get Height

        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)

        val height = editTextHeight.text.toString().toDouble() / 100

        // Calculate Height X Height

        var height2 = height * height

        // Calculate Weight / Height

        var bmi = weight / height2

        val textViewTotalBMI = findViewById<TextView>(R.id.textViewTotalBMI)

        textViewTotalBMI.text = String.format("%.1f", bmi)

        // Set Image

        val imageViewProfile = findViewById<ImageView>(R.id.imageViewProfile)

        if (bmi < 18.5)
        {
            imageViewProfile.setImageResource(R.drawable.under)
        }
        else if (bmi > 25)
        {
            imageViewProfile.setImageResource(R.drawable.over)
        }
        else
        {
            imageViewProfile.setImageResource(R.drawable.normal)
        }
    }

    private fun resetButton(viewThatIsClicked: View)
    {
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val textViewTotalBMI = findViewById<TextView>(R.id.textViewTotalBMI)

        editTextWeight.setText("")
        editTextHeight.setText("")
        textViewTotalBMI.setText("")

        val imageViewProfile = findViewById<ImageView>(R.id.imageViewProfile)

        imageViewProfile.setImageResource(R.drawable.empty)
    }
}
