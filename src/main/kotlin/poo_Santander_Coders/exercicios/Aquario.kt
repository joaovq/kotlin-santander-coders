package poo_Santander_Coders.exercicios

import kotlin.random.Random
import kotlin.random.nextInt


fun main(args: Array<String>) {
    val aquario = Aquario()
    aquario.escolherOpcoesMenu()
}


class Aquario(
    val peixes:MutableList<Peixe> = mutableListOf(),
    var parametroDeLimpeza:Int = 3,
    private var capacidade: Capacidade = Capacidade.PEQUENO
) {
    var condicaoDeLimpeza:Int

    init {
        println("Bem vindo ao seu aquário, $nome!")
        condicaoDeLimpeza = parametroDeLimpeza
    }
    private var aquarioEstaSujo:Boolean = false

    companion object{
        val nome:String
            get() {
                return "Mar vermelho"
            }
    }

    enum class Capacidade(val capacidade: Int){
        PEQUENO(capacidade = 5),
        MEDIO(capacidade = 10),
        GRANDE(capacidade = 15);
    }

    object test{
        val name:String
            get() {
                return "Mar vermelho"
            }
    }

    enum class TamanhoPeixe{
        PEQUENO,
        MEDIO,
        GRANDE;
    }

//    TODO:Colocar a cor numa enum
    data class Peixe(
        var nome:String = "",
        var cor:String = "",
        var tamanho:TamanhoPeixe = TamanhoPeixe.PEQUENO
    )

    private fun mostrarMenu(){
        val opcoes = Opcao.values()

        opcoes.forEachIndexed { index, opcao ->
            println("${index+1} - ${opcao.mostrarAcao()}")
        }
        println("0 - Sair do aquário!")
    }
    enum class Opcao(val acao:String){
        ALIMENTAR(acao ="Alimentar os peixes") {
            override fun mostrarAcao():String {
                return acao
            }
        },
        ADICIONAR(acao ="Adicionar peixes") {
            override fun mostrarAcao():String {
                return acao
            }
        },
        LIMPAR_AQUARIO(acao ="Limpar aquario") {
            override fun mostrarAcao():String {
                return acao
            }
        },
        MOSTRAR_PEIXES(acao ="Mostrar os peixes do aquario") {
            override fun mostrarAcao():String {
                return acao
            }
        },
        FAZER_UPGRADE(acao = "Fazer upgrade do aquario") {
            override fun mostrarAcao(): String {
                return acao
            }
        };


        abstract fun mostrarAcao():String
        override fun toString(): String {
            return "Opcao(acao='$acao')"
        }
    }

    fun escolherOpcoesMenu(){
        var programaAtivo = true
        do {
            mostrarMenu()
            println("Digite a opcao desejada: ")
            val opcao = readln().toIntOrNull()
            when(opcao){
                1-> {
                    alimentarPeixes()
                }
                2-> {
                    adicionarPeixes()
                }
                3-> {
                    limparAquario()
                }
                4-> {
                    mostrarPeixes()
                }
                5-> {
                    aumentarCapacidade()
                }
                0-> {
                    programaAtivo = false
                }
                else->{
                    println("Opção inválida")
                    escolherOpcoesMenu()
                }
            }
        }while (programaAtivo)

        println("Até a próxima!!")
    }

    private fun aumentarCapacidade(){
        println("Tentando aumentar a capacidade...")
        when(capacidade){
            Capacidade.PEQUENO->capacidade=Capacidade.MEDIO
            Capacidade.MEDIO->capacidade=Capacidade.GRANDE
            else -> {
                println("O aquario já esta na sua capacidade máxima")
            }
        }
    }

    private fun adicionarPeixes(){

        val peixe = Peixe()

        println("Digite o nome: ")
        val nome = readlnOrNull() ?: peixe.nome
        println("Digite a cor do peixe: ")
        val cor = readlnOrNull() ?: peixe.cor
        println("Digite o tamanho do peixe(PEQUENO, MEDIO OU GRANDE) : ")
        val tamanho:String = readlnOrNull() ?: peixe.tamanho.toString()
        var tamanhoEnum:TamanhoPeixe = peixe.tamanho

        when(tamanho.uppercase()){
            "GRANDE"-> tamanhoEnum= TamanhoPeixe.GRANDE
            "MEDIO"->tamanhoEnum = TamanhoPeixe.MEDIO
            "PEQUENO"-> tamanhoEnum =  TamanhoPeixe.PEQUENO
            else -> {
                println("Tamanho digitado é inexistente, repita o processo")
                adicionarPeixes()
            }
        }
        if (aquarioEstaSujo.not() && peixes.size<capacidade.capacidade)
        {
            peixe.nome = nome
            peixe.cor = cor
            peixe.tamanho = tamanhoEnum
            peixes.add(peixe)
        }
        else if (peixes.size<capacidade.capacidade){
            println("Não é possivel adicionar peixes com o aquario sujo.")
        }
        else {
            println("O aquario está cheio, faça o upgrade se possivel.")
        }

        aquarioEstaSujo = (peixes.size % condicaoDeLimpeza == 0)
    }
    private fun alimentarPeixes(){
        if (peixes.isNotEmpty()) {
            val opcao = Random.nextInt(range = (1..3))
            when (opcao) {
                1 -> {
                    println("Sucesso, todos os peixes foram alimentados.")
                }

                2 -> {
                    val peixesAlimentados = Random.nextInt(range = (1 .. peixes.size))
                    println("Número de peixes que foram alimentados é $peixesAlimentados")
                }

                3 -> {
                    println("Falha, nenhum peixe foi alimentado.")
                }
            }
        }else{
            println("O Aquário está vazio")
        }
    }
    private fun limparAquario(){
        if (aquarioEstaSujo){
            aquarioEstaSujo=false
            println("O aquario foi limpo.")
        }
        else
            println("O aquário não está sujo, não tem necessidade de limpeza.")
    }
    fun mostrarPeixes(){
        println("# -   NOME   -   COR    -    TAMANHO")

        peixes.forEachIndexed { index, peixe ->
            println("${index+1} - ${peixe.nome} - ${peixe.cor} - ${peixe.tamanho}")
        }

        if (peixes.isEmpty()){
            println("Ainda não foram adicionados peixes")
        }
    }
}



