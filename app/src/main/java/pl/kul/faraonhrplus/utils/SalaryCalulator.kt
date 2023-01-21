package pl.kul.faraonhrplus.utils

class SalaryCalulator(private val salary:Double) {

    fun getPensionInsurance(): Double {
        return salary *  0.0976;
    }
    fun getDisabilityInsurance(): Double {
        return salary *  0.015;
    }
    fun getMedicalInsurance(): Double {
        return salary *  0.0245;
    }
    fun getHealthInsurance(): Double {
        return (salary - (getPensionInsurance() + getDisabilityInsurance() + getMedicalInsurance())) * 0.09
    }
    fun getTax() : Double{
        if((salary * 12) <= 120000 )
            return salary * 0.12
        return salary * 0.32
    }
    fun getNetto():Double{
        return  salary - (getPensionInsurance() + getDisabilityInsurance() + getMedicalInsurance() + getHealthInsurance() + getTax())

    }

}