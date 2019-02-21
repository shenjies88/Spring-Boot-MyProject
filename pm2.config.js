const targetJar = 'spring-boot-myproject-service/target/myproject-spring-boot.jar';

module.exports = {
    apps: [{
        name: 'mySpringBoot',
        script: 'java',
        args: [
            '-jar',
            targetJar
        ],
        cwd: '.',
        interpreter: ''
    }],
};
