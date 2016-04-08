            var app = angular.module('myApp', []);
            app.controller('memberCtrl', function($scope, $http){
               $http.get("http://localhost:8080/AngularJQuery/api/member/complete")
                       .then(function(response){
                           $scope.members = response.data;
               });
            });