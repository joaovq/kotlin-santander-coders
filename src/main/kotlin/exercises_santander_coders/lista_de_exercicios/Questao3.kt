package exercises_santander_coders.lista_de_exercicios

fun main(args: Array<String>) {
    val mutableList:MutableList<Int> = mutableListOf()
    val list: List<Int> = listOf()

    for (i in 1..15){
        val num = readln().toIntOrNull()
        mutableList.add(num?:0)
    }

//    Revertendo a lista
    mutableList.reverse()

    /*  mutableList.forEach {
          println(it)
      }*/
    println(mutableList)

}