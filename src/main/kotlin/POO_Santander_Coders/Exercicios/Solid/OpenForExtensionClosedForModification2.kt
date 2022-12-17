package POO_Santander_Coders.Exercicios.Solid

fun main(args: Array<String>) {
    val list:List<Arquivo> = listOf(ArquivoPdf(), ArquivoWord(), ArquivoWord(), ArquivoWord())

    ArquivoPdf().geradorDeArquivos()

}

interface Arquivo{

    private fun gerarPdf(){
        println("Gerando pdf ")
    }
    private fun gerarWord(){
        println("Gerando word ")
    }

    fun geradorDeArquivos(arquivos: List<Arquivo>){
        arquivos.forEach{ arquivo ->
            when(arquivo){
                is ArquivoPdf -> gerarWord()
                is ArquivoWord -> gerarPdf()
                else->{
                    println("Não conseguimos gerar o Arquivo")
                }
            }

        }
    }
    fun geradorDeArquivos(){
            when(this){
                is ArquivoPdf -> gerarWord()
                is ArquivoWord -> gerarPdf()
                else->{
                    println("Não conseguimos gerar o Arquivo")
                }
            }
    }
}

class ArquivoPdf:Arquivo{
}
class ArquivoWord:Arquivo{
}

