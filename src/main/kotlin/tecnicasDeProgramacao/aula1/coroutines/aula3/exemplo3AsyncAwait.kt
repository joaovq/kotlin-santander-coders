package tecnicasDeProgramacao.aula1.coroutines.aula3

import kotlinx.coroutines.*


private suspend fun apiCall1():String{
    delay(2000L)
    return "Chamou o endpoint 1"
}
private suspend fun apiCall2():String{
    delay(2000L)
    return "Chamou o endpoint 2"
}

fun main():Unit  = runBlocking {
    launch(Dispatchers.IO) {
        val endpoint1 = async { apiCall1() }
        val endpoint2 = async { apiCall2() }

        println(endpoint1.await())
        println(endpoint2.await())
    }
    println("Main")
}