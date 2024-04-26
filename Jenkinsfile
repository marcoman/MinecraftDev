pipeline {
    agent any
    stages {
        stage('Check Out') {
            git branch: 'develocity-1'
                url: 'https://github.com/marcoman/MinecraftDev.git'
            
        }
        stage('Gradle Build') {
            withGradle {
                sh './gradlew build'
            }
        }
    }
}