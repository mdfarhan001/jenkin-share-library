def call(String repoUrl, String branch = 'main') {

    echo "Cloning repository: ${repoUrl}"

    git(
        url: repoUrl,
        branch: branch
    )

    echo "CODE CLONED SUCCESSFULLY"
}
