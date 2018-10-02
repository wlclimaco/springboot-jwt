(function() {
  'use strict';
	var commonControllers =  angular.module('wdApp.controllers', []);
  
	commonControllers.controller('WDAppController', ['$scope', '$rootScope', function($scope, $rootScope) {
		  
		$scope.admin = {
			layout: 'wide',
			menu: 'vertical'
		};

		return $scope.color = {
			primary: '#00475B',
			success: '#94B758',
			info: '#56BDF1',
			infoAlt: '#7F6EC7',
			warning: '#F3C536',
			danger: '#FA7B58'
		 };
    }]);
  
	commonControllers.controller('NavController', ['$scope', 'TaskStorage', 'filterFilter', function($scope, TaskStorage, filterFilter) {
		var tasks;
		tasks = $scope.tasks = TaskStorage.get();
		$scope.taskRemainingCount = filterFilter(tasks, {
			completed: false
		}).length;
		  
		return $scope.$on('taskRemaining:changed', function(event, count) {
			return $scope.taskRemainingCount = count;
		});
		
    }]);
  
	commonControllers.controller('LoginController', ['$scope', '$rootScope', '$location', 'localStorageService','WDAuthentication', 
		function($scope, $rootScope, $location, localStorageService, WDAuthentication) {
		
			$scope.login = function() {
				debugger
				WDAuthentication.processLogin(WebDaptiveAppConfig.authenticationURL, $.param({username: $scope.username, password: $scope.password}), function(authenticationResult) {
					
					var authToken = authenticationResult.token;
					if (authToken !== undefined){	
						$rootScope.authToken = authToken;
						localStorageService.set('authToken', authToken);
						var currentUser = {user: authenticationResult.name, roles: authenticationResult.roles};
						$rootScope.user = currentUser;
						$rootScope.main.name = authenticationResult.name;
						localStorageService.set('currentUser', $rootScope.user);
						var bAdmin = false;
						var tempRole = "";
						for (var prop in currentUser.roles) {
							tempRole += prop + " ";
							if(prop == 'ADMIN_USER')
								bAdmin = true
						}							
						$rootScope.displayRoles = tempRole;
						localStorageService.set('displayRoles', $rootScope.displayRoles);						
						if ($rootScope.callingPath !== undefined){	
							if ($rootScope.callingPath === '/pages/signin'){
								$rootScope.callingPath = "/";
							}
							$location.path($rootScope.callingPath);
						}
						else{
							$location.path( "/" );
						}		
					}
					else{
							$location.path( "/pages/signin" );
					}		
				});
			};
    }]);	

})();
