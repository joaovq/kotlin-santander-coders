package estruturaDeDados_Santander_Coders.aula7

fun combineSets(set: LinkedHashSet<Int>){

}

fun main(args: Array<String>) {
//    Imutavel
//    Como default é um linkedHashSet
//    Para um volume pequeno de dados, não tem problema usar
    val set = setOf(1,2,3,4,5,6,7,9,12)
//    Mutavel
    val set2 = HashSet<Int>()

    set2.add(1)
    set2.add(12)
    set2.add(4)
    set2.add(4)
    set2.add(1)
    set2.add(7)

    set.forEach{
        print("$it ")
    }
    set.forEach{
        print("$it ")
    }

}