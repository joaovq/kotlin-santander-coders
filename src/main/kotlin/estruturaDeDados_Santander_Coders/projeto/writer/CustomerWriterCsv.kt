package estruturaDeDados_Santander_Coders.projeto.writer

import estruturaDeDados_Santander_Coders.projeto.model.Customer
import poo_Santander_Coders.exercicios.concat
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.NoSuchFileException


class CustomerWriterCsv :WriterCsv<Customer> {
    override fun writeCsv(path: String, set: Collection<Customer>) {
        println("\nSalvando no arquivo csv:$path")
       try {
           val writer = File(path).bufferedWriter()
           writer.write("AGENCIA, CONTA, BANCO, TITULAR, SALDOTOTAL,")
           writer.newLine()
           set.forEach {
                   customer-> writer.write("${customer.agency}," +
                   " ${customer.account}," +
                   "${customer.bank}," +
                   "${customer.holder}," +
                   "${customer.balance}")
               writer.newLine()
           }

           writer.flush()
           writer.close()
       }catch (e:FileNotFoundException){
           e.printStackTrace()
       }
        catch (e:NoSuchFileException){
            e.printStackTrace()
        }
        println("\nSalvo no arquivo csv:$path")
    }
}