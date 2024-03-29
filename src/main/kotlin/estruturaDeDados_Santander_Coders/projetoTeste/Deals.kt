package estruturaDeDados_Santander_Coders.projetoTeste

import estruturaDeDados_Santander_Coders.projetoTeste.apacheCsv.ApacheCsvReader
import estruturaDeDados_Santander_Coders.projetoTeste.apacheCsv.writeCsv
import estruturaDeDados_Santander_Coders.projetoTeste.enums.Operations
import estruturaDeDados_Santander_Coders.projetoTeste.model.Customer
import estruturaDeDados_Santander_Coders.projetoTeste.model.Deal
import java.io.Reader
import java.io.Writer
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDateTime

object TestDeals {

    val reader: Reader = Files.newBufferedReader(Paths.get("utils/operacoes.csv"))
    val writer: Writer = Files.newBufferedWriter(Paths.get("utils/deals.csv"))
    fun getDeals(): MutableSet<Deal> {
        val readerCSV = ApacheCsvReader()
        return readerCSV.filterCSV(reader)
    }
    fun writeInCSV(){
        val mutableSetOf = mutableSetOf(
            Deal(
                Customer(1520,1, "SANTANDER","Joao",0.0),
                Operations.SAQUE,
                LocalDateTime.now(),
                150.0
            )
        )
        writer.writeCsv(mutableSetOf)


        println(LocalDateTime.now())
    }

}

fun main(args: Array<String>) {
    println(TestDeals.getDeals())
}