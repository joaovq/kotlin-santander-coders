package Exercises_Santander_Coders.aula2.exercises

/*
*   TODO: - Faça um programa que peça uma nota, entre zero e dez. Mostre uma mensagem caso o valor seja inválido
*    e continue pedindo até que o usuário informe um valor válido.
*
*
* */

fun main(args: Array<String>) {
    println("Digite uma nota de 0 a 10: ")

    var nota :Int?
    val boolean:Boolean = false

    while (!boolean){
        nota = readln().toInt()
        if (nota in 0..10){
            break
        }
        println("Nota inválida!!")
        println("Digite uma nota de 0 a 10: ")
    }


        println("Nota válida!!")


}