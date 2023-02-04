package tecnicasDeProgramacao.aula1.regex.aula5

fun main() {
    val regex = Regex("\\([0-9]{2}\\)\\s9\\d{4}-\\d{4}")

    println(regex.matches("(23) 94326-1672"))
    println(regex.matches("(53) 993a6-1672"))
}