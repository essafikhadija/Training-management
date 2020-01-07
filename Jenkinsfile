node{
    properties([disableConcurrentBuilds()])
    stage('Chekout'){
        git credentialsId: 'git-cred', url: 'https://github.com/ES-SOFYANY/formations'
    }
    stage('mvn build'){
        def mvnHome = tool name: 'maven-3', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh "${mvnCMD} clean package"
    }

    stage('build docker image'){
        sh 'docker build -t formations_image -f docker-directory/Dockerfile ./target'
    }

//    stage('push docker image to registry'){
//        sh 'docker tag formations_image localhost:5000/formations_image'
//        sh 'docker push localhost:5000/formations_image'
//    }

    stage('docker run'){
        sh 'docker stop formations || true'
        sh 'docker rm formations || true'
        sh 'docker run --name formations -d -p 80:8080 --memory="512m" formations_image'
    }
}
