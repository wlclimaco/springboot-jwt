(function() {
    angular.module('wdApp.apps.chat', []).controller('ChatController', ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig',
        function($scope, jogoFactory, AuthService, $rootScope, $location, localStorageService, toastr, $http, $interval, SysMgmtData, toastr, toastrConfig) {
            var evm = this;
            evm.combo = {};

            var fnCallback = function(oResp) {
                console.log(oResp);

                $scope.chat = oResp;
            }


            $scope.validarUser = function(chatItens) {
            	
                var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
                if (chatItens.user_id === oUser.id) {
                    return 'right';
                } else
                    return 'left';
            };

            var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));

            AuthService.fetchChatByUserId(oUser, fnCallback);

        }
    ]);
}).call(this);