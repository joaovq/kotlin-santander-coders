package exercises_santander_coders.lista_de_exercicios

fun main(args: Array<String>) {
    println("Digite um número máximo: ")
    val maxNumber = readln().toInt()
    val listNumPrimos  : MutableList<Int> = mutableListOf()
    if (maxNumber<1){
        println("Número inválido, repita a execução do programa!")
        return
    }


    println("Números primos entre 1 e $maxNumber")

   for (i in 1..maxNumber){
       if ((2 until i).none { i % it == 0 })
            listNumPrimos.add(i)
   }

    println(listNumPrimos)
//    Utilizando o método filter

    val listNumPrimosFilter = (1..maxNumber).
                                        filter { (2 until it).
                                        none { num -> num % it == 0 } }

    println("Pelo método filter $listNumPrimos")
}