package POO_Santander_Coders.Exercicios.Solid

import java.util.*

fun main(args: Array<String>) {

}


fun interface G{
    fun trasnform()
}

class C1 :G{
    override fun trasnform() {
        TODO("Not yet implemented")
    }

}

class EmployeeRepository1(dataSource: DataSource)
class VeryComplexService(
    private val properties: Properties = Properties(),
    private val employeeRepository: EmployeeRepository1 = EmployeeRepository1(createDataSource()),
    private val transformer: G = G { C1() }
)