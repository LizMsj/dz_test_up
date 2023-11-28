pipeline {
    agent any

    tools {
        jdk: "1.8"
        maven: "3.9.5"
    }

    stages{
        stage("Build") {
            steps {
                sh "mvn clean test '-Dtest=test.*Test'"
            }
        }
    }

    post {
        always {
            allure{[
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'allure-results']]
            ]}
        }
    }

}