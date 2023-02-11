package tecnicasDeProgramacao.aula1.funcoes_de_extensao.aula4

import java.time.LocalDate

class Exemplo{
    fun deDentroDaClasse(){
        println("Dentro da Classe")
    }

}

fun main(args: Array<String>) {
    Exemplo().deDentroDaClasse()

    Exemplo().externaFuncao()

    println(12.qualEEsseInt())

    println(12.8.realFormat())
    println(12.8.calculate("", 2.0))
    println(12.8.getTimesTwo())

    println("+Guilherme".removeFirstCharacter())

    println(LocalDate.now().tomorrow().formatter)
    println(LocalDate.now().yesterday().formatter)

    println(mutableListOf(1, 2, 3, 4).turnElementsPosition(0, 2))

    println(listOf("das", "dasdsafds", "ssa").majorElement())
}