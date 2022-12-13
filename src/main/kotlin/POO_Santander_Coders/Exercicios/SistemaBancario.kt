package POO_Santander_Coders.Exercicios

fun main(args: Array<String>) {

}

interface Conta{
    fun pagueBoleto()
}

interface ContaDigital:Conta{
    override fun pagueBoleto() {
        TODO("Not yet implemented")
    }
    fun transferenciaPix()
    fun investir()
    fun guardar()
}
interface ContaNormal:Conta{
   fun saque()
   fun deposito()
}

private abstract class PessoaFisica(
    open var nome:String,
    open var sobrenome:String
)

enum class Plano(nome: String){
    NORMAL(nome = "normal"),
    DIGITAL(nome = "digital"),
    PREMIUM(nome = "premium");
}

private abstract class Cliente(
    override var nome: String,
    override var sobrenome: String,
    open val plano:Plano
    ):PessoaFisica(
    nome,
    sobrenome
    ){


}
private data class ClienteNormal(
    override var nome: String,
    override var sobrenome: String,
    override val plano:Plano
):Cliente(nome, sobrenome, plano), CarteiraFisica{
    override fun pagueBoleto() {
        TODO("Not yet implemented")
    }

    override fun saque() {
        super.saque()
    }

    override fun deposito() {
        super.deposito()
    }

    override val senha: String
        get() = super.senha
    override val tipo: String
        get() = super.tipo
    override val saldo: Double
        get() = super.saldo
    override val extrato: String
        get() = super.extrato
}
private data class ClientePremium(
    override var nome: String,
    override var sobrenome: String,
    override val plano:Plano
):Cliente(nome, sobrenome, plano), CarteiraDigital, CarteiraFisica{
    override val senha: String
        get() = TODO("Not yet implemented")
    override val tipo: String
        get() = TODO("Not yet implemented")
    override val saldo: Double
        get() = TODO("Not yet implemented")
    override val extrato: String
        get() = TODO("Not yet implemented")

    override fun saque() {
        super.saque()
    }

    override fun deposito() {
        super.deposito()
    }

    override fun pagueBoleto() {
        super.pagueBoleto()
    }

    override fun transferenciaPix() {
        super.transferenciaPix()
    }

    override fun investir() {
        super.investir()
    }

    override fun guardar() {
        super.guardar()
    }
}
private data class ClienteDigital(
    override var nome: String,
    override var sobrenome: String,
    override val plano:Plano
):Cliente(nome, sobrenome, plano), CarteiraDigital{
    override val tipo: String
        get() = super.tipo
    override val saldo: Double
        get() = super.saldo
    override val extrato: String
        get() = super.extrato

    override fun pagueBoleto() {
        super.pagueBoleto()
    }

    override fun transferenciaPix() {
        super.transferenciaPix()
    }

    override fun investir() {
        super.investir()
    }

    override fun guardar() {
        super.guardar()
    }
}
 interface Carteira{
     val senha: String
     val tipo:String
     val saldo:Double
     val extrato:String
}

interface CarteiraFisica:Carteira, ContaNormal{


    override fun saque() {
        TODO("Not yet implemented")
    }

    override fun deposito() {
        TODO("Not yet implemented")
    }

    override val senha: String
        get() = ""
    override val tipo: String
        get() = TODO("Not yet implemented")
    override val saldo: Double
        get() = TODO("Not yet implemented")
    override val extrato: String
        get() = TODO("Not yet implemented")
}
interface CarteiraDigital:Carteira, ContaDigital{
    override val senha: String
        get() = TODO("Not yet implemented")
    override val tipo: String
        get() = TODO("Not yet implemented")
    override val saldo: Double
        get() = TODO("Not yet implemented")
    override val extrato: String
        get() = TODO("Not yet implemented")

    override fun pagueBoleto() {
        TODO("Not yet implemented")
    }

    override fun transferenciaPix() {
        TODO("Not yet implemented")
    }

    override fun investir() {
        TODO("Not yet implemented")
    }

    override fun guardar() {
        TODO("Not yet implemented")
    }

}