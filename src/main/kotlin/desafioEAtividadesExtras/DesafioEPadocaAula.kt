private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val FINALIZAR = 0
private const val LINHA = ".........."

val itensComanda: MutableList<String> = mutableListOf<String>()
var total: Double = 0.0

//cupons
//Se colocar sem o tipo, é considerado com Any
private const val CUPOMPADOCA5 = "5PADOCA"
private const val CUPOMPADOCA10 = "10PADOCA"
private const val CUPOMOFF5 = "5OFF"

//Paes
val valorPaoFrances = 0.60
val valorPaoDeLeite = 0.40
val valorPaoDeMilho = 0.50

val produtoPaoFrances = "Pão Francês"
val produtoPaoDeLeite = "Pão de Leite"
val produtoPaoDeMilho = "Pão de Milho"

val paes: List<Pair<String, Double>> = listOf(
    Pair(produtoPaoFrances, valorPaoFrances), // index 0
    Pair(produtoPaoDeLeite, valorPaoDeLeite), // index 1
    Pair(produtoPaoDeMilho, valorPaoDeMilho), // index 2
)

//Salgados
val valorCoxinha = 5.00
val valorEsfiha = 3.00
val valorPaoDeQueijo = 3.00

val produtoCoxinha = "Coxinha"
val produtoEsfiha = "Esfiha"
val produtoPaoDeQueijo = "Pão de Queijo"

val salgados: List<Pair<String, Double>> = listOf(
    Pair(produtoCoxinha, valorCoxinha), // index 0
    Pair(produtoEsfiha, valorEsfiha), // index 1
    Pair(produtoPaoDeQueijo, valorPaoDeQueijo), // index 2
)
// Doces

val valorCarolina = 1.50
val valorPudim = 4.00
val valorBrigadeiro = 2.00

val produtoCarolina = "Carolina"
val produtoPudim = "Pudim"
val produtoBrigadeiro = "Brigadeiro"

val doces: List<Pair<String, Double>> = listOf(
    Pair(produtoCarolina, valorCarolina), // index 0
    Pair(produtoPudim, valorPudim), // index 1
    Pair(produtoBrigadeiro, valorBrigadeiro), // index 2
)



val categorias = """
    Digite a opção desejada no Menu:
    1..................Pães
    2..............Salgados
    3.................Doces
    0......Finalizar compra
""".trimIndent()

val menuPaes = """
        1 - $produtoPaoFrances...........R$ $valorPaoFrances
        2 - $produtoPaoDeLeite..........R$ $valorPaoDeLeite
        3 - $produtoPaoDeMilho..........R$ $valorPaoDeMilho
        0 - Voltar
    """.trimIndent()


val menuSalgados = """
        1 - $produtoCoxinha...........R$ $valorCoxinha
        2 - $produtoEsfiha..........R$ $valorEsfiha
        3 - $produtoPaoDeQueijo..........R$ $valorPaoDeQueijo
        0 - Voltar
    """.trimIndent()

val menuDoces = """
        1 - $produtoCarolina...........R$ $valorCarolina
        2 - $produtoPudim..........R$ $valorPudim
        3 - $produtoBrigadeiro..........R$ $valorBrigadeiro
        0 - Voltar
    """.trimIndent()


fun main() {
    do {
        var finalizarCompra = "S"
        ePadoca()

        if (itensComanda.isEmpty()) {
            println("Deseja mesmo finalizar a compra? (S/N)")
            finalizarCompra = readln().uppercase()
        } else {
            println("Deseja inserir algum cupom? (S/N)")
            val querCupom= readln().uppercase()
            itensComanda.forEach { item -> // funcao
                println(item)
            }
            println("Valor total R$$total")
            if (querCupom.equals("S", ignoreCase = true)) {
                val totalComDesconto = selecionaCupom()
                println("Valor total com desconto do cupom: $totalComDesconto")
            }
        }
    } while (finalizarCompra != "S")
}

fun ePadoca() {
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categorias)

        val categoria = readln().toInt()

        when (categoria) {
            PAES -> selecionaProduto(menuSelecionado = menuPaes, produtos = paes)
            SALGADOS -> selecionaProduto(menuSelecionado = menuSalgados, produtos = salgados)
            DOCES -> selecionaProduto(menuSelecionado = menuDoces, produtos = doces)
            else -> Unit
        }
    } while (categoria != FINALIZAR)
}

fun selecionaProduto(
    menuSelecionado: String, produtos: List<Pair<String, Double>>
) {
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt() // valor atual -> 1 (corresponde ao pao frances)

        for ((i, produto) in produtos.withIndex()) {
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }


    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(produto: Pair<String, Double>) {
    println("Digite a quantidade:")
    val quantidade = readln().toInt()
    val totalItem = quantidade * produto.second
    val item =
        itemComanda(produto = produto.first, quantidade = quantidade, valorUnitario = produto.second, total = totalItem)
    itensComanda.add(item)
    total += totalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double,
): String = "${itensComanda.size.inc()}$LINHA$produto$LINHA$quantidade$LINHA$valorUnitario${LINHA}R$$total"


fun selecionaCupom() :Double {

    var totalComDesconto:Double
    var cupomSelecionado :Boolean
    do {
        println("Digite o nome do cupom: ")
        val cupom:String = readln().uppercase()
        cupomSelecionado=true
        totalComDesconto = when(cupom){
            CUPOMPADOCA5-> {
                total*0.95
            }
            CUPOMPADOCA10-> {
                total*0.9
            }
            CUPOMOFF5 -> {
                if (total<5.0) {
                    cupomSelecionado = false
                    1.0
                } else{
                    total-5
                }
            }
            else->{
                cupomSelecionado =false
                println("Cupom inexistente")
                1.0
            }
        }

    }while (!cupomSelecionado)
    return totalComDesconto

}