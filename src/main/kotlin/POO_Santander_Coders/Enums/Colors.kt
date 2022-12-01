package POO_Santander_Coders.Enums

import org.w3c.dom.css.RGBColor
import javax.swing.plaf.synth.ColorType

enum class Color(val nameColor:String,val hex:String,val rgb:String){
        VERMELHO(nameColor = "Vermelho", hex = "#eb4034", rgb = "235, 64, 52") {
                override fun transformarNomeEmUpperCase():String {
                        return "VERMELHO"
                }
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

enum class Status{
        ONLINE,
        OFFLINE,
        DORMINDO;
}

fun main(args: Array<String>) {
//      Color enum
        println(Color.BRANCO)
        println(Color.VERMELHO)
        println(Color.VERDE)
        println(Color.PRETO)
//        Status Enum
        println(Status.ONLINE.ordinal)
        println(Status.ONLINE)
        println(Status.OFFLINE.ordinal)
        println(Status.DORMINDO.ordinal)


}
