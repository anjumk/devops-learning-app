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
                    sh '''
                    mvn clean verify sonar:sonar \
                      -Dsonar.projectKey=anjumk_devops-learning-app \
                      -Dsonar.organization=anjumk \
                      -Dsonar.host.url=https://sonarcloud.io \
                      -Dsonar.login=$SONAR_AUTH_TOKEN
                    '''
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
