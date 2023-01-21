package pl.kul.faraonhrplus.schemas

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.kul.faraonhrplus.entities.Employee

@Database(entities = [Employee::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun employeeDao(): EmployeeDao
}