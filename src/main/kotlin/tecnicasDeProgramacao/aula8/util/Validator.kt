package tecnicasDeProgramacao.aula8.util

interface Validator <T> {
   suspend fun isValid(form : T) : Boolean
}