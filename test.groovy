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
                    userRemoteConfigs: [[credentialsId: 'github_cred',url: 'https://github.com/ilyaburak/study_jenkins.git']]])
                
                }}}
        
       
    }
    
}
