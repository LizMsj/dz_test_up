pipeline {
    agent any

    tools {
        jdk: "1.8"
        maven: "4.0.0"
    }

    stages{
        stage("Build") {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
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