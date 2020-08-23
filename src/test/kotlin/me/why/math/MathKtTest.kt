package me.why.math

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.forAll


class MathTest : StringSpec({
    "maxOfTwo" {
        forAll(Arb.int(), Arb.int()) { a: Int, b: Int ->
            val max = maxOfTwo(a, b)

            when {
                a >= b -> max == a
                else -> max == b
            }
        }
    }

    "maxOfInts returns null when the list is empty." {
        forAll(Arb.list(Arb.int()).filter { it.isEmpty() }) { ints: List<Int> ->
            val maxOfInts = maxOfInts(ints)

            maxOfInts == null
        }
    }

    "maxOfInts returns an element that belongs to the list." {
        forAll(Arb.list(Arb.int()).filter { it.isNotEmpty() }) { list: List<Int> ->
            val max = maxOfInts(list)

            list.contains(max)
        }
    }

    "maxOfInts returns the max of elements" {
        forAll(Arb.list(Arb.int()).filter { it.isNotEmpty() }) { list: List<Int> ->
            val max = maxOfInts(list)

            max != null &&
                    list.fold(false) { _, i -> max >= i }
        }
    }
})