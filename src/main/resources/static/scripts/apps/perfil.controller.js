(function() {
    angular.module('wdApp.apps.perfil', []).controller('PerfilController', ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig', 
        function($scope, jogoFactory, AuthService, $rootScope, $location, localStorageService, toastr, $http, $interval, SysMgmtData, toastr, toastrConfig) {
            var evm = this;
        
            var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
          //  var fnCallback = function(oResp)
          //  {
          //      $scope.loading = false;
                $scope.user = oUser;
          //  }
                
                var fnCallback2 = function(oResp)
                {
                    
                }

                
                $scope.saveUser = function() {
                	debugger
                	AuthService.userUpdate($scope.user, fnCallback2);
                }

        }
    ]);
}).call(this);