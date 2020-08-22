package me.why.math

fun maxOfInts(list: List<Int>): Int? = when {
    list.isEmpty() -> null
    else -> list.fold(list.first()) { max: Int, i: Int ->
        if (i > max) i
        else max
    }
}