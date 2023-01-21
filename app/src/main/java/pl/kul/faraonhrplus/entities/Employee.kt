package pl.kul.faraonhrplus.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "salary")  val salary : Double,


){
    constructor(firstName: String, lastName: String, email: String, salary: Double) : this(
        0, firstName, lastName, email,salary)
}
