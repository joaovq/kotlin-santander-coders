package exercises_santander_coders.lista_de_exercicios



fun main(args: Array<String>){
    println("Digite o número total de eleitores: ")
    val numTotal = readln().toInt()
    var a = 0
    var b = 0
    var c = 0
    if (numTotal<1){
        println("Número inválido")
    }


    for ( i in 0 until  numTotal){
        println("Digite o candidato escolhido: (A,B,C)")
        val escolha = readln()
        when{
            escolha.uppercase() == "A" -> a++
            escolha.uppercase() == "B" -> b++
            escolha.uppercase() == "C" -> c++
            else->{
                println("Resposta inválida, tente novamente")
                i.dec()
            }
        }
    }

    val percentA = a.times(100).div(numTotal)
    val percentB = b.times(100).div(numTotal)
    val percentC = c.times(100).div(numTotal)

    println("""
        
        Candidato A - $a votos ($percentA%)
        Candidato B - $b votos ($percentB%)
        Candidato C - $c votos ($percentC%)
        
        
    """.trimIndent())
}