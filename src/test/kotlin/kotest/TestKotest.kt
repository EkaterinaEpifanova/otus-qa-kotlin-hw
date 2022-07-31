package kotest

import Calculator
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals

class CalculatorTest : FunSpec({
    context("Test calculator") {
        val result = Calculator().add(5, 5)
        test("Successful test") {
            assertEquals(10, result)
        }
        test("Failed test") {
            assertEquals(0, result)
        }
    }
})