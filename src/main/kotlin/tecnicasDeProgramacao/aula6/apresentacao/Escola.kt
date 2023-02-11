package tecnicasDeProgramacao.aula6.apresentacao

import java.time.LocalDate
import java.time.Period
import kotlin.collections.ArrayList

class Escola(
    collectionAlunos : ArrayList<Aluno>,
    collectionTurmas : ArrayList<Turma>,
    collectionFuncionarios : ArrayList<Funcionario>,
    collectonProfessores : ArrayList<Professor>
){
    fun matricularAluno(aluno : Aluno){

    }

    fun matricularProfessor(professor : Professor){

    }
}

abstract class Pessoa(val nome : String)

data class Aluno(
    val nomeAluno : String,
    val notas : RepositorioNota,
    val turma : Turma
) : Pessoa(nomeAluno){

    fun media() : Double {
        return notas.media()
    }

    fun addNota(valor : Double) {
        if (notas.size() < 4)
            notas.addNota(valor)
    }

    fun replaceNota(posicao : Int, valor : Double) {
        if (posicao in 0..3)
            notas.replaceNota(posicao, valor)
    }

}

data class RepositorioNota(
    private val notas : ArrayList<Double> = arrayListOf()
) {
    fun media() : Double = if (notas.isNotEmpty()) (notas.sum()) / notas.size else 0.0

    fun replaceNota(posicao : Int, valor: Double) {
        notas[posicao] = valor
    }

    fun addNota(valor: Double) {
        notas.add(valor)
    }

    fun size(): Int {
        return notas.size
    }
}

open class Funcionario(
    val nomeFuncionario : String,
    val salario : Double,
    dataDeContratacao : LocalDate
): Pessoa(nomeFuncionario)


data class Professor(
    val nomeProfessor : String,
    private var salarioProfessor : Double,
    val dataDeContratacao : LocalDate
): Funcionario(nomeProfessor, salarioProfessor, dataDeContratacao){

    private var anoReajuste : LocalDate = dataDeContratacao
    val salarioAtual : Double
        get() = reajuste()

    private fun reajuste() : Double {
        val hoje = LocalDate.now()
        val diff = Period.between(anoReajuste, hoje)

        if (diff.years == 5) {
            salarioProfessor *= 1.1
            anoReajuste = hoje
        }

        return salarioProfessor
    }
}

class Turma(val number : Int, val teacher : ArrayList<Professor>, val collectionAlunos : ArrayList<Aluno>)

fun main(args : Array<String>) {
}