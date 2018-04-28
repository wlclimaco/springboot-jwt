(function() {
  'use strict';
  angular.module('wdApp.ui.controllers', []).controller('NotifyController', [
    '$scope', 'toastr', 'toastrConfig', function($scope, toastr, toastrConfig) {
		
	  toastrConfig.positionClass = 'toast-bottom-right';
      toastrConfig.closeButton = true;

      return $scope.notify = function(type) {
        switch (type) {
          case 'info':
            return toastr.info('Heads up! This alert needs your attention, but it\'s not super important.', 'Information');
          case 'success':
            return toastr.success('Well done! You successfully read this important alert message.');
          case 'warning':
            return toastr.warning('Warning! Best check yo self, you\'re not looking too good.', 'Warning');
          case 'error':
            return toastr.error('Oh snap! Change a few things up and try submitting again.', 'Error');
        }
      };
    }
  ]).controller('AlertDemoController', [
    '$scope', function($scope) {
      $scope.alerts = [
        {
          type: 'success',
          msg: 'Well done! You successfully read this important alert message.'
        }, {
          type: 'info',
          msg: 'Heads up! This alert needs your attention, but it is not super important.'
        }, {
          type: 'warning',
          msg: "Warning! Best check yourself, you're not looking too good."
        }, {
          type: 'danger',
          msg: 'Oh snap! Change a few things up and try submitting again.'
        }
      ];
      $scope.addAlert = function() {
        var num, type;
        num = Math.ceil(Math.random() * 4);
        type = void 0;
        switch (num) {
          case 0:
            type = 'info';
            break;
          case 1:
            type = 'success';
            break;
          case 2:
            type = 'info';
            break;
          case 3:
            type = 'warning';
            break;
          case 4:
            type = 'danger';
        }
        return $scope.alerts.push({
          type: type,
          msg: "Another alert!"
        });
      };
      return $scope.closeAlert = function(index) {
        return $scope.alerts.splice(index, 1);
      };
    }
  ]).controller('ProgressDemoController', [
    '$scope', function($scope) {
      $scope.max = 200;
      $scope.random = function() {
        var type, value;
        value = Math.floor((Math.random() * 100) + 10);
        type = void 0;
        if (value < 25) {
          type = "success";
        } else if (value < 50) {
          type = "info";
        } else if (value < 75) {
          type = "warning";
        } else {
          type = "danger";
        }
        $scope.showWarning = type === "danger" || type === "warning";
        $scope.dynamic = value;
        $scope.type = type;
      };
      return $scope.random();
    }
  ]).controller('AccordionDemoController', [
    '$scope', function($scope) {
      $scope.oneAtATime = true;
      $scope.groups = [
        {
          title: "Dynamic Group Header - 1",
          content: "Dynamic Group Body - 1"
        }, {
          title: "Dynamic Group Header - 2",
          content: "Dynamic Group Body - 2"
        }, {
          title: "Dynamic Group Header - 3",
          content: "Dynamic Group Body - 3"
        }
      ];
      $scope.items = ["Item 1", "Item 2", "Item 3"];
      $scope.status = {
        isFirstOpen: true,
        isFirstOpen1: true,
        isFirstOpen2: true,
        isFirstOpen3: true,
        isFirstOpen4: true,
        isFirstOpen5: true,
        isFirstOpen6: true
      };
      $scope.addItem = function() {
        var newItemNo;
        newItemNo = $scope.items.length + 1;
        $scope.items.push("Item " + newItemNo);
      };
    }
  ]).controller('CollapseDemoController', [
    '$scope', function($scope) {
      return $scope.isCollapsed = false;
    }
  ]).controller('ModalDemoController', [
    '$scope', '$uibModal', '$log','$document', function($scope, $uibModal, $log,$document) {
      $scope.items = ["item1", "item2", "item3"];
      $scope.ok = function(a,b) {debugger; console.log('a')}
      $scope.open = function(size, parentSelector,jogo,status) {
        var modalInstance;
        modalInstance = $uibModal.open({
          templateUrl: "myModalContent.html",
          controller: 'ModalInstanceController',
          resolve: {
            items: function() {
            	 return {"jogo" : jogo,"status" : status};
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

    	      var modalInstance;
    	     modalInstance = $uibModal.open({
    	      animation: $scope.animationsEnabled,
    	      ariaLabelledBy: 'modal-title',
    	      ariaDescribedBy: 'modal-body',
    	      templateUrl: 'myModalContent2.html',
    	      controller: 'ModalInstanceController',
    	      size: size,
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
    }
  ]).controller('ModalInstanceController', [
    '$scope', '$uibModalInstance', 'items','jogoFactory', function($scope, $uibModalInstance, items,jogoFactory) {
      $scope.items = items;
      $scope.selected = {
        item: $scope.items[0]
      };
      $scope.ok = function(oJogo, sStatus) {
    	  debugger
    	jogoFactory.update(oJogo, sStatus);
        $uibModalInstance.close($scope.selected.item);
      };
      $scope.cancel = function() {
        $uibModalInstance.dismiss("cancel");
      };
    }
  ]).controller('PaginationDemoController', [
    '$scope', function($scope) {
	  var pcm = this;	
      pcm.totalItems = 64;
      pcm.currentPage = 4;
      pcm.setPage = function(pageNo) {
        return pcm.currentPage = pageNo;
      };
      pcm.maxSize = 5;
      pcm.bigTotalItems = 175;
      return pcm.bigCurrentPage = 1;
    }
  ]).controller('TabsDemoController', [
    '$scope', function($scope) {
      $scope.tabs = [
        {
          title: "Dynamic Title 1",
          content: "Dynamic content 1.  Consectetur adipisicing elit. Nihil, quidem, officiis, et ex laudantium sed cupiditate voluptatum libero nobis sit illum voluptates beatae ab. Ad, repellendus non sequi et at."
        }, {
          title: "Disabled",
          content: "Dynamic content 2.  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil, quidem, officiis, et ex laudantium sed cupiditate voluptatum libero nobis sit illum voluptates beatae ab. Ad, repellendus non sequi et at.",
          disabled: true
        }
      ];
      return $scope.navType = "pills";
    }
  ]).controller('TreeDemoController', [
    '$scope','DemoData', function($scope, DemoData) {
    	
      

	  DemoData.getDemoData('./demodata/dyntree.json', function(data){
			$scope.list = data;		 
	  });
      $scope.selectedItem = {};
      $scope.options = {};
      $scope.remove = function(scope) {
        scope.remove();
      };
      $scope.toggle = function(scope) {
        scope.toggle();
      };
      return $scope.newSubItem = function(scope) {
        var nodeData;
        nodeData = scope.$modelValue;
        nodeData.items.push({
          id: nodeData.id * 10 + nodeData.items.length,
          title: nodeData.title + "." + (nodeData.items.length + 1),
          items: []
        });
      };
    }
  ]).controller('MapDemoController', [
    '$scope', '$http', '$interval', function($scope, $http, $interval) {
    	
    	var createMacromed =	function(oEmpresa)
        {
    	  var vazio = " -- "
      	  
      	  var sHtml = ' <div class="panel panel-default">' +
      	  ' <div class="panel-body">' +
            '    <div class="media">' +
            '       <div class="media-body">' +
            '            <ul class="list-unstyled list-info">' +
            '                <li>' +
            '                    <div class="pull-left"><span class="icon glyphicon glyphicon-user"></span>' +
            '                    <label>Nome Quadra</label>' +
            '                    '+oEmpresa.nome+'</div>' +
            '					 <div class="pull-right"><span class="icon glyphicon glyphicon-user"></span>' +
            '                    <label>Responsavel</label>' +
            '                    '+oEmpresa.nomeResponsavel+'</div>' +
            '                </li><br>' +
            '                <li>' +
            '                    <div class="pull-left"><span class="icon glyphicon glyphicon-envelope"></span>' +
            '                    <label>Email</label>' +
            '                    '+oEmpresa.email+' </div>' +
            '				     <div class="pull-right"><span class="icon glyphicon glyphicon-home"></span>' +
            '                    <label>Endereço</label>' +
            '                    '+oEmpresa.endereco.logradouro+', '+oEmpresa.endereco.numero+', '+oEmpresa.endereco.bairro+' </div>' +
            '                </li><br>' +
            '                <li>' +
            '                    <div class="pull-left"><span class="icon glyphicon glyphicon-earphone"></span>' +
            '                    <label>Telefone</label>' +
            '                    '+oEmpresa.telefone+'</div>' +
            '                    <div class="pull-right"><span class="icon glyphicon glyphicon-flag"></span>' +
            '                    <label>H. Func</label>' +
            '                    Australia</div>' +
            '                </li>' ;
            for(var y = 0; y < oEmpresa.quadras.length;y++){
            	
            	var oQuadra = oEmpresa.quadras[y];
            	sHtml=  sHtml+  '<hr><li>' +
            '                    <div class="pull-left"><span class="icon glyphicon glyphicon-globe"></span>' +
            '                    <label>Quadra</label>' +
            '                    '+oQuadra.nome+'</div>' +
            '                </li>' +
            '                <li>' +
            '                    <div class="pull-left"><span class="icon glyphicon glyphicon-globe"></span>' +
            '                    <label>Tipo Piso</label>' +
            '                    '+oQuadra.tipo  +'</div>' +
            '                    <div class="pull-right"><span class="icon glyphicon glyphicon-globe"></span>' +
            '                    <label>Coberta</label>' +
            '                    '+oQuadra.cobertura  +'</div>' +
            '                </li>' +
    		'                <li>' +
            '                    <div class="pull-left"><span class="icon glyphicon glyphicon-envelope"></span>' +
            '                    <label>Valor/Sem Bola</label>' +
            '                    '+oQuadra.valor+' </div>' +
            '				     <div class="pull-right"><span class="icon glyphicon glyphicon-home"></span>' +
            '                    <label>Valor/Com Bola</label>' +
            '                    '+(oQuadra.valor + oQuadra.valorBola) +'</div>' +
            '                </li>' 
            }

      	sHtml=  sHtml+'            </ul>' +
            '            ' +
            '        </div>' +
            '    </div>' +
            '</div>' +
            '</div>' ;
      	  debugger
      	  return sHtml;
        }
    	 var map, infoWindow;
    	var mapOptions = {
                zoom: 12,
                center: {lat: -19.7483300, lng: -47.9319400},
                mapTypeId: google.maps.MapTypeId.ROADMAP,
                scrollwheel: false
            };
             //   if (map === void 0) {
             //       map = new google.maps.Map(document.getElementById('mapamaster'), mapOptions);
             //   }
               
      var i, markers;
      markers = [];
      i = 0;
//      while (i < 8) {
        markers[0] = new google.maps.Marker({
          title: "Quadra 01 click details"
        });
    //    i++;
  //    }
      $scope.GenerateMapMarkers = function() {
    	  
        var d, lat, lng, loc, numMarkers;
        d = new Date();
        $scope.date = d.toLocaleString();
    //    numMarkers = Math.floor(Math.random() * 4) + 4;
   //     i = 0;
          for (var x = 0; $scope.empresaList.length > 0 ;x++)
          {
        	 // if($scope.empresaList[x] && $scope.empresaList[x].endereco)
        	//  {
	        	  var endereco = $scope.empresaList[x].endereco;
		          lat = endereco.lat;
		          lng = endereco.longi;
		          loc = new google.maps.LatLng(lat, lng);
		          markers[0].setPosition(loc);
		          markers[0].setMap($scope.map);
        	//  }
    //      i++;
        }
      };
      
      google.maps.event.addListener(markers[0], 'click', function () {
    	  
    	  var contentString = '<div id="content">'+
          '<div id="siteNotice">'+
          '</div>'+
          '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+
          '<div id="bodyContent">'+
          '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
          'sandstone rock formation in the southern part of the '+
          'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '+
          'south west of the nearest large town, Alice Springs; 450&#160;km '+
          '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '+
          'features of the Uluru - Kata Tjuta National Park. Uluru is '+
          'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
          'Aboriginal people of the area. It has many springs, waterholes, '+
          'rock caves and ancient paintings. Uluru is listed as a World '+
          'Heritage Site.</p>'+
          '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
          'https://en.wikipedia.org/w/index.php?title=Uluru</a> '+
          '(last visited June 22, 2009).</p>'+
          '</div>'+
          '</div>';

          // close window if not undefined
          if (infoWindow !== void 0) {
              infoWindow.close();
          }
          // create new window
          var infoWindowOptions = {
              content: createMacromed($scope.empresaList[0])
          };
          infoWindow = new google.maps.InfoWindow(infoWindowOptions);
          infoWindow.open($scope.map, markers[0]);
      });
      
      $interval($scope.GenerateMapMarkers, 10000);
    }
  ]).controller('LoaderController', ['$scope', 'cfpLoadingBar', function($scope, cfpLoadingBar) {
    $scope.start = function() {
      return cfpLoadingBar.start();
    };
    $scope.inc = function() {
      return cfpLoadingBar.inc();
    };
    $scope.set = function() {
      return cfpLoadingBar.set(0.3);
    };
    return $scope.complete = function() {
      return cfpLoadingBar.complete();
    };
   }
 ]);

}).call(this);

