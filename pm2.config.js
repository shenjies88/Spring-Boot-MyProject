const targetJar = 'spring-boot-myproject-service/target/spring-boot-myproject.jar';

module.exports = {
    apps: [{
        name: 'my-springboot-project',
        script: 'java',
        args: [
            '-jar',
            targetJar
        ],
        cwd: '.',
        interpreter: ''
    }],
};
