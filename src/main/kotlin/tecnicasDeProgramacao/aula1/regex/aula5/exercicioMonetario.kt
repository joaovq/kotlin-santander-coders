package tecnicasDeProgramacao.aula1.regex.aula5

import java.util.Currency
import java.util.Locale

fun main() {
//    \\s para um espaço
    val s:String = Currency.getInstance(Locale.getDefault()).symbol
    println(s)
    val regex = Regex("R\\$\\s\\d{1,30},\\d{2}")

    println(regex.matches("12,0"))
    println(regex.matches("R$ 12,00"))
    println(regex.matches("R$ 1200,00"))
    println(regex.matches("R$ 12,0"))
}