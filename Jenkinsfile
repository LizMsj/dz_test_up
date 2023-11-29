pipeline {
    agent any

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
