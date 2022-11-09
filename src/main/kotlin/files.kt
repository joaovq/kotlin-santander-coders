import java.io.File

fun main(args: Array<String>) {
    val file = File("utils/file.text").createNewFile()

    val file1 :File = File("utils")
    val packages = Package.getPackages()


    for (packag:Package in packages ){
        println(packag)
    }
    println(file)

}