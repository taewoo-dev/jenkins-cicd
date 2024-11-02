job('NestJS Docker example') {
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
        dockerBuildAndPublish {
            repositoryName('taewood/jenkins-cicd-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
