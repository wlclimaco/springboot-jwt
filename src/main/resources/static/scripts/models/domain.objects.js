	/**
	 * Initialize the main namespaces and constants.
	 */
	var qat = {
	    model: {},
	    base: {
	        model: {}
	    }
	};


	//County Object
	qat.model.county = function(_countyId, _countyDesc) {
	    this.id = _countyId;
	    this.description = _countyDesc;
	};

	//Procedure Object
	qat.model.procedure = function(_procId, _procCode, _procDesc, _procPrice, _version) {
	    this.id = _procId;
	    this.code = _procCode;
	    this.description = _procDesc;
	    this.price = _procPrice;
	    this.version = _version;
	};

	qat.model.jogo = function(oJogo) {
	    this.id = oJogo.id;
	    this.nome = oJogo.nome;
	    this.descricao = oJogo.descricao;
	    // this.usersJogo = oJogo.usersJogo ;
	    this.aceitaExterno = oJogo.aceitaExterno;
	    this.confirmacao = oJogo.confirmacao;
	    this.quadraId = oJogo.quadraId;
	    this.horaInicial = oJogo.horaInicial;
	    this.horaFinal = oJogo.horaFinal;
	    this.dia = oJogo.dia;
	    this.status = oJogo.status;
	    this.user_id = oJogo.user_id;
	    this.maximoConfirmados = oJogo.maximoConfirmados;

	};

	qat.model.UserJogo2 = function(oJogo) {
	    oJogo.id ? this.id = oJogo.id : null;
	    oJogo.user_id ? this.user_id = oJogo.user_id : null;
	    oJogo.jogo_id ? this.jogo_id = oJogo.jogo_id : null;
	    oJogo.status_user ? this.status_user = oJogo.status_user ? oJogo.status_user : "SOLICITADO" : null;
	    oJogo.admin ? this.admin = oJogo.admin ? oJogo.admin : "NAO" : null;
	    oJogo.aprovadoPor ? this.aprovadoPor = oJogo.aprovadoPor : null;
	    oJogo.aprovadoDate ? this.aprovadoDate = oJogo.aprovadoDate : null;


	};

	qat.model.jogoPorData = function(oJogo) {
	    this.id = oJogo.id;
	    this.data = oJogo.data ? oJogo.data : null;
	    this.jogoId = oJogo.jogoId ? oJogo.jogoId : null;
	    this.nota = oJogo.nota ? oJogo.nota : null;
	    this.qntGols = oJogo.qntGols ? oJogo.qntGols : null;
	    this.user_id = oJogo.user_id;

	};

	qat.model.NotasGols = function(oJogo) {
	    this.id = oJogo.id;
	    this.useJogoDataId = oJogo.useJogoDataId;
	    this.userId = oJogo.userId;
	    this.jogoId = oJogo.jogoId;
	    this.jogoPorDataId = oJogo.jogoPorDataId;
	    this.nota = oJogo.nota ? oJogo.nota : 0;
	    this.qntGols = oJogo.qntGols ? oJogo.qntGols : 0;
	    this.status = oJogo.status;
	    this.userNota = oJogo.userNota ? oJogo.userNota : 0;
	    this.date = oJogo.date ? oJogo.date : new Date();
	};

	qat.model.UserJogoData = function(oJogo) {
	    this.id = oJogo.id;
	    this.user_id = oJogo.user_id;
	    this.jogo_id = oJogo.jogo_id;
	    this.usuario = oJogo.usuario;
	    this.jogoPorData_id = oJogo.jogoPorData_id;
	    this.nota = oJogo.nota ? oJogo.nota : 0;
	    this.qntGols = oJogo.qntGols ? oJogo.qntGols : 0;
	    this.status = oJogo.status;
	    this.aprovadoPor = oJogo.aprovadoPor ? oJogo.aprovadoPor : 0;
	    this.aprovadoDate = oJogo.aprovadoDate ? oJogo.aprovadoDate : new Date();
	};

	qat.model.jogoPorData2 = function(oJogo) {

	    this.id = oJogo.id;
	    this.data = oJogo.data ? oJogo.data : null;
	    this.dataFinal = oJogo.dataFinal ? oJogo.dataFinal : null;
	    this.jogoId = oJogo.jogoId ? oJogo.jogoId : null;
	    this.status = oJogo.status ? oJogo.status : null;
	    this.userJogoData = oJogo.userJogoData ? oJogo.userJogoData : [];


	};
	
	qat.model.Chat = function(oJogo) {
	    this.id = oJogo.id;
	    this.jogoId = oJogo.jogoId;
	    this.chatItens = oJogo.chatItens;
	    this.currentLoginIp = oJogo.currentLoginIp;
	    
	    this.updatedAt = oJogo.updatedAt ? oJogo.updatedAt : new Date() ;
	};
	
	qat.model.ChatItens = function(oJogo) {
	    this.id           = oJogo.id;
	    this.texto        = oJogo.texto;
	    this.user_id      = oJogo.user_id;
	    this.chatId       = oJogo.chatId;
	    this.jogoId       = oJogo.jogoId;
	    this.lastLoginIp  = oJogo.lastLoginIp;
	    this.editMessage  = oJogo.editMessage ? oJogo.editMessage : 0;
	    this.dataMessagem = oJogo.dataMessagem ? oJogo.dataMessagem : new Date();

	};
	
	

	qat.model.user = function(oUser) {

	    this.id = oUser.id ? parseInt(oUser.id) : null;
	    this.email = oUser.email ? oUser.email : "";
	    this.password = oUser.password ? oUser.password : oUser.password;
	    this.name = oUser.name ? oUser.name : null;
	    this.active = oUser.active ? oUser.active : 0;
	   // this.roles = oUser.roles ? oUser.roles : null;
	    this.iv = oUser.iv ? oUser.iv : null;
	    this.salt = oUser.salt ? oUser.salt : null;
	    this.keySize = oUser.keySize ? oUser.keySize : 0;
	    this.iterations = oUser.iterations ? oUser.iterations : 0;
	    this.loginCount = oUser.loginCount ? oUser.loginCount : 0;
	    this.currentLoginAt = oUser.currentLoginAt ? oUser.currentLoginAt : new Date();
	    this.lastLoginAt = oUser.lastLoginAt ? oUser.lastLoginAt : new Date();
	    this.currentLoginIp = oUser.currentLoginIp ? oUser.currentLoginIp : null;
	    this.lastLoginIp = oUser.lastLoginIp ? oUser.lastLoginIp : null;
	    this.updatedAt = oUser.updatedAt ? oUser.updatedAt : new Date();
	    this.enabled = oUser.enabled ? oUser.enabled : 0;
	    this.encryptedPassword = oUser.encryptedPassword ? oUser.encryptedPassword : 0;
	    this.isEnviarNotifPorEmail = oUser.isEnviarNotifPorEmail ? oUser.isEnviarNotifPorEmail : 0;
	    this.endereco = {cep : oUser.cep,logradouro : oUser.logradouro ,numero : oUser.numero ,bairro : oUser.bairro,cidade : oUser.cidade};
	    this.telefone1 = oUser.telefone1 ? oUser.telefone1 : "";
	    this.telefone = oUser.telefone ? oUser.telefone : "";
	    this.receberNotificacoes = oUser.receberNotificacoes ? oUser.receberNotificacoes : 0;
	    this.isGoleiro = oUser.isGoleiro ? oUser.isGoleiro : 1;
	};

	qat.model.horario = function(oHorario) {
	    // this.id = oHorario.id;
	    this.dom = oHorario.dom ? parseInt(oHorario.dom) : 0;
	    this.seg = oHorario.seg ? parseInt(oHorario.seg) : 0;
	    this.ter = oHorario.ter ? parseInt(oHorario.ter) : 0;
	    this.qua = oHorario.qua ? parseInt(oHorario.qua) : 0;
	    this.qui = oHorario.qui ? parseInt(oHorario.qui) : 0;
	    this.sex = oHorario.sex ? parseInt(oHorario.sex) : 0;
	    this.sab = oHorario.sab ? parseInt(oHorario.sab) : 0;
	    this.horaInicial = oHorario.horaInicial.getHours() + ":" + oHorario.horaInicial.getMinutes();
	    this.horaFinal = oHorario.horaFinal.getHours() + ":" + oHorario.horaFinal.getMinutes();
	};

	qat.model.quadra = function(oQuadra) {
	    var oHorarios = [];
	    for (var x = 0; x < oQuadra.horarioAberto.length; x++) {
	        oHorarios.push(new qat.model.horario(oQuadra.horarioAberto[x]));
	    }
	    this.id = oQuadra.id;
	    this.nome = oQuadra.nome;
	    this.descricao = oQuadra.descricao;
	    this.tempoJogo = 60; //oQuadra.tempoJogo ;
	    this.intervalo = 0; //oQuadra.intervalo;
	    this.horarioAberto = oHorarios ? oHorarios : null;
	    this.valor = oQuadra.valor ? parseFloat(oQuadra.valor) : 0;
	    this.comBola = oQuadra.comBola ? parseInt(oQuadra.comBola) : 0;
	    this.valorBola = oQuadra.sex ? parseFloat(oQuadra.valorBola) : 0;
	};

	qat.model.notificacao = function(oNotificacao) {


	    this.id = oNotificacao.id ? parseInt(oNotificacao.id) : null;
	    this.descricao = oNotificacao.descricao ? oNotificacao.descricao : null;
	    this.updatedAt = new Date();
	    this.titulo = oNotificacao.titulo ? oNotificacao.titulo : null;
	    this.status = oNotificacao.status ? oNotificacao.status : null;
	    this.deUserId = oNotificacao.deUserId ? parseInt(oNotificacao.deUserId) : null;
	    this.deEmprId = oNotificacao.deEmprId ? parseInt(oNotificacao.deEmprId) : null;
	    this.paraUserId = oNotificacao.paraUserId ? parseInt(oNotificacao.paraUserId) : null;
	    this.paraEmprId = oNotificacao.paraEmprId ? parseInt(oNotificacao.paraEmprId) : null;
	    this.deJogoId = oNotificacao.deJogoId ? parseInt(oNotificacao.deJogoId) : null;
	    this.paraJogoId = oNotificacao.paraJogoId ? parseInt(oNotificacao.paraJogoId) : null;


	};