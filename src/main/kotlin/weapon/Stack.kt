package weapon

class Stack<T>  {

     private val items: MutableList<T> = mutableListOf()

    fun push(item: T) = items.add(item)

    fun pop(): T? = items.removeLastOrNull()

    fun isEmpty(): Boolean = items.isEmpty()

}
