package pl.kul.faraonhrplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.bindHandlers()

    }
    private  fun bindHandlers(){
        val showWorkersButton: Button = findViewById(R.id.showWorkersButton)
        val showCalendarButton: Button = findViewById((R.id.showCalendarButton))
        val addEmployeeButton: Button = findViewById((R.id.addEmployeeMainButton))

        showWorkersButton.setOnClickListener {
            val intent = Intent(this@MainActivity, WorkerListActivity::class.java)
            startActivity(intent)
        }

        showCalendarButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CalendarActivity::class.java)
            startActivity(intent)
        }

        addEmployeeButton.setOnClickListener {
            val intent = Intent(this@MainActivity,AddWorkerActivity::class.java)
            startActivity(intent)
        }
    }
}