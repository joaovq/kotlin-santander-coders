package poo_Santander_Coders

fun main(args: Array<String>) {

}
data class Nota(val valor:Double, val total:Double)

val List<Nota>.mediaPercentual: Double
    get() {
        var totalRecebido = 0.0
        var totalDistibuido = 0.0

        this.forEach{
            nota ->

            totalRecebido+=nota.valor
            totalDistibuido+=nota.total
        }


        return totalRecebido/(totalDistibuido*100)
    }

