job('NestJS example') {
    scm {
        git('https://github.com/taewoo-dev/jenkins-cicd.git') {  node ->
            node / gitConfigName('taewoo-dev')
            node / gitConfigEmail('twin9774@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('Node18')
    }
    steps {
        shell("npm install")
    }
}
