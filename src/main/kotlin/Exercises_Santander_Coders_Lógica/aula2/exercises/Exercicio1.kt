package Exercises_Santander_Coders_Lógica.aula2.exercises

/*
* TODO:
*  1 - Faça um programa que receba a idade de uma pessoa em anos e imprima essa idade em meses, dias, horas e minutos.
*   (obs: não será preciso levar em conta anos bissextos, podendo usar 365 dias por ano)
    Exemplo:
    Digite sua idade:
    -> 1
    Sua idade equivale a:
    12 meses
    365 dias
    8760 horas
     525600 minutos
*
*
* */

fun main(args: Array<String>) {
    println("Digite sua idade")
    val idade :Int?= readln().toIntOrNull()

//    meses
    val emMeses = idade?.times(12)
    val emDias = idade?.times(356)
    val emHoras = idade?.times(8760)
    val emMinutos = idade?.times(525600)
 // Nova forma de fazer e bem legal, Boa prática também
    /*val emMeses = idade?.times(QTD_MESES_ANO)*/
    /*val emDias = idade?.times(QTD_DIAS_ANO)*/
    /*val emHoras = idade?.times(QTD_HORAS_ANO)*/
    /*val emMinutos = idade?.times(QTD_MINUTOS_ANO)*/

    println("Em meses :$emMeses")
    println("Em dias :$emDias")
    println("Em horas :$emHoras")
    println("Em minutos :$emMinutos")
}

const val QTD_MESES_ANO = 12
const val QTD_DIAS_ANO = 356
const val QTD_HORAS_ANO = 8760
const val QTD_MINUTOS_ANO = 525600
