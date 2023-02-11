package tecnicasDeProgramacao.aula8.extension

import kotlinx.coroutines.delay
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private fun regexToPattern(pattern : String) = Regex(pattern)


// Validate from pattern an String
fun String.matcherFromPattern(pattern : String) =
    regexToPattern(pattern).matches(this)
fun LocalDate.matcherFromPattern(pattern : String) =
    try {
        val format = DateTimeFormatter.ofPattern(pattern).format(this)
        println("Data é válida : $format")
        true
    } catch (e : IllegalArgumentException){
        e.printStackTrace()
        false
    } catch (e : DateTimeException){
        e.printStackTrace()
        false
    }
