package POO_Santander_Coders.Exercicios.Solid

//*
// Na substituição de Liskov
// As interfaces devem ser intercambiaveis
//
//
// */

fun main(args: Array<String>) {
    val anyObject = object : A {
        override fun correr() {
            TODO("Not yet implemented")
        }

    }
    h(anyObject)
}

interface B
interface C
interface A{
    fun correr()
}
fun f(a:A): B = TODO()
fun g(b:B): C = TODO()

// Neste caso, a função h chama a função g que retorna c
// a função g passa como para metro a funçã f que tem como parametro a interface A
// que é passado como parametro da função h
fun h(a:A): C = g(f(a))

