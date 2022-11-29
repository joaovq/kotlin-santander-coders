package Exercises_Santander_Coders_Lógica.aula2


/*
*   TODO: O usuário não pode ter menos que 6 caracteres
*    e mais de 10 caracteres
*
*
* */


fun main(args: Array<String>) {

    println("-----Área de Cadastro----")
    println("min de 6 char")
    println("max de 10 char")

    println("Digite o usuário desejado")
    val user = readln()

//    if bem legal para utilizar
    val length = user.length
    if (length in (6..10)) {
        println("Usuário cadastrado!")
    }
    else{
        println("Usuário não cadastrado")
    }


//     Utilizando o when
//    Declarando de uma vez
     when{
        length in 6..10 -> println("Usuário cadastrado")
        length >10 -> println("Usuário não pode ser cadastrado com mais de 10 caracteres.")
        else -> println("Usuário não cadastrado")
    }


    when(length){
         in 6..10 -> println("Usuário cadastrado")
          in 0 ..  10 -> println("Usuário não pode ser cadastrado com mais de 10 caracteres.")
        else -> println("Usuário não cadastrado")
    }

    val result =  when{
        (length in 6..10) and user.first().isUpperCase()  -> "Usuário cadastrado"
        length >10 -> "Usuário não pode ser cadastrado com mais de 10 caracteres."
//        Não vai testar se alguma acima for verdadeira
        user.first().isUpperCase() -> "É maiuscula"
        else -> "Usuário não cadastrado"
//        else ->{
//            println("")
//        }
    }

    println(result)

}