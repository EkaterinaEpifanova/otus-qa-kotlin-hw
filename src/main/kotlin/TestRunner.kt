interface TestRunner {
    fun runTest(steps: ClearData, test: () -> Unit)
}
