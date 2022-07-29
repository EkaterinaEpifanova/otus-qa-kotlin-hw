interface TestRunner {
    fun runTest(steps: MetaSteps, test: () -> Unit)
}