pipeline {

   agent any

      stages {

         stage('Build') {

             steps {
               sh 'echo Build and compiling.'
               sh 'pwd'
               sh './mvnw clean install'
             }
}

          stage('Build Docker Image') {
              steps {
                      script{
                        sh 'docker build -t sourav40/hotel-room-service .'
                      }
     }
     }

            stage('Push Docker Image To Docker Hub') {
                   steps {
                           script{
//                            sh 'docker tag hotel-room-service:latest sourav40/hotel-room-service:latest'
                           sh 'docker login -u sourav40 -p dckr_pat_9_M2GkzkEBiGSyUJf4JVjXt_PPE'
                           sh 'docker push sourav40/hotel-room-service:latest'
                }
          }
          }
}
}