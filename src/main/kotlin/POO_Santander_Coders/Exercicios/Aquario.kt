package POO_Santander_Coders.Exercicios

import kotlin.random.Random
import kotlin.random.nextInt


fun main(args: Array<String>) {
    val peixe:Aquario.Peixe = Aquario.Peixe("dourado", "laranja", 20)
}

enum class PeixesPadrão{
    DOURADO,
    VOADOR
}
class Aquario(private val peixes:MutableList<Peixe> = mutableListOf()){

    private var aquarioEstaSujo:Boolean = false

    data class Peixe(var nome:String, var cor:String, var tamanho:Int)

    fun adicionarPeixes(peixe:Peixe){
        if (aquarioEstaSujo.not()) peixes.add(peixe) else println("Não é possivel adicionar peixes com o aquario sujo.")
    }
    fun alimentarPeixes(){
        val opcao = Random.nextInt(range = (1..3))
        when(opcao){
            1-> {
                println("Sucesso, todos os peixes")
            }
            2->{
                val peixesAlimentados = Random.nextInt(range = (1 until peixes.size))
                println("Número de peixes que foram alimentados")
            }
            3->{
                println("Falha, nenhum peixe foi alimentado.")
            }
        }
    }
    fun limparAquario(){
        if (aquarioEstaSujo){
            aquarioEstaSujo=false
        }
    }
}



