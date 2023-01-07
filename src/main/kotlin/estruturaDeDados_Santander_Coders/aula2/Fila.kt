package estruturaDeDados_Santander_Coders.aula2

import java.util.LinkedList
import java.util.Queue

class QueueManager<T>{
    private val queue:ArrayList<T> = arrayListOf()

//    Remover quem ta no fim da fila
    fun pop():T?{
        if (queue.isEmpty()){
            return null
        }

        return queue.removeAt(0)
    }

    fun push(value:T){
        queue.add(value)

        println(queue)
    }
}

fun main(args: Array<String>) {
    val queueManager = QueueManager<String>()

    queueManager.push("Joao")
    queueManager.push("Uinderson")

    val pop = queueManager.pop()
    println(pop)

//    O java tem a fila com classe
    var queue:Queue<String> = LinkedList<String>()
//    Insere dados na fila
    queue.offer("dsdsadas")
//    retorna o ultimo
    queue.poll()


// A fila implementa a linked list, mas não a ArrayList
// pois na arrayList podemos tirar dados de qualquer posição.
// A fila é first in first out
// var queue:Queue<String> = ArrayList<String>()


}