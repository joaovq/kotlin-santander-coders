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