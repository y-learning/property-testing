package me.why.math

fun maxOfTwo(a: Int, b: Int): Int = when {
    a < b -> b
    else -> a
}

fun maxOfInts(list: List<Int>): Int? = when {
    list.isEmpty() -> null
    else -> list.fold(list.first(), ::maxOfTwo)
}