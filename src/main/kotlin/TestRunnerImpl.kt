class TestRunnerImpl : TestRunner {

    override fun runTest(steps: MetaSteps, test: () -> Unit) {
        "BEFORE".log(steps::before)
        test()
        "AFTER".log(steps::after)
    }
}

fun String.log(action: () -> String) {
    println("[$this] ${action()}")
}

fun main() {
    val metaSteps = MetaSteps()
    val testRunner = TestRunnerImpl()
    testRunner.runTest(metaSteps) { "STEP".log { "Otus homework #1" } }
}