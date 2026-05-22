#!/user/bin/env groovy

def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t shivangjnv/java-maven-app:2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push shivangjnv/java-maven-app:2.0'
    }
}