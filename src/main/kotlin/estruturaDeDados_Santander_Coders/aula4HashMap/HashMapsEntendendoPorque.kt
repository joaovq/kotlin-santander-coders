package estruturaDeDados_Santander_Coders.aula4HashMap

import kotlin.random.Random
import kotlin.system.measureNanoTime

data class User(
    val name:String,
    val phone:String
)

val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
fun randomString() = (1..10)
    .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
    .joinToString("")


fun buildRandomUser():User{
    val name = randomString()
    val phone = randomString()
    return User(name, phone)
}
fun main(args: Array<String>) {

//     O Map calcula toda vez que extrapola a capacidade inicial, então se souber
//    Colocar a capacidade inicial
//    loadFactor é o fator de carregamento e o default é 0.35
    val userHashMap:HashMap<String, User> = HashMap( 10_000_000, 1f)
    val userArraysList:ArrayList<User> = arrayListOf()
    repeat(1000){
        val user = buildRandomUser()
        userHashMap[user.phone] = user
        userArraysList.add(user)
    }

        val user = userArraysList[56]
    val timeHashMap = measureNanoTime {
        userHashMap[user.phone]
    }
    println(timeHashMap)

    val timeArrayList = measureNanoTime {
        userArraysList.firstOrNull{
            it.phone == user.phone
        }
    }
    println(timeArrayList)


}