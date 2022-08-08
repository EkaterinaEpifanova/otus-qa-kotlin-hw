interface TestRunner {
    fun <T:Any> runTest(steps: T, test: () -> Unit)
}