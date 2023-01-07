package estruturaDeDados_Santander_Coders.aula2

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class Radio {
    private val queue: Queue<String> = LinkedList()
    private var currentSong: String? = null

    fun addNewSong(song: String) {
        queue.offer(song)
    }

    suspend fun play() {
        while(queue.isNotEmpty()) {
            currentSong = queue.poll()
            println("Musica: " + currentSong)
            println("Proxima musica: " + getNextSong())
            delay(1000)
        }
    }

    fun getNextSong(): String? {
        return queue.peek()
    }
}

//coroutines imported of kotlinx
fun main(): Unit = runBlocking {
    val radio = Radio()
    radio.addNewSong("Primeira musica")
    launch {
        radio.play()
    }

    launch {
        radio.addNewSong("Segunda música")
        radio.addNewSong("Terceira música")
        radio.addNewSong("Quarta música")
        radio.addNewSong("Quinta música")
        delay(500)
        radio.addNewSong("Sexta música")
    }
}