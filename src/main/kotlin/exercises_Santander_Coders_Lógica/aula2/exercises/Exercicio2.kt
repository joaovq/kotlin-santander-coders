package exercises_Santander_Coders_Lógica.aula2.exercises

/*
* TODO:2 - Faça um programa que receba o ano de nascimento de uma pessoa, o ano atual e calcule e imprima:>
*  - A idade dessa pessoa.
    - A idade convertida em semanas.
    (obs: vamos usar o valor aproximado de 52 semanas por ano para o calculo)
    * Exemplo:
    * Qual seu ano de nascimento?
    * -> 1953
    * Em qual ano estamos?
    * -> 2022
    * Você tem 69 anos, você já viveu aproximadamente 3588 semanas.
*
*
* */

fun main(args: Array<String>) {
    println("Qual o seu ano de nascimento? ")
    val anoDeNascimento = readln().toInt()
    println("Em que ano estamos? ")
    val anoAtual = readln().toInt()

    val idade = anoAtual.minus(anoDeNascimento)

    val emSemanas = idade.times(52)
    println("Você tem $idade anos, você já viveu aproximadamente $emSemanas semanas.")
}