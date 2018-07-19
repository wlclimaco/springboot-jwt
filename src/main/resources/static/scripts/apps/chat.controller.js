(function() {
    angular.module('wdApp.apps.chat', []).controller('ChatController', ['$scope', 'jogoFactory', 'AuthService', '$rootScope', '$location', '$http', '$interval', 'SysMgmtData', 'toastr', 'toastrConfig', 
        function($scope, jogoFactory, AuthService, $rootScope, $location, localStorageService, toastr, $http, $interval, SysMgmtData, toastr, toastrConfig) {
            var evm = this;
            evm.combo = {};
            $scope.oChat = [{}];
            /** holds tabs, we will perform repeat on this **/
            $scope.tabs = [{
                    id: 1,
                    content: 'This is a default tab on load'
                },
                {
                    id: 2,
                    content: 'This is a default tab on load'
                },
                {
                    id: 3,
                    content: 'This is a default tab on load'
                }
            ]

            $scope.counter = 1;
            /** Function to add a new tab **/
            $scope.addTab = function() {
                $scope.counter++;
                $scope.tabs.push({ id: $scope.counter, content: 'Any Content' });
                $scope.selectedTab = $scope.tabs.length - 1; //set the newly added tab active. 
            }

            /** Function to delete a tab **/
            $scope.deleteTab = function(index) {
                $scope.tabs.splice(index, 1); //remove the object from the array based on index
            }

            $scope.selectedTab = 0; //set selected tab to the 1st by default.

            /** Function to set selectedTab **/
            $scope.selectTab = function(index) {
                //  AuthService.fetchChatById(index, function(oResp) {
                //       $scope.oChat = oResp;
                //   });
                $scope.selectedTab = index;
            }

            var fnCallback = function(oResp) {
                $scope.chat = oResp;

               // $location.hash('bottom');

                // call $anchorScroll()
            //    $anchorScroll();
            }

            $scope.msg = "";

            $scope.classe = "";

            $scope.initChat = function(chat) {

            }

            $scope.mensagens = [];
            
      /*      $scope.$watch("$scope.mensagens", function(newValue, oldValue){
                	$scope.mensagens = [{message:"teste"}];
               
            });
*/
            $scope.enviarMessage = function(chat, msg) {

                var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));

                var oChatMsg = {
                    texto: msg,
                    user_id: oUser.id,
                    chatId: chat.id,
                    jogoId: chat.jogoId,
                    editMessage: 0,
                    dataMessagem: new Date()
                }

                AuthService.insertChatMessage(oChatMsg, function(oResp) {
                	
                    var sMessageHTML = "";
                    $scope.msg = "";
                    oChatMsg.usuario = oUser;
                    $scope.mensagens.push(oChatMsg)
                  //  $scope.mensagens.push({message:"teste2"});
                  //  for (x = 0; x < oResp.length; x++) {
                  //      if (oResp[x].id == chat.id) {
                   //     	$scope.mensagens = oResp[x]
                   //     }
                 //   }

                });
            }

            function teste(oChat) {
                return '<div class="row msg_container base_sent" ng-if="validarUser(chatItens) == true">' +
                    '<div class="col-md-10 col-xs-8">' +
                    '<div class="messages msg_sent">' +
                    '<time>' + oChat.usuario.email + '</time>' +
                    '<p>' + oChat.texto + '</p>' +
                    '<time datetime="2009-11-13T20:00">' + oChat.dataMessagem + '</time>' +
                    '</div>' +
                    '</div>' +
                    '<div class="col-md-2 col-xs-4 avatar">' +
                    '<img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg" class=" img-responsive ">' +
                    '</div>' +
                    '</div>' +
                    '<div class="row msg_container base_receive" ng-if="validarUser(chatItens) == false">' +
                    '<div class="col-md-2 col-xs-4 avatar">' +
                    '<img src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-5.jpg" class=" img-responsive ">' +
                    '</div>' +
                    '<div class="col-md-10 col-xs-8">' +
                    '<div class="messages msg_receive">' +
                    '<time>' + oChat.usuario.email + '</time>' +
                    '<p>' + oChat.texto + '</p>' +
                    '<time datetime="2009-11-13T20:00">' + oChat.dataMessagem + '</time>' +
                    '</div>' +
                    '</div>' +
                    '</div>'

            }

            function teste3(oChat) {
                var sReturn = ""
                for (var w = 0; w < oChat.length; w++) {
                    sReturn = sReturn + teste(oChat[w]);
                }
                return sReturn;
            }

            function teste2(oChat) {
                return '<div class="row chat-' + oChat.id + '">' +
                    '<div class="col-md-12 ">' +
                    '<div class="panel panel-primary ">' +
                    '<div class="panel-heading " id="accordion ">' +
                    '<span class="glyphicon glyphicon-comment "></span> Chat ' + oChat.id + ' ' + oChat.jogo.dia + ' - ' + oChat.jogo.horaInicial + ' as ' + oChat.jogo.horaFinal + ' * ' + oChat.jogo.id + '' +
                    '<div class="btn-group pull-right ">' +
                    '<a class="btn btn-default btn-xs " data-toggle="collapse " data-target="#collapseOne' + oChat.id + ' " data-parent="#menu " href="javascript:void(0) ">' +
                    '<span class="glyphicon glyphicon-chevron-down "></span>' +
                    '</a>' +
                    '</div>' +
                    '</div>' +
                    '<div class="panel-collapse collapse in show" id="collapseOne' + oChat.id + ' ">' +
                    '<div class="panel-body ">' +
                    '<div class="panel-body msg_container_base ">' +
                    ' ' + teste3(oChat.chatItens) +
                    '</div>' +
                    '<div class="panel-footer ">' +
                    '<div class="input-group ">' +
                    '<input id="btn-input " type="text " ng-model="msg " class="form-control input-sm " placeholder="Escreva a menssagem aqui " /> <span class="input-group-btn ">' +
                    '<button class="btn btn-warning btn-sm enviarMessage"  id="' + oChat.id + '-' + oChat.jogoId + '"' +
                    '>Enviar</button>' +
                    '</span>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>'
            }
            $scope.funcao2 = function(chat) {
            	$scope.mensagens = chat
            }
            $scope.updateChatMessage = function(chat, msg) {
                var oChatMsg = [];
                var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));

                AuthService.insertChatMessage(oChatMsg, function(oResp) {
                    console.log(oResp);

                });
            }

            $scope.deleteChatMessage = function(chat, msg) {
                var oChatMsg = [];
                var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));

                AuthService.insertChatMessage(oChatMsg, function(oResp) {
                    console.log(oResp);

                });
            }


            $scope.validarUser = function(chatItens) {

                var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
                if (chatItens.user_id === oUser.id) {
                    return true;
                } else
                    return false;
            };

            var oUser = JSON.parse(localStorage.getItem('wdAppLS.currentUser'));
            AuthService.fetchChatByUserId(oUser, fnCallback);



        }
    ]);
}).call(this);