import com.healthpartners.tests.BasePipelineTest

class TestScriptSpec extends BasePipelineTest {

    def 'test script stringifies the object'() {
        given:
        def binding = initializeMocks('boundObject')
        def testScript = getShell(binding, 'vars/testScript.groovy')
        when:
        def output = testScript()
        then:
        1*binding.boundObject.call() >> { "look a mock" }
        output == "look a mock"
    }
}
