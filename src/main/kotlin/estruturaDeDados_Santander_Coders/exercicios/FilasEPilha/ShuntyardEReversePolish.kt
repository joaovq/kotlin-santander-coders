package estruturaDeDados_Santander_Coders.exercicios.FilasEPilha

import poo_Santander_Coders.exercicios.concat
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

/*
* TODO:Interpretar expressões matemáticas não é uma tarefa trivial,
*   por isso é comum transformamos expressões da forma como conhecemos (3 + 4)
*   em uma notação polonesa reversa, que nesse caso teria o formato:
*   3 4 +.
*   Ao fazermos isso facilita criamos um algoritmo para calcular o resultado da expressão.
*   Para fazer tal conversão existem alguns algoritmos diferentes,
*  um deles é chamado Shunting Yard, você deve implementar um conversor de notação
*  utilizando o algoritmo de Shunting Yard simplificado, ou seja, ignorando a parte onde ele aceita
*   funções no meio da expressão. Esse conversor deve utilizar a estrutura de dados de pilha.
*/

class ShuntYard {
    val outputQueue: Queue<String> = LinkedList()
    val operatorStack: Stack<String> = Stack()


    fun readToken() {
        var token: String? = null
        while (token.isNullOrBlank()) {
            token = readlnOrNull()
            if (token.isNullOrBlank()) {
                continue
            } else {
                convertNotation(token)
            }
        }
    }

    private fun convertNotation(token: String) {
        for (i in token.indices ){
            val containsNum = token.substring(i, i+1).contains(regex = Regex("^[0-9]$"))
            val containsOperator = token.substring(i, i+1).contains(regex = Regex("[-+x/^]"))
            val containsLeftParenthesis = token.substring(i, i+1).contains(regex = Regex("^[(]$"))
            val containsRightParenthesis = token.substring(i, i+1).contains(regex = Regex("^[)]$"))
            val isOperatorO1:Boolean = if (operatorStack.isNotEmpty()){
                ((operatorStack.peek() != "(") &&
                        (isPrecedence(token.substring(i,i+1), operatorStack.peek()) ))
            }
            else{
                false
            }

//      TODO:TESTES  3+4x2/(1-5)^2^3
            when{
                containsNum ->{
                    outputQueue.offer(token.substring(i, i+1))
                }
                containsRightParenthesis->{
                   while (operatorStack.peek() != "("){
                       val operatorO1 = operatorStack.pop()
                       outputQueue.offer(operatorO1)
                   }
                    operatorStack.pop()
                }
                containsLeftParenthesis->{
                    operatorStack.push("(")
                }
                isOperatorO1->{
                    val operatorO1 = operatorStack.pop()
                    operatorStack.push(token.substring(i,i+1))
                    outputQueue.offer(operatorO1)
                }
                containsOperator->{
                    operatorStack.push(token.substring(i, i+1))
                }
            }
        }


        val output = outputQueue.joinToString(separator = " ")
        val operatorOutput = operatorStack.joinToString(separator = " ").reversed()

        println(output)
        println(operatorOutput)
        val append = StringBuilder(output).append(" $operatorOutput")
        println("Output: $append")


    }

    private fun isPrecedence(newOperator:String, stackOperator:String):Boolean = when{
        newOperator == stackOperator->{
                 false
            }
        newOperator == "^"->{
                false
            }
        newOperator == "+"->{
                false
            }
        newOperator == "-"->{
                false
            }
        newOperator == "x" && (
                   stackOperator=="+" ||
                stackOperator == "^")->{
                false
            }
        newOperator == "/" && (
                    stackOperator=="+" ||
                        stackOperator == "^")->{
                false
            }
            else -> {
                true
            }
    }


}

fun main(args: Array<String>) {
    val shuntYard = ShuntYard()

    shuntYard.readToken()
}