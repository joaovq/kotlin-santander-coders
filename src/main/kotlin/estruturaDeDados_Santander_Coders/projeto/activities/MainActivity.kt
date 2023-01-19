package estruturaDeDados_Santander_Coders.projeto.activities

import estruturaDeDados_Santander_Coders.projeto.TestDeals
import estruturaDeDados_Santander_Coders.projeto.apacheCsv.writeCsv
import estruturaDeDados_Santander_Coders.projeto.apacheCsv.writeCustomerCsv
import estruturaDeDados_Santander_Coders.projeto.enums.Operations
import estruturaDeDados_Santander_Coders.projeto.model.Customer
import estruturaDeDados_Santander_Coders.projeto.model.Deal
import kotlinx.coroutines.delay

class MainActivity {
    private lateinit var deals:MutableSet<Deal>
    private lateinit var customer: Set<Customer>
    fun onCreate(){
        println("""
            
            Criando a atividade!!
            
        """.trimIndent())
        deals = TestDeals.getDeals()
        customer = getBalanceForHolder(deals)
        onStart()
    }

    private fun onStart(){
//       Is visible
        println("""
            
            Iniciando a atividade!!
            
            
        """.trimIndent())
        deals.forEach {
            println(it)

        }
        println()
        customer.forEach {
            println(it)
        }
        TestDeals.writer.writeCsv(deals.toMutableSet())
        TestDeals.writer.writeCustomerCsv(customer.toMutableSet())
        onResume()
    }
    private fun onResume(){
//       Is visible
        onPause()
    }
    private fun onPause(){
//       partially visible
//       podemos voltar para o onResume()
        onStop()
    }


   private fun onStop(){
//        Is hidden
        println("""
            
           Activity pausada
           
        """.trimIndent())
       onDestroy()
    }

    private fun onDestroy(){
        deals.clear()
        println("""
            
            Fim da atividade do sistema
            
        """.trimIndent())
    }
}

fun getBalanceForHolder(deal: MutableSet<Deal>):Set<Customer> {
    return getBalance(deal)
}

private fun getBalance(deal: MutableSet<Deal>): Set<Customer> {
    val customers = deal.map {
        it.customer
    }.toSet()
    getBalanceAtCustomer(customers, deal)
    return customers
}

private fun getBalanceAtCustomer(
    customers: Set<Customer>,
    deal: MutableSet<Deal>
) {
    customers.forEach { customers ->
        val filter = deal.filter {
            it.customer == customers
        }
        filter.forEach {
            if (it.operation == Operations.DEPOSITO) {
                customers.deposit(it.amount, it.dateTime)
            }
            if (it.operation == Operations.SAQUE) {
                customers.withdraw(it.amount, it.dateTime)
            }
        }
    }
}

fun main() {
    val activity = MainActivity()
    activity.onCreate()
}