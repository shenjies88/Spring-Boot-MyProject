const targetJar = 'spring-boot-myproject-service/target/spring-boot-myproject.jar';

module.exports = {
    apps: [{
        name: 'SpringBoot',
        script: 'java',
        args: [
            '-jar',
            targetJar
        ],
        cwd: '.',
        interpreter: ''
    }],
};
