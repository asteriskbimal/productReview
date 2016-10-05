
var config = {headers: {
            'Access-Control-Allow-Origin': 'http://localhost:8080/usermanagement/api/',
            'Accept': 'application/json'
        }
    };

angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('/usermanagement/api/',config).
        then(function(response) {
            $scope.greeting = response.data;
        });
});