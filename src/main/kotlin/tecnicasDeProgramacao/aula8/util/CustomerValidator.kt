package tecnicasDeProgramacao.aula8.util

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import tecnicasDeProgramacao.aula8.extension.matcherFromPattern
import java.time.LocalDate

class CustomerValidator : ICustomerValidator {

    override suspend fun isValid(form : CustomerForm): Boolean = coroutineScope {
        val deferred = async {
            when {
                !isValidCpf(form.cpf) -> {
                    println("CPF FALHOU")
                    false
                }
                !isValidName(form.firstNameForm) && !isValidName(form.lastNameForm) -> {
                    println("NOME FALHOU")
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

    override fun isValidCpf(value : String) =
        value.matcherFromPattern(PatternForm.CPF.pattern)
    override fun isValidEmail(value : String) =
        value.matcherFromPattern(PatternForm.EMAIL.pattern)
    override fun isValidRg(value : String) =
        value.matcherFromPattern(PatternForm.RG.pattern)
    override fun isValidBirth(value : LocalDate) =
        value.matcherFromPattern(PatternForm.BIRTH.pattern)
    override fun isValidTelephone(value : String) =
        value.matcherFromPattern(PatternForm.TELEPHONE.pattern)
    override fun isValidName(value : String) =
        value.matcherFromPattern(PatternForm.NAME.pattern)
}