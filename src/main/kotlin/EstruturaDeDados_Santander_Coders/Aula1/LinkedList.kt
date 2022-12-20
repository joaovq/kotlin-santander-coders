package EstruturaDeDados_Santander_Coders.Aula1

// Listas ligadas guardam o endereço de memória do próximo item e o valor

data class Node<T>(
    var value: T,
    var next: Node<T>?
)

data class LinkedList2<T>(
    var head:Node<T>? = null
) {
    fun add(value: T) {
        val newNode = Node(value = value, next = null)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun show() {
        if (head == null) {
            println("Lista está vázia")
        } else {
            var current = head
            while (current != null) {
                print("[$current] ")
                current = current.next
            }
            println("\n")
        }
    }
    fun isEmpty(): Boolean {
        return head == null
    }

    fun remove(value: T) {
        if (head?.value == value) {
            head = head?.next
            return
        }

        var current = head
        while (current != null){
            if (current.next?.value == value) {
                current.next = current.next?.next
            }
            else {
                current = current.next
            }
        }
    }
}

fun main(args: Array<String>) {
    val linkedList2 = LinkedList2<Int>()

    linkedList2.add(2)
    linkedList2.add(4)
    linkedList2.show()

    linkedList2.remove(4)
    linkedList2.show()
}