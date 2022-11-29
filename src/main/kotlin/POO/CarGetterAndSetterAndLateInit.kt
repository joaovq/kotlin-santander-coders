package POO

import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    var car = Car()
    car.owner = "Frank"

    println("My car brand is ${car.myBrand}")
    car.maxSpeed = 400
    println("Max speed is ${car.maxSpeed}")
//  TODO: Não podemos assinar fora da classe pois o set é privado
//    car.myModel = "M3"
    val carModel = CarModel()
    val (name) = carModel.copy()
    carModel.toString()
}


class Car(){
    lateinit var owner:String
    var myBrand:String = "BMW"
//       TODO: Getter customizado
         get() {
//  TODO:  Não podemos refereciar o a propriedade pelo nome pois gera uma StackOverFlowException
//            myBrand.  Por isso utilizamos field
            return field.lowercase()
        }
    var maxSpeed:Int = 250
         get() = field
         set(value) {
            field = if (value>0) value
            else throw IllegalArgumentException("Max Speed cannot less than 0")
        }
    var myModel:String = "M5"
        private set
    init {
//    TODO:    Aqui podemos mudar com o private set
        this.myModel ="M3"
//        TODO:Se fizer isso, torna-se desnecessário o late init
//        this.owner = "Frank"
    }

    override fun toString(): String {
        return "Car(owner='$owner', myBrand='$myBrand', maxSpeed=$maxSpeed, myModel='$myModel')"
    }

}
data class CarModel(var name:String  = "M3",
                    var maxSpeed:Int = 120
                    )