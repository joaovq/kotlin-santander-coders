package estruturaDeDados_Santander_Coders.projeto

import com.opencsv.bean.CsvToBeanBuilder
import java.io.Reader
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDateTime

fun main(args: Array<String>) {
    val reader:Reader = Files.newBufferedReader(Paths.get("utils/operacoes.csv"))
    val csvReader = CsvToBeanBuilder<Deal>(reader).withType(Deal::class.java).build()
    val list = csvReader.parse()
    list.forEach{
        print("${it}")
        println()
    }
    val newBufferedWriter = Files.newBufferedWriter(Paths.get("utils/finish.csv"))
}

class Deal{
    //    Para funcionar a conversão para classe, precisa de um construtor padrão vazio
    var agencia: Int = 0
    var conta: Int = 0
    var banco: String =""
    var titular: String =""
    var operacao: String = ""
    var dataHora:String = ""
    var valor: Double= 0.0

    override fun toString(): String {
        return "Transaction(agencia=$agencia, conta=$conta, banco='$banco', titular='$titular', operacao='$operacao', dataHora='$dataHora', valor=$valor)"
    }
}