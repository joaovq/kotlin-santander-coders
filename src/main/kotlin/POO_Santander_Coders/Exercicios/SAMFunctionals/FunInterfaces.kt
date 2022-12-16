package POO_Santander_Coders.Exercicios.SAMFunctionals

import java.sql.DriverManager


fun interface IntPredicate {
    fun accept(i: Int): Boolean

//    fun isOdd():Boolean
}
////Utilizando mais de um método precisamos declarar mais de um objeto e implementar as funcoes
//val isEven = object :IntPredicate{
//    override fun accept(i: Int): Boolean {
//        TODO("Not yet implemented")
//    }
//    override fun isOdd():Boolean {
//        TODO("Not yet implemented")
//    }
//}

val isEven = IntPredicate { it % 2 == 0 }

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")

    connectionDb.connect()
}

fun interface ConnectionDb{
    fun connect()
}

val connectionDb = ConnectionDb { DriverManager.getConnection("") }


