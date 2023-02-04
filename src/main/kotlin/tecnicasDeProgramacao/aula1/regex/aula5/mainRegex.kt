package tecnicasDeProgramacao.aula1.regex.aula5

fun main() {
    val patternNumbers = Regex("^\\d+")
// pegar um digito(mesma coisa de 0-9)    Regex("^\\d")
//   ponto como caracter Regex("^[0-9]{3}\\.[0-9]{3}")
//                   Regex("^3{3}[0-9]{3}")
//         quantidade de digitos  Regex("^3[0-9]{3}")
//                    Regex("[0-9]")
//                    Regex("[0-9]*")
//                      Regex("1")
    val numberTests = "333.000"
    println("Number tests: ${patternNumbers.matches(numberTests)}")



    val patternLetters = Regex("[\\w]")

//    todas as letras de a - zA-Z mesma coisa Regex("[\\w]")
//           range de caracteres Regex("[a-zA-Z]{3,40}")
//                   Regex("[a-zA-Z]{3}")
//    Regex("[a-z]+")
    val letterTests = "sajdsfjnsdjfsd"
    println("Letter tests: ${patternLetters.matches(letterTests)}")
}