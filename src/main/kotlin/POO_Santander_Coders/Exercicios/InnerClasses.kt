package POO_Santander_Coders.Exercicios

class AnimalDeEstimacao(var nome:String? = null,var raca:String? = null){

    class Responsavel(){
//
        fun descreverDados(){
//            Não consigo acessar os parametros metodos da classe externa na nested class
//            nome
        }
    }
    inner class Tutor(
        name:String = "Guest",
        animal: AnimalDeEstimacao = AnimalDeEstimacao() ?: AnimalDeEstimacao(
            nome = "Jubile", raca = "Papagaio"
        )
    ){
        fun getTutorEAnimal(){
            println("$nome+$raca")
        }
        private var id:Long = 0
    }

    private fun getTutor(): Tutor {
        val tutor = Tutor()
        return tutor
    }

}


fun main(args: Array<String>) {
//    Nested Class (Classe aninhada)
    AnimalDeEstimacao.Responsavel()
//    Erro: Constructor of inner class Tutor can be called only with receiver of containing class
//    AnimalDeEstimacao.Tutor()
//    Conseguimos acessar uma inner Class se existir uma instância da classe.
    AnimalDeEstimacao().Tutor()
}
