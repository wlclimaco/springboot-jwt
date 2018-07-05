(function() {
    'use strict';
    angular.module('wdApp.apps.factory.meusJogos', [])
        .factory('jogoFactory', ['$rootScope', '$http', 'toastr', 'toastrConfig', 'localStorageService', 'AuthService', function($rootScope, $http, toastr, toastrConfig, localStorageService, AuthService) {

            toastrConfig.closeButton = true;

            return {

                gravarGols: function(oJogo) {
                    var oUserJogoData = [];
                    if(oJogo && oJogo.userJogoData)
                    {
	                    for (var i = 0; i < oJogo.userJogoData.length; i++) {
	                    	oUserJogoData.push(new qat.model.UserJogoData(oJogo.userJogoData[i]));
						}
	                    oJogo.userJogoData = oUserJogoData;
                    }
                    debugger
                    AuthService.gravarUserJogoData(new qat.model.jogoPorData2(oJogo), function(res) {
                        console.log(res)
                        toastr.success('Jogo ' + status.toLowerCase() + ' com sucesso!', 'Information');
                    })

                },

                gravarNotas: function(oJogo) {
                	var oUserJogoData = [];
                    if(oJogo && oJogo.userJogoData)
                    {
	                    for (var i = 0; i < oJogo.userJogoData.length; i++) {
	                    	oUserJogoData.push(new qat.model.UserJogoData(oJogo.userJogoData[i]));
						}
	                    oJogo.userJogoData = oUserJogoData;
                    }
                    debugger
                    AuthService.gravarUserJogoData(new qat.model.jogoPorData2(oJogo), function(res) {
                        console.log(res)
                        toastr.success('Jogo ' + status.toLowerCase() + ' com sucesso!', 'Information');
                    })
                },

                update: function(oJogo, status) {
                    var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
                    if (oJogo.status === "INDISPONIVEL") { // Solicitar participação
                        var oUserJogo = {
                            user_id: oUser.id,
                            jogo_id: oJogo.id,
                            status_user: "SOLICITADO",
                            admin: "NAO"
                        }
                        oJogo.status = status
                        oJogo.user_id = oUser.id;

                        AuthService.solicitarParticipacao(new qat.model.UserJogo2(oUserJogo), function(res) {
                            console.log(res)
                            toastr.success('Jogo ' + status.toLowerCase() + ' com sucesso!', 'Information');
                        })
                    } else // MArcar Quadra
                    {
                        oJogo.status = status
                        oJogo.user_id = oUser.id;
                        AuthService.marcarJogo(new qat.model.jogo(oJogo), function(res) {
                            console.log(res)
                            toastr.success('Jogo ' + status.toLowerCase() + ' com sucesso!', 'Information');
                        })
                    }
                },
                updateJogoPorData: function(oJogo, status, fncallBack) {
                    var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
                    oJogo.status = status
                    oJogo.user_id = oUser.id;
                    AuthService.marcarJogoPorData(new qat.model.jogoPorData(oJogo), function(res) {
                        console.log(res)
                        toastr.success('Jogo ' + status.toLowerCase() + ' com sucesso!', 'Information');
                        fncallBack(res);
                    })
                },

                aprovarJogador: function(oJogo, status, fncallBack) {
                    var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
                    oJogo.status_user = status
                    oJogo.aprovadoPor = oUser.id;
                    oJogo.aprovadoDate = new Date();
                    AuthService.aprovarJogador(new qat.model.UserJogo2(oJogo), function(res) {
                        console.log(res)
                        toastr.success('Jogo ' + status.toLowerCase() + ' com sucesso!', 'Information');
                        fncallBack(res);
                    })
                }
            };
        }]);

}).call(this);