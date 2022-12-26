package POO_Santander_Coders.Exercicios

import java.lang.StringBuilder
import java.text.NumberFormat
import java.util.*

//TODO: Avaliar o melhor caminho

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

//end myextension functions

//testes
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

//Cliente e os diferemtes planos do Sistema Bancário
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
):Cliente(nome, sobrenome, cpf, senha,Plano.NORMAL), ContaFisica {
    private inner class CarteiraClienteNormal(
        override val senha: String = ""
    ):CarteiraFisica {
        override val tipo: TipoDeCarteira = TipoDeCarteira.NORMAL
        override var saldo: Double = .0
        override var extrato: String = """=============EXTRATO============="""
    }

    private val carteiraFisica = CarteiraClienteNormal(this.senha) as CarteiraFisica

    override fun extrairSaldo():Double{
        return carteiraFisica.extrairSaldo()
    }
    override fun emitirExtrato():String{
        return carteiraFisica.retirarExtrato()
    }

    override fun depositar(valor: Double){
        carteiraFisica.deposito(valor)
    }

    override fun saque(valor: Double){
        carteiraFisica.saque(valor)
    }
    override fun pagarBoleto(valor: Double){
        carteiraFisica.pagueBoleto(valor)
    }
}
private data class ClientePremium(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String,
):Cliente(nome, sobrenome, cpf, senha, Plano.PREMIUM), ContaDigital, ContaFisica{
    private inner class CarteiraClientePremium(
        override val senha: String = ""
    ):CarteiraDigital, CarteiraFisica {
        override val tipo: TipoDeCarteira = TipoDeCarteira.PREMIUM
        override var saldo: Double = .0
        override var extrato: String = """=============EXTRATO============="""
    }
    private val carteiraDigital = CarteiraClientePremium(senha) as CarteiraDigital
    private val carteiraFisica = CarteiraClientePremium(senha) as CarteiraFisica

    override fun extrairSaldo():Double{
        return carteiraFisica.extrairSaldo()
    }
    override fun emitirExtrato():String{
        return carteiraFisica.retirarExtrato()
    }
    override fun transferenciaPix(valor: Double){
        carteiraDigital.transferenciaPix(valor)
    }
    override fun guardar(valor: Double){
        carteiraDigital.guardar(valor)
    }
    override fun investir(valor: Double){
        carteiraDigital.investir(valor)
    }

    override fun depositar(valor: Double){
        carteiraFisica.deposito(valor)
    }
    override fun pagarBoleto(valor: Double){
        carteiraDigital.pagueBoleto(valor)
    }

    override fun saque(valor: Double){
        carteiraFisica.saque(valor)
    }
}
private data class ClienteDigital(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String,
):Cliente(nome, sobrenome, cpf, senha, Plano.DIGITAL), ContaDigital{
    private inner class CarteiraClienteDigital(
        override val senha: String = ""
    ):CarteiraDigital {
        override val tipo: TipoDeCarteira = TipoDeCarteira.DIGITAL
        override var saldo: Double = .0
        override var extrato: String = "=============EXTRATO============="
    }

    private val carteiraDigital = CarteiraClienteDigital() as CarteiraDigital

    override fun extrairSaldo():Double{
        return carteiraDigital.extrairSaldo()
    }
    override fun emitirExtrato():String{
        return carteiraDigital.retirarExtrato()
    }
    override fun transferenciaPix(valor: Double){
        carteiraDigital.transferenciaPix(valor)
    }
    override fun pagarBoleto(valor: Double){
        carteiraDigital.pagueBoleto(valor)
    }
    override fun guardar(valor: Double){
        carteiraDigital.guardar(valor)
    }
    override fun investir(valor: Double){
        carteiraDigital.investir(valor)
    }
}

// Conta, Interfaces dos métodos de Cliente
interface Conta{
    fun extrairSaldo():Double
    fun emitirExtrato():String

    fun pagarBoleto(valor: Double)
}
interface ContaFisica:Conta{
    fun depositar(valor: Double)

    fun saque(valor: Double)
}
interface ContaDigital:Conta{
    fun guardar(valor: Double)
    fun investir(valor: Double)
    fun transferenciaPix(valor: Double)
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

//Tipo de Carteiras Enum
enum class TipoDeCarteira{
    PREMIUM,
    DIGITAL,
    NORMAL
}
