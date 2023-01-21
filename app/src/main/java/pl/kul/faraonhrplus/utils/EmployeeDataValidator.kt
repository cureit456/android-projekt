package pl.kul.faraonhrplus.utils

import android.text.TextUtils
import android.util.Patterns
import pl.kul.faraonhrplus.entities.Employee

class EmployeeDataValidator(private val firstName:String,
                            private val lastName:String,
                            private val email:String,
                            private val salary:String) {

    private fun isValidEmail(): Boolean {
        return if (TextUtils.isEmpty(email)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }
    private fun isSalaryValid() : Boolean {
        if (TextUtils.isEmpty(salary)) {
            return false
        } else {
            var numeric: Boolean
            numeric = salary.matches("\\d+(\\.\\d+)?".toRegex())
            return numeric
        }
    }
    private fun isfirstNameValid() : Boolean {
            return !TextUtils.isEmpty(firstName)
    }
    private fun isSecondNameValid() : Boolean {
        return !TextUtils.isEmpty(lastName)
    }
    fun isEmployeeValid():Boolean{
        return isValidEmail() && isfirstNameValid() && isSecondNameValid() && isSalaryValid()
    }
}