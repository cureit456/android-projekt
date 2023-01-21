package pl.kul.faraonhrplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WorkerInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_info)

        val firstNameTextView: TextView = findViewById(R.id.firstNameTextView)
        firstNameTextView.text = intent.getStringExtra("first_name")

        val lastNameTextView: TextView = findViewById(R.id.surrnameTextView)
        lastNameTextView.text = intent.getStringExtra("last_name")

        val emailTextView: TextView = findViewById(R.id.emailTextView)
        emailTextView.text = intent.getStringExtra("email")

        val salryTextView: TextView = findViewById(R.id.salaryTextView)
        salryTextView.text = intent.getStringExtra("salary")
    }
}