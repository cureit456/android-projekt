package pl.kul.faraonhrplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import pl.kul.faraonhrplus.utils.SalaryCalulator

class SalaryCalulatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salary_calulator)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        val bruttoEditText : EditText = findViewById(R.id.salaryBruttoEditText)
        val nettoViewText : TextView = findViewById(R.id.nettoTextView)

        calculateButton.setOnClickListener {
            val sC = SalaryCalulator(bruttoEditText.text.toString().toDouble())
            nettoViewText.text = sC.getNetto().toString()
            goodLuckWithYouSalaryToast()
        }
    }
    private fun goodLuckWithYouSalaryToast(){
        val myToast = Toast.makeText(applicationContext,R.string.netto_result_cheer , Toast.LENGTH_LONG)
        myToast.show()
    }

}