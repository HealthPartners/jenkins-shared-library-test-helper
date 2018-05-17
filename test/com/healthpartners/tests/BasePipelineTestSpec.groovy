package com.healthpartners.tests

class BasePipelineTestSpec extends BasePipelineTest {
    def 'base pipeline test initalizes mocks and executes script'() {
        given:
        def binding = initializeMocks('testMock')
        setEnv(binding, [ENV_VAR: 'value'])
        def testScript = getShell(binding, 'test/testScript.groovy')
        when:
        def output = testScript()
        then:
        1*binding.testMock.call() >> "output"
        output == "output/value"
    }
}
