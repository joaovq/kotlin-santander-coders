package Exercises_Santander_Coders.aula1

import java.io.File
import java.lang.StringBuilder
import java.util.*

/*TODO:
   3 - Gerador de usuarios.
   Crie um programa que receba o nome, sobrenome e ano de nascimento do usuário,
    e a partir disso gere um nick com as duas primeiras letras do nome, seu sobrenome
    ao contrario e os ultimos dois digitos de seu ano de nascimento tudo minusculo.
    Exemplo:
            - Maria
            - Medeiros
            - 1984
     nick gerado: masoriedem84

     TODO: Ver se consigo modificar a data de nascimento com int e não String
*
*
*
* */
fun main(args: Array<String>) {
    val nome:String
    val sobrenome:String
    val dataDeNascimento:Int?

    println("Digite o seu nome:" )
    nome = readln()
    println("Digite o seu sobrenome:" )
    sobrenome = readln()
    println("Digite o sua data de nascimento:" )
    dataDeNascimento = readln().toIntOrNull()

//    Gerador de nickname

//    reverse com StringBuilder
//    val sobrenomeBuilder:StringBuilder = StringBuilder(sobrenome).reverse()


    val reversed = sobrenome.reversed()

//    Maneira antiga
//    var stringBuilder:StringBuilder = StringBuilder(nome.subSequence(0,2)).
//                                        append(reversed).
//                                        append(dataDeNascimento?.toString()?.get(2)).
//                                        append(dataDeNascimento?.toString()?.get(3))
//    var stringBuilder:StringBuilder = StringBuilder(nome.subSequence(0,2)).
//                                        append(reversed).
//                                        append(dataDeNascimento.toString().subSequence(2,4))
    var stringBuilder:StringBuilder = StringBuilder(nome.substring(startIndex = 0, endIndex = 2)).
                                        append(reversed).
                                        append(dataDeNascimento.toString().substring(startIndex = 2))
    val nickname = stringBuilder.toString().lowercase()

//    Print do nickname
    println("nickname gerado: $nickname")

    val file =File("")
}