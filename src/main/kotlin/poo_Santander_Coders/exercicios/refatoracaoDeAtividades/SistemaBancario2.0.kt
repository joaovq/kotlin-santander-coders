package poo_Santander_Coders.exercicios.refatoracaoDeAtividades

import java.lang.StringBuilder
import java.text.NumberFormat
import java.util.*

//TODO: Avaliar o melhor caminho

// my extensions functions
fun currencyFormatter(number: Double): String {
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))
    return currencyInstance.format(number)
}

fun Double.currencyFormatterBr(): String {
    return currencyFormatter(this)
}

fun String.concat(appendable: String): String {
    val stringBuilder = StringBuilder(this)
    stringBuilder.append("\n$appendable")
    return stringBuilder.toString()
}

//end myextension functions

//START TESTS
fun main(args: Array<String>) {

}
//END TESTS

//Não preciso passar os parametros de cliente para os filhos, obrigatoriamente
abstract class Cliente(
    nome: String, sobrenome: String, senha: String, cpf: String, plano: Plano
)

data class ClienteNormal(
    val nome: String, val sobrenome: String, val senha: String, val cpf: String, private val plano: Plano = Plano.NORMAL
) : Cliente(
    nome, sobrenome, senha, cpf, plano
), ContaFisica {
    //    TODO:Passar a carteira através dos planos
    private val carteiraFisica: CarteiraFisica = CarteiraFisica(senha)

    fun verificarSaldo() {
        val saldoEmBRL = carteiraFisica.saldo.currencyFormatterBr()
        println("O saldo na sua conta é de $saldoEmBRL")
    }


    override fun pagarBoleto() {
        carteiraFisica.pagarBoleto()
    }


    override fun deposito(valorDeDeposito: Double) {
        carteiraFisica.deposito(valorDeDeposito)
    }


    override fun saque(valorDeSaque: Double) {
        carteiraFisica.saque(valorDeSaque)
    }
}

data class ClienteDigital(
    val nome: String,
    val sobrenome: String,
    val senha: String,
    val cpf: String,
    private val plano: Plano = Plano.DIGITAL
) : Cliente(
    nome, sobrenome, senha, cpf, plano
), ContaDigital {

    //    TODO:Passar a carteira através dos planos
    private val carteiraDigital: CarteiraDigital = CarteiraDigital(senha)

    fun verificarSaldo() {
        val saldoEmBRL = carteiraDigital.saldo.currencyFormatterBr()
        println("O saldo na sua conta é de $saldoEmBRL")
    }

    override fun pagarBoleto() {
        carteiraDigital.pagarBoleto()
    }

    override fun pix(valorParaTransferencia: Double) {
        carteiraDigital.pix(valorParaTransferencia)
    }

    override fun guardar(valor: Double) {
        carteiraDigital.guardar(valor)
    }

    override fun investir(valorDoInvestimento: Double) {
        carteiraDigital.investir(valorDoInvestimento)
    }
}

data class ClientePremium(
    val nome: String,
    val sobrenome: String,
    val senha: String,
    val cpf: String,
    private val plano: Plano = Plano.PREMIUM
) : Cliente(
    nome, sobrenome, senha, cpf, plano
), ContaFisica, ContaDigital {
    //    TODO:Passar a carteira através dos planos
    private val carteiraFisica: CarteiraFisica = CarteiraFisica(senha)
    private val carteiraDigital: CarteiraDigital = CarteiraDigital(senha)

    fun verificarSaldoCarteiraDigital() {
        val saldoEmBRL = carteiraDigital.saldo.currencyFormatterBr()
        println("O saldo na sua conta é de $saldoEmBRL")
    }

    fun extrato() {
        println(carteiraFisica.extrato)
    }

    fun verificarSaldoCarteiraFisica() {
        val saldoEmBRL = carteiraFisica.saldo.currencyFormatterBr()
        println("O saldo na sua conta é de $saldoEmBRL")
    }

    override fun pagarBoleto() {
        carteiraFisica.pagarBoleto()
    }


    override fun deposito(valorDeDeposito: Double) {
        carteiraFisica.deposito(valorDeDeposito)
    }


    override fun saque(valorDeSaque: Double) {
        carteiraFisica.saque(valorDeSaque)
    }

    override fun pix(valorParaTransferencia: Double) {
        carteiraDigital.pix(valorParaTransferencia)
    }

    override fun guardar(valor: Double) {
        carteiraDigital.guardar(valor)
    }

    override fun investir(valorDoInvestimento: Double) {
        carteiraDigital.investir(valorDoInvestimento)
    }
}

//INTERFACES CONTA
//Metodos que vai ser implementados em cliente, para recuperar as ações em Carteira
//TODO: VER SE SERIA MELHOR USAR TRANSACAO AO INVES DE CONTA

interface Conta {
    fun pagarBoleto()
}

interface ContaFisica : Conta {
    fun deposito(valorDeDeposito: Double)
    fun saque(valorDeSaque: Double)
}

interface ContaDigital : Conta {
    fun pix(valorParaTransferencia: Double)
    fun guardar(valor: Double)
    fun investir(valorDoInvestimento: Double)
}

//ENUM CLASSES
//TODO: Passar a carteira
enum class Plano(plano: String) {
    NORMAL("normal"), DIGITAL("digital"), PREMIUM("premium");
}

enum class Tipo(tipo: String) {
    FISICA("física"), DIGITAL("digital");
}

//CARTEIRAS
abstract class Carteira(
    senha: String
) {
    abstract val tipo: Tipo
    abstract var saldo: Double
    abstract var extrato: String
    abstract fun pagarBoleto()
}

data class CarteiraFisica(
    val senha: String,
) : Carteira(senha), TransacaoFisica {
    override val tipo: Tipo = Tipo.FISICA
    override var saldo: Double = 0.0
    override var extrato: String = ""

    override fun pagarBoleto() {
        TODO("Not yet implemented")
    }

    override fun deposito(valorDeDeposito: Double) {
        TODO("Not yet implemented")
    }

    override fun saque(valorDeSaque: Double) {
        TODO("Not yet implemented")
    }
}

data class CarteiraDigital(
    val senha: String,
) : Carteira(senha), TransacaoDigital {
    override val tipo: Tipo = Tipo.DIGITAL
    override var saldo: Double = 0.0
    override var extrato: String = ""

    override fun pagarBoleto() {
        TODO("Not yet implemented")
    }

    override fun pix(valorParaTransferencia: Double) {
        TODO("Not yet implemented")
    }

    override fun guardar(valor: Double) {
        TODO("Not yet implemented")
    }

    override fun investir(valorDoInvestimento: Double) {
        TODO("Not yet implemented")
    }
}

//INTERFACES TRANSFERENCIA
interface TransacaoFisica {
    fun deposito(valorDeDeposito: Double)
    fun saque(valorDeSaque: Double)
}

interface TransacaoDigital {
    fun pix(valorParaTransferencia: Double)
    fun guardar(valor: Double)
    fun investir(valorDoInvestimento: Double)
}