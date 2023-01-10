package estruturaDeDados_Santander_Coders.aula4HashMap

import java.lang.Math.abs
import java.util.LinkedList
import kotlin.math.absoluteValue

data class HashMap2<K,V>(
    private val buckets:Array<LinkedList<Pair<K,V>>?> = arrayOfNulls(16)
) {

    fun put(key: K, value: V) {
        val index = abs(key.hashCode() % buckets.size)

        var bucket = buckets[index]
        if (bucket == null) {
            bucket = LinkedList()
            buckets[index] = bucket
            bucket.add(Pair(key, value))
        } else {
            for (index in bucket.indices) {
                if (bucket[index].first == key) {
                    bucket[index] = key to value
                    return
                }
            }
            bucket.add(Pair(key, value))
        }
    }

    fun get(key:K):Pair<K, V>?{
        val index = abs(key.hashCode() % buckets.size)

        val bucket = buckets[index] ?: return null

        return bucket.firstOrNull{
            it.first == key
        }
    }

    fun remove(key: K){
        val index = abs(key.hashCode() % buckets.size)

        val bucket = buckets[index]


        if (bucket !=null){
            for (i in bucket.indices){
                if (bucket[i].first == key){
                    bucket.removeAt(i)
                    return
                }
            }
        }
//        Outra forma
        /*val indexOfFirst = bucket?.indexOfFirst { it.first == key }?:null
        if (bucket != null){
            bucket.removeAt(indexOfFirst!!)
        }*/
        return
    }
/*Outra solução
*   fun remove(key: K) {
        val index = abs(key.hashCode() % buckets.size)
        val bucket = buckets[index]

        if (bucket != null) {
            bucket.removeIf { it.first == key }
        }
    }
*
*
*
* */

}

data class Person(
    val name:String
)


fun main(args: Array<String>) {
//    Os adicionados são colocados na ordem
    val hashmap = LinkedHashMap<Person, String>()
    hashmap.put(Person("a"), "b")
    hashmap.put(Person("a"), "c")
    hashmap.put(Person("b"), "c")
    hashmap.put(Person("bc"), "c")
    hashmap.put(Person("bd"), "c")
    hashmap.put(Person("bea"), "c")
    hashmap.put(Person("easdf"), "c")
    hashmap.put(Person("easdf3"), "c")
    println(hashmap)

    hashmap.remove(Person("bd"))

    println(hashmap)
}