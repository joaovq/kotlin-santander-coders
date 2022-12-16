package POO_Santander_Coders.Exercicios.SAMFunctionals



typealias IntPredicate2 = (i: Int) -> Boolean

val isEven2: IntPredicate2 = { it % 2 == 0 }

fun main() {
    println("Is 7 even? - ${isEven2(7)}")
}