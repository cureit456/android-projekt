package pl.kul.faraonhrplus.schemas


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pl.kul.faraonhrplus.entities.Employee

@Dao
interface  EmployeeDao {
    @Query("SELECT * FROM employee")
    fun getAll(): List<Employee>

    @Insert
    fun insertAll(vararg employees: Employee)

    @Delete
    fun delete(user: Employee)
}