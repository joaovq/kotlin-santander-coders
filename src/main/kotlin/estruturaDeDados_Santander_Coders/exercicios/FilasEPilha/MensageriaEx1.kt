package estruturaDeDados_Santander_Coders.exercicios.FilasEPilha

import java.util.*
import kotlin.random.Random


/*
* TODO:
*   Temos um serviço de mensageria que ao receber uma nova mensagem a coloca
*   numa fila e tenta enviar a mensagem ao destinatário, acontece que as vezes temos problemas
*   ao tentar entregar a mensagem, por isso é necessário que tentemos
*   entregar a mesma mensagemm até 3 vezes.
*   Implementar uma fila dentro do MessageBroker onde seja possível
*   retentar o envio das mensagens por pelo menos 3 vezes,
*   caso a terceira tentativa seja uma falha, descartar a mensagem.
*
* */
data class Message(
    val text: String, val recipient: String
){
    var sendAttempt:Int = 0
}

class MessageBroker {
    private val messageSender = Random(System.currentTimeMillis())
    val queue: Queue<Message> = LinkedList()
    fun processFirstMessage() {
        /*
        * Implementar maneira de processar a fila e de retentar o envio de uma mensagem que deu erro
        */
        //send(message)
//        Pega o ultimo mas não remove
        val lastMessageInQueue = queue.peek()
        val send = send(lastMessageInQueue)
        if (send && lastMessageInQueue.sendAttempt<3) {
            println("""
                
                Mensagem enviada com sucesso.
                 
                 Text: ${lastMessageInQueue.text}
                 Recipient: ${lastMessageInQueue.recipient}
                 Attempt: ${lastMessageInQueue.sendAttempt}
                 
                 
                 """.trimIndent())
            queue.poll()
        }else if(lastMessageInQueue.sendAttempt==3){
            println("""
                
                Tentativa de envio foi abortada.
                 
                 Text: ${lastMessageInQueue.text}
                 Recipient: ${lastMessageInQueue.recipient}
                 
                 
                 """.trimIndent())
            queue.poll()
        }
        else {
//            Remove o último e pega
            queue.poll()
            lastMessageInQueue.sendAttempt++
            queue.offer(lastMessageInQueue)
        }
    }

    /*
    * Retorna true ao conseguir enviar uma mensagem com sucesso e false se não conseguir
    */
    private fun send(message: Message): Boolean {
        return messageSender.nextBoolean()
    }
}


fun main(args: Array<String>) {
    val message1 = Message("Hello car", "joshue@jsn.com")
    val message2 = Message("Please give the cart", "gabriel@jmsa.com")
    val message3 = Message("Hey man, what's up?", "hesketh69@hotmail.com")
    val message4 = Message("Wait one minute, please", "Hamg_333@gmail.com")


    val messageBroker = MessageBroker()
    messageBroker.queue.offer(message1)
    messageBroker.queue.offer(message2)
    messageBroker.queue.offer(message3)
    messageBroker.queue.offer(message4)

    with(messageBroker){
        while (this.queue.isNotEmpty()){
            this.processFirstMessage()
        }
    }

}