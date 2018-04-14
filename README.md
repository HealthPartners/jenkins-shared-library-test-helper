# Jenkins Shared Library Test Helper

[![Build Status](https://api.travis-ci.org/HealthPartnersOSS/jenkins-shared-library-test-helper.svg?branch=master)](https://travis-ci.org/HealthPartnersOSS/jenkins-shared-library-test-helper/)[![Bintray Version](https://img.shields.io/bintray/v/healthpartnersoss/jenkins/jenkins-shared-library-test-helper.svg)](https://bintray.com/healthpartnersoss/jenkins/jenkins-shared-library-test-helper)

This code was developed to allow [Jenkins 
shared libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/)
to be tested before being pushed to Jenkins. This library
allows [Spock](http://spockframework.org/spock/docs/1.1/index.html)
tests to be written against these Jenkins
scripts.

## Getting Started

This library is published to Bintray at https://dl.bintray.com/healthpartnersoss/jenkins.

##### Gradle
```$groovy
maven { url https://dl.bintray.com/healthpartnersoss/jenkins }

dependencies {
  testCompile 'com.healthpartners.jenkins:jenkins-shared-library-test-helper:VERSION'
}
```

### Testing Shared Library Scripts

This library is then meant to be used with Groovy scripts
in the `vars/` directory that are loaded into Jenkins as functions.
The special rule is that the script must end with `return this`.

```$groovy
def call(args) {
    //execution
}

return this
```

To test these scripts, do the following:

1. Construct a binding object
2. Initialize the script

```$groovy
def MyScriptSpec extends BasePipelineTest {

    def 'this is a spock test'() {
        given:
        //binding object
        def binding = initializeMocks('mockFunction', 'anotherFunction')
        //initialize the script
        def script = getShell(binding, 'test/testScript.groovy')
        
        when:
        //execute the call function on the script
        def scriptOutput = script.call()
        
        then:
        //do validations
        scriptOutput == "great stuff here"
        
        //interact with binding mocks
        1*binding.mockFunction.call() >> 2
        
        //binding mocks can throw exceptions too
        1*binding.anotherFunction.call() >> { throw new RuntimeException("badness")}
    }
}
```

### Other Features

This library comes with three utility interfaces that can be
used as mocks within testing your groovy scripts. Each of them
is meant to encompass some of the features that Jenkins would
provide in the pipeline interface when executing the script.

## Built With

* [Groovy](http://groovy-lang.org/)
* [Spock Framework](http://spockframework.org/spock/docs/1.1/index.html)

## Authors

* **James McShane** - [HealthPartners](https://github.com/healthpartnersoss)

See also the list of [contributors](https://github.com/healthpartnersoss/jenkins-shared-library-test-helper/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
