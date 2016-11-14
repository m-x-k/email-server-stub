node('node') {

	stage 'Checkout'
		checkout scm

	stage 'Build'
		sh './gradlew clean build shadowJar'

	stage 'Run'
		sh './rebuild-docker.sh'

	stage 'Test'
		sh './testEmail.sh'
		sh 'curl -f http://localhost:8080/emails' 

}