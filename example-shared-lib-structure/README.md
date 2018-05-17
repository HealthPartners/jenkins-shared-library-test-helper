# Example Shared Library Structure for Testing

This directory shows what a repository could look like that uses the test helper in order to compile and run Spock tests against Jenkins shared library functions. It uses gradle to compile and download the dependencies for the script and the testing package, then uses this library to build mocks for the context in which the tested script runs.

The goal of this package is to provide tests for the functions that exist within the `vars/` directory of these pipelines. The code in `src/` directories can be tested using standard methods of testing Groovy classes. In our environment, we extend these Spock principles to the groovy classes in `src/`, but this is not a requirements of the library.
