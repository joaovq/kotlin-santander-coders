package POO_Santander_Coders.Exercicios


data class Aluno(
    var name:String,
    var notas:MutableMap<Int, Double>
){

    class Presenca(){
        fun mostrarPresencas(){

        }
    }
    inner class Boletim(
        semestre:Int
    ){
        fun mostrarNotas(){
            notas
        }
    }
}
abstract class Pessoa(nome:String, cpf:String){
    class PessoaFisica()

    inner class PessoaJuridica(){}

}

fun main(args: Array<String>) {
    //    Cannot create an instance of an abstract class
//    Pessoa("Joao", cpf = "17921")

//    Nested class podemos instanciar fora da classe sem ter uma instancia da classe externa
    Pessoa.PessoaFisica()

//    Para inner class Não podemos instanciar sem uma instancia da classe pessoa, se não for dentro da classe externa
//    Pessoa.PessoaJuridica()
}