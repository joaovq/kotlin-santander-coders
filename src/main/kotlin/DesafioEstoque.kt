import java.io.File
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.nio.charset.Charset
import kotlin.Exception

var estoque :MutableList<Triple<Long,String, Int>> = mutableListOf()

fun main(args: Array<String>) {
    println("Seja bem vindo!!")
    mostrarMenu()
}
fun mostrarMenu(){
    println("""
        
        1- ADICIONAR ITEM 
        2- EDITAR ITEM 
        3- EXIBIR ITENS EM ESTOQUE 
        4- EXIBIR TODOS OS ITENS 
        5- FECHAR SISTEMA
        
        
    """.trimIndent())

    println("Digite a opção desejada:")
    try {
        val escolha = readln().toInt()
        when(escolha){
            1 -> adicionarItens()
            2 -> editarItens()
            3-> exibirItensEmEstoque()
            4 -> exibirTodosOsItens()
            5 -> {
                println("Programa encerrado!!")
                imprimirDadosTxt(estoque)
                return
            }
            else->{
                println("Resposta inválida.")
                mostrarMenu()
            }
        }
    } catch (e:NumberFormatException){
        e.printStackTrace()
        throw RuntimeException("Somente aceito números como resposta, nesta etapa.")
    }
}

fun adicionarItens(){
    println("Bem vindo a adição de itens")
    println("Digite o nome do item:")
    val nome = readln()
    println("Digite a quantidade do item:")
    val qtdEmEstoque = readln().toInt()

    if (qtdEmEstoque>999){
        throw LimiteEstoqueMaxException()
    }
    estoque.add(Triple(Integer.toUnsignedLong(estoque.size+1),nome, qtdEmEstoque))

    println("Item adicionado!!")

    mostrarMenu()
}

fun editarItens(){
    println("Bem vindo a edição de itens")
    println("Digite o identificador:")
    val id = readln().toInt()
    println("Digite o nome do item: (Se não deseja alterar, deixe em branco)")
    var nome = readln()
    nome = if (nome == "") estoque[id-1].second else nome
    println("Digite a quantidade do item: (Se não deseja alterar, deixe em branco)")
    val qtdEmEstoque = readln().toIntOrNull() ?:estoque[id-1].third

    try {
        if (id>estoque.size||id<0){
            println("Id não encontrado, repita o processo.")
            editarItens()
        }
        if (qtdEmEstoque>999){
            throw LimiteEstoqueMaxException()
        }
        val copy = estoque[id - 1].copy(first = Integer.toUnsignedLong(id), second = nome, third = qtdEmEstoque)
        estoque.removeAt(id-1)
        estoque.add(index = id-1, element = copy)
    }catch (e:IndexOutOfBoundsException ,){
            e.printStackTrace()
    }
        println("Item editado!!")

    mostrarMenu()
}

class LimiteEstoqueMaxException: Exception("Erro: Quantidade máxima no estoque é 999")


fun exibirTodosOsItens(){
    println("ID | Peça | Quantidade")
    estoque.forEach {
        println(print(it))
    }

    mostrarMenu()

}
fun exibirItensEmEstoque(){
    val filter = estoque.filter { (it.third == 0).not() }
    println("ID | Peça | Quantidade")
    filter.forEach {
        println(print(it))
    }
    mostrarMenu()
}

private fun print(entity: Triple<Long, String, Int>) :String =
    if (entity.first > 100) {
     """ 
            ------------------------------
            #0${entity.first} | ${entity.second} | ${entity.third}
        """.trimIndent()

    }
    else if (entity.first > 10) {
     """
            ------------------------------
            #00${entity.first} | ${entity.second} | ${entity.third}
        """.trimIndent()
    }
    else {
     """
            ------------------------------
            #000${entity.first} | ${entity.second} | ${entity.third}
        """.trimIndent()
    }

fun imprimirDadosTxt(estoque:MutableList<Triple<Long,String, Int>>){
    val file=File("utils/estoque.txt")
    file.setWritable(true)
    file.appendText("ID | Peça | Quantidade\n", Charset.defaultCharset())

    val filter = estoque.filter { (it.third == 0).not() }

    filter.forEach {
        file.appendText(print(it)+"\n\n")
    }

}

