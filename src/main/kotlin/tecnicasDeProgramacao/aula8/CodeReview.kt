package tecnicasDeProgramacao.aula8

import kotlinx.coroutines.*
import org.apache.commons.logging.LogFactory
import tecnicasDeProgramacao.aula8.enum.Gender
import tecnicasDeProgramacao.aula8.util.CustomerForm
import tecnicasDeProgramacao.aula8.util.CustomerValidator
import java.time.LocalDate

private val log = LogFactory.getLog(CustomerValidator::class.java)

fun main(args: Array<String>): Unit = runBlocking {
    val customerForm = CustomerForm(
        "078.126.355-70",
        "14.506.680-03",
        "João@ Vítor",
        "Queiroz Santos",
        LocalDate.of(2000, 11, 5),
        "(71) 99926-1272",
        Gender.MALE,
        "joao@gmail.com"
    )

    val customerValidator = CustomerValidator()

    launch {
        val isValid =  customerValidator.isValid(customerForm)
        log.info("O form está válido $isValid")
    }
}
