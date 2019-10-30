pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        echo "starting pull from github..."
        git(url: 'git@github.com:BruceYao11/demo.git', branch: 'master', credentialsId: '9f8abeec-ad92-40d2-9794-1d02206744ba')
      }
    }

    stage('unitTest') {
      steps {
        echo "starting unitTest..."
        bat "mvn clean test"
        jacoco()
      }
    }

    stage("sonar") {
      steps{
        echo "starting codeAnalyze with SonarQube..."
        withSonarQubeEnv('sonar') {
          sh "mvn -f pom.xml clean compile sonar:sonar"
        }
      }
    }

    stage("build") {
      steps{
        echo "starting build..."
        bat "mvn clean install"
      }
    }
  }
}