var grunt = require('grunt');

grunt.registerTask('world', 'world task description', function(){
    console.log('hello world');
});

grunt.registerTask('hello', 'say hello', function(name){
    if(!name || !name.length)
        grunt.warn('you need to provide a name.');

    console.log('hello ' + name);
});

grunt.registerTask('default', ['world', 'hello:adrian']);

grunt.loadNpmTasks('grunt-bower');

grunt.initConfig({
    "bower-install-simple": {
        options: {
            color: true

        },
        "prod": {
            options: {
                production: true
            }
        },
        "dev": {
            options: {
                production: false
            }
        }
    }
});

grunt.loadNpmTasks("grunt-bower-install-simple");

grunt.registerTask("bower-install", [ "bower-install-simple" ]);