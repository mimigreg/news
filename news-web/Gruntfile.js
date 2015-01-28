'use strict';

module.exports = function (grunt) {

 require('load-grunt-tasks')(grunt);

 grunt.initConfig({

	pkg: grunt.file.readJSON('package.json'),

	dirs:{
		src:  'src/main/webapp/scripts/',
        views: 'src/main/webapp/views/',
		test: 'src/test/js',
		build: 'src/main/webapp/dist',
		bower_components: 'src/main/webapp/bower_components/'
	},

	src: {
		js: ['src/webapp/src/**/*.js'],
		templates: ['src/webapp/views/**/*.html']
	},

	clean: {
		build: {
			src: [ '<%=dirs.build%>']
		},
		bower: { // nettoyer tous les packages gérés par bower
			src: [ '<%=dirs.bower_components%>/*','!<%=dirs.bower_components%>/readme.txt']
		}
	},

	"bower-install-simple": {
		options: {
			color:       true,
			directory:   "<%=dirs.bower_components%>"
		},
		dev:{
			options:{
				production:false // install devDependencies
			}			
		},
		prod:{
			options:{
				production:true
			}
		}
	},

	concat: {
		options: {
			banner: '/* <%=pkg.name%>:<%=pkg.version%>: concatenation ... (<%=grunt.template.today()%>) */\n(function (window, angular, undefined) {\n',
			footer: '\n})(window, window.angular);'
		},
		build: {
			src: [
			      '<%= dirs.src %>/app.js',
			      '<%= dirs.src %>/**/*.js',
                  '<%= dirs.build %>/app.templates.js'
			],
			dest: '<%= dirs.build %>/app.js'
		}
	},

	ngAnnotate: {
		dist: {
			files: [{
				expand: true,
				cwd: '<%=dirs.build%>',
				src: 'app.js',
				dest: '<%=dirs.build%>'
			}]
		}
	},

	uglify: {
		options: {
			banner: '/* <%=pkg.name%>:<%=pkg.version%> (<%=process.env.USERNAME%>@<%=process.env.COMPUTERNAME%>/<%=grunt.template.today("isoDateTime")%>) */\n',
			sourceMap: '<%=dirs.build%>/source-map.js'
		},
		build: {
			files: {
				'<%=dirs.build%>/app.min.js': ['<%=dirs.build%>/app.js']
			}
		}
	},

	cssmin:{
		app:{
			src: [ '<%=dirs.src%>/app.css'],
			dest: '<%=dirs.build%>/app.min.css'
          }
	},

	jshint: {
		options: {
			jshintrc: '.jshintrc'
		},
		files: {
			src: ['Gruntfile.js', '<%= dirs.src %>/**/*.js']
		}
	},

     html2js: { // templates
         options: {
             module: 'refapp.templates',
             base: 'src/main/webapp/',
             htmlmin: {collapseWhitespace: true},
             singleModule: true
         },
         main: {
             src: ['<%=dirs.views%>/**/*.html'],
             dest: '<%=dirs.build%>/app.templates.js'
         }
     },

     'string-replace': {
         templates: {
            files: { 'src/main/webapp/build/app.js': ['src/main/webapp/build/app.js'] },
            options: {
                replacements: [
                    {
                        pattern: /\/\*build:refapp.templates\*\//,
                        replacement:',"news.templates"'
                    }
                ]
            }
         }
     },

	csslint: {
		options: { ids:false, 'adjoining-classes':false, 'box-model':false, 'important':false },
		files: {
			src: ['<%= dirs.src %>/**/*.css']
		}
	},

	connect: {
		options: {
			port: 8000,
			hostname: '*',
			base: './src/main/webapp'
		},
		server: {
			options: {
                keepalive: true,
                middleware: function (connect, options) {
                    return [
                        require('grunt-connect-prism/middleware'),
                        connect().use('/news-web', connect.static('./src/main/webapp'))
                    ];
                }
            }
		},
		testserver: {
            options: {
                middleware: function (connect, options) {
                    return [
                        require('grunt-connect-prism/middleware'),
                        connect().use('/news-web', connect.static('./src/main/webapp'))
                    ];
                }
            }
        }
    },

    prism: {
        options: {
            mocksPath: './mocks',
            host: 'localhost',
            port: 8080,
            https: false,
            changeOrigin: true
        },
        server: {
            options: {
                mode: 'mock',
                context: '/news-web/api',
                delay: 200
            }
        }
    }

 });

 grunt.registerTask('default', ['build']);
 grunt.registerTask('build', 'Perform a normal build', ['clean','bower-install-simple','jshint','csslint','html2js','concat','string-replace','ngAnnotate','uglify','cssmin']);

 // lancer un serveur local pour les tests avec les mocks (avec génération de test-index.html)
 grunt.registerTask('serve',['prism:server:mock','connect:server']);
 grunt.registerTask('rec-srv',['prism:server:record','connect:server']);

 // réinitialiser les libs js (quand on change de branche il faut executer cette task)
 grunt.registerTask('bower', ['clean:bower','bower-install-simple']);

};