package poo_Santander_Coders

import java.io.File
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.nio.charset.Charset

//var list:MutableList<Produto> = mutableListOf()

data class Produto(
    var id :Int = 0,
    var  nome:String = "",
    var quantidade:Int = 0
){
}

fun main(args: Array<String>) {
    val estoque = Estoque()
    estoque.exibirMenu()
}


data class Estoque(val listaDeProdutos: MutableList<Produto> = mutableListOf()){

    init {
        println("Seja Bem vindo ao nosso controle de estoque!!")
    }
//    TODO: Colocar opções do menu em enum


    enum class MenuOpcoes(val value:String){
        ADICIONAR_ITEM(value = "ADICIONAR ITEM"),
        EDITAR_ITEM(value = "EDITAR ITEM"),
        EXIBIR_ESTOQUE(value ="EXIBIR ITENS EM ESTOQUE "),
        EXIBIR_TODOS(value ="EXIBIR TODOS OS ITENS "),
        ZERAR_ESTOQUE_DE_PRODUTO(value = "ZERAR ESTOQUE DE PRODUTO"),
        FECHAR_SISTEMA(value="FECHAR SISTEMA");
    }
    fun exibirMenu(){
        val opcoes = MenuOpcoes.values()

        opcoes.forEachIndexed{index, opção->
            println("${index+1} - ${opção.value}")
        }

        escolherOpcoes()
    }

    private fun escolherOpcoes() {
        println("Digite a opção desejada:")
        try {
            val escolha = readln().toInt()
            when (escolha) {
                1 -> adicionarItens()
                2 -> editarItens()
                3 -> exibirItensEmEstoque()
                4 -> exibirTodosOsItens()
                5 -> exibirZerarEstoque()
                6 -> {
                    println("Programa encerrado!!")
                    imprimirDadosTxt(listaDeProdutos)
                    return
                }

                else -> {
                    println("Resposta inválida.")
                    exibirMenu()
                }
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            throw RuntimeException("Somente aceito números como resposta, nesta etapa.")
        }
    }

    fun adicionarItens(){
        val produto = Produto()
        println("Bem vindo a adição de itens")
        println("Digite o nome do item:")
         produto.nome = readln()
        println("Digite a quantidade do item:")
        val quantidade = readln().toInt()
        if (quantidade>999){
            throw LimiteEstoqueMaxException()
        }
        produto.quantidade =quantidade
        produto.id = listaDeProdutos.size+1
        listaDeProdutos.add(produto)
        println("Item adicionado!!")
        exibirMenu()
    }

    fun editarItens(){
        println("Bem vindo a edição de itens")
        println("Digite o identificador:")
        val id = readln().toInt()
        println("Digite o nome do item: (Se não deseja alterar, deixe em branco)")
        var nome = readln()
        nome = if (nome == "") listaDeProdutos[id-1].nome else nome
        println("Digite a quantidade do item: (Se não deseja alterar, deixe em branco)")
        val qtdEmEstoque = readln().toIntOrNull() ?:listaDeProdutos[id-1].quantidade

        edicaoDeItens(id, qtdEmEstoque, nome)
    }

    private fun edicaoDeItens(id: Int, qtdEmEstoque: Int, nome: String) {
        try {
            if (id > listaDeProdutos.size || id < 0) {
                println("Id não encontrado, repita o processo.")
                editarItens()
            }
            if (qtdEmEstoque > 999) {
                throw LimiteEstoqueMaxException()
            }
            val copy = listaDeProdutos[id - 1].copy(id = id, nome = nome, quantidade = qtdEmEstoque)
            listaDeProdutos.removeAt(id - 1)
            listaDeProdutos.add(index = id - 1, element = copy)
        } catch (e: IndexOutOfBoundsException) {
            e.printStackTrace()
        }
        println("Item editado!!")

        exibirMenu()
    }


    fun exibirTodosOsItens(){
        println("ID | Peça | Quantidade")
        listaDeProdutos.forEach {
            println(printProdutos(it))
        }
        exibirMenu()
    }

    private fun printProdutos(entity: Produto) :String =
        if (entity.id > 100) {
            """ 
            ------------------------------
            #0${entity.id} | ${entity.nome} | ${entity.quantidade}
        """.trimIndent()

        }
        else if (entity.id > 10) {
            """
            ------------------------------
            #00${entity.id} | ${entity.nome} | ${entity.quantidade}
        """.trimIndent()
        }
        else {
            """
            ------------------------------
            #000${entity.id} | ${entity.nome} | ${entity.quantidade}
        """.trimIndent()
        }

        fun exibirItensEmEstoque(){
            val filter = listaDeProdutos.filter { (it.quantidade == 0).not() }
            println("ID | Peça | Quantidade")
            if (filter.isEmpty())
                println("Não há itens em estoque!")
            filter.forEach {
                println(printProdutos(it))
            }
            exibirMenu()
        }

        fun exibirZerarEstoque(){
            println("Bem vindo a edição de itens")
            println("Digite o identificador:")
            val id = readln().toInt()
            zerarEstoqueDeProduto(id)

        }

    private fun zerarEstoqueDeProduto(id: Int) {
        try {
            if (id > listaDeProdutos.size || id < 0) {
                println("Id não encontrado, repita o processo.")
                editarItens()
            }
            val copy = listaDeProdutos[id - 1].copy(id = id, quantidade = 0)
            listaDeProdutos.removeAt(id - 1)
            listaDeProdutos.add(index = id - 1, element = copy)
        } catch (e: IndexOutOfBoundsException) {
            e.printStackTrace()
        }
        println("Item editado!!")

        exibirMenu()
    }

    fun imprimirDadosTxt(estoque:MutableList<Produto>){
            val file= File("utils/estoque.txt")
            file.setWritable(true)
            file.appendText("ID | Peça | Quantidade\n", Charset.defaultCharset())

            val filter = estoque.filter { (it.quantidade == 0).not() }

            filter.forEach {
                file.appendText(printProdutos(it)+"\n\n")
            }

        }
}

class LimiteEstoqueMaxException: Exception("Erro: Quantidade máxima no estoque é 999")