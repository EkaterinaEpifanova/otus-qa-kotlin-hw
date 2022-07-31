package kotest

import io.kotest.core.annotation.AutoScan
import io.kotest.core.extensions.TestCaseExtension
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult

@AutoScan
class RepeatOnFailureExtension() : TestCaseExtension {
    private val maxRepeat = 5
    override suspend fun intercept(testCase: TestCase, execute: suspend (TestCase) -> TestResult): TestResult {
        var result = execute(testCase)
        if (result.isSuccess) {
            println("Success result")
            return result
        } else {
            repeat((1..maxRepeat).count()) {
                println("${it + 1} retry")
                result = execute(testCase)
                if (result.isSuccess) {
                    return result
                }
            }
            println("Failed result")
            return result
        }
    }
}