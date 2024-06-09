    
pipeline {
    agent{node('master')}
    stages {
        stage('Dowload project') {
            steps {
                script {
                    cleanWs()
                    //git(branch: 'master', credentialsId: 'alexey_usov', url: 'https://github.com/ADZRABARAKURA/test-jenkins')
                }
                script {
                    echo 'Start download project'
                    checkout([$class                           : 'GitSCM',
                              branches                         : [[name: '*/master']],
                              doGenerateSubmoduleConfigurations: false,
                              extensions                       : [[$class           : 'RelativeTargetDirectory',
                                                                   relativeTargetDir: 'auto']],
                              submoduleCfg                     : [],
                              userRemoteConfigs                : [[credentialsId: 'alexey_usov', url: 'https://github.com/ADZRABARAKURA/test-jenkins']]])
                }
            }
        }
        stage ('Create docker image'){
            steps{
                script{
                    sh "docker build ${WORKSPACE}/auto -t webapp"
                    sh "docker run -d webapp"
                    sh "docker exec -it webapp "df -h > ~/proc""
                }
            }
        }
        
    }

    
}
