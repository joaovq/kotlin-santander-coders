import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val file = File("utils/file.text")
    val read = FileInputStream(file).read()
    val fileInputStream :InputStreamReader = FileInputStream(file).reader(Charsets.UTF_8)


    println(read)
}