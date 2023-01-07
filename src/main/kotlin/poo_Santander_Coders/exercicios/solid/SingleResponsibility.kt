package poo_Santander_Coders.exercicios.solid

data class User(
    var name:String,
    var senha:String
):Autenticador()


sealed class Autenticador{
    fun login(){
        println("The user was login in system")
    }
    fun logout(){
        println("Logout in system...")
    }
}


fun main(args: Array<String>) {
    val user = User(
                    name = "João",
                    senha = "15273494"
                )

    user.login()
    user.logout()

}
