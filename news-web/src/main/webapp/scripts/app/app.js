'use strict';

angular.module('newsApp', [ 'ui.router'])
     .config(function ($httpProvider) {
        //enable CSRF
        $httpProvider.defaults.xsrfCookieName= 'CSRF-TOKEN';
        $httpProvider.defaults.xsrfHeaderName= 'X-CSRF-TOKEN';

     });
