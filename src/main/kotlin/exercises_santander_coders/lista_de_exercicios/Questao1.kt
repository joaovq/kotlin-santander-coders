package exercises_santander_coders.lista_de_exercicios

fun main(args: Array<String>) {
    var maior: Int =0
    var menor: Int = 0
    var num:Int
    for (i in 0 until 10){
        println("Digite o número ${i+1}:")
        num = readln().toInt()
//        Validação
        if (i==0) {
             maior = num
             menor = num
        }
//        Código do maior
        maior = if (num > maior){
            num
        }
        else{
            maior
        }
//        Código do menor
        menor = if (num < menor){
            num
        }
        else{
            menor
        }

        println(maior)
        println(menor)
    }
}