package tecnicasDeProgramacao.aula1.regex.aula5

fun main() {
    val regex = regex("gmail")

    println(regex.matches("joaovqdev@gmail.com"))
    println(regex.matches("joaovqdev@gmail.com.br"))
}

private fun regex(provider:String): Regex {
    val regex = Regex("[a-zA-Z0-9^~'`]{3,30}@$provider\\.com|[a-zA-Z0-9^~'`]{3,30}@$provider\\.com\\.br")
    return regex
}