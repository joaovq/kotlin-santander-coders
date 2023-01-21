package estruturaDeDados_Santander_Coders.projeto.writer

import java.io.File

interface WriterCsv<T> {
     fun writeCsv(path:String, set:Collection<T>)
}