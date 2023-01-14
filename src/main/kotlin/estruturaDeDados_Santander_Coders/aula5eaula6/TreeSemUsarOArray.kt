package estruturaDeDados_Santander_Coders.aula5eaula6

import kotlin.math.abs
import kotlin.math.max

data class Node2<T>(val value:T, var left:Node2<T>? = null, var right:Node2<T>?=null, var height:Int = 0){
    fun isLeaf(): Boolean {
        return left == null && right == null
    }

    fun removeLeaf(current: Node2<T>) {
        if (current == left) left = null
        else if (current == right) right = null
    }

    fun hasSingleNode(): Boolean {
        return when {
            left == null && right != null -> true
            left != null && right == null -> true
            else -> false
        }
    }

    fun removeSingleChildNode(current: Node2<T>) {
        if (left == current) {
            left = when {
                current.left != null -> current.left
                current.right != null -> current.right
                else -> null
            }
        } else if (right == current) {
            right = when {
                current.left != null -> current.left
                current.right != null -> current.right
                else -> null
            }
        }
    }
}

class Tree2<T:Comparable<T>> {
    private var root: Node2<T>? = null


    fun isBalanced(node: Node2<T>? = root):Int{
        if (node == null) return 0

        val leftHeight  = isBalanced(node.left)

        if (leftHeight < 0) return -1

        val rightHeight = isBalanced(node.right)

        if (rightHeight < 0) return -1

        return if (abs(leftHeight-rightHeight) <=1){
    //            Está balanceado
            max(leftHeight, rightHeight)+1
        } else{
            -1
        }
    }

    fun rotateLeft(node:Node2<T>): Node2<T>?{
        val right = node.right
        val leftRightNode = right?.left

        right?.left = node
        node.right = leftRightNode
        return right
    }
    fun rotateRight(node: Node2<T>):Node2<T>?{
        val leftNode = node.left
        val rightLeftNode = leftNode?.right


        leftNode?.right = node
        node.left = rightLeftNode

        return leftNode
    }
    fun add(value:T){
        if (root == null){
            root = Node2(value)
        }else{
            add(root!!, value)
        }
    }

    private fun add(node: Node2<T>?, value: T):Node2<T> {
        if (node == null) return Node2(value)

//Para a arvore AVL
        if (node.value> value){
//            Inserir a esquerda
            node.left = add(node.left, value)
        }else if (node.value< value){
            node.right = add(node.right, value)
        }
        else{
            return node
        }

//        val balance: Int = (node.left?.height() - node.right.height())

        return node
       /* if (node.value >= value) {
            if (node.left == null) {
                println("add esquerda ${node.value}")
                node.left = Node2(value)
            } else {
                println("esquerda")
                add(node.left!!, value)
            }
        } else {
            if (node.right == null) {
                println("add direita ${node.value}")
                node.right = Node2(value)
            } else {
                println("direita")
                add(node.right!!, value)
            }
        }*/
    }
//      O(log n)
//    Precisa de menos tempo para procurar e salvar os dados
    fun search(value: T): Boolean {
        var next = root
        do {
            next =
                when{
                    next?.value!!>value->{
                        next.left
                    }
                    next.value >value->{
                        next.left
                    }
                    next.value == value->{
                        return true
                    }
                    else -> {
                        return false
                    }
                }
        }while (next !=null)
        return false
    }



    fun remove(value: T){
        if (root == null) return

        if (root?.value!!>=value){
            remove(root!!, root?.left!!, value)
        }else{
            remove(root!!, root?.right!!, value)
        }

    }

    private fun remove(parent:Node2<T>, current:Node2<T>?, value: T){
        if (current == null) return

        if (current.value == value) {
            when {
                current.isLeaf() -> { parent.removeLeaf(current) }
                current.hasSingleNode() -> {
                    parent.removeSingleChildNode(current)
                }
                // TODO remover nós com dois filhos
            }
        } else if (current.value > value) {
            remove(current, current.left, value)
        } else {
            remove(current, current.right, value)
        }
    }


    override fun toString(): String {
        return toString(root)
    }

    private fun toString(node: Node2<T>?): String {
        if (node == null) return ""

        return node.value.toString() + " " + toString(node.left) + " " + toString(node.right)
    }

}


fun <T> Node2<T>.height() = this.height

fun main(args: Array<String>) {
    val tree2 = Tree2<Int>()
    tree2.add(8)
    println(tree2.isBalanced())
    tree2.add(5)
    println(tree2.isBalanced())
    tree2.add(4)
    println(tree2.isBalanced())

    val search = tree2.search(3)

    println(search)
}