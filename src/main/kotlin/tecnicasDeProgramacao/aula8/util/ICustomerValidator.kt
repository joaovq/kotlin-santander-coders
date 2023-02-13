package tecnicasDeProgramacao.aula8.util

import tecnicasDeProgramacao.aula8.extension.matcherFromPattern
import java.time.LocalDate

interface ICustomerValidator :Validator<CustomerForm>{
     fun isValidCpf(value : String) : Boolean
     fun isValidEmail(value : String) : Boolean
     fun isValidRg(value : String) : Boolean
     fun isValidBirth(value : LocalDate) : Boolean
     fun isValidTelephone(value : String) : Boolean
     fun isValidName(value : String) : Boolean
}