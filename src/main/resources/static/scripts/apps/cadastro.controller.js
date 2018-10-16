(function() {
    angular.module('wdApp.apps.register', []).controller('RegisterController', ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig', '$uibModal',
        function($scope, jogoFactory, AuthService, $rootScope, $location, $http, $interval, SysMgmtData, toastr, toastrConfig, $uibModal) {
            var rc = this;
            console.log('register controller');

            var original;
            rc.user = {
                name: '',
                email: '',
                password: '',
                isGoleiro: false
            };
            rc.showInfoOnSubmit = false;
            original = angular.copy(rc.user);
            rc.revert = function() {
                rc.user = angular.copy(original);
                return rc.form_signin.$setPristine();
            };
            rc.canRevert = function() {
                return !angular.equals(rc.user, original) || !rc.form_signin.$pristine;
            };
            rc.canSubmit = function() {
                return !angular.equals(rc.user, original);
            };
            rc.submitForms = function(admin) {

                console.log(rc.user);
                console.log('received the register event for user: ' + rc.user.name);
                $rootScope.isSubmitted = true;
                rc.dataLoading = true;
                //   rc.user.admin = admin;
                AuthService.register(rc.user, function(response) {

                    if (response.code == 200) {
                        AuthService.createJWTToken(response.result.user, response.result.token);
                        AuthService.setCredentials();
                        $location.path('/dashboard2');

                        var loginUrl = $location.absUrl() + '/dashboard2';

                        $state.go("app.dashboard");

                    } else {
                        rc.error = response.result;
                        rc.details = response.details;
                        rc.dataLoading = false;
                        $rootScope.isSubmitted = false;
                    }
                });
            }
        }

    ]);
}).call(this);