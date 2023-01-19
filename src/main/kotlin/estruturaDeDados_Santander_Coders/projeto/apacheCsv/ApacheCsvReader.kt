package estruturaDeDados_Santander_Coders.projeto.apacheCsv

import org.apache.commons.csv.CSVFormat
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Paths
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    val reader: Reader = Files.newBufferedReader(Paths.get("utils/operacoes.csv"))
    val readCsv = readCsv(reader)
    readCsv.forEach {
        println(it)
    }
    println()
    val toMutableSet = readCsv.toMutableSet()

    toMutableSet.forEach {
        println(it )
    }
}

fun readCsv(reader:Reader)= CSVFormat.Builder.create(CSVFormat.DEFAULT).apply {
        setIgnoreSurroundingSpaces(true)
    }.build().parse(reader)
        .drop(1)
        .map {
            Deal(
                agency = it[0].toInt(),
                account = it[1].toInt(),
                bank = it[2],
                holder = it[3],
                operation = it[4],
                dateTime = it[5],
                amount = it[6].toDouble()
            )
        }
//Posso colocar para um mutableSet Direto
//.toMutableSet()

data class Deal(
    var agency: Int,
    var account: Int,
    var bank: String,
    var holder: String,
    var operation: String,
    var dateTime:String,
    var amount: Double
){

    override fun toString(): String {
        return "Deal(agencia=$agency, conta=$account, banco='$bank', titular='$holder', operacao='$operation', dataHora='$dateTime', valor=$amount)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other !is Deal) return false
        return other.operation == operation
                && other.dateTime == dateTime
                && other.amount ==amount
    }

    override fun hashCode(): Int {
        var result = agency
        result = 31 * result + account
        result = 31 * result + bank.hashCode()
        result = 31 * result + holder.hashCode()
        result = 31 * result + operation.hashCode()
        result = 31 * result + dateTime.hashCode()
        result = 31 * result + amount.hashCode()
        return result
    }
}
val dateFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")