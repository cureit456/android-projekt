package pl.kul.faraonhrplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import pl.kul.faraonhrplus.entities.Employee
import pl.kul.faraonhrplus.schemas.AppDatabase
import java.util.*

class AddWorkerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_worker)

        val editTextTextPersonName : EditText = findViewById((R.id.editTextTextPersonName))
        val editTextTextSurrname : EditText = findViewById((R.id.editTextTextSurrname))
        val editTextTextSalary : EditText = findViewById((R.id.editTextTextSalary))
        val editTextTextEmailAddress : EditText = findViewById((R.id.editTextTextEmailAddress))



        val addEmployeeButton: Button = findViewById((R.id.addEmployeeButton))

        addEmployeeButton.setOnClickListener {
            val dataBase = Room.databaseBuilder(applicationContext,
                AppDatabase::class.java,"f-database").allowMainThreadQueries()
                .build()

            val employee = Employee(
                editTextTextPersonName.text.toString(),
                editTextTextSurrname.text.toString(),
                editTextTextEmailAddress.text.toString(),
                editTextTextSalary.text.toString().toDouble()
                )

            dataBase.employeeDao().insertAll(employee)
            showToastInfo(editTextTextPersonName.text.toString(), editTextTextSurrname.text.toString())
            val intent = Intent(this@AddWorkerActivity, WorkerListActivity::class.java)
            startActivity(intent)
        }

    }
    private fun showToastInfo(firstName : String, lastName :String){
        val myToast = Toast.makeText(applicationContext,"Pomyślnie dodano pracownika o imieniu $firstName $lastName",Toast.LENGTH_LONG)
        myToast.show()
    }

}