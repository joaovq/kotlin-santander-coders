package poo_Santander_Coders.exercicios.objects

class Objects {
//Exemplo
//    companion object é uma instância na classe

//    igual o static do Java
    companion object{
        val nome:String
            get() {
                return "Mar vermelho"
            }
    }
//    objeto test, declarado dentro da classe

    object test{
        val name:String
            get() {
                return "Mar vermelho"
            }
    }
}