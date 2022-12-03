package POO_Santander_Coders.Enums

import java.sql.DriverManager
import java.sql.PreparedStatement

enum class Colors(
        val nameColor:String,
        val hex:String,
        val rgb:String
){
        VERMELHO(nameColor = "Vermelho", hex = "#eb4034", rgb = "235, 64, 52") {
                override fun transformarNomeEmUpperCase():String = "VERMELHO"

        },
        BRANCO(nameColor = "Branco", hex = "#ffffff", rgb = "255, 255, 255") {
                override fun transformarNomeEmUpperCase() :String{
                        return "Branco"
                }
        },
        PRETO(nameColor = "Preto", hex = "#000000", rgb = "0, 0, 0") {
                override fun transformarNomeEmUpperCase() :String{
                        return "PRETO"
                }
        },
        VERDE(nameColor = "Verde", hex = "#4dff00", rgb = "77, 255, 0") {
                override fun transformarNomeEmUpperCase():String {
                        return "VERDE"
                }
        };

        override fun toString(): String {
            return "Color(nameColor='$nameColor', hex='$hex', rgb='$rgb')"
        }
        abstract fun transformarNomeEmUpperCase() :String

}
data class Color(
        val nameColor:String,
        val hex:String,
        val rgb:String
)

enum class Status{
        ONLINE,
        OFFLINE,
        DORMINDO;
}

fun main(args: Array<String>) {
//      Color enum
        println(Colors.BRANCO)
        println(Colors.VERMELHO)
        println(Colors.VERDE)
        println(Colors.PRETO)
//        Status Enum
        println(Status.ONLINE.ordinal)
        println(Status.ONLINE)
        println(Status.OFFLINE.ordinal)
        println(Status.DORMINDO.ordinal)
}
