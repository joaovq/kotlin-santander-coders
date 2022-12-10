package POO_Santander_Coders.Exercicios.Herança

import kotlin.math.PI
import kotlin.math.pow

open class Forma{
    open val unidade:String = ""
}
open class Forma2D(override val unidade: String): Forma(){
    open  val area:Double =0.0
    open fun calcularArea():String{
        return ""
    }
}

class Circulo(val raio:Double, unidade: String): Forma2D(unidade) {

    override val area: Double = raio.pow(2)* PI

    override fun calcularArea(): String {
        return "$area $unidade²"
    }
}
open class Forma3D(override val unidade: String): Forma(){
    open val volume:Double = 0.0
    open fun calcularVolume():String{
        return ""
    }
}

class Piramide(val areaDaBase:Double, val altura:Double, unidade: String): Forma3D(unidade){
    override val volume: Double= areaDaBase*altura/3

    override fun calcularVolume(): String {
        return "$volume $unidade³"
    }
}

class Cone(val raio:Double, val altura:Double, unidade: String): Forma3D(unidade){
    override val volume: Double= PI*raio.pow(2)*altura/3

    companion object{
//        podemos fazer uma constante privada em companions objects e No escopo global de uma file
        private const val NUMERO_PI = PI
    }

    override fun calcularVolume(): String {
        return "$volume $unidade³"
    }
}