
fun main() {
    val mutableList: MutableList<Int> = mutableListOf(1,2,3,4)
    val a = arrayOf(12,3,4,5)
    val b = listOf(1,3,4,5,*a)

    var exemplo: MutableList<Int> = mutableList

    mutableList[0] = 3

    exemplo = mutableListOf(1)

    val string:String


    println(exemplo)
    val list : List<Int> = listOf(1)

    val set: MutableSet<String> = mutableSetOf(elements = arrayOf("ahs", "jdsahfs", "adsdas", "jadshbj"))
    val set2: Set<String> = setOf()

    set.add("Aha")
//    remover se
    set.removeIf {
        it.contains(",")
    }

    println(set)
//    limpar
    set.clear()
//    Remover
    set.remove("Aha")

    set.forEach {
        println(it)
//        ver se é menor que o parametro passado
//        it.coerceAtLeast("fdg");
    }
//    retorna um hashcode
    set.hashCode()
//    Stream
    set.stream().filter {
        it.contains("@")
    }
    set.addAll(set2)

    set.retainAll{
        it.startsWith("23")
    }
    val int :Int
    val map : Map<Long, String>
    val map1 : MutableMap<Long, String>

}
/*

Você pode marcar um parâmetro de uma função (geralmente o último) com o modificador vararg:

Dentro de uma função, um parâmetro vararg do tipo T é visível como um array de T,
como no exemplo acima, onde a variável ts tem o tipo Array<out T>.

Apenas um parâmetro pode ser marcado como vararg. Se um parâmetro vararg não for o último da lista,
os valores para os parâmetros subsequentes podem ser passados usando a sintaxe de argumento nomeado ou,
se o parâmetro tiver um tipo de função, passando um lambda fora dos parênteses.

Quando você chama uma função vararg, você pode passar argumentos individualmente, 
por exemplo asList(1, 2, 3). Se você já possui um array e deseja passar seu conteúdo para a função, 
use o operador spread (prefixe o array com *):

*/



fun teste(vararg args:Int){

}

fun teste(args: ()->Unit){

}
