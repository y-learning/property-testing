package me.why.math

import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class MathTest : StringSpec() {
    init {
        "nothing" {
            forAll { _: Int ->
                true
            }
        }
    }
}