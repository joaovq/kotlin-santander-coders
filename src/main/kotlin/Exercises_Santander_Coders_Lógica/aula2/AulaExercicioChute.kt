package Exercises_Santander_Coders_Lógica.aula2

fun main(args: Array<String>) {
    println("Digite o mínimo:")
    val minimo = readln().toIntOrNull()
    println("Digite o máximo:")
    val maximo = readln().toIntOrNull()

//    val random = Random.nextInt(range = IntRange(minimo!!, maximo!!+1))
//    Metodo do IntRange (random())
    val random = (minimo!!..maximo?.plus(1)!!).random()
//    ou
//    val random = Random.nextInt(minimo!!, maximo!!)

    var chute :Int?

    do {
        println("Faça o seu chute")
        chute = readln().toIntOrNull()
        /*if (chute == random){
            break
        }
        else if(chute!! < random){
            println("O número é maior que $chute")
        }
        else{
            println("O número é menor que $chute")
        }*/

        when{
            chute == random -> break
            chute!! < random  -> println("O número é maior que $chute")
            true -> TODO()
//            Não implementa, utilizamos para indicar que é para fazer
//            Simplificando, ele não ira fazer nada
            false -> TODO()
            else -> println("O número é menor que $chute")
        }
    }while (chute != random)


    println("Parabéns, você acertou!")

}