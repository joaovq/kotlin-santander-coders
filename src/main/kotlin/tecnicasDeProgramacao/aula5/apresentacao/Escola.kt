package tecnicasDeProgramacao.aula5.apresentacao



class Escola(
    collectionAlunos:ArrayList<Aluno>,
    collectionTurmas:ArrayList<Turma>,
    collectionFuncionarios:ArrayList<Funcionario>,
    collectonProfessores:ArrayList<Professor>
){
    fun matricularAluno(aluno:Aluno){

    }

    fun matricularProfessor(professor:Professor){

    }
}

abstract class Pessoa(val nome:String)

data class Aluno(
    val nomeAluno:String,
    val notas:ArrayList<Notas>,
    val turma:Turma
):Pessoa(nomeAluno){

    fun media(notas:ArrayList<Notas>){

    }

}

fun Double.calcularAcrescimo() = this*0.1

open class Funcionario(
    nomeFuncionario:String,
    salario:Double,
    dataDeContratacao:String
):Pessoa(nomeFuncionario)


data class Professor(
    val nomeProfessor:String,
    val salarioProfessor:Double,
    val dataDeContratacao:String
):Funcionario(nomeProfessor, salarioProfessor,dataDeContratacao){
    fun aumentarSalario():Double{
        return 0.0
    }
}

data class Notas(val collectionNotas:ArrayList<Double>)
class Turma(val number:Int,val teacher:ArrayList<Professor>, val collectionAlunos:ArrayList<Aluno>)

fun main(args:Array<String>) {
}