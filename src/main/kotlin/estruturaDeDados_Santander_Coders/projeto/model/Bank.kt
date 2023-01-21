package estruturaDeDados_Santander_Coders.projeto.model


data class Bank(
    val name:String,
    var dealsBank: MutableSet<Deal> = mutableSetOf()
)
