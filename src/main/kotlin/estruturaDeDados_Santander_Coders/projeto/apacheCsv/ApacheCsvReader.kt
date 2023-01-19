package estruturaDeDados_Santander_Coders.projeto.apacheCsv

import estruturaDeDados_Santander_Coders.projeto.enums.Operations
import estruturaDeDados_Santander_Coders.projeto.model.Customer
import estruturaDeDados_Santander_Coders.projeto.model.Deal
import org.apache.commons.csv.CSVFormat
import java.io.Reader
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class ApacheCsvReader(){
    fun filterCSV(reader:Reader)= TreeSet<Deal>(readCSV(reader))

    fun readCSV(reader:Reader) =
        CSVFormat.Builder.create(CSVFormat.DEFAULT).apply {
            setIgnoreSurroundingSpaces(true)
        }.build().parse(reader)
            .drop(1)
            .map {
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
            }.toSet()

}

