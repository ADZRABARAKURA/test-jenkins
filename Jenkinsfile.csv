pipeline {
    agent any
    stages {
        stage('Disk Info') {
            steps {
                sh 'echo "Disk Usage Information:"'
                sh 'df -h'
                sh 'echo "Inode Usage Information:"'
                sh 'df -i'
                sh 'echo "Mounted Filesystems:"'
                sh 'mount'
            }
        }
    }
}

