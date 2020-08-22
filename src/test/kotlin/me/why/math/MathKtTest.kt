package me.why.math

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll


class MathTest : StringSpec() {
    init {
        "maxOfInts" {
            forAll { ints: List<Int> ->
                val maxOfInts = maxOfInts(ints)
                if (ints.isEmpty()) maxOfInts == null
                else {
                    maxOfInts != null &&
                            ints.contains(maxOfInts) &&
                            ints.fold(false) { _: Boolean, i: Int -> maxOfInts >= i }
                }
            }
        }
    }
}