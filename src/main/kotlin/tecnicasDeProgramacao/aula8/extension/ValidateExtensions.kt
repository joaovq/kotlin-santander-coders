package tecnicasDeProgramacao.aula8.extension

import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.LocalDate


private fun regexToPattern(pattern : String) = Regex(pattern)


// Validate from pattern an String
fun String.matcherFromPattern(pattern : String) =
    regexToPattern(pattern).matches(this)
fun LocalDate.matcherFromPattern(pattern : String) =
    try {
        SimpleDateFormat(pattern).format(this)
        true
    } catch (e : DateTimeException){
        false
    }
