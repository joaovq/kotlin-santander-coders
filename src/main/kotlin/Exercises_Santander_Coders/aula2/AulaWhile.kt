package Exercises_Santander_Coders.aula2



fun main(args: Array<String>) {
    println("-----Área de Cadastro----")
    println("min de 6 char")
    println("max de 10 char")

    println("Digite o usuário desejado")
    var user :String
    var condition:Boolean
    do {
        user = readln()
        condition = user.isEmpty() || user.isBlank()
    }while (condition)

     /*while(condition){
         println("Digite o usuário desejado")
         user = readln()
         val condition = user.isEmpty() || user.isBlank()
     }*/
}