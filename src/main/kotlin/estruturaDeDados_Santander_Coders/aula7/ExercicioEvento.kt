package estruturaDeDados_Santander_Coders.aula7

//Todo evento tem  uma hora
data class Event (
    val name:String,
    val time:Int = 1
)

class Calendar(
    val events:HashSet<Event>
){
//    O inserir deve garantir que o evento pode ser adicionado
//    encontrar os eventos iguais em duas agendar (quando tem o mesmo nome e horário)
//    Encontrar os horários vazios nas duas agendas (das 8 as  18)
    fun addEvent(event: Event){
        if (events.contains(event)){
            println("The event was added previously")
            return
        }
        else{
            events
        }
    }
}