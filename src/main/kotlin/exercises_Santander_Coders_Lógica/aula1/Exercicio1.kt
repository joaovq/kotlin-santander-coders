package exercises_Santander_Coders_Lógica.aula1

/*
* TODO:
*  1 - Faça um algoritimo que receba o comprimento do lado de um
*  quadrado e calcule sua área e seu perímetro.
*  Exemplo:Digite o lado do do quadrado: 12
*  A area do quadrado e de 144 e seu perimetro de 48
* */

fun main(args: Array<String>) {
    println("""Digite o lado do quadrado: """)
    val ladoDoQuadrado: Int? = readln().toIntOrNull()

//    Calculo da área

    val area = ladoDoQuadrado?.times(ladoDoQuadrado)
//    Cálculo do perimetro
    var perimetro : Int? = 0
    for (i in 1..4){
        perimetro  = ladoDoQuadrado?.plus(ladoDoQuadrado)
    }
//      Print dos resultados
    println("A área do quadrado é de $area e seu perimetro é de $perimetro")

}