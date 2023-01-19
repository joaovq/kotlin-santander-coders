package estruturaDeDados_Santander_Coders.projeto.activities

import estruturaDeDados_Santander_Coders.projeto.TestDeals
import estruturaDeDados_Santander_Coders.projeto.apacheCsv.writeCsv
import estruturaDeDados_Santander_Coders.projeto.apacheCsv.writeCustomerCsv
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
        customer = TestDeals.getBalanceForHolder(deals)
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

fun main() {
    val activity = MainActivity()
    activity.onCreate()
}