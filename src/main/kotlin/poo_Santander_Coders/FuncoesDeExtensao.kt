package poo_Santander_Coders

fun <T> List<T>.printLista(){
    this.forEach{
        println(it)
    }
}

class FormularioFuncionario(nome:String, sobrenome:String, cpf:String)

class FuncionarioFuncao(nome:String, sobrenome:String, cpf:String, cargo:String, salario:Double)
fun FormularioFuncionario.validaFuncionario() : FuncionarioFuncao {
// se cpf é válido, inseri-lo formatado para o funcionario a ser criado
    return FuncionarioFuncao("","","","", 1000.0)
}
