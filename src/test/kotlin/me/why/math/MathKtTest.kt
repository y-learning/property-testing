package me.why.math

import io.kotest.core.spec.style.FunSpec
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.forAll


class MyTests : FunSpec({
    context("maxOfTwo") {
        test("returns the greater of two values `a` and `b`.") {
            forAll(Arb.int(), Arb.int()) { a: Int, b: Int ->
                val max = maxOfTwo(a, b)

                when {
                    a >= b -> max == a
                    else -> max == b
                }
            }
        }
    }

    context("maxOfInts") {
        test("returns null when the list is empty.") {
            forAll(Arb.list(Arb.int()).filter { it.isEmpty() }) { ints: List<Int> ->
                val maxOfInts = maxOfInts(ints)

                maxOfInts == null
            }
        }

        test("returns an element that belongs to the list.") {
            forAll(Arb.list(Arb.int()).filter { it.isNotEmpty() }) { list: List<Int> ->
                val max = maxOfInts(list)

                list.contains(max)
            }
        }

        test("returns the max of elements") {
            forAll(Arb.list(Arb.int()).filter { it.isNotEmpty() }) { list: List<Int> ->
                val max = maxOfInts(list)

                max != null &&
                        list.fold(false) { _, i -> max >= i }
            }
        }
    }
})