package estruturaDeDados_Santander_Coders.projeto.model

import estruturaDeDados_Santander_Coders.projeto.Operations
import java.time.LocalDateTime

data class Customer(
    val agency:Int,
    val account:Int,
    val bank:String,
    val holder:String,
    var balance:Double = 0.0
){
    fun withdraw(value:Double, date:LocalDateTime = LocalDateTime.now()): Deal? = if (value>0){
        balance-=value
        Deal(
            this, Operations.SAQUE,date, value
        )
    }else{
        null
    }
    fun deposit(value:Double, date:LocalDateTime = LocalDateTime.now()): Deal? = if (value>0){
        balance+=value
        Deal(
            this, Operations.DEPOSITO,date, value
        )
    }else{
        null
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (agency != other.agency) return false
        if (account != other.account) return false
        if (bank.uppercase() != other.bank.uppercase()) return false
        if (holder.uppercase() != other.holder.uppercase()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = agency
        result = 31 * result + account
        result = 31 * result + bank.hashCode()
        result = 31 * result + holder.hashCode()
        result = 31 * result + balance.hashCode()
        return result
    }



}
