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
                    ssh '''
                     ${MAVEN_HOME}/bin/mvn clean verify sonar:sonar \
                     -Dsonar.projectKey=anjumk_devops-learning-app \
                     -Dsonar.organization=anjumk \
                     -Dsonar.host.url=https://sonarcloud.io \
                     -Dsonar.login=$SONAR_TOKEN
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
    tools {
        maven 'Maven-3.9'
    }
}
