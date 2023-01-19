package estruturaDeDados_Santander_Coders.projeto.model

data class Bank(
    val name:String,
    val dealsBank: Set<Deal> = setOf()
){
    fun findDealsBank(deals:Collection<Deal>):Set<Deal> = deals.filter {
        it.customer.bank == name
    }.toSet()
}
