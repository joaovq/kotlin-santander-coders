package estruturaDeDados_Santander_Coders.projeto.model

import estruturaDeDados_Santander_Coders.projeto.Operations
import java.time.LocalDateTime

data class Deal(
    var customer: Customer,
    var operation: Operations,
    var dateTime:LocalDateTime,
    var amount: Double
):Comparable<Deal>
{
    fun exportAllToCSV(){
    }

    override fun toString(): String {
        return "Deal(agencia=${customer.agency}," +
                " conta=${customer.account}," +
                " banco='${customer.bank}'," +
                " titular='${customer.holder}'," +
                " operacao='$operation'," +
                " dataHora='$dateTime'," +
                " valor=$amount)"
    }

    override fun compareTo(other: Deal): Int {
        if (customer.account>other.customer.account && dateTime>other.dateTime) return 1
        if (customer.account<other.customer.account&& dateTime<other.dateTime) return -1
        return 1
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Deal) return false
        return other.operation == operation
                && other.dateTime == dateTime
                && other.amount ==amount
    }

    override fun hashCode(): Int {
        var result = customer.hashCode()
        result = 31 * result + operation.hashCode()
        result = 31 * result + dateTime.hashCode()
        result = 31 * result + amount.hashCode()
        return result
    }


}
