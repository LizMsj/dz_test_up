pipeline {
  agent any
  tools {
    maven 'maven_jenkins' 
  }
  stages {
    stage ('Build') {
      steps {
        sh "mvn clean test"
      }
      post { 
        script(
          allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'target/allure-results']]
          ])
        }
      }
    }
  }
}
