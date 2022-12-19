fun main(args: Array<String>) {
}




data class WordCupStickers(
    private val stickers: MutableList<Sticker> = mutableListOf()
){
    fun addSticker(sticker: Sticker){
        stickers.add(sticker)

    }

     fun removeSticker(name: String){
        stickers.removeIf{
            it.name == name
        }
        println("$name foi removido")
    }

    fun findByName(name: String):Sticker?{
        return stickers.find {
            it.name == name
        }
    }


    fun sortSticker(){
        return stickers.sortBy { it.name }
    }
}

data class Sticker(
  val number: Int,
  val name:String,
  val team:String
)
