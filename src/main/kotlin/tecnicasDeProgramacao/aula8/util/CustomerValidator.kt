package tecnicasDeProgramacao.aula8.util

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import tecnicasDeProgramacao.aula8.extension.matcherFromPattern
import java.time.LocalDate

class CustomerValidator : Validator<CustomerForm> {

    override suspend fun isValid(form : CustomerForm): Boolean = coroutineScope {
        val deferred = async {
//            delay(3000)
            when {
                !isValidCpf(form.cpf) -> {
                    println("CPF FALHOU")
                    false
                }
                !isValidEmail(form.emailForm) -> {
                    println("EMAIL FALHOU")
                    false
                }
                !isValidRg(form.rg) -> {
                    println("RG FALHOU")
                    false
                }
                !isValidBirth(form.birthForm) -> {
                    println("DATA DE NASCIMENTO FALHOU")
                    false
                }
                !isValidTelephone(form.numTelephoneForm) -> {
                    println("NÚMERO DE TELEFONE FALHOU")
                    false
                }
                else -> true
            }
        }
        deferred.await()
    }

    private fun isValidCpf(value : String) =
        value.matcherFromPattern(PatternForm.CPF.pattern)
    private fun isValidEmail(value : String) =
        value.matcherFromPattern(PatternForm.EMAIL.pattern)
    private fun isValidRg(value : String) =
        value.matcherFromPattern(PatternForm.RG.pattern)
    private fun isValidBirth(value : LocalDate) =
        value.matcherFromPattern(PatternForm.BIRTH.pattern)
    private fun isValidTelephone(value : String) =
        value.matcherFromPattern(PatternForm.TELEPHONE.pattern)
}