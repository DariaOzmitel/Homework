package com.example.homework.kotlin

//Задача 1
data class Key(
    val field1: Int,
    var field2: String
) {
    var field3: String? = null

}
//Могут ли возникнуть какие-то проблемы, если мы будем использовать подобный класс
//в качестве ключа для HashMap?

//Проблемы возникнуть могут, так как ключи в HashMap должны быть не изменяемы. В дата классе хэш
// код вычисляется по конструктору, по этому там не должно быть полей var.
//Пример ошибки:

fun main() {
    val map = HashMap<Key, String>()

    val key = Key(1, "initial")
    map[key] = "value"
    println(map[key]) // вернет value
    key.field2 = "changed"
    println(map[key]) //вернет null
}
