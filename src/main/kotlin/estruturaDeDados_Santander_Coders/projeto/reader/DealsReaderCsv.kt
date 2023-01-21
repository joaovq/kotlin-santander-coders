package estruturaDeDados_Santander_Coders.projeto.reader

import estruturaDeDados_Santander_Coders.projeto.Operations
import estruturaDeDados_Santander_Coders.projeto.model.Bank
import estruturaDeDados_Santander_Coders.projeto.model.Customer
import estruturaDeDados_Santander_Coders.projeto.model.Deal
import java.time.LocalDateTime
import java.util.*

class DealsReaderCsv(
   private val bank: Bank
) :ReaderCsv(){
    fun findDealsBank(deals:Collection<Deal>):Set<Deal> = deals.filter {
        it.customer.bank == bank.name
    }.toSet()

    fun getDealsFromCsv(path: String):MutableSet<Deal>{
        try {
            bank.dealsBank = filterDuplicates(path)
        }catch (e:Exception){
            e.printStackTrace()
        }
        return bank.dealsBank
    }

    private fun getListOfDeals(path:String):List<Deal> = readCsv(path).map {
        Deal(
            customer = Customer(
                it[0].toInt(),
                it[1].toInt(),
                it[2],
                it[3]
            ),
            operation = Operations.valueOf(it[4].uppercase()),
            dateTime = LocalDateTime.parse(it[5]),
            amount = it[6].toDouble()
        )
    }

    fun filterDuplicates(path: String) = getListOfDeals(path).toMutableSet()
    fun sort(path: String) = TreeSet<Deal>(filterDuplicates(path))

    private fun getCustomersAtDeals(path: String) = sort(path).map {
            deal->
        deal.customer
    }.toSet()

    fun getCustomersWithBalance(path: String):Set<Customer>{
        val dealsUniques = filterDuplicates(path)

        val customers = getCustomersAtDeals(path)

        customers.forEach {
                customer->
            dealsUniques.filter {
                it.customer == customer
            }.forEach{
                if (it.operation == Operations.DEPOSITO){
                    customer.deposit(it.amount, it.dateTime)
                }
                if (it.operation == Operations.SAQUE){
                    customer.withdraw(it.amount, it.dateTime)
                }
            }
        }

        return customers
    }
}