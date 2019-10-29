pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'git@github.com:BruceYao11/demo.git', branch: 'master', changelog: true)
        bat 'mvn clean install'
      }
    }
    stage('Test') {
      steps {
        jacoco()
      }
    }
  }
}