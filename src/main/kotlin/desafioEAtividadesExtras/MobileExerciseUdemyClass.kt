package desafioEAtividadesExtras

fun main(args: Array<String>) {
    MobilePhone(osName = "Android", brand = "Motorola", model = "G7")
    MobilePhone(osName = "Android", brand = "Samsung", model = "S20 Ultra")
    MobilePhone(osName = "IOS", brand = "Apple", model = "Iphone 14")


}
class MobilePhone (osName:String, brand:String, model:String){
    init {
        println("$brand $model. Here the osName is $osName, brand is $brand, model is $model")
    }
}