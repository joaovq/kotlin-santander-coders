package tecnicasDeProgramacao.aula1.coroutines.aula3

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import org.apache.commons.logging.LogFactory
import kotlin.coroutines.CoroutineContext

val log = LogFactory.getLog("Log")

fun main(args: Array<String>) {

//    Criando um coroutineContext
    val name:CoroutineName = CoroutineName("Koroutines")
    val element: CoroutineContext.Element = name
    val context:CoroutineContext = element

    println(context)

//    Criando um Job
    val job: Job = Job()
    val jobElement: CoroutineContext.Element = job
    val contextJob:CoroutineContext = jobElement

    println(contextJob)



}