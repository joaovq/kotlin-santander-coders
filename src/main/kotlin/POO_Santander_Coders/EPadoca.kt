package POO_Santander_Coders

import java.lang.IndexOutOfBoundsException
import java.text.NumberFormat
import java.util.Locale

//@author joaovq

private fun currencyFormatterBr(number:Double) :String {
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))
    return currencyInstance.format(number)
}
//Extensão da função currency formatter
private fun Double.currencyFormatter() :String{
    return currencyFormatterBr(this)
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
    padaria.exibirComanda()
   println("\nVolte sempre!!!")
}

data class Padaria(
    var nome:String,
    var categorias:MutableList<Categoria> = mutableListOf(Categoria.PAES, Categoria.SALGADOS,Categoria.DOCES),
    var carrinho: Carrinho = Carrinho()
){

    private var total = 0.0
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
        when(escolha){
            0-> return
            in 1 .. categoria.produtos.size-> {
                    println("Qual a quantidade que deseja?.")
                    val qtd=readln().toInt()
                    val produto = carrinho.produtos
                    if (!produto.containsKey(categoria.produtos[escolha-1])){
                        produto[categoria.produtos[escolha - 1]] = qtd
                    }
                    else{
                        val valorAtual = produto[categoria.produtos[escolha - 1]]
                        produto[categoria.produtos[escolha - 1]] = qtd.plus(valorAtual!!)
                    }
            }
            else->throw IndexOutOfBoundsException("Este produto não existe")
        }
    }

    fun exibirComanda(){
        println("""
        ====================Comanda E-padoca=======================
        ===========================================================
        item.......Produto..........Qtd.......Valor...........Total
        ===========================================================
    """.trimIndent())

        carrinho.produtos.forEach{
            println(
                "${carrinho.produtos.keys.indexOf(it.key)+1}"+
                    ".......${it.key.nome}.........." +
                    "${currencyFormatterBr(it.key.valor)}......." +
                    "${it.value}..........." +
                        currencyFormatterBr(it.key.valor*it.value)
            )
            total+= (it.key.valor*it.value)
        }
        println("Total da conta: ${total.currencyFormatter()}")
        val desconto = aplicarCupom()
        if (desconto>0.0){
            println("\nValor total com desconto : ${desconto.currencyFormatter()}")
        }
    }
    fun aplicarCupom():Double{
        println("Deseja aplicar cupom? (S/N)")
        val escolha = readln()
        if (escolha.equals("N", true))
            return 0.0
        println("Insira o nome do cupom: ")
        val resposta=readln()
        val desconto=when(resposta.uppercase()){
            Cupom.CUPOMPADOCA5-> total-(total*Cupom.PADOCA5.desconto)
            Cupom.CUPOMPADOCA10-> total-(total*Cupom.PADOCA10.desconto)
            Cupom.CUPOMOFF5->total-Cupom.OFF5.desconto
            else -> {
                println(
                    "Cupom requisitado não existe," +
                        " ou é inválido para este dia"
                )
                aplicarCupom()
            }
        }
        return desconto
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
    PADOCA10(desconto = 0.10),
    OFF5(desconto = 5.0);
//    Objeto de classe, estático
    companion object{
         const val CUPOMPADOCA5 = "5PADOCA"
         const val CUPOMPADOCA10 = "10PADOCA"
         const val CUPOMOFF5 = "5OFF"
    }
//    Objeto de instância test
    object test {

    }
}