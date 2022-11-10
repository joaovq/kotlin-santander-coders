package Exercises_Santander_Coders.aula2.exercises

/*
*   TODO:3 - Faça um programa que receba a idade de um nadador e imprima a sua categoria seguindo as regras:
*    CATEGORIA   	IDADE
*       Infantil A 		5 — 7 anos
*       Infantil B		8 — 10 anos
        Juvenil A		11 — 13 anos
        Juvenil B		14 — 17 anos
        Sênior		maiores de 18 anos
*
*
* */

fun main(args: Array<String>) {
    println("Digite a sua idade: ")
    val age = readln().toInt()


    println("""
        
      CATEGORIA       IDADE
        Infantil A 		5 — 7 anos
        Infantil B		8 — 10 anos
        Juvenil A		11 — 13 anos
        Juvenil B		14 — 17 anos
        Sênior		maiores de 18 anos
        
    """.trimIndent())

    val category= when(age){
        in 5..7-> "Infantil A"
        in 8..10-> "Infantil B"
        in 11..13-> "Juvenil A"
        in 14..17-> "Juvenil B"
        in 18..Int.MAX_VALUE-> "Sênior"
        else -> {
            println("Resposta inválida")
            return
        }
    }

    println("Sua categoria é a $category")


//    TODO: FORMAS DE PRINTAR
    /*println("""
        
        Hello World
        |
    """.trimMargin())
    println("""
        
        Hello World
        |
    """.trimIndent())
    println("""
        
        Hello World
        |
    """.trim())

    println("""
        
        Hello World

    """.trimIndent())*/


}