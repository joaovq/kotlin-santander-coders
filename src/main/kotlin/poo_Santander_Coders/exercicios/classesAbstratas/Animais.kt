package poo_Santander_Coders.exercicios.classesAbstratas

abstract class Animal {
    abstract val numeroDePatas:Int

//    protected val nome:String= ""
    protected abstract val nome:String
    abstract fun alimentar()
    abstract fun emitirSom()
}

class Elefante(override val nome:String):Animal(){
    override val numeroDePatas: Int = 4
    override fun alimentar() {
        TODO("Not yet implemented")
//        Posso utilizar os atributos e as funcoes de Animal, porem não sobrescrever porque não é open,
//        nem abstract
//        nome
    }

    override fun emitirSom() {
        TODO("Not yet implemented")
    }
}

fun main(args: Array<String>) {
    val elefante = Elefante("Dumbo")
//    Não consigo acessar porque esta protegida
//    elefante.nome

}