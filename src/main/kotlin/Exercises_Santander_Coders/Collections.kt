fun main() {
    val mutableList: MutableList<Int> = mutableListOf(1,2,3,4)

    var exemplo: MutableList<Int> = mutableList

    mutableList[0] = 3

    exemplo = mutableListOf(1)

    println(exemplo)
    val list : List<Int> = listOf(1)

    val set: MutableSet<String> = mutableSetOf("assadsda")
    val set2: Set<String> = setOf()
    
    set.add("Aha")
//    remover se
    set.removeIf {
        it.contains(",")
    }
//    limpar
    set.clear()
//    Remover
    set.remove("Aha")

    set.forEach { 
        println(it)
    }
//    retorna um hashcode
    set.hashCode()
//    Stream
    set.stream().filter { 
        it.contains("@")
    }
    set.addAll(set2)
    
    val map : Map<Long, String>
    val map1 : MutableMap<Long, String>

}
