package estruturaDeDados_Santander_Coders.aula3PilhaStack

import java.util.*

class ExpressionValidator() {

    // apenas validar parenteses
    // utilizando pilha
    fun isValid(expression: String): Boolean {
        val stack = Stack<Char>()

        expression.forEach {
            if (expression == "("){
                stack.push('(')
            }else if (expression == ")"){
                val removed = stack.removeFirstOrNull() ?: return false
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    val expressionValidator = ExpressionValidator()
    println(expressionValidator.isValid("((1 + 2))"))
}