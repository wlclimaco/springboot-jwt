(function() {
  angular.module('wdApp.apps.dialogs', []).controller('ModalDemoCtrl', 
  ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$uibModal', '$log', '$document', 'SysMgmtData', 'toastr', 'toastrConfig',
	function($scope, jogoFactory, AuthService, $rootScope, $uibModal,  $log, $document, SysMgmtData, toastr, toastrConfig) {

  $scope.items = ['item1', 'item2', 'item3'];

  $scope.animationsEnabled = true;

  $scope.open = function() {
      var modalInstance;
      modalInstance = $uibModal.open({
        templateUrl:  "myModalContent.html",
        controller: 'ModalInstanceCtrl',
        controllerAs: '$ctrls',
        resolve: {
          items: function() {
            return $scope.items;
          }
        }
      });
      modalInstance.result.then((function(selectedItem) {
        $scope.selected = selectedItem;
      }), function() {
        $log.info("Modal dismissed at: " + new Date());
      });
    };

  $scope.openSolicitacao = function (size, parentSelector,jogo,status) {
	  debugger
		var abUl = $location.absUrl(); 
	//	  var surl = "https://quadra-test.herokuapp.com/#/pages/signin";
		  var surl = "http://localhost:8080/#/pages/signin";
		  if(abUl === surl){
			  $scope.remover = false;
			  $scope.desmarcar = false;
			  $scope.marcar = false;
		  }
    var parentElem = parentSelector ? 
      angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
    var modalInstance = $uibModal.open({
      animation: $scope.animationsEnabled,
      ariaLabelledBy: 'modal-title',
      ariaDescribedBy: 'modal-body',
      templateUrl: 'stackedModal.html',
      controller: 'ModalInstanceCtrl',
      controllerAs: '$ctrl',
      size: size,
      appendTo: parentElem,
      resolve: {
        items: function () {
          
          return {"jogo" : jogo,"status" : status};
        }
      }
    });

    modalInstance.result.then(function (selectedItem) {
      $scope.selected = selectedItem;
       
      console.log(jogo);
    }, function () {
       
      console.log(jogo);
      $log.info('Modal dismissed at: ' + new Date());
    });
  };

  $scope.openComponentModal = function () {
    var modalInstance = $uibModal.open({
      animation: $scope.animationsEnabled,
      component: 'modalComponent',
      resolve: {
        items: function () {
          return $scope.items;
        }
      }
    });

    modalInstance.result.then(function (selectedItem) {
      $scope.selected = selectedItem;
    }, function () {
      $log.info('modal-component dismissed at: ' + new Date());
    });
  };

  $scope.openMultipleModals = function () {
    $uibModal.open({
      animation: $scope.animationsEnabled,
      ariaLabelledBy: 'modal-title-bottom',
      ariaDescribedBy: 'modal-body-bottom',
      templateUrl: 'stackedModal.html',
      size: 'sm',
      controller: function($scope) {
        $scope.name = 'bottom';  
      }
    });

    $uibModal.open({
      animation: $scope.animationsEnabled,
      ariaLabelledBy: 'modal-title-top',
      ariaDescribedBy: 'modal-body-top',
      templateUrl: 'stackedModal.html',
      size: 'sm',
      controller: function($scope) {
        $scope.name = 'top';  
      }
    });
  };

  $scope.toggleAnimation = function () {
    $scope.animationsEnabled = !$scope.animationsEnabled;
  };
  }
]);
}).call(this);
