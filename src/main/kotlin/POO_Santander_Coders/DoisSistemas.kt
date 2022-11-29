package POO_Santander_Coders

import java.text.NumberFormat
import java.time.LocalDateTime
import java.util.*

data class Carro(var modelo:String,
                 val ano:Int,
                 val cor:String
                 )
abstract class Pessoa(open var nome:String,
                      open var idade:Int,
                      )
data class Cliente(var cpf:String,
                        var altura:Double,
                        override var nome: String,
                        override var idade: Int
                        ):Pessoa(nome,idade)
data class Animal(var tipo:String,
                  var raca:String,
                  var cor:String,
                  var idade:String
                  )
data class FuncionarioClasse(
                       var matricula:String,
                       var cargo:String,
                       override var nome: String,
                       override var idade: Int,
                ):Pessoa(nome,idade)
data class Servico(
                   var problema:String,
                   var areaAtingida:String,
                   var pecaTrocada:String,
                   var orcamento:Double,
                   val dataDoServico:LocalDateTime
                   ){
    private fun currencyFormater(number:Double):String{
        var currencyInstance = NumberFormat.getCurrencyInstance()
        val format = currencyInstance.format(number)
        return format
    }
    init {
        this.orcamento = currencyFormater(orcamento).toDouble()
    }
}

fun main() {
    var currencyInstance = NumberFormat.getCurrencyInstance()
    println(currencyInstance.currency.symbol)
    println(currencyInstance.format(6000))
}
