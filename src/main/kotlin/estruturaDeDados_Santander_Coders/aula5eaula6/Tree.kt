package estruturaDeDados_Santander_Coders.aula5eaula6

data class Node<T>(var value:T)
class Tree<T :Comparable<T>>{
    private val container = arrayOfNulls<Node<T>>(100)
    fun add(value: T,index:Int = 0){
        val node = container[index]

        if (node == null){
            container[index]= Node(value)
        }
        else if (node.value >= value){
            add(
                value,(2*index).coerceAtLeast(1))
        }else{
            add( value, 2+(index+1))
        }
    }

    override fun toString(): String {
        return "Tree(container=${container.contentToString()})"
    }


}

fun main(args: Array<String>) {
    val tree = Tree<Int>()
    tree.add(5)
    tree.add(5)
    tree.add(5)
    tree.add(5)
    tree.add(5)

    println(tree)
}
