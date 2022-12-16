package POO_Santander_Coders.Exercicios.Solid

fun main(args: Array<String>) {

}

fun interface DataSource{
    fun getDataSource()
}

//Cada função podem implementar uma interface funcional também
internal fun createDataSource(): DataSource = TODO("Provide a datasource")