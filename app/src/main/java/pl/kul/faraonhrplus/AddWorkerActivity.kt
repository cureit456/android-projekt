package pl.kul.faraonhrplus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import pl.kul.faraonhrplus.entities.Employee
import pl.kul.faraonhrplus.schemas.AppDatabase
import pl.kul.faraonhrplus.utils.EmployeeDataValidator


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

            val validator : EmployeeDataValidator = EmployeeDataValidator(
                editTextTextPersonName.text.toString(),
                editTextTextSurrname.text.toString(),
                editTextTextEmailAddress.text.toString(),
                editTextTextSalary.text.toString())

            if(validator.isEmployeeValid()){
                val employee = Employee(
                    editTextTextPersonName.text.toString(),
                    editTextTextSurrname.text.toString(),
                    editTextTextEmailAddress.text.toString(),
                    editTextTextSalary.text.toString().toDouble()
                )
                dataBase.employeeDao().insertAll(employee)
                employeeCorrectAddedToast(editTextTextPersonName.text.toString(), editTextTextSurrname.text.toString())
                val intent = Intent(this@AddWorkerActivity, WorkerListActivity::class.java)
                startActivity(intent)
            }else{
                employeeFailAddedToast()
            }

        }

    }
    private fun employeeCorrectAddedToast(firstName : String, lastName :String){
        val myToast = Toast.makeText(applicationContext, "${R.string.toast_employee_success}  $firstName $lastName",Toast.LENGTH_LONG)
        myToast.show()
    }
    private fun employeeFailAddedToast(){
        val myToast = Toast.makeText(applicationContext,R.string.toast_employee_fail  ,Toast.LENGTH_LONG)
        myToast.show()
    }

}