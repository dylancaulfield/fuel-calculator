package ie.dylancaulfield.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val distanceInput = findViewById<TextInputEditText>(R.id.distanceInput)
        val fuelUsageInput = findViewById<TextInputEditText>(R.id.fuelUsageInput)
        val fuelPriceInput = findViewById<TextInputEditText>(R.id.fuelPriceInput)
        val numPassengersInput = findViewById<TextInputEditText>(R.id.numPassengersInput)
        val taxiRateSwitch = findViewById<SwitchMaterial>(R.id.chargeExtraSwitch)
        val calculateButton = findViewById<MaterialButton>(R.id.calculateButton)

        calculateButton.setOnClickListener {

            val distance = distanceInput.text.toString().toDouble()
            val fuelUsage = fuelUsageInput.text.toString().toDouble()
            val fuelPrice = fuelPriceInput.text.toString().toDouble()
            val numPassengers = numPassengersInput.text.toString().toDouble()
            val shouldAddTaxiRate = taxiRateSwitch.isChecked


            var price: Double = (fuelUsage / 100.0) * distance * fuelPrice / numPassengers

            if (shouldAddTaxiRate)
                price *= 1.5

            val message = String.format("Cost: €%.2f", price)

            Snackbar.make(calculateButton, message, Snackbar.LENGTH_INDEFINITE).show()

        }

    }
}
