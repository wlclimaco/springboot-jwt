(function() {
  angular.module('wdApp.apps.buscarQuadra', []).controller('BuscaQuadraController', 
  ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig','$uibModal',
	function($scope, jogoFactory, AuthService, $rootScope, $location,   $http, $interval, SysMgmtData, toastr, toastrConfig,$uibModal) {
	  
	  var vm = this;

  
    vm.teste = 'DOMINGO';
 //   vm.empresaList = [];
 //   $scope.empresaList =[]
    $scope.myOrderBy = {dia : 'DOMINGO'};
        AuthService.fetchAllEmpresa(vm.empresa, function (response) {
            
            vm.empresaList = response;
            $scope.empresaList = response;
            console.log($scope.empresaList);
            $scope.loading = false;
           // if (resp && resp.code==200) {
          //      AuthService.createJWTToken(resp.result.user, resp.result.token);
           //     AuthService.setCredentials();
           //     $location.path('/app');
           //  $scope.quadras = 
         
        });

    

    console.log(localStorage.getItem('empresa'))
    $scope.gravarHorario = function(oJogo, sStatus)
    {
        $scope.loading = true;
        jogoFactory.update(oJogo, sStatus);
        $scope.loading = false;
    }

    $scope.orderByMe = function(x) {
        
        $scope.myOrderBy = x;
      }

      $scope.checkParentID = function(value, index) {
        
        return value.dia && ['DOMINGO','SEGUNDA'].indexOf(value.dia) !== -1;
      }

      $scope.myFilter = function (item) { 
        return 'DOMINGO'; 
    };
    
}
  ]);
}).call(this);
