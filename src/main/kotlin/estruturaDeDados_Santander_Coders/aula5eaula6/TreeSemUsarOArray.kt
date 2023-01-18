package estruturaDeDados_Santander_Coders.aula5eaula6

import kotlin.math.abs
import kotlin.math.max



data class Node2<T>(
    val value: T,
    var left: Node2<T>? = null,
    var right: Node2<T>? = null,
    var height: Int = 1
) {

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

fun <T> Node2<T>?.height(): Int {
    return this?.height ?: 0
}

class Tree2<T : Comparable<T>> {

    private var root: Node2<T>? = null

    /**
     * Se retornar >= 0 está balanceada
     * Caso contrário não está balanceada
     */
    fun isBalanced(node: Node2<T>? = root): Int {
        if (node == null) return 0

        val leftHeight = isBalanced(node.left)
        if (leftHeight < 0)
            return -1

        val rightHeight = isBalanced(node.right)
        if (rightHeight < 0)
            return -1

        if (abs(leftHeight - rightHeight) <= 1) {
            // está balanceado
            return max(leftHeight, rightHeight) + 1
        } else {
            return -1
        }
    }

    fun rotateLeft(node: Node2<T>): Node2<T>? {
        println("Rotate left " + node.value)
        val rightNode = node.right
        val leftOfRightNode = rightNode?.left

        rightNode?.left = node
        node.right = leftOfRightNode

        node.height = max(node.left.height(), node.right.height()) + 1
        rightNode?.height = max(rightNode?.left.height(), rightNode?.right.height() )

        return rightNode
    }

    fun rotateRight(node: Node2<T>): Node2<T>? {
        println("Rotate right " + node.value)
        val leftNode = node.left
        val rightOfLeftNode = leftNode?.right

        leftNode?.right = node
        node.left = rightOfLeftNode

        node.height = max(node.left.height(), node.right.height())
        leftNode?.height = max(leftNode?.left.height(), leftNode?.right.height())

        return leftNode
    }

    fun add(value: T) {

        if (root == null) {
            root = Node2(value)
        } else {
            root = add(root, value)
        }
    }

    private fun add(node: Node2<T>?, value: T): Node2<T>? {
        if (node == null)
            return Node2(value)

        if (node.value > value) {
            // inserir a esquerda
            node.left = add(node.left, value)
        } else if (node.value < value) {
            // inserir a direita
            node.right = add(node.right, value)
        } else {
            // não inserimos valores repetidos
            return node
        }

        node.height = 1 + max(node.left.height(), node.right.height())

        val balance = node.left.height() - node.right.height()

        if (balance > 1 && node.left!!.value > value) {
            return rotateRight(node)
        }

        if (balance < -1 && node.right!!.value < value) {
            return rotateLeft(node)
        }

        if (balance > 1 && node.left!!.value < value) {
            node.right = rotateLeft(node.left!!.right!!)
            return rotateRight(node)
        }

        if (balance < -1 && node.right!!.value > value) {
            node.left = rotateRight(node.right!!.left!!)
            return rotateLeft(node)
        }

        return node
    }

    fun search(value: T): Boolean {
        var node = root

        while (node != null) {
            when {
                node.value == value -> return true
                node.value > value -> node = node.left
                node.value < value -> node = node.right
            }
        }
        return false
    }

    fun remove(value: T) {
        if (root == null) return

        if (root!!.value > value) {
            remove(root!!, root?.left, value)
        } else if (root!!.value < value) {
            remove(root!!, root?.right, value)
        }
    }

    private fun remove(parent: Node2<T>, current: Node2<T>?, value: T) {
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

        return node.value.toString() +
                " " +
                toString(node.left) + " " +
                toString(node.right)
    }

    // In Order, Post Order, Pre Order
    // In Order = esq nó direita
    // Post Order = direita nó esquerda
    // Pre Order = nó esquerda direita

    fun preOrder(node: Node2<T>? = root) {
        if (node == null) return

        println(node.value)
        preOrder(node.left)
        preOrder(node.right)
    }

    fun inOrder(node: Node2<T>? = root) {
        if (node == null) return

        inOrder(node.left)
        println(node.value)
        inOrder(node.right)
    }

    fun postOrder(node: Node2<T>? = root) {
        if (node == null) return

        postOrder(node.right)
        println(node.value)
        postOrder(node.left)
    }
}

fun main() {
    val tree = Tree2<Int>()
    tree.add(8)
    println(tree.isBalanced()) //true
    tree.add(5)
    println(tree.isBalanced()) // true
    tree.add(4)
    println(tree.isBalanced())
    tree.add(10)
    println(tree.isBalanced())
    tree.add(9)

    println("------------")
    tree.inOrder()
    println("------------")
    tree.postOrder()
    println("------------")
    tree.preOrder()
}