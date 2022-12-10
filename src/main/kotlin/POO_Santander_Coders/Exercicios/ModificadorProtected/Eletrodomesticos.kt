package POO_Santander_Coders.Exercicios.ModificadorProtected

open class Eletrodomesticos(
    protected val voltagem:Int,
    protected val comprimento:Double,
    protected val largura:Double,
    protected val qtdDePortas:Int,
    protected val cor:String
)


class Geladeira: Eletrodomesticos(
    voltagem = 127,
    comprimento = 1.5 ,
    largura = 0.5,
    qtdDePortas = 2,
    cor = "Cinza"
){
    fun descricao(){
        println("Voltagem: $voltagem," +
                " Comprimento: $comprimento," +
                " Largura: $largura," +
                " Quantidade de Portas: $qtdDePortas," +
                " Cor: $cor")
    }
}

fun main() {
    val geladeira = Geladeira()
    geladeira.descricao()
}