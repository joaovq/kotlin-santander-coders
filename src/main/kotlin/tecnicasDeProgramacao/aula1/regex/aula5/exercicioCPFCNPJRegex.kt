package tecnicasDeProgramacao.aula1.regex.aula5

// Faça uma regex que valide um cpf no formato nnn.nnn.nnn-nn

fun String.isValidCpf():Boolean{
    val regex:Regex = Regex("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")

    return regex.matches(this)
}
fun String.isValidCnpj():Boolean{
    val regex:Regex = Regex("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")

    return regex.matches(this)
}
fun String.isValidCpfCnpj():Boolean{
    val regex = Regex(
        "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$" +
                "|^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}\$"
    )

    return regex.matches(this)
}
fun main() {

//    TESTES CPF

    println("CPF\n\n")

    println("Is valid CPF? ${"078.126.355-70".isValidCpf()}")// true
    println("Is valid CPF? ${"505.126.355-70".isValidCnpj()}")//true
    println("Is valid CPF? ${"505.126.355-0".isValidCpf()}")//false
    println("Is valid CPF? ${"505.1l6.355-70".isValidCpf()}\n\n")//false

    println("CNPJ\n\n")

    println("Is valid CNPJ? ${"50.186.355/7777-70".isValidCnpj()}")//true
    println("Is valid CNPJ? ${"50.186.3557777-70".isValidCnpj()}\n\n")//false

    println("CPF e CNPJ\n\n")

    println("Is valid CNPJ? ${"50.186.355/7777-70".isValidCpfCnpj()}")//true
    println("Is valid CNPJ? ${"50.186.3557777-70".isValidCnpj()}")//false
    println("Is valid CPF? ${"078.126.355-70".isValidCpfCnpj()}")// true
    println("Is valid CPF? ${"505.126.355-70".isValidCpfCnpj()}")//true
    println("Is valid CPF? ${"505.176.55-70".isValidCpf()}\n\n")//false
}