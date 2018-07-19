(function() {
    'use strict';
    var commonData = angular.module('wdApp.apps.Auth', []);
    var sUrlServer = 'https://quadra-test.herokuapp.com';
    commonData.factory('AuthService', ['Base64', '$http', 'SysMgmtData', function(Base64, $http, SysMgmtData) {

        function userValorDefauld(oUser) {

            oUser.active = 1;
            oUser.isDono = 0;
            oUser.roles = [{ id: 1}];
            oUser.lastLoginAt = new Date();
            oUser.enabled = 0;
            oUser.receberNotificacoes = true;

            return oUser;
        }

        function encryptPassword(password) {
            var aesPack = {};
            var iv = CryptoJS.lib.WordArray.random(256 / 8).toString(CryptoJS.enc.Hex);
            aesPack.iv = iv;
            aesPack.salt = CryptoJS.lib.WordArray.random(256 / 8).toString(CryptoJS.enc.Hex);
            aesPack.keySize = 256;
            aesPack.iterations = 1000;

            var key = CryptoJS.PBKDF2(
                "biZndDtCMkdeP8K0V15OKMKnSi85",
                CryptoJS.enc.Hex.parse(aesPack.salt), { keySize: aesPack.keySize / 32, iterations: aesPack.iterations });

            var encrypted = CryptoJS.AES.encrypt(password, key, { iv: CryptoJS.enc.Hex.parse(aesPack.iv) });
            aesPack.ciphertext = encrypted.ciphertext.toString(CryptoJS.enc.Base64);

            return aesPack;
        };

        return {

            fetchJogosByUserId: function(user, fnCallback) {
                var url = sUrlServer + '/jogo/findJogoByUser';

                SysMgmtData.processPostPageData(url, user, fnCallback);
            },
            
            fetchChatByUserId: function(user, fnCallback) {
                var url = sUrlServer + '/chat/findChatByUser';

                SysMgmtData.processPostPageData(url, user, fnCallback);
            }, // fetchChatById
            fetchChatById: function(user, fnCallback) {
                var url = sUrlServer + '/chat/findChatById';

                SysMgmtData.processPostPageData(url, user, fnCallback);
            },
            fetchAllEmpresa: function(user, fnCallback) {
                var url = sUrlServer + '/empresa/fetchAllEmpresa';

                SysMgmtData.processPostPageData(url, user, fnCallback);
            },
            marcarJogo: function(oJogo, fnCallback) {
                var url = sUrlServer + '/jogo/update';

                SysMgmtData.processPostPageData(url, oJogo, fnCallback);
            },
            solicitarParticipacao: function(oJogo, fnCallback) {
                var url = sUrlServer + '/jogo/insertUserJogo';

                SysMgmtData.processPostPageData(url, oJogo, fnCallback);
            }, 
            gravarUserJogoData: function(oJogo, fnCallback) {
                var url = sUrlServer + '/userJogoData/update';

                SysMgmtData.processPostPageData(url, oJogo, fnCallback);
            }, 
            
            register: function(oUser, fnCallback) {
                
                var url = sUrlServer + '/user/insert';

                var aesPack = encryptPassword(oUser.password);
                oUser.password = oUser.password;
                oUser.vpassword = '';
                oUser.iv = aesPack.iv;
                oUser.salt = aesPack.salt;
                oUser.keySize = aesPack.keySize;
                oUser.iterations = aesPack.iterations;
                oUser.encryptedPassword = aesPack.ciphertext;

                console.log('encryptedPassword: ' + oUser.encryptedPassword);
                console.log('pass: ' + oUser.password);
                console.log('email: ' + oUser.email);
                console.log('displayName: ' + oUser.nome);
                oRole = [];
                oRole = oUser.roles;
                oRole.push({id : 2})
                oRole.push({id : 3})
                oRole.push({id : 4})
                oRole.push({id : 5})



                var aesPack = encryptPassword(oUser.password);

                SysMgmtData.processPostPageData(url, new qat.model.user(userValorDefauld(oUser)), fnCallback);
            },
            fetchAllNotificacoes: function(oNotificacao, fnCallback) {
                var url = sUrlServer + '/notificacao/fetchByUser';

                SysMgmtData.processPostPageData(url, oNotificacao, fnCallback);
            },
            insertChatMessage: function(oNotificacao, fnCallback) {
                var url = sUrlServer + '/chat/insert';

                SysMgmtData.processPostPageData(url, oNotificacao, fnCallback);
            },
            updateChatMessage: function(oNotificacao, fnCallback) {
                var url = sUrlServer + '/chat/Update';

                SysMgmtData.processPostPageData(url, oNotificacao, fnCallback);
            },
            deleteChatMessage: function(oNotificacao, fnCallback) {
                var url = sUrlServer + '/chat/delete';

                SysMgmtData.processPostPageData(url, oNotificacao, fnCallback);
            },
            updateNotificacoes: function(oNotificacao, fnCallback) {
                var url = sUrlServer + '/notificacao/update';

                SysMgmtData.processPostPageData(url, oNotificacao, fnCallback);
            },
            deleteNotificacoes: function(oNotificacao, fnCallback) {
                var url = sUrlServer + '/notificacao/delete';

                SysMgmtData.processPostPageData(url, oNotificacao, fnCallback);
            },
            contNotificacoes: function(oNotificacao, fnCallback) {
                var url = sUrlServer + '/notificacao/fetchByUserCount';

                SysMgmtData.processPostPageData(url, oNotificacao, fnCallback, false);
            }, //
            fetchAllQuadraByEmpresa: function(oEmpresa, fnCallback) {
                var url = sUrlServer + '/quadra/findAllQuadraByEmpresa';

                SysMgmtData.processPostPageData(url, oEmpresa, fnCallback, false);
            },
            marcarJogoPorData: function(oEmpresa, fnCallback) {
                var url = sUrlServer + '/jogo/updateJogoPorData';

                SysMgmtData.processPostPageData(url, oEmpresa, fnCallback, false);
            },
            aprovarJogador: function(oEmpresa, fnCallback) {
                var url = sUrlServer + '/jogo/aprovarJogador';

                SysMgmtData.processPostPageData(url, oEmpresa, fnCallback, false);
            }
        };
    }]);
})();
