pipeline {
    agent any
    stages {
        stage ('GetProject') {
            steps {
                git 'https://github.com/jcolladonui/jorgespetitions2'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean:clean'
                sh 'mvn dependency:copy-dependencies'
                sh 'git add .'

            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
                sh 'git add .'
                sh 'git commit -m "Test stage"'
                sh 'git push origin master'
            }
        }

        stage('Package') {
             steps {
                 sh 'mvn package'
                 sh 'mv target//jorgepetitions2.war/jcolladonui/jorgespetitions2'
                    }
            }

        stage('Deploy') {
            steps {
                 input message: 'Approve deployment?', ok: 'Deploy'
            }
        }
    }
}

