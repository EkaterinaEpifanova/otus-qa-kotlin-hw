class TestRunnerImpl : TestRunner {
    private val beforeMethodName = "before"
    private val afterMethodName = "after"
    override fun <T : Any> runTest(steps: T, test: () -> Unit) {
        "BEFORE".log { steps::class.members.first { it.name == beforeMethodName }.call(steps) as String }
        test()
        "AFTER".log { steps::class.members.first { it.name == afterMethodName }.call(steps) as String }
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