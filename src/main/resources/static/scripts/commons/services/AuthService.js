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
	        },
	        fetchAllNotificacoes   : function (oNotificacao, fnCallback) {
	            var url = sUrlServer + '/notificacao/fetchByUser';
	            	
	            SysMgmtData.processPostPageData(url, oNotificacao ,fnCallback);
	        },
	        updateNotificacoes   : function (oNotificacao, fnCallback) {
	            var url = sUrlServer + '/notificacao/update';
	            	
	            SysMgmtData.processPostPageData(url, oNotificacao ,fnCallback);
	        },
	        deleteNotificacoes   : function (oNotificacao, fnCallback) {
	            var url = sUrlServer + '/notificacao/delete';
	            	
	            SysMgmtData.processPostPageData(url, oNotificacao ,fnCallback);
	        },
	        contNotificacoes   : function (oNotificacao, fnCallback) {
	            var url = sUrlServer + '/notificacao/fetchByUserCount';
	            	
	            SysMgmtData.processPostPageData(url, oNotificacao ,fnCallback, false);
	        }
		};
	}]);
})();