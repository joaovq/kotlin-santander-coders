package EstruturaDeDados_Santander_Coders.Exercicios.Listas


/*
*
*
* TODO:Dado a estrutura de lista ligada que construímos em sala, adicionar:
*  -Método de busca por um valor específico
*  -Otimização para termos a adição de um nó ao final de O(1),
*  ou seja, será necessário manter uma referência para o último elemento da lista
*
* */
data class Node<T>(
    var value: T,
    var next: Node<T>?
)

data class LinkedList2<T>(
    var head: Node<T>? = null
) {
    private var last:Node<T>? = null
    fun add(value: T) {
        val newNode = Node(value = value, null)

        if (head == null) {
            head = newNode
            last = newNode
            return
        } else {
//            var current = head
//            while (current?.next != null) {
//                current = current.next
//            }
            val current = last
            current?.next = newNode
            last = newNode
        }
    }

    fun getIndexAt(searchedValue: T):Int?{
        var current = head
        var currentIndex: Int  = 0
        if (current == null){
            println("Lista vazia")
            return null
        }

        do{
            if (current?.value==searchedValue) {
                return currentIndex
            }
            current = current?.next
            currentIndex++
        }
        while (current!=null)

        println("Elemento procurado não existe dentro da lista")
        return null
    }

    fun getNode(searchedValue: T):Node<T>?{
        var current = head
        if (current == null){
            println("Lista vazia")
            return null
        }

        do{
            if (current?.value==searchedValue) {
                return current
            }
            current = current?.next
        }
        while (current!=null)

        println("Elemento procurado não existe dentro da lista")
        return null
    }

    fun remove(value: T): Boolean {
        if (head?.value == value) {
            head = head?.next
            return true
        }
        var current = head?.next
        var previous = head

        while(current != null && current.value != value) {
            previous = current
            current = current.next
        }

        if (current != null) {
            previous?.next = current.next
            return true
        }

        return false
    }

    fun show() {
        var current = head
        if (current == null) {
            println("Lista vazia")
            return
        }

        while(current != null) {
            println(current.value)
            current = current.next
        }
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}

fun main(args: Array<String>) {
    val listOfInts = LinkedList2<Int>()

    listOfInts.add(1)
    listOfInts.add(2)
    listOfInts.add(2)
    listOfInts.add(3)

    listOfInts.show()

    listOfInts.remove(2)
    listOfInts.show()

    val indexOfSearched = listOfInts.getIndexAt(3)
    val nodeResult = listOfInts.getNode(2)

    println(nodeResult)

    println(indexOfSearched)
}