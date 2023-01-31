package tecnicasDeProgramacao.aula1.coroutines.aula3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(args: Array<String>): Unit = runBlocking {
    launch(Dispatchers.IO) {

        println(coroutineContext)

        withContext(Dispatchers.Default){
            println(coroutineContext)
        }
    }
    print("")
}