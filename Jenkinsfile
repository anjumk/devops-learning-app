pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh '/opt/homebrew/bin/mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh '/opt/homebrew/bin/mvn test'
            }
        }

        stage('Package') {
            steps {
                sh '/opt/homebrew/bin/mvn package'
            }
        }
    }
}
