package POO_Santander_Coders.Exercicios

fun main(args: Array<String>) {

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
    protected abstract val plano: Plano
    }
private data class ClienteNormal(
    override var nome: String,
    override var sobrenome: String,
    override val cpf: String,
    override var senha: String
):Cliente(nome, sobrenome, cpf, senha){

    override val plano = Plano.NORMAL
    val carteiraFisica = plano.carteiraFisica!!

    fun pagueBoleto(valorBoleto: Double){
        carteiraFisica.pagueBoleto(valorBoleto)
    }

    fun deposito(valor: Double){
        carteiraFisica.deposito(valor)
    }

    fun saque(valor: Double){
        carteiraFisica.saque(valor)
    }

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

    fun pagueBoleto(valorBoleto: Double){
        carteiraDigital.pagueBoleto(valorBoleto)
    }

    fun deposito(valor: Double){
        carteiraFisica.deposito(valor)
    }

    fun saque(valor: Double){
        carteiraFisica.saque(valor)
    }

    fun transferenciaPix(valor: Double){
        carteiraDigital.transferenciaPix(valor)
    }

    fun guardar(valor: Double){
        carteiraDigital.guardar(valor)
    }


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

    fun pagueBoleto(valorBoleto: Double){
        carteiraDigital.pagueBoleto(valorBoleto)
    }


    fun transferenciaPix(valor: Double){
        carteiraDigital.transferenciaPix(valor)
    }

    fun guardar(valor: Double){
        carteiraDigital.guardar(valor)
    }
}

interface Carteira{
     val senha: String
     val tipo:String
     val saldo:Double
     val extrato:String

     fun pagueBoleto(valor: Double){
         println("Pagamento de boleto efetuado de valor $valor")
     }
}

open class CarteiraFisica() :Carteira{


    override var senha: String = ""
    override var tipo: String  = ""
    override var saldo: Double = 0.0
    override val extrato: String = ""
    fun saque(valor: Double){
        if (saldo.minus(valor)>0.0){
            this.saldo=saldo.minus(valor)
            saldo=0.0
            println("Saque efetuado.")
        }
        else{
            println("Não é possível fazer saque co")
        }
    }
    fun deposito(valor: Double){
        saldo = saldo.plus(valor)
        println("Deposito de $valor foi efetuado")
    }
}
open class CarteiraDigital:Carteira{

    override var senha: String = ""
    override var tipo: String = ""
    override var saldo: Double = 0.0
    override val extrato: String = ""

    open fun transferenciaPix(valor: Double){
        println("Transferencia de pix realizada, valor: $valor")
    }
    open fun investir(valor:Double){
        if (saldo.minus(valor)>0.0){
            this.saldo=saldo.minus(valor)
            saldo=0.0
            println("Investindo o dinheiro $valor")
        }
        else{
            println("Deposite mais dinheiro para investir")
        }


    }
    open fun guardar(valor: Double){
        saldo = saldo.plus(valor)
        println("O valor de $valor foi guardado")
    }
}


