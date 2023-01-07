package poo_Santander_Coders.exercicios.sealedClass

import poo_Santander_Coders.exercicios.sealedClass.ResultadoBuscaUsuario.Carregando.buscaUsuario
import kotlin.random.Random

data class Usuario(var name:String, var senha:String)



sealed class ResultadoBuscaUsuario(val tipo:Int){
    data class Sucesso(val usuarioBuscado: Usuario, val mensagem: String):ResultadoBuscaUsuario(tipo = 1)
    object Carregando : ResultadoBuscaUsuario(tipo = 0) {
        fun update(): ResultadoBuscaUsuario {
            return Sucesso(usuarioBuscado = Usuario("", ""), mensagem = "Carregando foi atualizado!")
        }
    }
    data class Falha(val erro: String) : ResultadoBuscaUsuario(tipo = -1)

    fun buscaTipo() {
        println("Meu tipo é $tipo.")
    }


    fun buscaUsuario(): ResultadoBuscaUsuario {
        val usuarioAleatorio = Usuario(name = "Bernardo", senha = "1234")

        return when(Random.nextInt(0, 3)) {
            0 -> Sucesso(usuarioBuscado = usuarioAleatorio, mensagem = "Sucesso ao buscar usuário!")
            1 -> Carregando
            2 -> Falha(erro = "Falha ao buscar usuário.")
            else -> Carregando
        }
}

abstract class Pessoa(nome:String, cpf:String){
      class PessoaFisica()

    inner class PessoaJuridica(){}

}
}
fun main(args: Array<String>) {
//    Não podemos instanciar uma sealed class. é abstrata
//    Sealed types cannot be instantiated
//    val resultadoBuscaUsuario = ResultadoBuscaUsuario()

//    Cannot create an instance of an abstract class
//    Pessoa("Joao", cpf = "17921")

//    Nested class podemos instanciar fora da classe sem ter uma instancia da classe externa
    ResultadoBuscaUsuario.Pessoa.PessoaFisica()

//    Para inner class Não podemos instanciar sem uma instancia da classe pessoa, se não for dentro da classe externa
//    Pessoa.PessoaJuridica()

    repeat(6) {
        when(val resposta = buscaUsuario()) {
            is ResultadoBuscaUsuario.Sucesso -> println("${resposta.mensagem} O usuário buscado foi ${resposta.usuarioBuscado}.")
            is ResultadoBuscaUsuario.Carregando -> {
                println("Carregando...")
                resposta.update()
            }
            is ResultadoBuscaUsuario.Falha -> println(resposta.erro)
        }
    }
}