package estruturaDeDados_Santander_Coders.aula2FilaFilaPrioritaria


import java.util.PriorityQueue
import java.util.Queue

data class TicketRequest1(
    val name:String,
     val waitingTime:Int = (1..20).random()
)

class TicketManager1{
//    O PriorityQueue implementa o Queue
    private val queue: Queue<TicketRequest> = PriorityQueue{
        new, inQueue->
//    Priorizando
        if (new.waitingTime>=10) 1
        else if (new.waitingTime in 7..9 && inQueue.waitingTime<new.waitingTime) -1
//        Despriorizando
        else if(new.waitingTime>inQueue.waitingTime) 1
        else 0
    }
    private var currentTicketRequest: TicketRequest? = null
    /*
    * Criar uma estrutura para tratar um ticket de suporte, tratar apenas com waiting time
    * menor que 10
    *
    * */

    fun addRequest(ticket: TicketRequest){
        queue.offer(ticket)
    }

    fun callTickets(){
        while (queue.isNotEmpty()){
            currentTicketRequest = queue.poll()
            if (currentTicketRequest?.waitingTime!! >10) {
                println("Tempo de espera maior do que 10")
                println("Ticket cancelado: $currentTicketRequest")
            }
            else{
                println("Ticket chamado: $currentTicketRequest")
            }
        }
    }

    fun getNextTicket(): TicketRequest {
        return queue.peek()
    }
}