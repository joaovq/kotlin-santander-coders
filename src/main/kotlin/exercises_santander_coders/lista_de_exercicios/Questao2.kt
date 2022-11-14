package exercises_santander_coders.lista_de_exercicios

fun main(args: Array<String>) {
    for (i in 1..10){
        println("Tabuada de $i")
        for (j in 1..10){
            val result = i*j
            println("$i x $j = $result")
        }
        println("\n")
    }
}