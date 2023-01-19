package estruturaDeDados_Santander_Coders.projeto.apacheCsv

import org.apache.commons.csv.CSVFormat
import java.io.File
import java.io.Writer
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val writable = File("utils/deals.csv")
    val writer1 = writable.writer(Charset.defaultCharset())
    writer1.write("Hello")
    val mutableSetOf = mutableSetOf(
        Deal(
            1520,
            1,
            bank = "SANTANDER",
            "JOAO",
            "SAQUE",
            "2022-02-10T10:13:39",
            150.0
        )
    )
    writer1.writeCsv(mutableSetOf.toMutableList())
}

fun Writer.writeCsv(set:MutableList<Deal>) {
    CSVFormat.DEFAULT.print(this).apply {
        printRecord("AGENCIA", "CONTA", "BANCO", "TITULAR", "OPERACAO", "DATAHORA", "VALOR")
        set.forEach { (agency, account, bank, holder, operation, dateTime, amount) ->
            printRecord(agency, account, bank, holder, operation, dateTime, amount)
        }
    }
}

