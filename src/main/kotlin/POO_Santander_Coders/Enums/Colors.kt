package POO_Santander_Coders.Enums

import org.w3c.dom.css.RGBColor
import javax.swing.plaf.synth.ColorType

enum class Color(val nameColor:String,val hex:String,val rgb:String){
        VERMELHO(nameColor = "Vermelho", hex = "#eb4034", rgb = "235, 64, 52"),
        BRANCO(nameColor = "Branco", hex = "#ffffff", rgb = "255, 255, 255"),
        PRETO(nameColor = "Preto", hex = "#000000", rgb = "0, 0, 0"),
        VERDE(nameColor = "Verde", hex = "#4dff00", rgb = "77, 255, 0");

        override fun toString(): String {
            return "Color(nameColor='$nameColor', hex='$hex', rgb='$rgb')"
        }

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
        println(Status.ONLINE)
//        Status Enum
        println(Status.ONLINE.ordinal)
        println(Status.OFFLINE.ordinal)
        println(Status.DORMINDO.ordinal)


}
