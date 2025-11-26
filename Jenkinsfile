pipeline {
    agent any

    environment {
        // Updated username
        DOCKER_IMAGE = 'sanyamvermaa/roll-number-even'
        REGISTRY_CREDENTIALS_ID = 'dockerhub-creds'
        
        // Uncommented PATH so Jenkins can find Docker
        PATH = "/opt/homebrew/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:$PATH"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Code') {
            steps {
                echo 'Compiling Java Code...'
                sh 'javac CalculatorApp.java'
            }
        }

        stage('Test Code') {
            steps {
                echo 'Running Tests...'
                sh 'javac -cp . TestCalculatorApp.java'
                sh 'java -cp . TestCalculatorApp'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image...'
                script {
                    sh "docker build -t ${DOCKER_IMAGE}:${env.BUILD_NUMBER} ."
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                echo 'Pushing to DockerHub...'
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
                        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                        sh "docker push ${DOCKER_IMAGE}:${env.BUILD_NUMBER}"
                        sh "docker tag ${DOCKER_IMAGE}:${env.BUILD_NUMBER} ${DOCKER_IMAGE}:latest"
                        sh "docker push ${DOCKER_IMAGE}:latest"
                    }
                }
            }
        }
    }
}
