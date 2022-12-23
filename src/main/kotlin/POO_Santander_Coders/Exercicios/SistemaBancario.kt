package POO_Santander_Coders.Exercicios

import java.lang.StringBuilder
import java.text.NumberFormat
import java.util.*

//TODO: Refazer e colocar carteiras em interfaces
//TODO: Tirar asserted!!

// my extensions functions
fun currencyFormatter(number: Double):String{
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))
    return currencyInstance.format(number)
}

fun Double.currencyFormatterBr():String{
    return currencyFormatter(this)
}

fun String.concat(appendable: String):String{
    val stringBuilder = StringBuilder(this)
    stringBuilder.append("\n$appendable")
    return stringBuilder.toString()
}


fun main(args: Array<String>) {
    val clientePremium = ClientePremium(
        nome = "Joao",
        sobrenome = "Queiroz",
        cpf = "623839-0",
        senha = "4345564"
    )
    with(clientePremium.carteiraDigital){
        this.guardar(100.0)
        println(this.saldo)
        this.transferenciaPix(100.0)
        println(this.saldo)
        println(clientePremium.plano)
        println(extrato+"\n")
    }


    val clienteDigital = ClienteDigital(
        nome = "Joao",
        sobrenome = "Queiroz",
        cpf = "623839-0",
        senha = "4345564"
    )
    with(clienteDigital.carteiraDigital){
        this.guardar(100.0)
        println(this.saldo.currencyFormatterBr())
        this.transferenciaPix(100.0)
        println(this.saldo.currencyFormatterBr())
        println(clienteDigital.plano)
        println(extrato+"\n")
    }

    val clienteNormal = ClienteNormal(
        "Vitor",
        "Bruno",
        "17783-0",
        senha = "17730934"
    )

    with(clienteNormal.carteiraFisica){
        println("Seu saldo é: ${saldo.currencyFormatterBr()}")
        this.deposito(5000.0)
        this.saque(3000.0)
        println(saldo.currencyFormatterBr())
        println(extrato+"\n")
    }

}

private abstract class PessoaFisica(
    open var nome:String,
    open var sobrenome:String,
    open val cpf:String
)

enum class Plano(var nome: String,var  carteiraFisica: CarteiraFisica? = null,var carteiraDigital: CarteiraDigital? = null){
    NORMAL(nome = "normal", carteiraFisica = CarteiraFisica()),
    DIGITAL(nome = "digital", carteiraDigital = CarteiraDigital()),
    PREMIUM(nome = "premium", carteiraFisica = CarteiraFisica(), carteiraDigital = CarteiraDigital());
}

private abstract class Cliente(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    protected open var senha:String
    ):PessoaFisica(nome, sobrenome, cpf){
        abstract val plano: Plano

//        TODO:Cliente deveria ter métodos que acessem as suas carteiras, estas deveriam estar privadas para acesso;
    }


private data class ClienteNormal(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String
):Cliente(nome, sobrenome, cpf, senha){

    override val plano = Plano.NORMAL
    val carteiraFisica = plano.carteiraFisica!!
}
private data class ClientePremium(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String
):Cliente(nome, sobrenome, cpf, senha) {

    override val plano: Plano = Plano.PREMIUM

    val carteiraFisica = plano.carteiraFisica!!
    val carteiraDigital =plano.carteiraDigital!!

}

private data class ClienteDigital(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String
):Cliente(nome, sobrenome, cpf, senha){

    override val plano = Plano.DIGITAL
        get() = field

    val carteiraDigital: CarteiraDigital = plano.carteiraDigital!!

}

interface Carteira{
     val senha: String
     val tipo:String
     val saldo:Double
     var extrato:String

     fun pagueBoleto(valor: Double){
         extrato = extrato.concat("Pagamento de boleto efetuado de valor ${valor.currencyFormatterBr()}")
         println("Pagamento de boleto efetuado de valor ${valor.currencyFormatterBr()}")
     }
}

open class CarteiraFisica() :Carteira{


    override var senha: String = ""
    override var tipo: String  = ""
    override var saldo: Double = 0.0
    override var extrato: String = """
        ============EXTRATO============
    """.trimIndent()
    fun saque(valor: Double){
        if (saldo.minus(valor)>0.0){
            saldo=saldo.minus(valor)
            extrato = extrato.concat("Saque efetuado no valor de :${valor.currencyFormatterBr()}")
            println("Saque efetuado.")
        }
        else{
            saldo = 0.0
        }
    }
    fun deposito(valor: Double){
        saldo = saldo.plus(valor)
        extrato = extrato.concat("Deposito de ${valor.currencyFormatterBr()} foi efetuado")
        println("Deposito de ${valor.currencyFormatterBr()} foi efetuado")
    }
}
open class CarteiraDigital:Carteira{

    override var senha: String = ""
    override var tipo: String = ""
    override var saldo: Double = 0.0
    override var extrato: String = """
        ============EXTRATO============
    """.trimIndent()

    open fun transferenciaPix(valor: Double){
        saldo-=valor
        extrato = extrato.concat("Transferencia de pix realizada, valor: ${valor.currencyFormatterBr()}")
        println("Transferencia de pix realizada, valor: ${valor.currencyFormatterBr()}")
    }
    open fun investir(valor:Double){
        if (saldo.minus(valor)>0.0){
            this.saldo=saldo.minus(valor)
            saldo=0.0
            extrato = extrato.concat("Investindo o dinheiro ${valor.currencyFormatterBr()}")
            println("Investindo o dinheiro ${valor.currencyFormatterBr()}")
        }
        else{
            println("Deposite mais dinheiro para investir")
        }


    }
    open fun guardar(valor: Double){
        saldo = saldo.plus(valor)
        extrato = extrato.concat("O valor de ${valor.currencyFormatterBr()} foi guardado")
        println("O valor de ${valor.currencyFormatterBr()} foi guardado")
    }
}


