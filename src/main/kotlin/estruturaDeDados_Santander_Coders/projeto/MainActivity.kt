package estruturaDeDados_Santander_Coders.projeto

import estruturaDeDados_Santander_Coders.projeto.model.Bank
import estruturaDeDados_Santander_Coders.projeto.reader.DealsReaderCsv
import estruturaDeDados_Santander_Coders.projeto.writer.CustomerWriterCsv
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


fun main() {
    val bank:Bank = Bank("SANTANDER")
    val bankReader = DealsReaderCsv(bank)
    val path = "utils/operacoes.csv"
    bankReader.getDealsFromCsv(path)
    bankReader.sort(path).forEach {
        println(it)
    }
    println()
    val writerCsv = CustomerWriterCsv()
    bankReader.getCustomersWithBalance(path).forEach {
        println(it)
    }

    writerCsv.apply {
        val pathDeals = "utils/dealsCustomers"+LocalDateTime.now().format(formatter)+".csv"
        writeCsv(pathDeals, bankReader.getCustomersWithBalance(path))
    }
}
val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")