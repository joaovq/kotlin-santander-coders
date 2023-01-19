package estruturaDeDados_Santander_Coders.aula8AlgDeOrdenacao

/**hello**/
/**esq(indice*2)+1
 *
 * direita(indice*2)+2**/
//Heap pode ser de minimo ou máximo

/*
*
* (tamanho do array/2)+1
*
*  */

fun printArray(intArray: IntArray){
    intArray.forEach {
        print("$it ")
    }
    println()
}
fun main(args: Array<String>) {
    val intArrayOf = intArrayOf(1, 5, 3, 4, 2)
    heapSort(intArrayOf)
}

private fun heapSort(intArray: IntArray) {
    //    O(n log n)
    makeIntoHeap(intArray)
//    Ordenação de uma arvore ordenada
    printArray(intArray)

    for (i in intArray.lastIndex downTo 0) {
        val highestValue = intArray[0]
        intArray[0] = intArray[i]
        intArray[i] = highestValue
        heapify(0, i - 1, intArray)
    }
    printArray(intArray)
}

/**
* Complexidade de temo O(n log n )
* Complexidade espacial de O(1)
* */

fun makeIntoHeap(list:IntArray){
    val lastNodeWithLeaf=(list.size/2)-1
    for (i in lastNodeWithLeaf downTo 0){
        heapify(i, list.lastIndex, list)
    }
}

private fun heapify(rootIndex: Int, heapSize: Int, list: IntArray) {
    val leftIndex = (rootIndex * 2) + 1
    val rightIndex = (rootIndex * 2) + 2

    var highestValueIndex = rootIndex

    if (heapSize >= leftIndex && list[leftIndex] > list[highestValueIndex]) {
        highestValueIndex = leftIndex
    }
    if (heapSize >= rightIndex && list[rightIndex] > list[highestValueIndex]) {
        highestValueIndex = rightIndex
    }
    if (highestValueIndex != rootIndex) {
        val tmp = list[rootIndex]
        list[rootIndex] = list[highestValueIndex]
        list[highestValueIndex] = tmp
        heapify(highestValueIndex,heapSize,list= list)
    }
}