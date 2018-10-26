(function() {
  angular.module('wdApp.apps.meusJogos.details', []).filter('filterStatus', function () {
      
      return function (input, price) {
          var output = [];
          var returns = [];
          $.each( $('#buscarStatus-container3 .badgebox'), function( key, value ) {

          if($(this).is(":checked")){
            console.log($(this).val());
            output.push($(this).val())}
          })
          for(var x = 0 ; x < input.length;x++)
          {
               if( $.inArray(input[x].status, output) !== -1 ){
                   returns.push(input[x]);
               }
          }
     /*     
          returns.sort(function(a, b){
              
           a = parseInt(a.dia);
           b = parseInt(b.dia);
           return a - b;
       });
*/ 

          return returns;
      }
  }).filter('priceGreaterThan', function () {
      
      return function (input, price) {
          
          var output = [];
          var returns = [];
          $.each( $('#buscarQuadra-container3 .badgebox'), function( key, value ) {
           // console.log( key + ": " + value );
          if($(this).is(":checked")){
            console.log($(this).val());
            output.push($(this).val())}
          })
          for(var x = 0 ; x < input.length;x++)
          {
               if( $.inArray(input[x].dia, output) !== -1 ){
                   returns.push(input[x]);
               }
          }
     /*     
          returns.sort(function(a, b){
              
           a = parseInt(a.dia);
           b = parseInt(b.dia);
           return a - b;
       });
*/
          return returns;
      }
  }).controller('MeusJogosDetailsController', 
  ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig',
	function($scope, jogoFactory, AuthService, $rootScope, $location,  localStorageService, toastr, $http, $interval, SysMgmtData, toastr, toastrConfig) {
	  var evm = this;
		evm.combo = {};
		$scope.bUserJogoConfirm = false;
		$scope.bUserJogoAprovar = false;
		$scope.bUserJogoJogado = false;
		$scope.iQuantGols = 0;
		$scope.fMedia = 0;

		

		$scope.myFilter = function (item) {
			var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
			return ((item.status === 'ACONFIRMAR') && (item.data > ((new Date).getDate())) && (oUser.id === item.user_id));
		};

		$scope.myFilterUserJogo = function (item) {
			
			var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
			return ((item.status_user === 'SOLICITADO'));
		};

		$scope.myFilter2 = function (item) {

			return (item.status === 'CONFIRMADO' || item.status === 'NAOVO');
		};
		
		$scope.showAprovar = function () {
			item = $scope.jogos.usersJogo;
			var bReturn = false;
			for(var x = 0;x < item.lenght; x++){
				if(item[x].jogoData.status_user == 'SOLICITADO')
					bReturn = true;
			}
			return bReturn;
		};
		
		$scope.showConfirmar = function () {
			item = $scope.jogos.jogoPorData;
			var bReturn = false;
			for(var x = 0;x < item.lenght; x++){
				if(item[x].jogoData.status == 'AJOGAR')
					bReturn = true;
			}
			return bReturn;
		};

		$scope.myFilter3 = function (item) {
			
			//var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
			return (item.status === 'AJOGAR');
		};


		$scope.fnNameJogadorAprovar = function (item,jogoData) {
			var sName = "";

			for(var x = 0; x< item.usersJogo.length;x++)
			{
				if(jogoData.user_id === item.usersJogo[x].id)
				{
					sName = item.usersJogo[x].name +" "+ item.usersJogo[x].lastName + "(" + item.usersJogo[x].email + ")";
				}
			}
			
			return sName;
		};

		$scope.fnConfirm = function (usuariosConfirm, usuariosJogo) {
			var iReturn = 1;
			
			if (usuariosConfirm && usuariosConfirm.usersJogo2) {
				for (var x = 0; x < usuariosConfirm.usersJogo2.length;x++) {
					var jogos = usuariosConfirm.usersJogo2[x];
					if(jogos.user_id === usuariosJogo.id){
						if (jogos.status_user === "CONFIRMADO") {
							iReturn = 3;
							break
						} else if (jogos.status_user === "NAOVO") {
							iReturn = 2;
							break
						}
			
					}
				}
			}
			
			return iReturn;
		}

		//===============================================================//
		$scope.oneAtATime = true;
		$scope.groups = [{
			title: "Dynamic Group Header - 1",
			content: "Dynamic Group Body - 1"
		}, {
			title: "Dynamic Group Header - 2",
			content: "Dynamic Group Body - 2"
		}, {
			title: "Dynamic Group Header - 3",
			content: "Dynamic Group Body - 3"
		}];
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
		$scope.addItem = function () {
			var newItemNo;
			newItemNo = $scope.items.length + 1;
			$scope.items.push("Item " + newItemNo);
		};


		var fnCallback = function (oResp) {

			var odata = [];
			var oGols = [];
			var oNota = [];
			console.log(oResp);
			$scope.jogos = oResp;
//			for (var x = 0; x < oResp.length; x++) {
//				var pJogo = oResp[x];
//				$scope.bUserJogoConfirm = pJogo.usersJogo.length > 0 ? true : false;
//				$scope.bUserJogoAprovar = pJogo.usersJogo2.length > 0 ? true : false;
//				$scope.bUserJogoJogado = pJogo.jogos.length > 0 ? true : false;
//				for (var y = 0; y < pJogo.jogos.length; y++) {
//					var oJogoData = pJogo.jogos[y];
//					odata.push(moment(oJogoData.data).format("DD/MM/YY"));
//					oNota.push(oJogoData.nota ? parseInt(oJogoData.nota, 10) : 0);
//					oGols.push(oJogoData.qntGols ? oJogoData.qntGols : 0);
//					$scope.iQuantGols = $scope.iQuantGols + oJogoData.qntGols;
//					$scope.fMedia = $scope.fMedia + oJogoData.nota;
//				}
//
//			}
//			//	evm.combo.options = {};
//			evm.combo.options = {
//				tooltip: {
//					trigger: 'axis'
//				},
//				toolbox: {
//					show: true,
//					feature: {
//						//	dataView : {show: true, readOnly: false, title: "data",  lang:['Data View', 'close', 'refresh']},
//						magicType: {
//							show: true,
//							type: ['line', 'bar'],
//							title: {
//								line: 'line',
//								bar: 'bar'
//							}
//						},
//						restore: {
//							show: true,
//							title: "restore"
//						},
//						//	saveAsImage : {show: true, title: "save as image"}
//					}
//				},
//				calculable: true,
//				legend: {
//					data: ['Gols', 'Nota']
//				},
//				xAxis: [{
//					type: 'category',
//					data: odata //['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
//				}],
//				yAxis: [{
//						type: 'value',
//						name: 'Quantidade',
//						axisLabel: {
//							formatter: '{value}'
//						}
//					},
//					{
//						type: 'value',
//						name: 'Temperature',
//						axisLabel: {
//							formatter: '{value} °C'
//						}
//					}
//				],
//				series: [
//
//					{
//						name: 'Gols',
//						type: 'bar',
//						data: oGols
//					},
//					{
//						name: 'Nota',
//						type: 'bar',
//						data: oNota
//					}
//					/*	,
//						{
//							name:'Average Temperature',
//							type:'line',
//							yAxisIndex: 1,
//							data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
//						} */
//				]
//			};

		}
	//	debugger
		AuthService.fetchJogosById({id: parseInt($location.search().id,10)}, fnCallback);

		$scope.gravarHorario = function (oJogo, sStatus) {
			jogoFactory.updateJogoPorData(oJogo, sStatus, function (oResp) {
				AuthService.fetchJogosByUserId(oUser, fnCallback)
			});
		}

		
		$scope.aprovarJogador = function (oJogo, sStatus) {
			oJogo.aprovadoPor = oUser.id;
			jogoFactory.aprovarJogador(oJogo, sStatus, function (oResp) {
				AuthService.fetchJogosByUserId(oUser, fnCallback)
			});
		}
	}
  ]);
}).call(this);
