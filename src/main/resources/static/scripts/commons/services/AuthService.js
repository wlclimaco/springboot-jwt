(function() {
'use strict';
	var commonData = angular.module('wdApp.apps.Auth', []);
	var sUrlServer = 'http://localhost:8080';
	commonData.factory('AuthService', ['$http','SysMgmtData', function($http,SysMgmtData){
		return{
			fetchJogosByUserId : function (user, fnCallback) {
	            var url = sUrlServer + '/jogo/findJogoByUser';
	            	
	            SysMgmtData.processPostPageData(url, user ,fnCallback);
	        },
	        fetchAllEmpresa : function (user, fnCallback) {
	            var url = sUrlServer + '/empresa/fetchAllEmpresa';
	            	
	            SysMgmtData.processPostPageData(url, user ,fnCallback);
	        },
	        marcarJogo : function (oJogo, fnCallback) {
	            var url = sUrlServer + '/jogo/update';
	            	
	            SysMgmtData.processPostPageData(url, oJogo ,fnCallback);
	        },
	        solicitarParticipacao  : function (oJogo, fnCallback) {
	            var url = sUrlServer + '/jogo/insertUserJogo';
	            	
	            SysMgmtData.processPostPageData(url, oJogo ,fnCallback);
	        }
		};
	}]);
})();