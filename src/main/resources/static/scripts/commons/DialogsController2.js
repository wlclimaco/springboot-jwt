(function() {

  angular.module('wdApp.apps.dialogs.um', []).controller('ModalInstanceCtrl',[ 'jogoFactory' ,'$uibModalInstance', function (jogoFactory,$uibModalInstance, items) {
	  var $ctrl = this;
	  $ctrl.items = items;
	  $ctrl.selected = {
	    item: $ctrl.items[0]
	  };

	  $ctrl.ok = function (oJogo, sStatus) {
	    
	   // $scope.loading = true;
	    jogoFactory.update(oJogo, sStatus);
	 //   $scope.loading = false;
	    $uibModalInstance.close($ctrl.selected.item);
	  };

	  $ctrl.cancel = function () {
	    $uibModalInstance.dismiss('cancel');
	  };
	}]);
}).call(this);
