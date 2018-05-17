def call() {
  //this variable is bound to the script context as all Jenkins functions
  //are, see https://jenkins.io/doc/pipeline/steps/workflow-basic-steps/
  boundObject()
}

return this

