package POO_Santander_Coders

fun main(args: Array<String>) {
}

data class Padaria(
    var nome:String,
    var categorias:MutableList<Categoria> = mutableListOf()
){

    fun adicionarNovaCategoria(){
        val nomeCategoria = readln()
        val n = readln().toInt()
        val produto = readln()
        for (i in 1..n){

        }
    }
}

enum class Categoria(var produtos:MutableList<String>){
    PAES(mutableListOf("Pão de Sal", "Pão de Leite", "Pão de Milho")),
    SALGADOS(mutableListOf("Pão de Sal", "Pão de Leite", "Pão de Milho")),
    DOCES(mutableListOf("Pão de Sal", "Pão de Leite", "Pão de Milho"));

}

class Carrinho(){

}

enum class Cupom(var desconto:Double){
    PADOCA5(desconto = 0.05),
    PADOCA10(desconto = 0.05),
    OFF5(desconto = 0.05);
}