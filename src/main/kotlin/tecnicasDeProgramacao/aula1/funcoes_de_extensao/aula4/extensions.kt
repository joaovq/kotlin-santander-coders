package tecnicasDeProgramacao.aula1.funcoes_de_extensao.aula4

import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.List

fun Exemplo.externaFuncao(){
    println("Função extendida de Exemplo")
}

fun Int.qualEEsseInt() = this


fun Double.realFormat() = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br")).format(this)

fun Double.getTimesTwo() = this*2
fun Double.calculate(operation:String, valor:Double):Double? = when(operation.uppercase()){
    "+"-> this +valor
    "-"->this -valor
    "/"->this/valor
    "*"->this *valor
    else->{
        null
    }
}

fun String.removeFirstCharacter() = this.drop(1)

fun LocalDate.tomorrow(): LocalDate = this.plusDays(1)
fun LocalDate.yesterday(): LocalDate = this.minusDays(1)

val LocalDate.formatter:String
    get() {
        return this.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
    }

fun <T> MutableList<T>.turnElementsPosition(index1:Int, index2: Int) :MutableList<T>{
    if (index1<this.size || index2<this.size){
        val aux = this[index1]
        this[index1] = this[index2]
        this[index2] = aux
        println("Troca concluida")
    }
    return this
}

fun  List<String>.majorElement():String{
   return this.sortedBy { t-> t.length }[0]
}
