package exercises_santander_coders.lista_de_exercicios
val carrinho: MutableMap<String,MutableList<Double>> = mutableMapOf()
var total = 0.00
//Pode utilizar esse no ligar do map, so que não é uma lista
var pair:Pair<Long, String> = Pair(1, "Joao")
var triple:Triple<Long, String, Int> = Triple(1, "Joao", 2)

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
                }
            }
            else{
                fechamentoDoCarrinho()
            }
        }
        1-> {
            mostrarPaes()
        }
        2-> {
            mostrarSalgados()
        }
        3-> {
            mostrarDoces()
        }
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
            if (!carrinho.containsKey("Pão Francês")){
                carrinho.put("Pão Francês", mutableListOf())
            }
            carrinho.get("Pão Francês")?.add(0.6)
            println("Compra realizada!")
            mostrarPaes()
        }
        2-> {
            if (!carrinho.containsKey("Pão de Leite")){
                carrinho.put("Pão de Leite", mutableListOf())
            }
            carrinho.get("Pão de Leite")?.add(0.4)
            println("Compra realizada!")
            mostrarPaes()
        }
        3-> {
            if (!carrinho.containsKey("Pão de milho")){
                carrinho.put("Pão de milho", mutableListOf())
            }
            carrinho.get("Pão de milho")?.add(0.4)
            println("Compra realizada!")
            mostrarPaes()
        }
        else -> {
            println("Resposta Inválida")
            mostrarPaes()
        }
    }
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
            menu()
        }
        1-> {
            if (!carrinho.containsKey("Bauru")){
                carrinho.put("Bauru", mutableListOf())
            }
            carrinho.get("Bauru")?.add(0.4)
            println("Compra realizada!")
            mostrarSalgados()
        }
        2-> {
            if (!carrinho.containsKey("Misto")){
                carrinho.put("Misto", mutableListOf())
            }
            carrinho.get("Misto")?.add(0.4)
            println("Compra realizada!")
            mostrarSalgados()
        }
        3-> {
            if (!carrinho.containsKey("Pastel")){
                carrinho.put("Pastel", mutableListOf())
            }
            carrinho.get("Pastel")?.add(0.5)
            println("Compra realizada!")
            mostrarSalgados()
        }
        else -> {
            println("Resposta Inválida")
            mostrarSalgados()
        }
    }
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
            if (!carrinho.contains("Brigadeiro")) {
                carrinho.put("Brigadeiro", mutableListOf())
            }
            carrinho.get("Brigadeiro")?.add(0.6)
            println("Compra realizada!")
            mostrarDoces()
        }
        2-> {
            if (!carrinho.contains("Casadinho")) {
                carrinho.put("Casadinho", mutableListOf())
            }
            carrinho.get("Casadinho")?.add(0.8)
            println("Compra realizada!")
            mostrarDoces()
        }
        3-> {
            if (!carrinho.contains("Sequilho")) {
                carrinho.put("Sequilho", mutableListOf())
            }
            carrinho.get("Sequilho")?.add(0.4)
            println("Compra realizada!")
            mostrarDoces()
        }
        else -> {
            println("Resposta Inválida")
            mostrarDoces()
        }
    }
}
fun fechamentoDoCarrinho() {
    println("Deseja aplicar algum cupom?? (S/N)")
    val escolhaCupom = readln()
    var resposta:String =""
    if (escolhaCupom.equals("S", true)){
         resposta = receberCupom()
    }
    else if (!escolhaCupom.equals("N", true)){
        println("Respota inválida!")
        fechamentoDoCarrinho()
    }

    println("""
        ====================Comanda E-padoca=======================
        ===========================================================
        item.......Produto..........Qtd.......Valor...........Total
        ===========================================================
    """.trimIndent())


    carrinho.forEach {
        println("${carrinho.keys.indexOf(it.key)+1}..........." +
                "${it.key}......" +
                "${it.value.size}........" +
                "R\$${String.format("%.2f", it.value[0])}........" +
                "R\$ ${String.format("%.2f", it.value.sum())}")
        total+=it.value.sum()
    }

//    Calculo do desconto

    when{
        resposta.equals("5PADOCA", true)->{
            total *=0.95
        }
        resposta.equals("10PADOCA", true)->{
            total*=0.9
        }
        resposta.equals("5OFF", true)->{
            if (total>5){
                total-=5
            }
            else{
                println("Esse cupom não pode ser aplicado para valores menores que 5 reais.")
            }
        }
        else ->{
            println("Cupom inválido")
            fechamentoDoCarrinho()
        }
    }

    println("""
        
        ===========================================================
        Total ===========================================> R$${String.format("%.2f", total)}
        =====================VOLTE SEMPRE ^-^======================
    """.trimIndent())

}

fun receberCupom():String{
    println("Digite o Cupom: ")

    val resposta = readln()
    return resposta
}