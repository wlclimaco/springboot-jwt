(function() {
  angular.module('wdApp.apps.buscarQuadra', []).controller('BuscaQuadraController', 
  ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig','$uibModal',
	function($scope, jogoFactory, AuthService, $rootScope, $location, $http, $interval, SysMgmtData, toastr, toastrConfig,$uibModal) {
	  
	  var vm = this;
	  
	  var abUl = $location.absUrl(); 
	  
	  if(abUl === "https://quadra-test.herokuapp.com/#/pages/signin"){
		  $scope.remover = false;
		  $scope.desmarcar = false;
		  $scope.marcar = false;
	  }
  
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
    $scope.oAvaliacao = [{}];
    $scope.addRowToGrid = function(oAvaliacao) {
      console.log(oAvaliacao);
      console.log($scope.oAvaliacao);
      var oRequest = {empresaId:82,email:oAvaliacao.email,mensagen:oAvaliacao.menssagem, avaliacaoItens :  $scope.oAvaliacao,updatedAt:new Date()};
      AuthService.saveAvaliacao(oRequest,function(oResp){console.log(oResp)});
      debugger
    }

    $scope.detalhesQuadra = function(jogo)
    {
    	alert('aqui');
    	//openDetailQuadra
    }

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
