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
    with(clientePremium){
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
    with(clienteDigital){
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

    with(clienteNormal){
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

enum class Plano(var nome: String){
    NORMAL(nome = "normal"),
    DIGITAL(nome = "digital"),
    PREMIUM(nome = "premium");
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
    override var senha: String,
    override var tipo: String = "",
    override var saldo: Double = 0.0,
    override var extrato: String = """
        ============EXTRATO============
    """.trimIndent()
):Cliente(nome, sobrenome, cpf, senha),CarteiraFisica {
    override val plano = Plano.NORMAL
}
private data class ClientePremium(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String,
    override var tipo: String  = "",
    override var saldo: Double = 0.0,
    override var extrato: String = """
        ============EXTRATO============
    """.trimIndent()
):Cliente(nome, sobrenome, cpf, senha), CarteiraFisica, CarteiraDigital{

    override val plano: Plano = Plano.PREMIUM


}

private data class ClienteDigital(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String,
    override var tipo: String  = "",
    override var saldo: Double = 0.0,
    override var extrato: String = """
        ============EXTRATO============
    """.trimIndent()
):Cliente(nome, sobrenome, cpf, senha), CarteiraDigital{
    override val plano = Plano.DIGITAL


}

interface Carteira{
     val senha: String
     val tipo:String
     var saldo:Double
     var extrato:String

      fun pagueBoleto(valor: Double){
         extrato = extrato.concat("Pagamento de boleto efetuado de valor ${valor.currencyFormatterBr()}")
         println("Pagamento de boleto efetuado de valor ${valor.currencyFormatterBr()}")
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


