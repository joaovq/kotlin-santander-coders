package estruturaDeDados_Santander_Coders.aula2

import java.util.LinkedList
import java.util.Queue

data class TicketRequest(
    val name:String,
     val waitingTime:Int = (1..20).random()
)

class TicketManager{
    private val queue: Queue<TicketRequest> = LinkedList()
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