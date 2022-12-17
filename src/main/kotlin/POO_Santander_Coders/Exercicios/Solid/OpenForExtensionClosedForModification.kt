package POO_Santander_Coders.Exercicios.Solid

import junit.framework.TestCase
import org.jetbrains.annotations.TestOnly
import java.util.*

//Se delegarmos o para employee repository, podemos utilizar o repository através da variavel
//Mas neste caso, não é o objetivo
class FunctionalEmployeeService(
    private val employeeRepository: EmployeeRepository
){
//    Privada e so pode usar somente aqui na classe
//    A implementação do repository pode ser somente feita pela classe
    private fun handleChange(id: UUID, change:PureEmployee.() ->PureEmployee) {
        employeeRepository.findById(id)
            .change()
            .let { employeeRepository.upsert(it) }
    }

    fun handleRaise(id:UUID, raise:Double) =
        handleChange(id) { copy(salary = salary + raise) }

    fun handleTitleChange(id:UUID, newTitle:String) =
        handleChange(id) { copy(title = newTitle) }


}

data class PureEmployee(
    val id:UUID,
    var name:String,
    var title:String,
    var salary:Double
)

interface EmployeeRepository {
    fun findById(id:UUID):PureEmployee{
        return PureEmployee(
            id = UUID(1, 100),
            name = "Carl",
            title = "TechLead",
            salary = 4000.0
        )
    }

    fun upsert(id:PureEmployee):PureEmployee{
        return PureEmployee(
            id = UUID(1, 100),
            name = "Carl",
            title = "TechLead",
            salary = 4000.0
        )
    }
}

fun main(args: Array<String>) {
    val value:EmployeeRepository = object :EmployeeRepository {
        val name = "joao"
    }
    val functionalEmployeeService = FunctionalEmployeeService(
        value
    )

    val pureEmployee = PureEmployee(
        id = UUID(180, 100000000),
        name = "Carl",
        title = "TechLead",
        salary = 4000.0
    )

    functionalEmployeeService.handleRaise(
        pureEmployee.id,
        pureEmployee.salary
    )

    println(pureEmployee.id)
}

