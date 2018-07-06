(function() {
    'use strict';
    angular.module('wdApp.apps.factory.meusJogos', [])
        .factory('jogoFactory', ['$rootScope', '$http', 'toastr', 'toastrConfig', 'localStorageService', 'AuthService', function($rootScope, $http, toastr, toastrConfig, localStorageService, AuthService) {

            toastrConfig.closeButton = true;

            return {

                gravarGols: function(oJogo) {
                    debugger
                    var oUserJogoData = [];
                    if (oJogo && oJogo.userJogoData) {
                        for (var i = 0; i < oJogo.userJogoData.length; i++) {
                            oUserJogoData.push(new qat.model.UserJogoData(oJogo.userJogoData[i]));
                        }
                        oJogo.userJogoData = oUserJogoData;
                    }
                    AuthService.gravarUserJogoData(new qat.model.jogoPorData2(oJogo), function(res) {
                        console.log(res)
                    })

                },

                gravarNotas: function(oJogo) {
                    debugger

                    function teste(oNotasGols, jogoId, jogoPorDataId, useJogoDataId, userId, userNota) {
                        if (oNotasGols) {
                            for (var x = 0; x < oNotasGols.length; x++) {
                                var oNotasGolsAux = oNotasGols[x];
                                if ((oNotasGolsAux.jogoId == jogoId) &&
                                    (oNotasGolsAux.jogoPorDataId == jogoPorDataId) &&
                                    (oNotasGolsAux.useJogoDataId == useJogoDataId) &&
                                    (oNotasGolsAux.userId == userId) &&
                                    (oNotasGolsAux.userNota == userNota)
                                ) {
                                    return oNotasGolsAux.id;
                                } else {
                                    return null
                                }
                            }
                        } else {
                            return null
                        }
                    }
                    var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
                    var oUserJogoData = [];
                    if (oJogo && oJogo.userJogoData) {
                        for (var i = 0; i < oJogo.userJogoData.length; i++) {
                            var aJogo = oJogo.userJogoData[i];

                            var notaGols = {
                                id: teste(oJogo.notasGols, oJogo.jogoId, aJogo.jogoPorData_id, aJogo.id, aJogo.user_id, oUser.id),
                                useJogoDataId: aJogo.id,
                                userId: aJogo.user_id,
                                jogoId: oJogo.jogoId,
                                jogoPorDataId: aJogo.jogoPorData_id,
                                nota: aJogo.nota ? aJogo.nota : 0,
                                qntGols: aJogo.qntGols ? aJogo.qntGols : 0,
                                date: new Date(),
                                userNota: oUser.id
                            }

                            oUserJogoData.push(new qat.model.NotasGols(notaGols));
                        }
                    }
                    AuthService.gravarUserJogoData({ notasGols: oUserJogoData }, function(res) {
                        console.log(res)
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