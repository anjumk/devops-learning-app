pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean compile'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('SonarCloud Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                    sh './mvnw verify sonar:sonar \
                    -Dsonar.projectKey=anjumk_devops-learning-app \
                    -Dsonar.organization=anjumk \
                    -Dsonar.host.url=https://sonarcloud.io'
                }
            }
        }

        stage('Package') {
            steps {
                sh './mvnw package'
            }
        }
    }
}
