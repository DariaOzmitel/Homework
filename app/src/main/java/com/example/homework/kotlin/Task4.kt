package com.example.homework.kotlin

fun List<Int?>?.shakerSortWithNulls(): List<Int?> {
    if (this == null) return emptyList()

    val nonNulls = this.filterNotNull().toMutableList()
    val nullCount = this.count { it == null }

    var start = 0
    var end = nonNulls.size - 1
    var swapped: Boolean

    do {
        swapped = false

        for (i in start until end) {
            if (nonNulls[i] > nonNulls[i + 1]) {
                val tmp = nonNulls[i]
                nonNulls[i] = nonNulls[i + 1]
                nonNulls[i + 1] = tmp
                swapped = true
            }
        }

        if (!swapped) break

        end--

        for (i in end downTo start + 1) {
            if (nonNulls[i] < nonNulls[i - 1]) {
                val tmp = nonNulls[i]
                nonNulls[i] = nonNulls[i - 1]
                nonNulls[i - 1] = tmp
                swapped = true
            }
        }

        start++
    } while (swapped)

    return nonNulls + List(nullCount) { null }
}

fun main() {
    val list: List<Int?>? = listOf(5, null, 2, 9, null, 3, 1)

    val sorted = list.shakerSortWithNulls()
    println(sorted)
}