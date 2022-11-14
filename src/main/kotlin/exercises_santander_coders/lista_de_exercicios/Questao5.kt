package exercises_santander_coders.lista_de_exercicios

fun main(args: Array<String>) {
    println("Digite um número máximo: ")
    val maxNumber = readln().toInt()
    if (maxNumber<1){
        println("Número inválido, repita a execução do programa!")
        return
    }


    println("Números ímpares entre 1 e $maxNumber")

    println( (1..maxNumber).filter { num -> num%2 != 0 })

}