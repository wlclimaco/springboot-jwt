(function() {
  angular.module('wdApp.apps.buscarQuadra', []).controller('BuscaQuadraController', 
  ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig','$uibModal',
	function($scope, jogoFactory, AuthService, $rootScope, $location, $http, $interval, SysMgmtData, toastr, toastrConfig,$uibModal) {
	  
	  var vm = this;
	  
	  var abUl = $location.absUrl(); 
   //   var surl = "https://quadra-test.herokuapp.com/#/pages/signin";
      var surl = "http://localhost:8080/#/pages/signin";
    
	  if(abUl === surl){
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
            
            $scope.calcAvaliacao(response[0].avaliacao, response[0].avaliacaoOptions);
           // if (resp && resp.code==200) {
          //      AuthService.createJWTToken(resp.result.user, resp.result.token);
           //     AuthService.setCredentials();
           //     $location.path('/app');
           //  $scope.quadras = 
         
        });

    $scope.calcAvaliacao = function(listAvaliacao,listOpcao) {
      debugger
        $scope.avaliacaoList = []; 
        if(listAvaliacao){
          for (let y = 0; y < listAvaliacao.length; y++) {
            var avaliacaoItens = listAvaliacao[y].avaliacaoItens
            for (let index = 0; index < avaliacaoItens.length; index++) {
                for (let i = 0; i < listOpcao.length; i++) {
                    if(avaliacaoItens[index].opcaoId == listOpcao[i].id){
                      calcTotalNota($scope.avaliacaoList, avaliacaoItens[index].nota, avaliacaoItens[index].opcaoId, listOpcao[i].opcao )
                    }
                }
            }
          }
        }
        debugger
    }

    calcTotalNota = function(listAvaliacao, nota, id, opcao){
        var bInsert = true;
        for (let index = 0; index < listAvaliacao.length; index++) {
          if(listAvaliacao[index].id == id){
            listAvaliacao[index].nota = (listAvaliacao[index].nota + nota);
            listAvaliacao[index].divisor = (listAvaliacao[index].divisor + 1);
            bInsert = false;
          } 
        }   
          if(bInsert){
            $scope.avaliacaoList.push({id: id,nota: nota, nome: opcao, divisor: 1});
        }
    }

    $scope.getAvaliacaoName = function(idAvaliacao, listAvaliacao) {
        var avaliacaoName = "";
        for (let index = 0; index < listAvaliacao.length; index++) {
            const element = listAvaliacao[index];
            if(listAvaliacao[index].opcaoId === idAvaliacao){
              avaliacaoName = listAvaliacao[index].opcao;
            }
        }
        return avaliacaoName;  
    }
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
