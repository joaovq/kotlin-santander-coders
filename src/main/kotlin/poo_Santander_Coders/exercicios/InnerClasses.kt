package poo_Santander_Coders.exercicios


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

    //    Cannot create an instance of an abstract class
//    Pessoa("Joao", cpf = "17921")

//    Nested class podemos instanciar fora da classe sem ter uma instancia da classe externa
    Pessoa.PessoaFisica()

//    Para inner class Não podemos instanciar sem uma instancia da classe pessoa, se não for dentro da classe externa
//    Pessoa.PessoaJuridica()
}
