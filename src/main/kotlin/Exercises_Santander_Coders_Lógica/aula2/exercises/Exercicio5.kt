package Exercises_Santander_Coders_Lógica.aula2.exercises

/*
* TODO:5 - Faça um programa que leia um nome de usuário e a sua senha e não aceite a senha igual ao nome do usuário,
*   mostrando urna mensagem de erro e voltando a pedir as informações.
*
*
* */

fun main(args: Array<String>) {
    println("Digite o seu usuário: ")
    var user = readln()
    println("Digite a sua senha: ")
    var password = readln()

    var condition:Boolean
    condition = user.equals(password, true)

    while (condition){
        println("Digite usuário e senha diferentes!!")
        println("Digite o seu usuário: ")
        user = readln()
        println("Digite a sua senha: ")
        password = readln()
        condition = user.equals(password, true)
    }

    //  user.contains(password) podemos utilizar isso, .not() nega o booleano
    // podemos utilzar em um do while
    println("Cadastro feito com sucesso.")
    
    
//        A partir do léxico, numero de caracteres, alfabeto
//    if (user.compareTo(password, true) > 1)
}
