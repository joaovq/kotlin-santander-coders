package POO_Santander_Coders.Exercicios.Solid

fun main(args: Array<String>) {
    val list:List<Arquivo> = listOf(ArquivoPdf(), ArquivoWord(), ArquivoWord(), ArquivoWord())

    GeradorDeArquivos().geradorDeArquivos(list)
}
interface Arquivo{
    fun gerarArquivo()
}

class GeradorDeArquivos{
    fun geradorDeArquivos(arquivos: List<Arquivo>){
        arquivos.forEach{ arquivo ->
            arquivo.gerarArquivo()
        }
    }
    fun geradorDeArquivos(arquivos: Arquivo){
        arquivos.gerarArquivo()
    }

}

class ArquivoPdf:Arquivo{
    override fun gerarArquivo() {
        println("Gerando arquivo em word")
    }
}
class ArquivoWord:Arquivo{
    override fun gerarArquivo() {
        println("Gerando arquivo em pdf")
    }
}
/*//Fazendo de outro jeito
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

}*/

