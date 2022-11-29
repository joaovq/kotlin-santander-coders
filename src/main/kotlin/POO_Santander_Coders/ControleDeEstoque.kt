package POO_Santander_Coders

var list:MutableList<Produto> = mutableListOf()

fun main(args: Array<String>) {
    val produto = Produto("Guardanapo", 90)

    println(produto.id)

    list.add(produto)

    val produto1 = Produto("Jarra", 80)

    println(produto1.id)

}

data class Produto(
                   var nome:String,
                   var quatidade:Int
                   ){
    val id:Int = list.size+1
}