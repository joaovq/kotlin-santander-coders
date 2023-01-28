package tecnicasDeProgramacao.aula1.introduction

fun somar(a: Int, b: Int): Int {
    val somar = a + b
    return somar
}

fun mostraSoma(s:(Int, Int) -> Int){
    val resultado = s(20, 10)
    println(resultado)
}


//HOF com FunctionType
val soma: (Double, Double) -> Double = { x, y -> x + y }
val subtrai: (Double, Double) -> Double = { x, y -> x - y }
val divide: (Double, Double) -> Double = { x, y -> x / y }
val multiplica: (Double, Double) -> Double = { x, y -> x * y }

fun calculadora(x: Double, y: Double, operacao: (Double, Double) -> Double): Double {
    return operacao(x, y)
}
// ---

fun main(){
    /**
    * High order functions são funções
     * que recebem uma função ou mais como argumento,
     * retornando outra função;
    */
    mostraSoma(::somar)
    println(Int::and)
    val calc = calculadora(50.0, 10.0, subtrai)
    println(calc)
}