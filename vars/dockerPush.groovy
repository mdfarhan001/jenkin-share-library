def call(String imageName) {

    withCredentials([
        usernamePassword(
            credentialsId: "dockerHubCred",
            usernameVariable: "dockerHubUser",
            passwordVariable: "dockerHubPass"
        )
    ]) {
        sh "echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin"

        sh "docker tag ${imageName}:latest ${dockerHubUser}/${imageName}:latest"

        sh "docker push ${dockerHubUser}/${imageName}:latest"
    }
}
