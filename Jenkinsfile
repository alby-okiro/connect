pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Compiling Java files..."'
                sh 'javac -d bin $(find src -name "*.java")'
            }
        }
        stage('Run') {
            steps {
                sh 'echo "Running in auto mode..."'
                sh 'java -cp bin src.ui.Main --auto'
            }
        }
    }
}
