pipeline {
  agent any
  tools {
    maven 'maven_jenkins' 
  }
  stages {
    stage ('Tests') {
      steps {
        sh "mvn clean test"
      }
    }
    stage('Allure') { 
      steps {
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
