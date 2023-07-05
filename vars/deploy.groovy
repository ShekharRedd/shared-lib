#!/usr/bin/env groovy
def call(String image){
    echo "deploying the application to production env "
    withCredentials([usernamePassword(credentialsId: "Docker-hub" , passwordVariable: 'PASS', usernameVariable: 'USER')])
    sh "docker build -t $image ."
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh "docker push $image"
}
