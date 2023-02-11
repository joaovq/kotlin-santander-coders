package tecnicasDeProgramacao.aula1.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


suspend fun soma(a:Int, b:Int):Int{
    delay(1000)
    return a+b
}
suspend fun cumprimento(nome:String){
    delay(2000L)
    println(nome)
}
suspend fun cumprimentoNomeCompleto(nome:String, sobrenome:String) = coroutineScope{
  launch {
      delay(3000L)
      print(sobrenome)
  }

    launch {
        delay(2000L)
        print(nome)
    }
}
fun main(args: Array<String>)  = runBlocking {
    println("olá, boa noite ")

    cumprimentoNomeCompleto("João Vítor", "Queiroz")

    val tempo1 = measureTimeMillis { launch { cumprimento("Eduardo") } }

    println("$tempo1 ms")

    val tempo = measureTimeMillis {
        val soma1 = async { soma(2, 2) }
        val soma2 = async { soma(2, 2) }
        println("Soma 1: ${soma1.await()}")
        println("Soma 2: ${soma2.await()}")
    }

    println("Tempo em milisegundos: $tempo")
}