(function() {
'use strict';
	var commonData = angular.module('wdApp.apps.Auth', []);
	var sUrlServer = 'http://localhost:8080';
	commonData.factory('AuthService', ['$http','SysMgmtData', function($http,SysMgmtData){
		
		return{
			encryptPassword : function (password) {
	            var aesPack = {};
	            var iv = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
	            aesPack.iv = iv;
	            aesPack.salt = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
	            aesPack.keySize = 128;
	            aesPack.iterations = 1000;

	            var key = CryptoJS.PBKDF2(
	                "biZndDtCMkdeP8K0V15OKMKnSi85",
	                CryptoJS.enc.Hex.parse(aesPack.salt), { keySize: aesPack.keySize/32, iterations: aesPack.iterations });

	            var encrypted = CryptoJS.AES.encrypt(password, key, { iv: CryptoJS.enc.Hex.parse(aesPack.iv) });
	            aesPack.ciphertext = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
	            return aesPack;
			},     
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
	        register  : function (oUser, fnCallback) {
	        	
	            var url = sUrlServer + '/user/insert';
	            
	            var aesPack = {};
	            var iv = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
	            aesPack.iv = iv;
	            aesPack.salt = CryptoJS.lib.WordArray.random(128/8).toString(CryptoJS.enc.Hex);
	            aesPack.keySize = 128;
	            aesPack.iterations = 1000;

	            var key = CryptoJS.PBKDF2(
	                "biZndDtCMkdeP8K0V15OKMKnSi85",
	                CryptoJS.enc.Hex.parse(aesPack.salt), { keySize: aesPack.keySize/32, iterations: aesPack.iterations });

	            var encrypted = CryptoJS.AES.encrypt(oUser.password, key, { iv: CryptoJS.enc.Hex.parse(aesPack.iv) });
	            aesPack.ciphertext = encrypted.ciphertext.toString(CryptoJS.enc.Base64);
	            
	            oUser.password = '';
	            oUser.iv = aesPack.iv;
	            oUser.salt = aesPack.salt;
	            oUser.keySize = aesPack.keySize;
	            oUser.iterations = aesPack.iterations;
	            oUser.encryptedPassword = aesPack.ciphertext;

                console.log('encryptedPassword: '+oUser.encryptedPassword);
                console.log('pass: '+oUser.password);
                console.log('email: '+oUser.email);
                console.log('displayName: '+oUser.nome);
	
	            SysMgmtData.processPostPageData(url, new qat.model.user(oUser) ,fnCallback);
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
	        },//
	        fetchAllQuadraByEmpresa   : function (oEmpresa, fnCallback) {
	            var url = sUrlServer + '/quadra/findAllQuadraByEmpresa';
	            	
	            SysMgmtData.processPostPageData(url, oEmpresa ,fnCallback, false);
	        },
	        marcarJogoPorData   : function (oEmpresa, fnCallback) {
	            var url = sUrlServer + '/jogo/updateJogoPorData';
	            	
	            SysMgmtData.processPostPageData(url, oEmpresa ,fnCallback, false);
	        },
	        aprovarJogador   : function (oEmpresa, fnCallback) {
	            var url = sUrlServer + '/jogo/aprovarJogador';
	            	
	            SysMgmtData.processPostPageData(url, oEmpresa ,fnCallback, false);
	        }
		};
	}]);
})();