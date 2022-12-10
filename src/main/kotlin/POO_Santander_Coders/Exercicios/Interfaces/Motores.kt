package POO_Santander_Coders.Exercicios.Interfaces

import POO.Car


interface Motor{
    val nivelDePoluicao:NivelDePoluicao
}
interface Terrestre{
    val numDeRodas:Int
}
interface Voador{
    val numDeHelices:Int
}
interface MotorACombustao:Motor{
    override val nivelDePoluicao: NivelDePoluicao
    val combustiveisUtilizados:String

//    fun verificarCarro()
    fun abastecer(){
        println("abastecedo o veiculo com $combustiveisUtilizados")
    }
    fun trocarOleo(){
        println("abastecedo o veiculo com nivel de poluição $nivelDePoluicao")
    }
}
interface MotorAEletrico:Motor{
    override val nivelDePoluicao: NivelDePoluicao
    val tamanhoBateria: Int

    fun carregarBateria(){
        println("Carregando a  bateria de tamanho $tamanhoBateria")
    }

    fun trocarBateria(){
        println("trocando a  bateria na qual o nivel de poluição é $nivelDePoluicao")
    }

}
class Caminhao(
    override val combustiveisUtilizados: String,
    override val nivelDePoluicao: NivelDePoluicao
) : MotorACombustao, Terrestre{

    override val numDeRodas: Int = 4


    override fun abastecer() {
        super.abastecer()
    }



}

class Aviao(
    override val combustiveisUtilizados: String,
    override val nivelDePoluicao: NivelDePoluicao
) : MotorACombustao, Voador{

    override val numDeHelices: Int = 2



    override fun abastecer() {
        super.abastecer()
    }



}
enum class NivelDePoluicao{
    BAIXO,
    ALTO
}
class Moto(
    override val nivelDePoluicao: NivelDePoluicao,
    override val combustiveisUtilizados: String
) :MotorACombustao, Terrestre{
    override val numDeRodas: Int = 2

    override fun abastecer() {
        super.abastecer()
    }

    //Não é necessario o override porque os metodos foram declarados na interface
    override fun trocarOleo() {
        super.trocarOleo()
    }
}
class Carro(
    override val nivelDePoluicao: NivelDePoluicao,
    override val combustiveisUtilizados: String
) :MotorACombustao{


    override fun abastecer() {
        super.abastecer()
    }
    //Não é necessario o override porque os metodos foram declarados na interface
    override fun trocarOleo() {
        super.trocarOleo()
    }
}
class CarroEletrico(
    override val nivelDePoluicao: NivelDePoluicao,
    override val tamanhoBateria: Int
) :MotorAEletrico{
    override fun carregarBateria() {
        super.carregarBateria()
    }
//Não é necessario o override porque os metodos foram declarados na interface
    override fun trocarBateria() {
        super.trocarBateria()
    }
}

//Testes
fun main(args: Array<String>) {
    val caminhao = Caminhao(nivelDePoluicao = NivelDePoluicao.ALTO, combustiveisUtilizados = "gasolina")
    caminhao.abastecer()
    caminhao.trocarOleo()

    val carroEletrico = CarroEletrico(nivelDePoluicao = NivelDePoluicao.BAIXO, tamanhoBateria = 50000)
    carroEletrico.trocarBateria()
    carroEletrico.carregarBateria()
}