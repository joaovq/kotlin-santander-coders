package EstruturaDeDados_Santander_Coders.Aula1

import java.util.*
import kotlin.coroutines.CoroutineContext

class Radio{
    private val queue:Queue<String> = LinkedList()
    private var currentSong:String? = null

    fun addNewSong(song:String){
        queue.add(song)
    }
    fun play(){
        while (queue.isNotEmpty()){
//            Pega o ultimo
            currentSong = queue.peek()
            println("Música: $currentSong")
            currentSong = queue.poll()
        }
    }

    fun getNextSong():String{
        return queue.poll()
    }
}

fun main(args: Array<String>) :Unit = run{
    val radio:Radio = Radio()

}