package estruturaDeDados_Santander_Coders.projeto.apacheCsv

import estruturaDeDados_Santander_Coders.projeto.model.Customer
import estruturaDeDados_Santander_Coders.projeto.model.Deal
import org.apache.commons.csv.CSVFormat
import java.io.Writer

fun Writer.writeCsv(set:MutableSet<Deal>) {
    CSVFormat.DEFAULT.print(this).apply {
        printRecord("AGENCIA", "CONTA", "BANCO", "TITULAR", "OPERACAO", "DATAHORA", "VALOR")
        set.forEach { (holder, operation, dateTime, amount) ->
            printRecord(holder.agency, holder.account, holder.bank, holder.holder, operation, dateTime, amount)
        }
        println()
        printRecord("AGENCIA", "CONTA", "BANCO", "TITULAR","SALDO TOTAL")
    }
    this.flush()
}

fun Writer.writeCustomerCsv(set:MutableSet<Customer>) {
    CSVFormat.DEFAULT.print(this).apply {
        set.forEach { (agency, account, bank, holder, balance) ->
            printRecord(agency,account, bank, holder,balance)
        }
    }
    this.close()
}


