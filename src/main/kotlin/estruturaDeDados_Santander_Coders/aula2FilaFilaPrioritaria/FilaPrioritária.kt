package estruturaDeDados_Santander_Coders.aula2FilaFilaPrioritaria

import java.util.PriorityQueue

fun main(args: Array<String>) {
//    Fila com prioridades
    val priorityQueue: PriorityQueue<Int> = PriorityQueue{
        new,inQueue->
//        >0, <0 , ==0
        if (new>inQueue) 1
        else 0
    }

    priorityQueue.offer(1)
    priorityQueue.offer(1)
    priorityQueue.offer(3)
    priorityQueue.offer(4)

//    Vai mostrar a ordem normal
    println(priorityQueue)

//    Quando puxamos os valores, conseguimos ver as prioridades
    println(priorityQueue.poll())
    println(priorityQueue.poll())
    println(priorityQueue.poll())
    println(priorityQueue.poll())
}