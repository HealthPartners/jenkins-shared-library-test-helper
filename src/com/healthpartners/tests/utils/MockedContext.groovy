package com.healthpartners.tests.utils


interface MockedContext {
    def getEnv()
    def getScm()
    def httpRequest(LinkedHashMap)
    def echo(String)
    def sh(String)
    def input(String)
}
