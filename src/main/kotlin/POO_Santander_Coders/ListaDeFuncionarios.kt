package POO_Santander_Coders

class Funcionario(var name:String,
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
}
