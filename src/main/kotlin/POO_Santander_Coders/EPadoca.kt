package POO_Santander_Coders

import java.lang.IndexOutOfBoundsException
import java.text.NumberFormat
import java.util.Locale

private const val PADOCA5 = "5PADOCA"
private const val PADOCA10 = "10PADOCA"
private const val OFF5 = "5OFF"
private fun currencyFormatterBr(number:Double) :String{
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))
    return currencyInstance.format(number)
}

fun main(args: Array<String>) {
    val padaria = Padaria("São Miguel")
    var terminarPedido = false
   do{
       padaria.exibirMenu()
       println("Deseja fechar o seu pedido? (S/N)")
       val resposta = readln()
       if (resposta.equals("S", true))
           terminarPedido=true
   }while (!terminarPedido)
   println("\nVolte sempre!!!")
}

data class Padaria(
    var nome:String,
    var categorias:MutableList<Categoria> = mutableListOf(Categoria.PAES, Categoria.SALGADOS,Categoria.DOCES),
    var carrinho: Carrinho = Carrinho()
){
    init {
        println("Bem vindo a padaria $nome. O que deseja?")
    }

    fun exibirMenu(){
        categorias.forEachIndexed { index, categoria ->
            println("""
                ${index+1} -  ${categoria.name}         
            """.trimIndent())
        }
        escolherCategoria()
    }
    fun adicionarNovaCategoria(){
        val nomeCategoria = readln()
        val n = readln().toInt()
        val produto = readln()
        for (i in 1..n){

        }
    }
    fun escolherCategoria(){
//        Da o número da posição da enum
        println("Digite a opção na qual deseja comprar:")
        val escolha = readln().toInt()
        when(escolha){
            Categoria.PAES.ordinal+1->mostrarCardapio(Categoria.PAES)
            Categoria.SALGADOS.ordinal+1->mostrarCardapio(Categoria.SALGADOS)
            Categoria.DOCES.ordinal+1->mostrarCardapio(Categoria.DOCES)
            else->{
                println("Entrada inválida!")
            }
        }
    }
    fun mostrarCardapio(categoria: Categoria){
        categoria.produtos.forEachIndexed{
            index, produto ->  println("${index+1} - ${produto.nome} - R$ ${produto.valor}")
        }
        println("0 - VOLTAR")
        escolherProduto(categoria)
    }
    fun escolherProduto(categoria: Categoria){
        println("Faça sua escolha.")
        val escolha=readln().toInt()
        println("Qual a quantidade que deseja?.")
        val qtd=readln().toInt()
        when(escolha){
            in 1 .. categoria.produtos.size-> {
                    val produto = carrinho.produtos
                    produto.put(categoria.produtos[escolha-1], qtd)
            }
            else->throw IndexOutOfBoundsException("Este produto não existe")
        }
        exibirComanda()
    }

    fun exibirComanda(){
        carrinho.produtos.forEach{
            println(
                    "${it.key.nome} " +
                    "- ${currencyFormatterBr(it.key.valor)} " +
                    "- ${it.value} " +
                    "- ${currencyFormatterBr(it.key.valor*it.value)}"
            )
        }
        exibirMenu()
    }
    fun aplicarCupom(){
        println("Insira o nome do cupom: ")
        val resposta=readln()
        val desconto=when(resposta){
            PADOCA5-> Cupom.PADOCA5.desconto
            PADOCA10-> Cupom.PADOCA10.desconto
            OFF5-> Cupom.OFF5.desconto
            else -> {
                println(
                    "Cupom requisitado não existe," +
                        " ou é inválido para este dia"
                )
                null
            }
        }
    }
}

enum class Categoria(var produtos:MutableList<ProdutoPadaria>){
    PAES(mutableListOf(
        ProdutoPadaria("Pão de sal",0.8),
        ProdutoPadaria("Pão de leite", 0.6),
        ProdutoPadaria("Pão de milho", 0.4))
    ),
    SALGADOS(mutableListOf(
        ProdutoPadaria("Coxinha", 5.0),
        ProdutoPadaria("Pastel", 9.0),
        ProdutoPadaria("Croissant", 8.0))
    ),
    DOCES(mutableListOf(
        ProdutoPadaria("Brigadeiro", 2.0),
        ProdutoPadaria("Casadinho", 1.5),
        ProdutoPadaria("Canjica", 0.6)));

}

data class ProdutoPadaria(val nome: String, val valor:Double)

class Carrinho(val produtos: MutableMap<ProdutoPadaria,Int> = mutableMapOf())

enum class Cupom(var desconto:Double){
    PADOCA5(desconto = 0.05),
    PADOCA10(desconto = 0.05),
    OFF5(desconto = 0.05);
}