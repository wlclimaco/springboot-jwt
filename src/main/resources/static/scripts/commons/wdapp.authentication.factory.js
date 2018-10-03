(function() {
'use strict';
	var commonAuth = angular.module('wdApp.authentication', []);

	commonAuth.factory('WDAuthentication', ['$http', function($http){
		return{//btoa("testjwtclientid:XY7kmzoNzl100")
			
				processLogin: function(_url, _req, _callback){
					$http.defaults.headers.post["Content-Type"] = "application/json;charset=utf-8";
					var res = $http.post(_url, _req, {});
					res.then(function(response) {
						_callback(response.data );						
					})
				}
			};
	}]);
})();