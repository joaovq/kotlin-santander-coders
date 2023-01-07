package poo

fun main(args: Array<String>) {
    val joao=Person(firstName = "João Vítor", lastName = "Queiroz Santos", age = 13)
//   TODO: Construtor Vazio somente possivel com valores padrões
    var denis = Person()
    Person(lastName = "Queiroz")


//    TODO:Não pode criar sozinho
//    Person(age = 32)

}

//  TODO:Valores padrões no construtor
class Person(firstName:String = "Denis", lastName:String = "Panjuta"){
//    TODO:Podemos atribuir desta forma também
//    var firstName: String = firstName
//    var lastName: String = lastName
    var age:Int? =null
    var hobby:String = "watch Netflix"
    var firstName:String? =null

    init {
//        TODO:Podemos atribuir desta forma
        this.firstName=firstName
        println("Instance of Person $firstName $lastName")
    }

//    TODO: construtor secundário com age
    constructor(firstName: String, lastName: String,age:Int):this(firstName, lastName){
        this.age = age
    }


    fun stateHobby(){
        println("$firstName\'s hobby is $hobby")
    }
}