package tecnicasDeProgramacao.aula8.util

import tecnicasDeProgramacao.aula8.extension.matcherFromPattern
import java.time.LocalDate

class CustomerValidator : Validator<CustomerForm> {

    override fun isValid(form : CustomerForm): Boolean =
        when{
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
            else -> true
        }

    private fun isValidCpf(value : String) = value.matcherFromPattern(PatternForm.CPF.pattern)
    private fun isValidEmail(value : String) = value.matcherFromPattern(PatternForm.EMAIL.pattern)
    private fun isValidRg(value : String) = value.matcherFromPattern(PatternForm.RG.pattern)
    private fun isValidBirth(value : LocalDate) = value.matcherFromPattern(PatternForm.BIRTH.pattern)
}