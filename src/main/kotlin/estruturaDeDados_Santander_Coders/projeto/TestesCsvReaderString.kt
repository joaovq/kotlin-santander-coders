package estruturaDeDados_Santander_Coders.projeto

import com.opencsv.CSVReaderBuilder
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val reader:Reader = Files.newBufferedReader(Paths.get("utils/operacoes.csv"))
    val csvReader = CSVReaderBuilder(reader).withSkipLines(1).build()
    val list = csvReader.readAll()
    list.forEach{
        print("${it[0]} ,${it[1]} ,${it[2]} ,${it[3]} ,${it[4]} ,${it[5]} ,${it[6]}")
        println()
    }
}