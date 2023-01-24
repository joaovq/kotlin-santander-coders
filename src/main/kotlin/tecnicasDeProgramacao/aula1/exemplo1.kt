package tecnicasDeProgramacao.aula1
//(potencia*hora)/1000
fun main() {
    println(getSpentAtMachine(1000, 2,2))//4.0
    println(getSpentAtMachine(1000, 0,2))// 0.0
    println(getSpentAtMachine(50, 9,2))// 0.9
    println(getSpentAtMachine(10, 89,2))//1.78

}

fun getSpentAtMachine(powerMachine:Int, hoursOfUsage:Int, daysOfUsage:Int = 1):Double =
     powerMachine.times(hoursOfUsage).times(daysOfUsage).div(1000.0)

fun getSpentAtMachineForDay(powerMachine: Int, hoursOfUsage: Int) =
    getSpentAtMachine(powerMachine, hoursOfUsage,1)


fun getSpentAtMachineForMonth(powerMachine: Int, hoursOfUsage: Int) =
    getSpentAtMachine(powerMachine, hoursOfUsage, 30)
