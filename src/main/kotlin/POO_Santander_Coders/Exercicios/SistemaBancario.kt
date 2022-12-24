package POO_Santander_Coders.Exercicios

import java.lang.StringBuilder
import java.text.NumberFormat
import java.util.*

//TODO: Refazer e colocar carteiras em interfaces

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
    with(clientePremium){
        this.guardar(100.0)
        println(this.extrairSaldo().currencyFormatterBr())
        this.transferenciaPix(100.0)
        println(this.extrairSaldo().currencyFormatterBr())
        println(clientePremium.plano)
        println(emitirExtrato()+"\n")
    }


    val clienteDigital = ClienteDigital(
        nome = "Joao",
        sobrenome = "Queiroz",
        cpf = "623839-0",
        senha = "4345564"
    )
    with(clienteDigital){
        this.guardar(100.0)
        this.transferenciaPix(100.0)
        println(extrairSaldo().currencyFormatterBr())
        println(clienteDigital.plano)
        println(emitirExtrato()+"\n")
    }

    val clienteNormal = ClienteNormal(
        "Vitor",
        "Bruno",
        "17783-0",
        senha = "17730934"
    )

    with(clienteNormal){
        println("Seu saldo é: ${extrairSaldo().currencyFormatterBr()}")
        this.depositar(5000.0)
        this.saque(3000.0)
        println(extrairSaldo().currencyFormatterBr())
        println(emitirExtrato()+"\n")
    }

}


enum class Plano(var nome: String){
    NORMAL(nome = "normal"),
    DIGITAL(nome = "digital"),
    PREMIUM(nome = "premium");
}

private abstract class Cliente(
    open var nome: String,
    open var sobrenome: String,
    open val cpf: String,
    protected open var senha:String,
    val plano: Plano
    )


private data class ClienteNormal(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String
):Cliente(nome, sobrenome, cpf, senha,Plano.NORMAL) {
    inner class CarteiraClienteNormal(
        override val senha: String = ""
    ):CarteiraFisica {
        override val tipo: TipoDeCarteira = TipoDeCarteira.NORMAL
        override var saldo: Double = .0
        override var extrato: String = """=============EXTRATO============="""
    }

    private val carteiraFisica = CarteiraClienteNormal(this.senha) as CarteiraFisica

    fun extrairSaldo():Double{
        return carteiraFisica.extrairSaldo()
    }
    fun emitirExtrato():String{
        return carteiraFisica.retirarExtrato()
    }

    fun depositar(valor: Double){
        carteiraFisica.deposito(valor)
    }

    fun saque(valor: Double){
        carteiraFisica.saque(valor)
    }
    fun pagarBoleto(valor: Double){
        carteiraFisica.pagueBoleto(valor)
    }
}
private data class ClientePremium(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String,
):Cliente(nome, sobrenome, cpf, senha, Plano.PREMIUM){
    private inner class CarteiraClientePremium(
        override val senha: String = ""
    ):CarteiraDigital, CarteiraFisica {
        override val tipo: TipoDeCarteira = TipoDeCarteira.PREMIUM
        override var saldo: Double = .0
        override var extrato: String = """=============EXTRATO============="""
    }
    private val carteiraDigital = CarteiraClientePremium(senha) as CarteiraDigital
    private val carteiraFisica = CarteiraClientePremium(senha) as CarteiraFisica

    fun extrairSaldo():Double{
        return carteiraFisica.extrairSaldo()
    }
    fun emitirExtrato():String{
        return carteiraFisica.retirarExtrato()
    }
    fun transferenciaPix(valor: Double){
        carteiraDigital.transferenciaPix(valor)
    }
    fun guardar(valor: Double){
        carteiraDigital.guardar(valor)
    }
    fun investir(valor: Double){
        carteiraDigital.investir(valor)
    }

    fun depositar(valor: Double){
        carteiraFisica.deposito(valor)
    }
    fun pagarBoleto(valor: Double){
        carteiraDigital.pagueBoleto(valor)
    }

    fun saque(valor: Double){
        carteiraFisica.saque(valor)
    }
}

private data class ClienteDigital(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String,
):Cliente(nome, sobrenome, cpf, senha, Plano.DIGITAL){
    private inner class CarteiraClienteDigital(
        override val senha: String = ""
    ):CarteiraDigital {
        override val tipo: TipoDeCarteira = TipoDeCarteira.DIGITAL
        override var saldo: Double = .0
        override var extrato: String = "=============EXTRATO============="
    }

    private val carteiraDigital = CarteiraClienteDigital() as CarteiraDigital


    fun extrairSaldo():Double{
        return carteiraDigital.extrairSaldo()
    }
    fun emitirExtrato():String{
        return carteiraDigital.retirarExtrato()
    }
    fun transferenciaPix(valor: Double){
        carteiraDigital.transferenciaPix(valor)
    }
    fun pagarBoleto(valor: Double){
        carteiraDigital.pagueBoleto(valor)
    }
    fun guardar(valor: Double){
        carteiraDigital.guardar(valor)
    }
    fun investir(valor: Double){
        carteiraDigital.investir(valor)
    }

}

// Carteiras
interface Carteira{
     val senha: String
     val tipo:TipoDeCarteira
     var saldo:Double
     var extrato:String

      fun pagueBoleto(valor: Double){
         extrato = extrato.concat("Pagamento de boleto efetuado de valor ${valor.currencyFormatterBr()}")
         println("Pagamento de boleto efetuado de valor ${valor.currencyFormatterBr()}")
     }
    fun extrairSaldo(): Double {
        return saldo
    }
    fun retirarExtrato():String{
        return extrato
    }
}

interface CarteiraFisica :Carteira{
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
interface CarteiraDigital:Carteira{
    fun transferenciaPix(valor: Double){
        saldo-=valor
        extrato = extrato.concat("Transferencia de pix realizada, valor: ${valor.currencyFormatterBr()}")
        println("Transferencia de pix realizada, valor: ${valor.currencyFormatterBr()}")
    }
    fun investir(valor:Double){
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
    fun guardar(valor: Double){
        saldo = saldo.plus(valor)
        extrato = extrato.concat("O valor de ${valor.currencyFormatterBr()} foi guardado")
        println("O valor de ${valor.currencyFormatterBr()} foi guardado")
    }
}



//Tipo de Carteiras

enum class TipoDeCarteira{
    PREMIUM,
    DIGITAL,
    NORMAL
}
