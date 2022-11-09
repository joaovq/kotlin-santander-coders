package logicExercises

fun main(args: Array<String>) {
    val sum = sum(1, 2)
    println(sum)
    val  subtract = subtract(1, 2)
    println(subtract)
    val multiply = multiply(5, 4)
    println(multiply)
    val divider = divider(2, 4)
    println(divider)

    val odd = isOdd(4)

    val a = 6
    val b = 5

    val result = a/b.toDouble()


    println("É par? $odd")
}

fun sum(a:Int,b:Int): Int {
    return a+b
}
fun subtract(a:Int,b:Int): Int {
    return a-b
}
fun multiply(a:Int,b:Int): Int {
    return a*b
}
fun divider(a:Int,b:Int): Double {
    return a/b.toDouble()
}
fun isOdd(num:Int):Boolean{
    val odd = num % 2 == 0
    if (odd){
        return true
    }
    return false
}

