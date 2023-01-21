package pl.kul.faraonhrplus

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import pl.kul.faraonhrplus.entities.Employee
import pl.kul.faraonhrplus.schemas.AppDatabase

class WorkerListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_list)

        val dataBase = Room.databaseBuilder(applicationContext,
            AppDatabase::class.java,"f-database").allowMainThreadQueries()
            .build()



        val arrayAdapter: ArrayAdapter<*>
        val list = dataBase.employeeDao().getAll()
        // access the listView from xml file
        val viewlist : ListView =  findViewById (R.id.workersListView)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, list
        )
        viewlist.adapter = arrayAdapter

        viewlist.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as Employee

            val intent = Intent(this, WorkerInfoActivity::class.java)
            intent.putExtra("first_name",selectedItem.firstName)
            intent.putExtra("last_name",selectedItem.lastName)
            intent.putExtra("email",selectedItem.email)
            intent.putExtra("salary",selectedItem.salary.toString())
            startActivity(intent)
        }
    }

}
