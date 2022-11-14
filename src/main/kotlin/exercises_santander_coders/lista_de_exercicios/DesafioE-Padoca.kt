package exercises_santander_coders.lista_de_exercicios

var qtd:Int = 0
var carrinho: MutableMap<String,MutableList<Double>> = mutableMapOf()
var qtdPF:Int = 0
var qtdPM:Int = 0

fun main(args: Array<String>) {
    println("Seja bem vindo a nossa E-Padoca!! ")
    menu()
}

fun menu(){
    println("O nosso cardapio: ")
    println("""
       O que deseja?
        
        1..................Pães
        2..............Salgados
        3.................Doces
        0......Finalizar compra
        
    """.trimIndent())
    println("Digite uma das opções para prosseguir: ")
    val escolha = readln().toInt()

    when(escolha){
        0 -> {
            println("Finalizando a sua compra...")
            if (carrinho.isEmpty()){
                println("Deseja realmente cancelar? (S/N)")
                val cancelamento = readln()
                if (cancelamento.equals("S", true)){
                    println("Volte sempre!!!")
                    return
                }
            }
            else{
                fechamentoDoCarrinho()
            }
        }
        1-> mostrarPaes()
        2-> mostrarSalgados()
        3-> mostrarDoces()
        else -> {
            println("Resposta Inválida\n")
            menu()
        }
    }
}
fun mostrarPaes(){
    println("""
        1 - Pão Francês...........R$ 0,60
        2 - Pão de Leite..........R$ 0,40
        3 - Pão de Milho..........R$ 0,50
        0 - Voltar
    """.trimIndent())
    println("Digite uma das opções para prosseguir: ")
    val escolha = readln().toInt()

    when(escolha){
        0 -> {
            menu()
        }
        1-> {
            if (carrinho.isEmpty()){
                carrinho.put("Pão Francês", mutableListOf())
            }
            carrinho.get("Pão Francês")?.add(0.6)
            mostrarPaes()
        }
        2-> {
            if (!carrinho.containsKey("Pão de Leite")){
                carrinho.put("Pão de Leite", mutableListOf())
            }
            carrinho.get("Pão de Leite")?.add(0.5)
            mostrarPaes()
        }
        3-> {
            if (carrinho.isEmpty()){
                carrinho.put("Pão de milho", mutableListOf())
                carrinho.get("Pão de milho")?.add(0.4)
            }
            carrinho.get("Pão de milho")?.add(0.4)
            mostrarPaes()
        }
        else -> {
            println("Resposta Inválida")
        }
    }
    mostrarPaes()
}
fun mostrarSalgados(){
    println("""
        1 - Bauru...........R$ 0,60
        2 - Misto...........R$ 0,40
        3 - Pastel..........R$ 0,50
        0 - Voltar
    """.trimIndent())
    println("Digite uma das opções para prosseguir: ")
    val escolha = readln().toInt()

    when(escolha){
        0-> {
            println("Finalizando a sua compra...")
            return
        }
        1-> TODO()
        2-> TODO()
        3-> TODO()
    }
    mostrarSalgados()
}
fun mostrarDoces(){
    println("""
        1 - Brigadeiro...........R$ 0,60
        2 - Casadinho..........R$ 0,40
        3 - Sequilho..........R$ 0,50
        0 - Voltar
    """.trimIndent())
    println("Digite uma das opções para prosseguir: ")
    val escolha = readln().toInt()
    when(escolha){
        0-> {
           menu()
        }
        1-> {
            carrinho.put("Brigadeiro", mutableListOf())
            carrinho.get("Brigadeiro")?.add(0.6)
            mostrarDoces()
        }
        2-> {
            carrinho.put("Casadinho", mutableListOf())
            carrinho.get("Casadinho")?.add(0.8)
            mostrarDoces()
        }
        3-> {
            carrinho.put("Sequilho", mutableListOf())
            carrinho.get("Sequilho")?.add(0.4)
            mostrarDoces()
        }
        else -> {
            println("Resposta Inválida")
        }
    }
}
fun fechamentoDoCarrinho() :Unit{
    println("""
        
        ====================Comanda E-padoca=======================
        ===========================================================
        item.......Produto..........Qtd.......Valor...........Total
        ===========================================================
    """.trimIndent())

    carrinho.forEach {
        println("${it}...........${it.key}......${it.value.size}........R\$${it.value.get(0)}........R\$ ${it.value.sum()}")
    }

    println("""
        
        ===========================================================
        Total ===========================================> R$ ${carrinho.size}
        =====================VOLTE SEMPRE ^-^======================
    """.trimIndent())

    return
}