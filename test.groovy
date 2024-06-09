pipeline {
    agent {node ('Built-In Node')}
    stages {
        stage ('Download from git'){
            steps {
                script {
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'RelativeTargetDirectory',
                    relativeTargetDir: 'test']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'alexey_usov',url: 'https://github.com/ADZRABARAKURA/test-jenkins']]])
                
                }}}
        
       
    }
    
}
