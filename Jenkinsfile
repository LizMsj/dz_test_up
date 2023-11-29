pipeline {
  agent any
  tools {
    maven 'maven_jenkins' 
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean test '-Dtest=test.*Test'"'
      }
    }
  }
}
