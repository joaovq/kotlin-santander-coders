package estruturaDeDados_Santander_Coders.aula4HashMap

data class Event(
    val title: String,
    val time: Long,
    val day: Int
)

data class Calendar(
    private val agenda: HashMap<Int,MutableList<Event>> = hashMapOf()
) {

    fun newEvent(event: Event) {
        if (agenda.containsKey(event.day)){
            agenda[event.day]?.add(event)
        }else{
            agenda[event.day] = mutableListOf(event)
        }
    }

    fun getEventsForTheDay(day: Int): List<Event> = agenda[day]?: emptyList()
}

fun main() {
    val calendar = Calendar()
    calendar.newEvent(Event("dsahdfus", 28L, 3))
    calendar.newEvent(Event("asdhi", 28L, 4))
    calendar.newEvent(Event("dsahdfus", 28L, 4))
    calendar.newEvent(Event("dasads", 28L, 4))
    calendar.newEvent(Event("dsahdwwdfus", 28L, 4))

    val eventsForTheDay = calendar.getEventsForTheDay(4)
    println(eventsForTheDay)
}