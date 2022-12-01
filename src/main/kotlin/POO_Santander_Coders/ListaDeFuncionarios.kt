package POO_Santander_Coders

import java.text.NumberFormat
import java.util.*

private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
class Funcionario(
    var name:String,
                  var role:String = "Funcionary",
                  var cpf:String,
                  var email:String,
                  var enterprise:String,
                  var wage: Double = 0.0
                  ) {

    fun increaseSalary(wage: Double){
        this.wage = wage
    }

    fun editRole(role: String){
        this.role= role
    }

    fun decreaseSalary(wage: Double){
        this.wage = wage
    }

    override fun toString(): String {
        return "Funcionario(" +
                "name='$name'," +
                " role='$role'," +
                " cpf='$cpf'," +
                " email='$email'," +
                " enterprise='$enterprise'," +
                " wage=${currencyFormatter.format(wage)}" +
                ")"
    }


}
