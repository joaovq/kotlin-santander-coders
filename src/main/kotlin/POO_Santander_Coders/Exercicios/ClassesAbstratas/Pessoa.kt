package POO_Santander_Coders.Exercicios.ClassesAbstratas


abstract class Pessoa{
    abstract var primeiroNome:String
    abstract var segundoNome:String
    abstract val rg:String


}
class PessoaFisica(
    override var primeiroNome: String,
    override var segundoNome: String,
    override val rg: String
) :Pessoa(){

}

class PessoaJuridica(
    override var primeiroNome: String,
    override var segundoNome: String,
    override val rg: String
) :Pessoa(){

}