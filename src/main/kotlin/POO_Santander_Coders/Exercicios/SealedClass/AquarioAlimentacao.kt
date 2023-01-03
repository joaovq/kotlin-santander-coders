package POO_Santander_Coders.Exercicios.SealedClass

import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>) {
    val aquario = Aquario()

    repeat(6){
        when(val resposta=aquario.alimentarPeixes()){
            is StatusFalha -> println("${resposta.mensagem} em alimentar peixes")
            is StatusParcial -> println("${resposta.mensagem} em alimentar peixes")
            is StatusSucesso -> println("${resposta.mensagem} em alimentar peixes")
        }
    }
}
//Um nome alteranivo para evitar nomes grandes
//typealias so aceita tipo. Para constantes que não sejam tipos, utiliza-se const val
typealias StatusSucesso= Aquario.Alimento.Sucesso
typealias StatusParcial= Aquario.Alimento.Parcial
typealias StatusFalha= Aquario.Alimento.Falha

class Aquario(){


    data class Peixe(var name:String, var cor:String, var tamanhoPeixe: Int)

    sealed class Alimento(numPeixes:Int){
        class Sucesso(val mensagem :String= "Sucesso" ) :Alimento(numPeixes = 100)
        class Parcial(val mensagem :String= "Parcial" ): Alimento(numPeixes = Random.nextInt(100))
        class Falha(val mensagem :String= "Falha" ) :Alimento(numPeixes = 0)
    }

    fun alimentarPeixes():Aquario.Alimento{
        return when(Random.nextInt(0..2)){
            0-> Alimento.Sucesso()
            1-> Alimento.Parcial()
            2-> Alimento.Falha()
            else -> {
                Alimento.Falha()
            }
        }
    }

}