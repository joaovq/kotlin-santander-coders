package exercises_Santander_Coders_Lógica.aula1

/* TODO:2 - Faça um algoritimo que leia a base e a altura de um triangulo e calcule a sua area.
       F => base*altura/2
*
*
*
* */
fun main(args: Array<String>) {
    println("Digite a base do triângulo:")
    val base :Int?= readln().toIntOrNull()
    println("Digite a altura do triângulo:")
    val altura :Int?= readln().toIntOrNull()

//    Cálculo da área

//    val baseAltura:Int? = altura?.let { base?.times(it) }
//    asserta que não é null (!!)
    println(base)
    val baseAltura:Int? = base?.times(altura!!)

    val area = baseAltura?.div(2)

    println("A área do triagulo de base $base e altura $altura é $area")

}