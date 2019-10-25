pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        git(url: 'git@github.com:BruceYao11/demo.git', branch: 'master', changelog: true)
      }
    }
    stage('test') {
      steps {
        bat 'mvn test'
      }
    }
  }
}