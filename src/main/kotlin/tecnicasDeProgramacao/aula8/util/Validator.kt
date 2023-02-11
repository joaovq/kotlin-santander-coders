package tecnicasDeProgramacao.aula8.util

interface Validator <T> {
    fun isValid(form : T) : Boolean
}