package EstruturaDeDados_Santander_Coders.Aula2

import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.PriorityQueue
import java.util.Queue

/*
* TODO:Definir classe de pessoa (nome e idade)
*  Criar a estrutura de banco (fila, novas pessoas entram no banco, atende)
*  Caso a pessoa tenha mais de 60 anos ela te prioridade na fila
* */

data class Person(
    val name:String,
    val age:Int
)/*:Comparable<Person>{
    override fun compareTo(other: Person): Int {
        return if (age<60) 1
            else if(age>other.age) 0
            else -1
    }

}*/
//Podemos implementar a interface Comparable<T> e utilizar o compareTo

//Podemos utilizar o nó para pegar o tempo
data class Node(val person: Person, val timestamp: Timestamp)
class Banco{
    private val priorityQueue:Queue<Person> = PriorityQueue{
        new, inQueue->
            if (new.age>60) -1
            else if(new.age>inQueue.age) 0
            else 1
    }

    private var currentPerson:Person? = null


    fun addInQueue(pessoa: Person){
        priorityQueue.offer(pessoa)
//        Pelo timestamp
//        priorityQueue.offer(Node(pessoa, timestamp = Timestamp.valueOf(LocalDateTime.now())))
    }

    fun execute(){
        while (priorityQueue.isNotEmpty()){
            currentPerson = priorityQueue.poll()
            println("Pessoa chamada: $currentPerson")
        }
    }

    fun getNextPerson():Person{
        return priorityQueue.peek()
    }
}

fun main(args: Array<String>) {
    val banco = Banco()
    banco.addInQueue(Person("Joao", 20))
    banco.addInQueue(Person("Carla", 60))
    banco.addInQueue(Person("Bernardo", 70))
    banco.addInQueue(Person("Vitor", 15))
    banco.addInQueue(Person("Joao", 71))

    banco.execute()
}