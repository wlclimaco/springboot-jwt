INSERT INTO pagina(id ,pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES (101,'Financeiro', 0, 100, 1477075035443, 'System');


INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (102,'TIPO DOCUMENTO', 'TIPO DOCUMENTO', 1477075035443, 'System'),
	(103,'CATEGORIA', 'CATEGORIA' , 1477075035443, 'System'),
(104,'CADASTROMAIS', 'CADASTRO MAIS VEZES' , 1477075035443, 'System'),
(105,'INTERVALO', 'INTERVALO' , 1477075035443, 'System'),
(106,'SITUACAO', 'SITUACAO' , 1477075035443, 'System');


INSERT INTO pagina(id ,pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES (102,'Conta', 0, 100, 1477075035443, 'System');


INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (110,'TIPO CONTA', 'TIPO CONTA', 1477075035443, 'System');



INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES

('1', 'Caixa','Caixa',110,102, 1477075035443, 'System'),
('2', 'Banco Itaú','Banco Itaú',110,102, 1477075035443, 'System');


INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES

('1', 'Apenas uma vez','Apenas uma vez',104,101, 1477075035443, 'System'),
('2', '2 vezes ao todo','2 vezes ao todo',104,101, 1477075035443, 'System'),
('3', '3 vezes ao todo','3 vezes ao todo',104,101, 1477075035443, 'System'),
('4', '4 vezes ao todo','4 vezes ao todo',104,101, 1477075035443, 'System'),
('5', '5 vezes ao todo','5 vezes ao todo',104,101, 1477075035443, 'System'),
('6', '6 vezes ao todo','6 vezes ao todo',104,101, 1477075035443, 'System'),
('7', '7 vezes ao todo','7 vezes ao todo',104,101, 1477075035443, 'System'),
('8', '8 vezes ao todo','8 vezes ao todo',104,101, 1477075035443, 'System'),
('9', '9 vezes ao todo','9 vezes ao todo',104,101, 1477075035443, 'System'),
('10', '10 vezes ao todo','10 vezes ao todo',104,101, 1477075035443, 'System'),
('11', '11 vezes ao todo','11 vezes ao todo',104,101, 1477075035443, 'System'),
('12', '12 vezes ao todo','12 vezes ao todo',104,101, 1477075035443, 'System'),
('13', '13 vezes ao todo','13 vezes ao todo',104,101, 1477075035443, 'System'),
('14', '14 vezes ao todo','14 vezes ao todo',104,101, 1477075035443, 'System'),
('15', '15 vezes ao todo','15 vezes ao todo',104,101, 1477075035443, 'System'),
('16', '16 vezes ao todo','16 vezes ao todo',104,101, 1477075035443, 'System'),
('17', '17 vezes ao todo','17 vezes ao todo',104,101, 1477075035443, 'System'),
('18', '18 vezes ao todo','18 vezes ao todo',104,101, 1477075035443, 'System'),
('19', '19 vezes ao todo','19 vezes ao todo',104,101, 1477075035443, 'System'),
('20', '20 vezes ao todo','20 vezes ao todo',104,101, 1477075035443, 'System'),
('21', '21 vezes ao todo','21 vezes ao todo',104,101, 1477075035443, 'System'),
('22', '22 vezes ao todo','22 vezes ao todo',104,101, 1477075035443, 'System'),
('23', '23 vezes ao todo','23 vezes ao todo',104,101, 1477075035443, 'System'),
('24', '24 vezes ao todo','24 vezes ao todo',104,101, 1477075035443, 'System'),


('1', 'Dias','Dias',105,101, 1477075035443, 'System'),
('7', 'Semanas','Semanas',105,101, 1477075035443, 'System'),
('15', 'Quinzenas','Quinzenas',105,101, 1477075035443, 'System'),
('30', 'Meses','Meses',105,101, 1477075035443, 'System'),
('60', 'Bimestres','Bimestres',105,101, 1477075035443, 'System'),
('90', 'Trimestres','Trimestres',105,101, 1477075035443, 'System'),
('180', 'Semestres','Semestres',105,101, 1477075035443, 'System'),
('365', 'Anos','Anos',105,101, 1477075035443, 'System'),
('0', 'Sem intervalo','Sem intervalo',105,101, 1477075035443, 'System'),


('1', 'Pago','Pago',106,101, 1477075035443, 'System'),
('2', 'Aberta','Aberta',106,101, 1477075035443, 'System'),
('3', 'Vencida','Vencida',106,101, 1477075035443, 'System'),
('4', 'Cancelada','Cancelada',106,101, 1477075035443, 'System');



INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES

	('1', 'Dinheiro','Dinheiro',102,101, 1477075035443, 'System'),
        ('2', 'Cheque','Cheque',102,101, 1477075035443, 'System'),
        ('3', 'Boleto','Boleto',102,101, 1477075035443, 'System'),
        ('4', 'Cartão Crédito','Cartão Crédito',102,101, 1477075035443, 'System'),
        ('5', 'Cartão Débito','Cartão Débito',102,101, 1477075035443, 'System'),
        ('6', 'Duplicata','Duplicata',102,101, 1477075035443, 'System'),
        ('7', 'Carnê','Carnê',102,101, 1477075035443, 'System'),
        ('8', 'Transf. Eletrônica','Transf. Eletrônica',102,101, 1477075035443, 'System'),
        ('9', 'Crédito Loja','Crédito Loja',102,101, 1477075035443, 'System'),
        ('10', 'Vale Alimentação','Vale Alimentação',102,101, 1477075035443, 'System'),
        ('11', 'Vale Refeição','Vale Refeição',102,101, 1477075035443, 'System'),
        ('12', 'Vale Presente','Vale Presente',102,101, 1477075035443, 'System'),
        ('13', 'Vale Combustível','Vale Combustível',102,101, 1477075035443, 'System'),
        ('14', 'Sem documento','Sem documento',102,101, 1477075035443, 'System'),

('14', 'Despesas operacionais Água','Despesas operacionais Água',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais Aluguel','Despesas operacionais Aluguel',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais Condomínio','Despesas operacionais Condomínio',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais FGTS','Despesas operacionais FGTS',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais INSS','Despesas operacionais INSS',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais Luz','Despesas operacionais Luz',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais Material de consumo','Despesas operacionais Material de consumo',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais Material de escritório','Despesas operacionais Material de escritório',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais Salário','Despesas operacionais Salário',103,101, 1477075035443, 'System'),
('14', 'Despesas operacionais Outras despesas','Despesas operacionais Outras despesas',103,101, 1477075035443, 'System'),
('14', 'Despesas de vendas Comissões','Despesas de vendas Comissões',103,101, 1477075035443, 'System'),
('14', 'Despesas de vendas Embalagens','Despesas de vendas Embalagens',103,101, 1477075035443, 'System'),
('14', 'Despesas de vendas Fretes','Despesas de vendas Fretes',103,101, 1477075035443, 'System'),
('14', 'Despesas de vendas Outras despesas','Despesas de vendas Outras despesas',103,101, 1477075035443, 'System'),
('14', 'Impostos IPI','Impostos IPI',103,101, 1477075035443, 'System'),
('14', 'Impostos ICMS','Impostos ICMS',103,101, 1477075035443, 'System'),
('14', 'Impostos ISSQN','Impostos ISSQN',103,101, 1477075035443, 'System'),
('14', 'Impostos SIMPLES','Impostos SIMPLES',103,101, 1477075035443, 'System'),
('14', 'Impostos Outro imposto','Impostos Outro imposto',103,101, 1477075035443, 'System'),
('14', 'Despesas diversas Tarifas bancárias','Despesas diversas Tarifas bancárias',103,101, 1477075035443, 'System'),
('14', 'Despesas diversas Juros e multas','Despesas diversas Juros e multas',103,101, 1477075035443, 'System'),
('14', 'Despesas diversas Outras despesas','Sem_documento',103,101, 1477075035443, 'System'),
('14', 'Investimentos Automóvel','Investimentos Automóvel',103,101, 1477075035443, 'System'),
('14', 'Investimentos Computador','Investimentos Computador',103,101, 1477075035443, 'System'),
('14', 'Investimentos Móveis','Investimentos Móveis',103,101, 1477075035443, 'System'),
('14', 'Investimentos Outros investimentos','Investimentos Outros investimentos',103,101, 1477075035443, 'System'),
('14', 'Compras (estoque) Compras (estoque)','Compras (estoque) Compras (estoque)',103,101, 1477075035443, 'System'),


('14', 'Compras (estoque) Compras (estoque)','Compras (estoque) Compras (estoque)',104,101, 1477075035443, 'System'),

('14', 'Compras (estoque) Compras (estoque)','Compras (estoque) Compras (estoque)',105,101, 1477075035443, 'System');



INSERT INTO pagina(pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES ('Produto', 0, 100, 1477075035443, 'System');


INSERT INTO pagina(id,pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES (6,'tributação', 0, 100, 1477075035443, 'System');


    INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (21,'ICMS - SITUAÇÃO TRIBUTARIA SIMPLES NACIONAL', 'ICMS - SITUAÇÃO TRIBUTARIA SIMPLES NACIONAL', 1477075035443, 'System'),
	(22,'ICMS - SITUAÇÃO TRIBUTARIA TRIBUTACAO NORMAL', 'ICMS - SITUAÇÃO TRIBUTARIA TRIBUTACAO NORMAL' , 1477075035443, 'System'),
	(23,'ICMS - REGINE', 'ICMS - REGIME' , 1477075035443, 'System'),
	(10,'ICMS - MODALIDADE BC', 'MODALIDADE BC', 1477075035443, 'System'),
	(11,'ICMS - MODALIDADE BC ST', 'MODALIDADE BC', 1477075035443, 'System'),
	(12,'ICMS - MOTIVO DESONERAÇÃO', 'ICMS - MOTIVO DESONERAÇÃO', 1477075035443, 'System'),
	(13,'IPI - SITUAÇÃO TRIBUTARIA', 'IPI - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	(14,'TIPO CALCULO', 'TIPO CALCULO', 1477075035443, 'System'),
	(15,'PIS - SITUAÇÃO TRIBUTARIA', 'PIS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	(16,'COFINS - SITUAÇÃO TRIBUTARIA', 'COFINS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System');


	INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES


    	/* MODALIDADE BC */
    	('0', 'Margem valor agregado','Margem valor agregado',10,6, 1477075035443, 'System'),
    	('1', 'Pauta (valor)','Pauta (valor)',10,6, 1477075035443, 'System'),
    	('2', 'Preço tabelado máx. (valor)','Preço tabelado máx. (valor)',10,6, 1477075035443, 'System'),
    	('3', 'Valor da operação','Valor da operação',10,6, 1477075035443, 'System'),

    	/* ICMS - REGINE */
       ('00', '00: Tributada Normal','00: Tributada Normal',23,6, 1477075035443, 'System'),
	   ('10', '10: Simples Nacional','10: Simples Nacional',23,6, 1477075035443, 'System'),

	   /*MODALIDADE BC ST*/
	   ('0', 'Tabelado ou máx. sugerido','Tabelado ou máx. sugerido',11,6, 1477075035443, 'System'),
	   ('1', 'Lista Negativa (valor)','Lista Negativa (valor)',11,6, 1477075035443, 'System'),
	   ('2', 'Lista Positiva (valor)','Lista Positiva (valor)',11,6, 1477075035443, 'System'),
	   ('3', 'Lista Neutra (valor)','Lista Neutra (valor)',11,6, 1477075035443, 'System'),
	   ('4', 'Margem Valor Agregado (%)','Margem Valor Agregado (%)',11,6, 1477075035443, 'System'),
	   ('5', 'Pauta (valor)','Pauta (valor)',11,6, 1477075035443, 'System'),

	   /* ICMS - SITUAÇÃO TRIBUTARIA */
	   ('00', '00: Tributada integralmente','Tributada integralmente',22,6, 1477075035443, 'System'),
	   ('10', '10: Tributada com cobr. por subst. trib.','10: Tributada com cobr. por subst. trib.',22,6, 1477075035443, 'System'),
	   ('20', '20: Com redução de base de cálculo','20: Com redução de base de cálculo',22,6, 1477075035443, 'System'),
	   ('30', '30: Isenta ou não trib com cobr por subst trib','30: Isenta ou não trib com cobr por subst trib',22,6, 1477075035443, 'System'),
	   ('40', '40: Isenta','40: Isenta',22,6, 1477075035443, 'System'),
	   ('41', '41: Não tributada','41: Não tributada',22,6, 1477075035443, 'System'),
	   ('50', '50: Suspesão','50: Suspesão',22,6, 1477075035443, 'System'),
	   ('51', '51: Diferimento','51: Diferimento',22,6, 1477075035443, 'System'),
	   ('60', '60: ICMS cobrado anteriormente por subst trib','60: ICMS cobrado anteriormente por subst trib',22,6, 1477075035443, 'System'),
	   ('70', '70: Redução de Base Calc e cobr ICMS por subst trib','70: Redução de Base Calc e cobr ICMS por subst trib',22,6, 1477075035443, 'System'),
	   ('90', '90: Outros','90: Outros',22,6, 1477075035443, 'System'),
	   ('10Part', 'Partilha 10: Entre UF origem e destino ou definida na legislação com Subst Trib','Entre UF origem e destino ou definida na legislação com Subst Trib',22,6, 1477075035443, 'System'),
	   ('90Part', 'Partilha 90: Entre UF origem e destino ou definida na legislação - outros','Entre UF origem e destino ou definida na legislação - outros',22,6, 1477075035443, 'System'),
	   ('41ST', 'ICMS ST retido em operações interestaduais com repasses do Subst Trib','ICMS ST retido em operações interestaduais com repasses do Subst Trib',22,6, 1477075035443, 'System'),
	   ('101', '101: Com permissão de crédito','101: Com permissão de crédito',21,6, 1477075035443, 'System'),
	   ('102', '102: Sem permissão de crédito','102: Sem permissão de crédito',21,6, 1477075035443, 'System'),
	   ('103', '103: Isenção do ICMS para faixa de receita bruta','103: Isenção do ICMS para faixa de receita bruta',2,6, 1477075035443, 'System'),
	   ('201', '201: Com permissão de crédito, com cobr ICMS por Subst Trib','201: Com permissão de crédito, com cobr ICMS por Subst Trib',21,6, 1477075035443, 'System'),
	   ('202', '202: Sem permissão de crédito, com cobr ICMS por Subst Trib','202: Sem permissão de crédito, com cobr ICMS por Subst Trib',21,6, 1477075035443, 'System'),
	   ('203', '203: Isenção ICMS p/ faixa de receita bruta e cobr do ICMS por ST','203: Isenção ICMS p/ faixa de receita bruta e cobr do ICMS por ST',21,6, 1477075035443, 'System'),
	   ('300', '300: Imune','300: Imune',21,6, 1477075035443, 'System'),
	   ('400', '400: Não tributada','400: Não tributada',21,6, 1477075035443, 'System'),
	   ('500', '500: ICMS cobrado antes por subst trib ou antecipação','500: ICMS cobrado antes por subst trib ou antecipação',21,6, 1477075035443, 'System'),
	   ('900', '900: Outros','900: Outros',21,6, 1477075035443, 'System'),

	   /* MODALIDADE BC */
	   ('0','Nacional, exceto as indicadas nos códigos de 3 a 5','0 - Nacional, exceto as indicadas nos códigos de 3 a 5',4,6, 1477075035443, 'System'),
	   ('1','Estrangeira - Importação direta, exceto a indicada no código 6','1 - Estrangeira - Importação direta, exceto a indicada no código 6',4,6, 1477075035443, 'System'),
	   ('2','Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7','2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7',4,6, 1477075035443, 'System'),
	   ('3','Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40%','3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40%',4,6, 1477075035443, 'System'),
	   ('4','Nacional, produção em conformidade com processos básicos que tratam as legisl. dos Ajustes','4 - Nacional, produção em conformidade com processos básicos que tratam as legisl. dos Ajustes',4,6, 1477075035443, 'System'),
	   ('5','Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%','5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%',4,6, 1477075035443, 'System'),
	   ('6','Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX','6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX',4,6, 1477075035443, 'System'),
	   ('7','Estrangeira - Adquirida mercado interno, sem similar nacional, constante em lista da CAMEX','7 - Estrangeira - Adquirida mercado interno, sem similar nacional, constante em lista da CAMEX',4,6, 1477075035443, 'System'),

	   /*MOTIVO DESONERAÇÃO*/
	   ('0','Não desejo usar','Não desejo usar',12,6, 1477075035443, 'System'),
	   ('3','Produtor agropecuário','3: Produtor agropecuário',12,6, 1477075035443, 'System'),
	   ('9','Outros','9: Outros',12,6, 1477075035443, 'System'),
	   ('12','Órgão de fomento e desenvolv. agropecuário','12: Órgão de fomento e desenvolv. agropecuário',12,6, 1477075035443, 'System'),

	   /*IPI - SITUAÇÃO TRIBUTARIA*/
	   ('-1','Não usar','- Não usar -',13,6, 1477075035443, 'System'),
	   ('00','00: Entrada com recuperação de crédito','00: Entrada com recuperação de crédito',13,6, 1477075035443, 'System'),
	   ('01','01: Entrada tributada com alíquota zero','01: Entrada tributada com alíquota zero',13,6, 1477075035443, 'System'),
	   ('02','02: Entrada isenta','02: Entrada isenta',13,6, 1477075035443, 'System'),
	   ('03','03: Entrada não-tributada','03: Entrada não-tributada',13,6, 1477075035443, 'System'),
	   ('04','04: Entrada imune','04: Entrada imune',13,6, 1477075035443, 'System'),
	   ('05','05: Entrada com suspensão','05: Entrada com suspensão',13,6, 1477075035443, 'System'),
	   ('49','49: Outras entradas','49: Outras entradas',13,6, 1477075035443, 'System'),
	   ('50','50: Saída tributada','50: Saída tributada',13,6, 1477075035443, 'System'),
	   ('51','51: Saída tributada com alíquota zero','51: Saída tributada com alíquota zero',13,6, 1477075035443, 'System'),
	   ('52','52: Saída isenta','52: Saída isenta',13,6, 1477075035443, 'System'),
	   ('53','53: Saída não-tributada','53: Saída não-tributada',13,6, 1477075035443, 'System'),
	   ('54','54: Saída imune','54: Saída imune',13,6, 1477075035443, 'System'),
	   ('55','55: Saída com suspensão','55: Saída com suspensão',13,6, 1477075035443, 'System'),
	   ('99','99: Outras saídas','99: Outras saídas',13,6, 1477075035443, 'System'),

	   /* Porcentagem BC */
	   ('1','Porcentagem','Porcentagem',14,6, 1477075035443, 'System'),
	   ('2','Em valor','Em valor',14,6, 1477075035443, 'System'),

	   /* PIS SITUAÇÃO TRIBUTARIA */
	   ('01','01: Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)','01: Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)',15,6, 1477075035443, 'System'),
	   ('02','02: Operação tributável (BC = valor da operação (alíquota diferenciada)','02: Operação tributável (BC = valor da operação (alíquota diferenciada)',15,6, 1477075035443, 'System'),
	   ('03','03: Operação tributável (BC = quant. x alíq. por unidade de produto)','03: Operação tributável (BC = quant. x alíq. por unidade de produto)',15,6, 1477075035443, 'System'),
	   ('04','04: Operação tributável (tributação monofásica, alíquota zero)','04: Operação tributável (tributação monofásica, alíquota zero)',15,6, 1477075035443, 'System'),
	   ('06','06: Operação tributável (alíquota zero)','06: Operação tributável (alíquota zero)',15,6, 1477075035443, 'System'),
	   ('07','07: Operação isenta da contribuição','07: Operação isenta da contribuição',15,6, 1477075035443, 'System'),
	   ('08','08: Operação sem incidência da contribuição','08: Operação sem incidência da contribuição',15,6, 1477075035443, 'System'),
	   ('09','09: Operação com suspensão da contribuição','09: Operação com suspensão da contribuição',15,6, 1477075035443, 'System'),
	   ('49','49: Outras Operações de Saída','49: Outras Operações de Saída',15,6, 1477075035443, 'System'),
	   ('50','50: Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno','50: Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno',15,6, 1477075035443, 'System'),
	   ('51','51: Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno','51: Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno',15,6, 1477075035443, 'System'),
	   ('52','52: Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação','52: Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação',15,6, 1477075035443, 'System'),
	   ('53','53: Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno','53: Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno',15,6, 1477075035443, 'System'),
	   ('54','54: Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação','54: Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação',15,6, 1477075035443, 'System'),
	   ('55','55: Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação','55: Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação',15,6, 1477075035443, 'System'),
	   ('56','56: Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','56: Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',15,6, 1477075035443, 'System'),
	   ('60','60: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno','60: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno',15,6, 1477075035443, 'System'),
	   ('61','61: Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno','61: Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno',15,6, 1477075035443, 'System'),
	   ('62','62: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação','62: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação',15,6, 1477075035443, 'System'),
	   ('63','63: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno','63: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno',15,6, 1477075035443, 'System'),
	   ('64','64: Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação','64: Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação',15,6, 1477075035443, 'System'),
	   ('65','65: Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação','65: Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação',15,6, 1477075035443, 'System'),
	   ('66','66: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','66: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',15,6, 1477075035443, 'System'),
	   ('67','67: Crédito Presumido - Outras Operações','67: Crédito Presumido - Outras Operações',15,6, 1477075035443, 'System'),
	   ('70','70: Operação de Aquisição sem Direito a Crédito','70: Operação de Aquisição sem Direito a Crédito',15,6, 1477075035443, 'System'),
	   ('71','71: Operação de Aquisição com Isenção','71: Operação de Aquisição com Isenção',15,6, 1477075035443, 'System'),
	   ('72','72: Operação de Aquisição com Suspensão','72: Operação de Aquisição com Suspensão',15,6, 1477075035443, 'System'),
	   ('73','73: Operação de Aquisição a Alíquota Zero','73: Operação de Aquisição a Alíquota Zero',15,6, 1477075035443, 'System'),
	   ('74','74: Operação de Aquisição sem Incidência da Contribuição','74: Operação de Aquisição sem Incidência da Contribuição',15,6, 1477075035443, 'System'),
	   ('75','75: Operação de Aquisição por Substituição Tributária','75: Operação de Aquisição por Substituição Tributária',15,6, 1477075035443, 'System'),
	   ('98','98: Outras Operações de Entrada','98: Outras Operações de Entrada',15,6, 1477075035443, 'System'),
	   ('99','99: Outras operações','99: Outras operações',15,6, 1477075035443, 'System'),

		/* COFINS SITUAÇÃO TRIBUTARIA */
	   ('01','Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)','01: Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)',16,6, 1477075035443, 'System'),
	   ('02','02: Operação tributável (BC = valor da operação (alíquota diferenciada)','02: Operação tributável (BC = valor da operação (alíquota diferenciada)',16,6, 1477075035443, 'System'),
	   ('03','Operação tributável (BC = quant. x alíq. por unidade de produto)','03: Operação tributável (BC = quant. x alíq. por unidade de produto)',16,6, 1477075035443, 'System'),
	   ('04','Operação tributável (tributação monofásica, alíquota zero)','04: Operação tributável (tributação monofásica, alíquota zero)',16,6, 1477075035443, 'System'),
	   ('06','Operação tributável (alíquota zero)','06: Operação tributável (alíquota zero)',16,6, 1477075035443, 'System'),
	   ('07','Operação isenta da contribuição','07: Operação isenta da contribuição',16,6, 1477075035443, 'System'),
	   ('08','Operação sem incidência da contribuição','08: Operação sem incidência da contribuição',16,6, 1477075035443, 'System'),
	   ('09','Operação com suspensão da contribuição','09: Operação com suspensão da contribuição',16,6, 1477075035443, 'System'),
	   ('49','Outras Operações de Saída','49: Outras Operações de Saída',16,6, 1477075035443, 'System'),
	   ('50','Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno','50: Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno',16,6, 1477075035443, 'System'),
	   ('51','Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno','51: Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno',16,6, 1477075035443, 'System'),
	   ('52','Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação','52: Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação',16,6, 1477075035443, 'System'),
	   ('53','Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno','53: Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno',16,6, 1477075035443, 'System'),
	   ('54','Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação','54: Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação',16,6, 1477075035443, 'System'),
	   ('55','Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação','55: Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação',16,6, 1477075035443, 'System'),
	   ('56','Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','56: Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',16,6, 1477075035443, 'System'),
	   ('60','Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno','60: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno',16,6, 1477075035443, 'System'),
	   ('61','Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno','61: Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno',16,6, 1477075035443, 'System'),
	   ('62','Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação','62: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação',16,6, 1477075035443, 'System'),
	   ('63','Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno','63: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno',16,6, 1477075035443, 'System'),
	   ('64','Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação','64: Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação',16,6, 1477075035443, 'System'),
	   ('65','Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação','65: Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação',16,6, 1477075035443, 'System'),
	   ('66','Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','66: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',16,6, 1477075035443, 'System'),
	   ('67','Crédito Presumido - Outras Operações','67: Crédito Presumido - Outras Operações',16,6, 1477075035443, 'System'),
	   ('70','Operação de Aquisição sem Direito a Crédito','70: Operação de Aquisição sem Direito a Crédito',16,6, 1477075035443, 'System'),
	   ('71','Operação de Aquisição com Isenção','71: Operação de Aquisição com Isenção',16,6, 1477075035443, 'System'),
	   ('72','Operação de Aquisição com Suspensão','72: Operação de Aquisição com Suspensão',16,6, 1477075035443, 'System'),
	   ('73','Operação de Aquisição a Alíquota Zero','73: Operação de Aquisição a Alíquota Zero',16,6, 1477075035443, 'System'),
	   ('74','Operação de Aquisição sem Incidência da Contribuição','74: Operação de Aquisição sem Incidência da Contribuição',16,6, 1477075035443, 'System'),
	   ('75','Operação de Aquisição por Substituição Tributária','75: Operação de Aquisição por Substituição Tributária',16,6, 1477075035443, 'System'),
	   ('98','Outras Operações de Entrada','98: Outras Operações de Entrada',16,6, 1477075035443, 'System'),
	   ('99','Outras operações','99: Outras operações',16,6, 1477075035443, 'System');




INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES ('00', 'Tributada integralmente','Tributada integralmente',22,2, 1477075035443, 'System'),
	   ('10', '10:Tributada com cobr. por subst. trib.','10: Tributada com cobr. por subst. trib.',22,2, 1477075035443, 'System'),
	   ('20', '20:Com redução de base de cálculo','20: Com redução de base de cálculo',22,2, 1477075035443, 'System'),
	   ('30', '30: Isenta ou não trib com cobr por subst trib','30: Isenta ou não trib com cobr por subst trib',22,2, 1477075035443, 'System'),
	   ('40', '40: Isenta','40: Isenta',22,2, 1477075035443, 'System'),
	   ('41', '41: Não tributada','41: Não tributada',22,2, 1477075035443, 'System'),
	   ('50', '50: Suspesão','50: Suspesão',22,2, 1477075035443, 'System'),
	   ('51', '51: Diferimento','51: Diferimento',22,2, 1477075035443, 'System'),
	   ('60', '60: ICMS cobrado anteriormente por subst trib','60: ICMS cobrado anteriormente por subst trib',22,2, 1477075035443, 'System'),
	   ('70', '70: Redução de Base Calc e cobr ICMS por subst trib','70: Redução de Base Calc e cobr ICMS por subst trib',22,2, 1477075035443, 'System'),
	   ('90', '90: Outros','90: Outros',22,2, 1477075035443, 'System'),
	   ('10Part', 'Entre UF origem e destino ou definida na legislação com Subst Trib','Entre UF origem e destino ou definida na legislação com Subst Trib',22,2, 1477075035443, 'System'),
	   ('90Part', 'Entre UF origem e destino ou definida na legislação - outros','Entre UF origem e destino ou definida na legislação - outros',22,2, 1477075035443, 'System'),
	   ('41ST', 'ICMS ST retido em operações interestaduais com repasses do Subst Trib','ICMS ST retido em operações interestaduais com repasses do Subst Trib',22,2, 1477075035443, 'System'),
	   ('101', 'Simples Nacional: 101: Com permissão de crédito','Simples Nacional: 101: Com permissão de crédito',21,2, 1477075035443, 'System'),
	   ('102', 'Simples Nacional: 102: Sem permissão de crédito','Simples Nacional: 102: Sem permissão de crédito',21,2, 1477075035443, 'System'),
	   ('103', 'Simples Nacional: 103: Isenção do ICMS para faixa de receita bruta','Simples Nacional: 103: Isenção do ICMS para faixa de receita bruta',2,2, 1477075035443, 'System'),
	   ('201', 'Simples Nacional: 201: Com permissão de crédito, com cobr ICMS por Subst Trib','',21,2, 1477075035443, 'System'),
	   ('202', 'Simples Nacional: 202: Sem permissão de crédito, com cobr ICMS por Subst Trib','',21,2, 1477075035443, 'System'),
	   ('203', 'Simples Nacional: 203: Isenção ICMS p/ faixa de receita bruta e cobr do ICMS por ST','',21,2, 1477075035443, 'System'),
	   ('300', 'Simples Nacional: 300: Imune','',21,2, 1477075035443, 'System'),
	   ('400', 'Simples Nacional: 400: Não tributada','',21,2, 1477075035443, 'System'),
	   ('500', 'Simples Nacional: 500: ICMS cobrado antes por subst trib ou antecipação','',21,2, 1477075035443, 'System'),
	   ('900', 'Simples Nacional: 900: Outros','',21,2, 1477075035443, 'System');

	   ('0', 'Nacional, exceto as indicadas nos códigos de 3 a 5','0 - Nacional, exceto as indicadas nos códigos de 3 a 5',3,2, 1477075035443, 'System'),
	   ('1', 'Estrangeira - Importação direta, exceto a indicada no código 6','1 - Estrangeira - Importação direta, exceto a indicada no código 6',3,2, 1477075035443, 'System'),
	   ('2', 'Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7','2 - Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7',3,2, 1477075035443, 'System'),
	   ('3', 'Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40%','3 - Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40%',3,2, 1477075035443, 'System'),
	   ('4', 'Nacional, produção em conformidade com processos básicos que tratam as legisl. dos Ajustes','4 - Nacional, produção em conformidade com processos básicos que tratam as legisl. dos Ajustes',3,2, 1477075035443, 'System'),
	   ('5', 'Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%','5 - Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%',3,2, 1477075035443, 'System'),
	   ('6', 'Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX','6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX',3,2, 1477075035443, 'System'),
	   ('7', 'Estrangeira - Adquirida mercado interno, sem similar nacional, constante em lista da CAMEX','7 - Estrangeira - Adquirida mercado interno, sem similar nacional, constante em lista da CAMEX',3,2, 1477075035443, 'System'),





INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES ('00', '00: Tributada Normal','00: Tributada Normal',23,2, 1477075035443, 'System'),
	   ('10', '10: Simples Nacional','10: Simples Nacional',23,2, 1477075035443, 'System');




	   ('01','Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)','01: Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)',8,2, 1477075035443, 'System'),
	   ('02','Operação tributável (BC = valor da operação (alíquota diferenciada)','02: Operação tributável (BC = valor da operação (alíquota diferenciada)',8,2, 1477075035443, 'System'),
	   ('03','Operação tributável (BC = quant. x alíq. por unidade de produto)','03: Operação tributável (BC = quant. x alíq. por unidade de produto)',8,2, 1477075035443, 'System'),
	   ('04','Operação tributável (tributação monofásica, alíquota zero)','04: Operação tributável (tributação monofásica, alíquota zero)',8,2, 1477075035443, 'System'),
	   ('06','Operação tributável (alíquota zero)','06: Operação tributável (alíquota zero)',8,2, 1477075035443, 'System'),
	   ('07','Operação isenta da contribuição','07: Operação isenta da contribuição',8,2, 1477075035443, 'System'),
	   ('08','Operação sem incidência da contribuição','08: Operação sem incidência da contribuição',8,2, 1477075035443, 'System'),
	   ('09','Operação com suspensão da contribuição','09: Operação com suspensão da contribuição',8,2, 1477075035443, 'System'),
	   ('49','Outras Operações de Saída','49: Outras Operações de Saída',8,2, 1477075035443, 'System'),
	   ('50','Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno','50: Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno',8,2, 1477075035443, 'System'),
	   ('51','Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno','51: Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno',8,2, 1477075035443, 'System'),
	   ('52','Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação','52: Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação',8,2, 1477075035443, 'System'),
	   ('53','Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno','53: Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno',8,2, 1477075035443, 'System'),
	   ('54','Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação','54: Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação',8,2, 1477075035443, 'System'),
	   ('55','Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação','55: Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação',8,2, 1477075035443, 'System'),
	   ('56','Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','56: Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',8,2, 1477075035443, 'System'),
	   ('60','Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno','60: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno',8,2, 1477075035443, 'System'),
	   ('61','Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno','61: Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno',8,2, 1477075035443, 'System'),
	   ('62','Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação','62: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação',8,2, 1477075035443, 'System'),
	   ('63','Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno','63: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno',8,2, 1477075035443, 'System'),
	   ('64','Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação','64: Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação',8,2, 1477075035443, 'System'),
	   ('65','Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação','65: Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação',8,2, 1477075035443, 'System'),
	   ('66','Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','66: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',8,2, 1477075035443, 'System'),
	   ('67','Crédito Presumido - Outras Operações','67: Crédito Presumido - Outras Operações',8,2, 1477075035443, 'System'),
	   ('70','Operação de Aquisição sem Direito a Crédito','70: Operação de Aquisição sem Direito a Crédito',8,2, 1477075035443, 'System'),
	   ('71','Operação de Aquisição com Isenção','71: Operação de Aquisição com Isenção',8,2, 1477075035443, 'System'),
	   ('72','Operação de Aquisição com Suspensão','72: Operação de Aquisição com Suspensão',8,2, 1477075035443, 'System'),
	   ('73','Operação de Aquisição a Alíquota Zero','73: Operação de Aquisição a Alíquota Zero',8,2, 1477075035443, 'System'),
	   ('74','Operação de Aquisição sem Incidência da Contribuição','74: Operação de Aquisição sem Incidência da Contribuição',8,2, 1477075035443, 'System'),
	   ('75','Operação de Aquisição por Substituição Tributária','75: Operação de Aquisição por Substituição Tributária',8,2, 1477075035443, 'System'),
	   ('98','Outras Operações de Entrada','98: Outras Operações de Entrada',8,2, 1477075035443, 'System'),
	   ('99','Outras operações','99: Outras operações',8,2, 1477075035443, 'System'),

	   ('01','Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)','01: Operação tributável (BC = Operação alíq. normal (cumul./não cumul.)',9,2, 1477075035443, 'System'),
	   ('02','02: Operação tributável (BC = valor da operação (alíquota diferenciada)','02: Operação tributável (BC = valor da operação (alíquota diferenciada)',9,2, 1477075035443, 'System'),
	   ('03','Operação tributável (BC = quant. x alíq. por unidade de produto)','03: Operação tributável (BC = quant. x alíq. por unidade de produto)',9,2, 1477075035443, 'System'),
	   ('04','Operação tributável (tributação monofásica, alíquota zero)','04: Operação tributável (tributação monofásica, alíquota zero)',9,2, 1477075035443, 'System'),
	   ('06','Operação tributável (alíquota zero)','06: Operação tributável (alíquota zero)',9,2, 1477075035443, 'System'),
	   ('07','Operação isenta da contribuição','07: Operação isenta da contribuição',9,2, 1477075035443, 'System'),
	   ('08','Operação sem incidência da contribuição','08: Operação sem incidência da contribuição',9,2, 1477075035443, 'System'),
	   ('09','Operação com suspensão da contribuição','09: Operação com suspensão da contribuição',9,2, 1477075035443, 'System'),
	   ('49','Outras Operações de Saída','49: Outras Operações de Saída',9,2, 1477075035443, 'System'),
	   ('50','Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno','50: Direito a Crédito. Vinculada Exclusivamente a Receita Tributada no Mercado Interno',9,2, 1477075035443, 'System'),
	   ('51','Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno','51: Direito a Crédito. Vinculada Exclusivamente a Receita Não Tributada no Mercado Interno',9,2, 1477075035443, 'System'),
	   ('52','Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação','52: Direito a Crédito. Vinculada Exclusivamente a Receita de Exportação',9,2, 1477075035443, 'System'),
	   ('53','Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno','53: Direito a Crédito. Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno',9,2, 1477075035443, 'System'),
	   ('54','Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação','54: Direito a Crédito. Vinculada a Receitas Tributadas no Mercado Interno e de Exportação',9,2, 1477075035443, 'System'),
	   ('55','Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação','55: Direito a Crédito. Vinculada a Receitas Não-Trib. no Mercado Interno e de Exportação',9,2, 1477075035443, 'System'),
	   ('56','Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','56: Direito a Crédito. Vinculada a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',9,2, 1477075035443, 'System'),
	   ('60','Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno','60: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita Tributada no Mercado Interno',9,2, 1477075035443, 'System'),
	   ('61','Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno','61: Créd. Presumido. Aquisição Vinc. Exclusivamente a Rec. Não-Trib. no Mercado Interno',9,2, 1477075035443, 'System'),
	   ('62','Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação','62: Créd. Presumido. Aquisição Vinc. Exclusivamente a Receita de Exportação',9,2, 1477075035443, 'System'),
	   ('63','Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno','63: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. no Mercado Interno',9,2, 1477075035443, 'System'),
	   ('64','Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação','64: Créd. Presumido. Aquisição Vinc. a Rec. Trib. no Mercado Interno e de Exportação',9,2, 1477075035443, 'System'),
	   ('65','Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação','65: Créd. Presumido. Aquisição Vinc. a Rec. Não-Trib. Mercado Interno e Exportação',9,2, 1477075035443, 'System'),
	   ('66','Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação','66: Créd. Presumido. Aquisição Vinc. a Rec. Trib. e Não-Trib. Mercado Interno e Exportação',9,2, 1477075035443, 'System'),
	   ('67','Crédito Presumido - Outras Operações','67: Crédito Presumido - Outras Operações',9,2, 1477075035443, 'System'),
	   ('70','Operação de Aquisição sem Direito a Crédito','70: Operação de Aquisição sem Direito a Crédito',9,2, 1477075035443, 'System'),
	   ('71','Operação de Aquisição com Isenção','71: Operação de Aquisição com Isenção',9,2, 1477075035443, 'System'),
	   ('72','Operação de Aquisição com Suspensão','72: Operação de Aquisição com Suspensão',9,2, 1477075035443, 'System'),
	   ('73','Operação de Aquisição a Alíquota Zero','73: Operação de Aquisição a Alíquota Zero',9,2, 1477075035443, 'System'),
	   ('74','Operação de Aquisição sem Incidência da Contribuição','74: Operação de Aquisição sem Incidência da Contribuição',9,2, 1477075035443, 'System'),
	   ('75','Operação de Aquisição por Substituição Tributária','75: Operação de Aquisição por Substituição Tributária',9,2, 1477075035443, 'System'),
	   ('98','Outras Operações de Entrada','98: Outras Operações de Entrada',9,2, 1477075035443, 'System'),
	   ('99','Outras operações','99: Outras operações',9,2, 1477075035443, 'System');


	   INSERT INTO pagina(id,pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES (5,'Pedido Vendas', 0, 101, 1477075035443, 'System');




INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES ('0', '0 - Emitente','0 - Emitente',26,5, 1477075035443, 'System'),
	   ('1', '1 - Destinatário','1 - Destinatário',26,5, 1477075035443, 'System'),
	   ('2', '2 - Terceiros','2 - Terceiros',26,5, 1477075035443, 'System'),
	   ('9', '9 - Sem frete','9 - Sem frete',26,5, 1477075035443, 'System');


INSERT INTO pagina(id,pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES (10,'Nota Fiscal', 0, 100, 1477075035443, 'System');


INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
       (1001,'0', '0 - Pedido Vendas','0 - Pedido Vendas',1001,10, 1477075035443, 'System'),
	   (1002,'1', '1 - Orçamento','1 - Orçamento',1001,10, 1477075035443, 'System'),
	   (1003,'2', '2 - NF-e Saida','2 - NF-e Saida',1001,10, 1477075035443, 'System'),
	   (1004,'3', '3 - NF-e Entrada','3 - NF-e Entrada',1001,10, 1477075035443, 'System'),
	   (1005,'4', '4 - Pedido Compra','4 - Pedido Compra',1001,10, 1477075035443, 'System');



	   INSERT INTO pagina(id,pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES (10,'Nota Fiscal', 0, 100, 1477075035443, 'System');


INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
       (1001,'0', '0 - Pedido Vendas','0 - Pedido Vendas',1001,10, 1477075035443, 'System'),
	   (1002,'1', '1 - Orçamento','1 - Orçamento',1001,10, 1477075035443, 'System'),
	   (1003,'2', '2 - NF-e Saida','2 - NF-e Saida',1001,10, 1477075035443, 'System'),
	   (1004,'3', '3 - NF-e Entrada','3 - NF-e Entrada',1001,10, 1477075035443, 'System'),
	   (1005,'4', '4 - Pedido Compra','4 - Pedido Compra',1001,10, 1477075035443, 'System');
//===============

INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1,'NFNotaInfoItemModalidadeBCICMSST', 'NF NOTA INFO ITEM MODALIDADE BC ICMS ST', 1477075035443, 'System'),
	(2,'NFNotaInfoItemModalidadeBCICMS', 'NF NOTA INFO ITEM MODALIDADE BC ICMS', 1477075035443, 'System'),
	(3,'NFNotaInfoImpostoTributacaoISSQN', 'NF NOTA INFO IMPOSTO TRIBUTACAO ISSQN', 1477075035443, 'System'),
	(4,'NFNotaInfoImpostoTributacaoICMS', 'NF NOTAINFO IMPOSTO TRIBUTACAO ICMS', 1477075035443, 'System'),
	(5,'NFNotaInfoEspecieVeiculo', 'NF NOTA INFO ESPECIE VEICULO', 1477075035443, 'System'),
	(6,'NFNotaInfoCombustivelTipo', 'NF NOTA INFO COMBUSTIVEL TIPO', 1477075035443, 'System'),

	(16,'TIPO FRETE', 'TIPO FRETE', 1477075035443, 'System'),
	(17,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System'),
	(18,'NF AMBIENTE', 'NF AMBIENTE', 1477075035443, 'System'),
	(19,'NF MODALIDADE FRETE', 'NF MODALIDADE FRETE', 1477075035443, 'System'),
	(20,'NFModelo', 'NF MODELO', 1477075035443, 'System'),
	(21,'ICMS - SITUAÇÃO TRIBUTARIA SIMPLES NACIONAL', 'ICMS - SITUAÇÃO TRIBUTARIA SIMPLES NACIONAL', 1477075035443, 'System'),
	(22,'ICMS - SITUAÇÃO TRIBUTARIA TRIBUTACAO NORMAL', 'ICMS - SITUAÇÃO TRIBUTARIA TRIBUTACAO NORMAL' , 1477075035443, 'System'),
	(23,'ICMS - REGINE', 'ICMS - REGIME' , 1477075035443, 'System'),
	(7,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System'),
	(8,'ICMS - SITUAÇÃO TRIBUTARIA ', 'ICMS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	(9,'ICMS - ORIGEM', 'ICMS - ORIGEM', 1477075035443, 'System'),
	(10,'ICMS - MODALIDADE BC', 'MODALIDADE BC', 1477075035443, 'System'),
	(11,'ICMS - MOTIVO DESONERAÇÃO', 'ICMS - MOTIVO DESONERAÇÃO', 1477075035443, 'System'),
	(12,'IPI - SITUAÇÃO TRIBUTARIA', 'IPI - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	(13,'TIPO CALCULO', 'TIPO CALCULO', 1477075035443, 'System'),
	(14,'PIS - SITUAÇÃO TRIBUTARIA', 'PIS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	(15,'COFINS - SITUAÇÃO TRIBUTARIA', 'COFINS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System');


INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

    INSERT INTO doisvalortype(tipo, descricao,  create_date, create_user)
    VALUES ('ICMS - SITUAÇÃO TRIBUTARIA ', 'ICMS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	('ICMS - ORIGEM', 'ICMS - ORIGEM', 1477075035443, 'System'),
	('ICMS - MODALIDADE BC', 'MODALIDADE BC', 1477075035443, 'System'),
	('ICMS - MOTIVO DESONERAÇÃO', 'ICMS - MOTIVO DESONERAÇÃO', 1477075035443, 'System'),
	('IPI - SITUAÇÃO TRIBUTARIA', 'IPI - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	('TIPO CALCULO', 'TIPO CALCULO', 1477075035443, 'System'),
	('PIS - SITUAÇÃO TRIBUTARIA', 'PIS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System'),
	('COFINS - SITUAÇÃO TRIBUTARIA', 'COFINS - SITUAÇÃO TRIBUTARIA', 1477075035443, 'System');


INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (26,'TIPO FRETE', 'TIPO FRETE', 1477075035443, 'System');
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1002,'NF AMBIENTE', 'NF AMBIENTE', 1477075035443, 'System');

	INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
       (1006,'1', '1 - Produção','1 - Produção',1002,10, 1477075035443, 'System'),
	   (1007,'2', '2 - Homologação','2 - Homologação',1002,10, 1477075035443, 'System'),

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1003,'NF MODALIDADE FRETE', 'NF MODALIDADE FRETE', 1477075035443, 'System');

	INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
       (1008,'0', 'POR_CONTA_DO_EMITENTE','Por conta do emitente',1003,10, 1477075035443, 'System'),
	   (1009,'1', 'POR_CONTA_DO_DESTINATARIO_REMETENTE','Por conta do destinatário remetente',1003,10, 1477075035443, 'System'),
	   (1010,'2', 'POR_CONTA_DE_TERCEIROS','Por conta de terceiros',1003,10, 1477075035443, 'System'),
	   (1011,'9', 'SEM_FRETE','Sem frete',1003,10, 1477075035443, 'System'),

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1004,'NFModelo', 'NF MODELO', 1477075035443, 'System');


	INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
       (1012,'55', 'NFE','NF-e',1004,10, 1477075035443, 'System'),
	   (1013,'65', 'NFCE','NFC-e',1004,10, 1477075035443, 'System');

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1005,'NFNotaInfoCombustivelTipo', 'NF NOTA INFO COMBUSTIVEL TIPO', 1477075035443, 'System');

	INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
	(1014,'01', 'ALCOOL','\u00c1lcool',1005,10, 1477075035443, 'System'),
	(1015,'02', 'GASOLINA','Gasolina',1005,10, 1477075035443, 'System'),
	(1016,'03', 'DIESEL','Diesel',1005,10, 1477075035443, 'System'),
	(1017,'04', 'GASOGENIO','Gasog\u00eanio',1005,10, 1477075035443, 'System'),
	(1018,'05', 'GAS_METANO','G\u00e1s metano',1005,10, 1477075035443, 'System'),
	(1019,'06', 'ELETRICO_FONTE_INTERNA','"El\u00e9trico (fonte interna)',1005,10, 1477075035443, 'System'),
	(1020,'07', 'ELETRICO_FONTE_EXTERNA','El\u00e9trico (fonte externa)',1005,10, 1477075035443, 'System'),
	(1021,'08', 'GASOL_GAS_NATURAL_COMBUSTIVEL','Gasol/G\u00e1s natural/Combust\u00edvel',1005,10, 1477075035443, 'System'),
	(1022,'09', 'ALCOOL_GAS_NATURAL','\u00c1lcool/G\u00e1s natural',1005,10, 1477075035443, 'System'),
	(1023,'10', 'DIESEL_GAS_NATURAL','Diesel/G\u00e1s natural',1005,10, 1477075035443, 'System'),
	(1024,'11', 'VIDE_CAMPO_OBSERVACAO','Vide campo observa\u00e7\u00e3o',1005,10, 1477075035443, 'System'),
	(1025,'12', 'ALCOOL_GAS_NATURAL_VEICULAR','\u00c1lcool/G\u00e1s natural veicular',1005,10, 1477075035443, 'System'),
	(1026,'13', 'GASOLINA_GAS_NATURAL_VEICULAR','Gasolina/G\u00e1s natural veicular',1005,10, 1477075035443, 'System'),
	(1027,'14', 'DIESEL_GAS_NATURAL_VEICULAR','Diesel/G\u00e1s natural veicular',1005,10, 1477075035443, 'System'),
	(1028,'15', 'GAS_NATURAL_VEICULAR','G\u00e1s natural veicular',1005,10, 1477075035443, 'System'),
	(1029,'16', 'ALCOOL_GASOLINA','\u00c1lcool/Gasolina',1005,10, 1477075035443, 'System'),
	(1030,'17', 'GASOLINA_ALCOOL_GAS_NATURAL','Gasolina/\u00c1lcool/G\u00e1s natural',1005,10, 1477075035443, 'System'),
	(1031,'18', 'GASOLINA_ELETRICO','Gasolina/El\u00e9trico',1005,10, 1477075035443, 'System');

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1006,'NFNotaInfoEspecieVeiculo', 'NF NOTA INFO ESPECIE VEICULO', 1477075035443, 'System');


INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
	(1032,'1', 'PASSAGEIRO','Passageiro',1006,10, 1477075035443, 'System'),
	(1033,'2', 'CARGA','Carga',1006,10, 1477075035443, 'System'),
	(1034,'3', 'MISTO','Misto',1006,10, 1477075035443, 'System'),
	(1035,'4', 'CORRIDA','Corrida',1006,10, 1477075035443, 'System'),
	(1036,'5', 'TRACAO','Tração',1006,10, 1477075035443, 'System'),
	(1037,'6', 'ESPECIAL','Especial',1006,10, 1477075035443, 'System'),
	(1038,'7', 'COLECAO','Coleção',1006,10, 1477075035443, 'System');

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1007,'NFNotaInfoImpostoTributacaoICMS', 'NF NOTAINFO IMPOSTO TRIBUTACAO ICMS', 1477075035443, 'System');

	INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
	(1039,'00', 'TRIBUTACAO_INTEGRALMENTE','Tributada integralmente',1007,10, 1477075035443, 'System'),
	(1040,'10', 'TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA','Tributada com cobran\u00e7a de ICMS por ST',1007,10, 1477075035443, 'System'),
	(1041,'20', 'COM_REDUCAO_BASE_CALCULO','Com redu\u00e7\u00e3o da base de c\u00e1lculo',1007,10, 1477075035443, 'System'),
	(1042,'30', 'ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA','Isenta ou n\u00e3o tributada com cobran\u00e7a de ICMS por ST',1007,10, 1477075035443, 'System'),
	(1043,'40', 'ISENTA','Isenta',1007,10, 1477075035443, 'System'),
	(1044,'41', 'NAO_TRIBUTADO','N\u00e3o tributada',1007,10, 1477075035443, 'System'),
	(1045,'50', 'SUSPENSAO','Suspens\u00e3o',1007,10, 1477075035443, 'System'),
	(1046,'51', 'DIFERIMENTO','Diferimento',1007,10, 1477075035443, 'System'),
	(1047,'60', 'ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA','ICMS cobrado anteriormente por ST',1007,10, 1477075035443, 'System'),
	(1048,'70', 'COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA','Com redu\u00e7\u00e3o da base de c\u00e1lculo/Cobran\u00e7a ICMS por ST/ICMS ST',1007,10, 1477075035443, 'System'),
	(1049,'90', 'OUTROS','Outros',1007,10, 1477075035443, 'System');

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1008,'NFNotaInfoImpostoTributacaoISSQN', 'NF NOTA INFO IMPOSTO TRIBUTACAO ISSQN', 1477075035443, 'System');

INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
	(1050,'N', 'NORMAL','Normal',1008,10, 1477075035443, 'System'),
	(1051,'R', 'RETIDA','Retida',1008,10, 1477075035443, 'System'),
	(1052,'S', 'SUBSTITUTA','Substituta',1008,10, 1477075035443, 'System'),
	(1053,'I', 'ISENTA','Isenta',1008,10, 1477075035443, 'System');

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1009,'NFNotaInfoItemModalidadeBCICMS', 'NF NOTA INFO ITEM MODALIDADE BC ICMS', 1477075035443, 'System');

INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
	(1054,'0', 'MVA','Margem de valor agregado',1009,10, 1477075035443, 'System'),
	(1055,'1', 'PAUTA','Pauta',1009,10, 1477075035443, 'System'),
	(1056,'2', 'PRECO_TABELADO_MAXIMO','Pre\u00e7o tabelado m\u00e1ximo',1009,10, 1477075035443, 'System'),
	(1057,'3', 'VALOR_OPERACAO','Valor da opera\u00e7\u00e3o',1009,10, 1477075035443, 'System');

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1010,'NFNotaInfoItemModalidadeBCICMSST', 'NF NOTA INFO ITEM MODALIDADE BC ICMS ST', 1477075035443, 'System');

	INSERT INTO doisvalor(id,value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES
	(1058,'0', 'PRECO_TABELADO','Pre\u00e7o Tabelado',1010,10, 1477075035443, 'System'),
	(1059,'1', 'LISTA_NEGATIVA','Lista Negativa',1010,10, 1477075035443, 'System'),
	(1060,'2', 'LISTA_POSITIVA','Lista Positiva',1010,10, 1477075035443, 'System'),
	(1061,'3', 'LISTA_NEUTRA','Lista Neutra',1010,10, 1477075035443, 'System'),
	(1062,'4', 'MARGEM_VALOR_AGREGADO','Margem Valor Agregado',1010,10, 1477075035443, 'System'),
	(1063,'5', 'PAUTA','Pauta',1010,10, 1477075035443, 'System'),

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFNotaInfoItemProdutoArmamentoTipo {

    PERMITIDO("0", "Permitido"),
    RESTRITO("1", "Restrito");

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFNotaInfoItemProdutoVeiculoCondicao {

    ACABADO("1", "Acabado"),
    INACABADO("2", "Inacabado"),
    SEMI_ACABADO("3", "Semi-acabado");
//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFNotaInfoItemProdutoVeiculoCondicaoChassi {

    NORMAL("N", "Normal"),
    REMARCADO("R", "Remarcado");
//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFNotaInfoItemProdutoVeiculoRestricao {

    NAO_HA("0", "N\u00e3o h\u00e1"),
    ALIENACAO_FIDUCIARIA("1", "Aliena\u00e7\u00e3o fiduci\u00e1ria"),
    ARRENDAMENTO_MERCANTIL("2", "Arrendamento mercantil"),
    RESERVA_DOMINIO("3", "Reserva dom\u00ednio"),
    PENHOR("4", "Penhor"),
    OUTRAS("9", "Outras");
//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFNotaInfoItemProdutoVeiculoTipoOperacao {

    OUTROS("0", "Outros"),
    VENDA_CONCESSIONARIA("1", "Venda concession\u00e1ria"),
    FATURAMENTO_DIRETO_CONSUMIDOR_FINAL("2", "Faturamento direto consumidor final"),
    VENDA_DIRETA_GRANDES_CONSUMIDORES("3", "Venda direta grandes consumidores");

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFNotaInfoTipoVeiculo {

    AUTOMOVEL("06", "Autom\u00f3vel"),
    CAMINHAO("14", "Caminh\u00e3o"),
    CAMINHONETA("13", "Caminhoneta"),
    CARGA_CAM("24", "Carga"),
    CICLOMOTO("02", "Ciclomotor"),
    ESP_ONIBUS("22", "Especial \u00d4nibus"),
    MICROONIBUS("07", "Micro\u00f4nibus"),
    MISTO_CAM("23", "Misto"),
    MOTOCICLO("04", "Motociclo"),
    MOTONETA("03", "Motoneta"),
    ONIBUS("08", "\u00d4nibus"),
    REBOQUE("10", "Reboque"),
    TRICICLO("05", "Triciclo"),
    TRATOR("17", "Trator");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');


public enum NFNotaInfoVeiculoCor {

    AMARELA("01", "Amarela"),
    AZUL("02", "Azul"),
    BEGE("03", "Bege"),
    BRANCA("04", "Branca"),
    CINZA("05", "Cinza"),
    DOURADA("06", "Dourada"),
    GRENA("07", "Gren\u00e1"),
    LARANJA("08", "Laranja"),
    MARROM("09", "Marrom"),
    PRATA("10", "Prata"),
    PRETA("11", "Preta"),
    ROSA("12", "Rosa"),
    ROXA("13", "Roxa"),
    VERDE("14", "Verde"),
    VERMELHA("15", "Vermelha"),
    FANTASIA("16", "Fantasia");


	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFOrigemProcesso {

    SEFAZ("0", "Sefaz"),
    JUSTICA_FEDERAL("1", "Justi\u00e7a Federal"),
    JUSTICA_ESTADUAL("2", "Justi\u00e7a Estadual"),
    SECEX_RFB("3", "Secex RFB"),
    OUTROS("9", "Outros");


	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');


public enum NFProcessoEmissor {

    CONTRIBUINTE("0", "Aplicativo do contribuinte"),
    AVULSA_FISCO("1", "Emiss\u00e3o de NF-e avulsa pelo Fisco"),
    AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO("2", "Emiss\u00e3o de NF-e avulsa, pelo contribuinte com certificado digital atrav\u00e9s do Fisco"),
    CONTRIBUINTE_APLICATIVO_FISCO("3", "Emiss\u00e3o de NF-e pelo contribuinte com aplicativo fornecido pelo Fisco");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');


public enum NFProdutoCompoeValorNota {

    NAO("0", "N\u00e3o"),
    SIM("1", "Sim");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');


public enum NFRetornoStatus {

    AUTORIZADO_USO_NFE(100, "Autorizado o uso da NF-e"),
    CODIGO_101(101, "Cancelamento de NF-e homologado"),
    CODIGO_102(102, "Inutiliza\u00e7\u00e3o de n\u00famero homologado"),
    LOTE_RECEBIDO_COM_SUCESSO(103, "Lote recebido com sucesso"),
    LOTE_PROCESSADO(104, "Lote processado"),
    CODIGO_105(105, "Lote em processamento"),
    CODIGO_106(106, "Lote n\u00e3o localizado"),
    CODIGO_107(107, "Servi\u00e7o em Opera\u00e7\u00e3o"),
    CODIGO_108(108, "Servi\u00e7o Paralisado Momentaneamente (curto prazo)"),
    CODIGO_109(109, "Servi\u00e7o Paralisado sem Previs\u00e3o"),
    CODIGO_110(110, "Uso Denegado"),
    CODIGO_111(111, "Consulta cadastro com uma ocorr\u00eancia"),
    CODIGO_112(112, "Consulta cadastro com mais de uma ocorr\u00eancia"),
    CODIGO_113(113, "SCAN ser\u00e1 desabilitado para a UF \u00e0s hh:mm"),
    CODIGO_114(114, "SCAN desabilitado pela SEFAZ Origem"),
    CODIGO_128(128, "Lote de Evento Processado"),
    EVENTO_REGISTRADO_VINCULADO_NFE(135, "Evento registrado e vinculado a NF-e"),
    CODIGO_136(136, "Evento registrado, mas n\u00e3o vinculado a NF-e"),
    CODIGO_137(137, "Nenhum documento localizado para o Destinat\u00e1rio"),
    CODIGO_138(138, "Documento localizado para o Destinat\u00e1rio"),
    CODIGO_139(139, "Pedido de Download processado"),
    CODIGO_140(140, "Download disponibilizado"),
    CODIGO_150(150, "Autorizado o uso da NF-e"),
    CODIGO_151(151, "Cancelamento de NF-e homologado fora de prazo"),
    CODIGO_155(155, "Cancelamento de NF-e homologado fora de prazo"),
    CODIGO_201(201, "Rejei\u00e7\u00e3o: O numero m\u00e1ximo de numera\u00e7\u00e3o de NF-e a inutilizar ultrapassou o limite"),
    CODIGO_202(202, "Rejei\u00e7\u00e3o: Falha no reconhecimento da autoria ou integridade do arquivo digital"),
    CODIGO_203(203, "Rejei\u00e7\u00e3o: Emissor n\u00e3o habilitado para emiss\u00e3o da NF-e"),
    CODIGO_204(204, "Rejei\u00e7\u00e3o: Duplicidade de NF-e"),
    CODIGO_205(205, "Rejei\u00e7\u00e3o: NF-e est\u00e1 denegada na base de dados da SEFAZ"),
    CODIGO_206(206, "Rejei\u00e7\u00e3o: NF-e j\u00e1 est\u00e1 inutilizada na Base de dados da SEFAZ"),
    CODIGO_207(207, "Rejei\u00e7\u00e3o: CNPJ do emitente inv\u00e1lido"),
    CODIGO_208(208, "Rejei\u00e7\u00e3o: CNPJ do destinat\u00e1rio inv\u00e1lido"),
    CODIGO_209(209, "Rejei\u00e7\u00e3o: IE do emitente inv\u00e1lida"),
    CODIGO_210(210, "Rejei\u00e7\u00e3o: IE do destinat\u00e1rio inv\u00e1lida"),
    CODIGO_211(211, "Rejei\u00e7\u00e3o: IE do substituto inv\u00e1lida"),
    CODIGO_212(212, "Rejei\u00e7\u00e3o: Data de emiss\u00e3o NF-e posterior a data de recebimento"),
    CODIGO_213(213, "Rejei\u00e7\u00e3o: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital"),
    CODIGO_214(214, "Rejei\u00e7\u00e3o: Tamanho da mensagem excedeu o limite estabelecido"),
    CODIGO_215(215, "Rejei\u00e7\u00e3o: Falha no schema XML"),
    CODIGO_216(216, "Rejei\u00e7\u00e3o: Chave de Acesso difere da cadastrada"),
    CODIGO_217(217, "Rejei\u00e7\u00e3o: NF-e n\u00e3o consta na base de dados da SEFAZ"),
    CODIGO_218(218, "Rejei\u00e7\u00e3o: NF-e j\u00e1 esta cancelada na base de dados da SEFAZ"),
    CODIGO_219(219, "Rejei\u00e7\u00e3o: Circula\u00e7\u00e3o da NF-e verificada"),
    CODIGO_220(220, "Rejei\u00e7\u00e3o: Destinat\u00E1rio com identifica\u00E7\u00E3o igual \u00E0 identifica\u00E7\u00E3o do emitente"),
    CODIGO_221(221, "Rejei\u00e7\u00e3o: Confirmado o recebimento da NF-e pelo destinat\u00e1rio"),
    CODIGO_222(222, "Rejei\u00e7\u00e3o: Protocolo de Autoriza\u00e7\u00e3o de Uso difere do cadastrado"),
    CODIGO_223(223, "Rejei\u00e7\u00e3o: CNPJ do transmissor do lote difere do CNPJ do transmissor da consulta"),
    CODIGO_224(224, "Rejei\u00e7\u00e3o: A faixa inicial \u00e9 maior que a faixa final"),
    CODIGO_225(225, "Rejei\u00e7\u00e3o: Falha no Schema XML da NFe"),
    CODIGO_226(226, "Rejei\u00e7\u00e3o: C\u00f3digo da UF do Emitente diverge da UF autorizadora"),
    CODIGO_227(227, "Rejei\u00e7\u00e3o: Erro na Chave de Acesso - Campo ID"),
    CODIGO_228(228, "Rejei\u00e7\u00e3o: Data de Emiss\u00e3o muito atrasada"),
    CODIGO_229(229, "Rejei\u00e7\u00e3o: IE do emitente n\u00e3o informada"),
    CODIGO_230(230, "Rejei\u00e7\u00e3o: IE do emitente n\u00e3o cadastrada"),
    CODIGO_231(231, "Rejei\u00e7\u00e3o: IE do emitente n\u00e3o vinculada ao CNPJ"),
    CODIGO_232(232, "Rejei\u00e7\u00e3o: IE do destinat\u00e1rio n\u00e3o informada"),
    CODIGO_233(233, "Rejei\u00e7\u00e3o: IE do destinat\u00e1rio n\u00e3o cadastrada"),
    CODIGO_234(234, "Rejei\u00e7\u00e3o: IE do destinat\u00e1rio n\u00e3o vinculada ao CNPJ"),
    CODIGO_235(235, "Rejei\u00e7\u00e3o: Inscri\u00e7\u00e3o SUFRAMA inv\u00e1lida"),
    CODIGO_236(236, "Rejei\u00e7\u00e3o: Chave de Acesso com d\u00edgito verificador inv\u00e1lido"),
    CODIGO_237(237, "Rejei\u00e7\u00e3o: CPF do destinat\u00e1rio inv\u00e1lido"),
    CODIGO_238(238, "Rejei\u00e7\u00e3o: Cabe\u00e7alho - Vers\u00e3o do arquivo XML superior a Vers\u00e3o vigente"),
    CODIGO_239(239, "Rejei\u00e7\u00e3o: Cabe\u00e7alho - Vers\u00e3o do arquivo XML n\u00e3o suportada"),
    CODIGO_240(240, "Rejei\u00e7\u00e3o: Cancelamento/Inutiliza\u00e7\u00e3o - Irregularidade Fiscal do Emitente"),
    CODIGO_241(241, "Rejei\u00e7\u00e3o: Um n\u00famero da faixa j\u00e1 foi utilizado"),
    CODIGO_242(242, "Rejei\u00e7\u00e3o: Cabe\u00e7alho - Falha no Schema XML"),
    CODIGO_243(243, "Rejei\u00e7\u00e3o: XML Mal Formado"),
    CODIGO_244(244, "Rejei\u00e7\u00e3o: CNPJ do Certificado Digital difere do CNPJ da Matriz e do CNPJ do Emit"),
    CODIGO_245(245, "Rejei\u00e7\u00e3o: CNPJ Emitente n\u00e3o cadastrado"),
    CODIGO_246(246, "Rejei\u00e7\u00e3o: CNPJ Destinat\u00e1rio n\u00e3o cadastrado"),
    CODIGO_247(247, "Rejei\u00e7\u00e3o: Sigla da UF do Emitente diverge da UF autorizadora"),
    CODIGO_248(248, "Rejei\u00e7\u00e3o: UF do Recibo diverge da UF autorizadora"),
    CODIGO_249(249, "Rejei\u00e7\u00e3o: UF da Chave de Acesso diverge da UF autorizadora"),
    CODIGO_250(250, "Rejei\u00e7\u00e3o: UF diverge da UF autorizadora"),
    CODIGO_251(251, "Rejei\u00e7\u00e3o: UF/Munic\u00edpio destinat\u00e1rio n\u00e3o pertence a SUFRAMA"),
    CODIGO_252(252, "Rejei\u00e7\u00e3o: Ambiente informado diverge do Ambiente de recebimento"),
    CODIGO_253(253, "Rejei\u00e7\u00e3o: Digito Verificador da chave de acesso composta inv\u00e1lida"),
    CODIGO_254(254, "Rejei\u00e7\u00e3o: NF-e complementar n\u00e3o possui NF referenciada"),
    CODIGO_255(255, "Rejei\u00e7\u00e3o: NF-e complementar possui mais de uma NF referenciada"),
    CODIGO_256(256, "Rejei\u00e7\u00e3o: Uma NF-e da faixa j\u00e1 est\u00e1 inutilizada na Base de dados da SEFAZ"),
    CODIGO_257(257, "Rejei\u00e7\u00e3o: Solicitante n\u00e3o habilitado para emiss\u00e3o da NF-e"),
    CODIGO_258(258, "Rejei\u00e7\u00e3o: CNPJ da consulta inv\u00e1lido"),
    CODIGO_259(259, "Rejei\u00e7\u00e3o: CNPJ da consulta n\u00e3o cadastrado como contribuinte na UF"),
    CODIGO_260(260, "Rejei\u00e7\u00e3o: IE da consulta inv\u00e1lida"),
    CODIGO_261(261, "Rejei\u00e7\u00e3o: IE da consulta n\u00e3o cadastrada como contribuinte na UF"),
    CODIGO_262(262, "Rejei\u00e7\u00e3o: UF n\u00e3o fornece consulta por CPF"),
    CODIGO_263(263, "Rejei\u00e7\u00e3o: CPF da consulta inv\u00e1lido"),
    CODIGO_264(264, "Rejei\u00e7\u00e3o: CPF da consulta n\u00e3o cadastrado como contribuinte na UF"),
    CODIGO_265(265, "Rejei\u00e7\u00e3o: Sigla da UF da consulta difere da UF do Web Service"),
    CODIGO_266(266, "Rejei\u00e7\u00e3o: S\u00e9rie utilizada fora da faixa permitida no SCAN (0-889)"),
    CODIGO_267(267, "Rejei\u00e7\u00e3o: Chave de Acesso referenciada inexistente"),
    CODIGO_268(268, "Rejei\u00e7\u00e3o: NF Complementar referencia uma outra NF-e Complementar"),
    CODIGO_269(269, "Rejei\u00e7\u00e3o: CNPJ Emitente da NF Complementar difere do CNPJ da NF Referenciada"),
    CODIGO_270(270, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Fato Gerador: d\u00edgito inv\u00e1lido"),
    CODIGO_271(271, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Fato Gerador: difere da UF do emitente"),
    CODIGO_272(272, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Emitente: d\u00edgito inv\u00e1lido"),
    CODIGO_273(273, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Emitente: difere da UF do emitente"),
    CODIGO_274(274, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Destinat\u00e1rio: d\u00edgito inv\u00e1lido"),
    CODIGO_275(275, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Destinat\u00e1rio: difere da UF do Destinat\u00e1rio"),
    CODIGO_276(276, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Local de Retirada: d\u00edgito inv\u00e1lido"),
    CODIGO_277(277, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Local de Retirada: difere da UF do Local de Retirada"),
    CODIGO_278(278, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Local de Entrega: d\u00edgito inv\u00e1lido"),
    CODIGO_279(279, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do Local de Entrega: difere da UF do Local de Entrega"),
    CODIGO_280(280, "Rejei\u00e7\u00e3o: Certificado Transmissor inv\u00e1lido"),
    CODIGO_281(281, "Rejei\u00e7\u00e3o: Certificado Transmissor Data Validade"),
    CODIGO_282(282, "Rejei\u00e7\u00e3o: Certificado Transmissor sem CNPJ"),
    CODIGO_283(283, "Rejei\u00e7\u00e3o: Certificado Transmissor - erro Cadeia de Certifica\u00e7\u00e3o"),
    CODIGO_284(284, "Rejei\u00e7\u00e3o: Certificado Transmissor revogado"),
    CODIGO_285(285, "Rejei\u00e7\u00e3o: Certificado Transmissor difere ICP-Brasil"),
    CODIGO_286(286, "Rejei\u00e7\u00e3o: Certificado Transmissor erro no acesso a LCR"),
    CODIGO_287(287, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do FG - ISSQN: d\u00edgito inv\u00e1lido"),
    CODIGO_288(288, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio do FG - Transporte: d\u00edgito inv\u00e1lido"),
    CODIGO_289(289, "Rejei\u00e7\u00e3o: C\u00f3digo da UF informada diverge da UF solicitada"),
    CODIGO_290(290, "Rejei\u00e7\u00e3o: Certificado Assinatura inv\u00e1lido"),
    CODIGO_291(291, "Rejei\u00e7\u00e3o: Certificado Assinatura Data Validade"),
    CODIGO_292(292, "Rejei\u00e7\u00e3o: Certificado Assinatura sem CNPJ"),
    CODIGO_293(293, "Rejei\u00e7\u00e3o: Certificado Assinatura - erro Cadeia de Certifica\u00e7\u00e3o"),
    CODIGO_294(294, "Rejei\u00e7\u00e3o: Certificado Assinatura revogado"),
    CODIGO_295(295, "Rejei\u00e7\u00e3o: Certificado Assinatura difere ICP-Brasil"),
    CODIGO_296(296, "Rejei\u00e7\u00e3o: Certificado Assinatura erro no acesso a LCR"),
    CODIGO_297(297, "Rejei\u00e7\u00e3o: Assinatura difere do calculado"),
    CODIGO_298(298, "Rejei\u00e7\u00e3o: Assinatura difere do padr\u00e3o do Projeto"),
    CODIGO_299(299, "Rejei\u00e7\u00e3o: XML da \u00e1rea de cabe\u00e7alho com codifica\u00e7\u00e3o diferente de UTF-8"),
    CODIGO_301(301, "Uso Denegado : Irregularidade fiscal do emitente"),
    CODIGO_302(302, "Uso Denegado : Irregularidade fiscal do destinat\u00e1rio"),
    CODIGO_303(303, "Uso Denegado : Destinat\u00e1rio n\u00e3o habilitado a operar na UF"),
    CODIGO_304(304, "Rejei\u00e7\u00e3o: Pedido de Cancelamento para NF-e com evento da Suframa"),
    CODIGO_321(321, "Rejei\u00e7\u00e3o: NF-e de devolu\u00e7\u00e3o n\u00e3o possui conhecimento fiscal referenciado"),
    CODIGO_322(322, "Rejei\u00e7\u00e3o: NF-e de devolu\u00e7\u00e3o com mais de um documento fiscal referenciado"),
    CODIGO_323(323, "Rejei\u00e7\u00e3o: CNPJ autorizado para download inv\u00e1lido"),
    CODIGO_324(324, "Rejei\u00e7\u00e3o: CNPJ do destinat\u00e1rio ja autorizado para download"),
    CODIGO_325(325, "Rejei\u00e7\u00e3o: CPF autorizado para download inv\u00e1lido"),
    CODIGO_326(326, "Rejei\u00e7\u00e3o: CPF do destinat\u00e1rio autorizado para download"),
    CODIGO_327(327, "Rejei\u00e7\u00e3o: CFOP inv\u00e1lido para NF-e com finalidade de devolu\u00e7\u00e3o"),
    CODIGO_328(328, "Rejei\u00e7\u00e3o: CFOP inv\u00e1lido para NF-e que n\u00e3o tem finalidade de devolu\u00e7\u00e3o"),
    CODIGO_329(329, "Rejei\u00e7\u00e3o: N\u00famero da DI/DSI inv\u00e1lido"),
    CODIGO_330(330, "Rejei\u00e7\u00e3o: Informar o valor da AFRMM na importa\u00e7\u00e3o por via mar\u00edtima"),
    CODIGO_331(331, "Rejei\u00e7\u00e3o: Informar o CNPJ do adquirente ou do encomendante nesta forma de importa\u00e7\u00e3o"),
    CODIGO_332(332, "Rejei\u00e7\u00e3o: CNPJ do adquirente ou do encomendante da importa\u00e7\u00e3o inv\u00e1lido"),
    CODIGO_333(333, "Rejei\u00e7\u00e3o: Informar a UF do adquirente ou do encomendante nesta forma de importa\u00e7\u00e3o"),
    CODIGO_334(334, "Rejei\u00e7\u00e3o: N\u00famero do processo de drawback n\u00e3o informado na importa\u00e7\u00e3o"),
    CODIGO_335(335, "Rejei\u00e7\u00e3o: N\u00famero do processo de drawback na importa\u00e7\u00e3o inv\u00e1lido"),
    CODIGO_336(336, "Rejei\u00e7\u00e3o: Informado o grupo de exporta\u00e7\u00e3o no item para CFOP que n\u00e3o \u00e9 de exporta\u00e7\u00e3o"),
    CODIGO_337(337, "Rejei\u00e7\u00e3o: N\u00e3o informado o grupo de exporta\u00e7\u00e3o no item"),
    CODIGO_338(338, "Rejei\u00e7\u00e3o: N\u00famero de processo de drawback n\u00e3o informado na exporta\u00e7\u00e3o"),
    CODIGO_339(339, "Rejei\u00e7\u00e3o: N\u00famero de processo de drawback na exporta\u00e7\u00e3o inv\u00e1lido"),
    CODIGO_340(340, "Rejei\u00e7\u00e3o: N\u00e3o informado o grupo de exporta\u00e7\u00e3o indireta no item"),
    CODIGO_341(341, "Rejei\u00e7\u00e3o: N\u00famero do registro de exporta\u00e7\u00e3o inv\u00e1lido"),
    CODIGO_342(342, "Rejei\u00e7\u00e3o: Chave de acesso informada na exporta\u00e7\u00e3o indireta com DV inv\u00e1lido"),
    CODIGO_343(343, "Rejei\u00e7\u00e3o: Modelo da NF-e informada na exporta\u00e7\u00e3o indireta diferente de 55"),
    CODIGO_344(344, "Rejei\u00e7\u00e3o: Duplicidade de NF-e informada na exporta\u00e7\u00e3o indireta (chave acesso informada mais de uma vez)"),
    CODIGO_345(345, "Rejei\u00e7\u00e3o: Chave de acesso informada na exporta\u00e7\u00e3o indireta n\u00e3o consta como NF-e referenciada"),
    CODIGO_346(346, "Rejei\u00e7\u00e3o: Somat\u00f3rio quantidades informadas na exporta\u00e7\u00e3o indireta n\u00e3o corresponde total do item"),
    CODIGO_347(347, "Rejei\u00e7\u00e3o: Descri\u00e7\u00e3o do combust\u00edvel diverge da descri\u00e7\u00e3o adotada pela ANP"),
    CODIGO_348(348, "Rejei\u00e7\u00e3o: NFC-e com grupo RECOPI"),
    CODIGO_349(349, "Rejei\u00e7\u00e3o: N\u00famero RECOPI n\u00e3o informado"),
    CODIGO_350(350, "Rejei\u00e7\u00e3o: N\u00famero RECOPI inv\u00e1lido"),
    CODIGO_351(351, "Rejei\u00e7\u00e3o: Valor do ICMS da opera\u00e7\u00e3o no ICMS-ST=51 difere do produto BC e al\u00edquota"),
    CODIGO_352(352, "Rejei\u00e7\u00e3o: Valor do ICMS diferido no CST=51 difere do produto Valor ICMS opera\u00e7\u00e3o e ICMS diferido"),
    CODIGO_353(353, "Rejei\u00e7\u00e3o: Valor do ICMS no CST=51 n\u00e3o corresponde a diferen\u00e7a do ICMS opera\u00e7\u00e3o e ICMS diferido"),
    CODIGO_354(354, "Rejei\u00e7\u00e3o: Informado grupo de devolu\u00e7\u00e3ode tributos para NF-e e que n\u00e3o tem finalidade de devolu\u00e7\u00e3o"),
    CODIGO_355(355, "Rejei\u00e7\u00e3o: Informar o local de sa\u00edda do pa\u00eds no caso de exporta\u00e7\u00e3o"),
    CODIGO_356(356, "Rejei\u00e7\u00e3o: Informar o clocal de sa\u00edda do p\u00eds somente no caso de exporta\u00e7\u00e3o"),
    CODIGO_357(357, "Rejei\u00e7\u00e3o: Chave de acesso do grupo de exporta\u00e7\u00e3o indireta inexistente"),
    CODIGO_358(358, "Rejei\u00e7\u00e3o: Chave de acesso no grupo de exporta\u00e7\u00e3o indireta cancelada ou denegada"),
    CODIGO_359(359, "Rejei\u00e7\u00e3o: NF-e de venda a \u00d3rg\u00e3o p\u00fablico sem informar a Nota de Empenho"),
    CODIGO_360(360, "Rejei\u00e7\u00e3o: NF-e com Nota de Empenho inv\u00e1lida para UF"),
    CODIGO_361(361, "Rejei\u00e7\u00e3o: NF-e com Nota de Empenho inexistente na UF"),
    CODIGO_362(362, "Rejei\u00e7\u00e3o: Venda de combust\u00edvel sem informa\u00e7\u00e3o do Transportador"),
    CODIGO_363(363, "Rejei\u00e7\u00e3o: Total do ISS difere do somat\u00f3rio dos itens"),
    CODIGO_364(364, "Rejei\u00e7\u00e3o: Total do valor da dedu\u00e7\u00e3o do ISS difere do somat\u00f3rio dos itens"),
    CODIGO_365(365, "Rejei\u00e7\u00e3o: Total de outras reten\u00e7\u00f5es difere do somat\u00f3rio dos itens"),
    CODIGO_366(366, "Rejei\u00e7\u00e3o: Total do desconto incondicionado do ISS difere do somat\u00f3rio dos itens"),
    CODIGO_367(367, "Rejei\u00e7\u00e3o: Total do desconto condicionado do ISS difere do somat\u00f3rio dos itens"),
    CODIGO_368(368, "Rejei\u00e7\u00e3o: Total do ISS retido difere do somat\u00f3rio dos itens"),
    CODIGO_369(369, "Rejei\u00e7\u00e3o: N\u00e3o informado o grupo avulsa na emiss\u00e3o pelo Fisco"),
    CODIGO_370(370, "Rejei\u00e7\u00e3o: Nota Fiscal Avusa com tipo de emiss\u00e3o inv\u00e1lido"),
    CODIGO_386(386, "Rejei\u00e7\u00e3o: CFOP n\u00e3o permitido para o CSOSN informado"),
    CODIGO_401(401, "Rejei\u00e7\u00e3o: CPF do remetente inv\u00e1lido"),
    CODIGO_402(402, "Rejei\u00e7\u00e3o: XML da \u00e1rea de dados com codifica\u00e7\u00e3o diferente de UTF-8"),
    CODIGO_403(403, "Rejei\u00e7\u00e3o: O grupo de informa\u00e7\u00f5es da NF-e avulsa \u00e9 de uso exclusivo do Fisco"),
    CODIGO_404(404, "Rejei\u00e7\u00e3o: Uso de prefixo de namespace n\u00e3o permitido"),
    CODIGO_405(405, "Rejei\u00e7\u00e3o: C\u00f3digo do pa\u00eds do emitente: d\u00edgito inv\u00e1lido"),
    CODIGO_406(406, "Rejei\u00e7\u00e3o: C\u00f3digo do pa\u00eds do destinat\u00e1rio: d\u00edgito inv\u00e1lido"),
    CODIGO_407(407, "Rejei\u00e7\u00e3o: O CPF s\u00f3 pode ser informado no campo emitente para a NF-e avulsa"),
    CODIGO_409(409, "Rejei\u00e7\u00e3o: Campo cUF inexistente no elemento nfeCabecMsg do SOAP Header"),
    CODIGO_410(410, "Rejei\u00e7\u00e3o: UF informada no campo cUF n\u00e3o \u00e9 atendida pelo Web Service"),
    CODIGO_411(411, "Rejei\u00e7\u00e3o: Campo versaoDados inexistente no elemento nfeCabecMsg do SOAP Header"),
    CODIGO_417(417, "Rejei\u00e7\u00e3o: Total do ICMS superior ao valor limite estabelecido"),
    CODIGO_418(418, "Rejei\u00e7\u00e3o: Total do ICMS-ST superior ao limite estabelecido"),
    CODIGO_420(420, "Rejei\u00e7\u00e3o: Cancelamento para NF-e j\u00e1 cancelada"),
    CODIGO_450(450, "Rejei\u00e7\u00e3o: Modelo da NF-e diferente de 55"),
    CODIGO_451(451, "Rejei\u00e7\u00e3o: Processo de emiss\u00e3o informado inv\u00e1lido"),
    CODIGO_452(452, "Rejei\u00e7\u00e3o: Tipo Autorizador do Recibo diverge do \u00d3rg\u00e3o Autorizador"),
    CODIGO_453(453, "Rejei\u00e7\u00e3o: Ano de inutiliza\u00e7\u00e3o n\u00e3o pode ser superior ao Ano atual"),
    CODIGO_454(454, "Rejei\u00e7\u00e3o: Ano de inutiliza\u00e7\u00e3o n\u00e3o pode ser inferior a 2006"),
    CODIGO_461(461, "Rejei\u00e7\u00e3o: Informado percentual de g\u00e1s natural na mistura para produto diferente de GLP"),
    CODIGO_464(464, "Rejei\u00e7\u00e3o: C\u00f3digo de Hash no QR-Code difere do calculado"),
    CODIGO_465(465, "Rejei\u00e7\u00e3o: N\u00famero de controle da FCI inexistente"),
    CODIGO_478(478, "Rejei\u00e7\u00e3o: Local da entrega n\u00e3o informado para faturamto direto de ve\u00edculos novos"),
    CODIGO_479(479, "Rejei\u00e7\u00e3o: Emissor em situa\u00e7\u00e3o irregular peranto o fisco"),
    CODIGO_480(480, "Rejei\u00e7\u00e3o: CNPJ da Chave de acesso da NF-e informada diverge do CNPJ do emitente"),
    CODIGO_481(481, "Rejei\u00e7\u00e3o: UF da Chave de acesso diverge do c\u00f3digo da UF informada"),
    CODIGO_482(482, "Rejei\u00e7\u00e3o: AA da Chave de acesso inv\u00e1lida"),
    CODIGO_483(483, "Rejei\u00e7\u00e3o: MM da Chave de acesso inv\u00e1lido"),
    CODIGO_484(484, "Rejei\u00e7\u00e3o: DPEC com tipo de emiss\u00e3o diferente de \"4\"(posi\u00e7\u00e3o 35 da Chave de Acess"),
    CODIGO_485(485, "Rejei\u00e7\u00e3o: N\u00famero DPEC j\u00e1 existe no cadastro de DPEC"),
    CODIGO_486(486, "Rejei\u00e7\u00e3o: DPEC n\u00e3o localizada para o n\u00famero de registro de DPEC informado"),
    CODIGO_487(487, "Rejei\u00e7\u00e3o: Nenhuma DPEC localizada para a chave de acesso informada"),
    CODIGO_488(488, "Rejei\u00e7\u00e3o: Requisitante de Consulta n\u00e3o tem o mesmo CNPJ base do emissor da DPEC"),
    CODIGO_489(489, "Rejei\u00e7\u00e3o: CNPJ informado inv\u00e1lido (DV ou zeros)"),
    CODIGO_490(490, "Rejei\u00e7\u00e3o: CPF informado inv\u00e1lido (DV ou zeros)"),
    CODIGO_491(491, "Rejei\u00e7\u00e3o: O tpEvento informado inv\u00e1lido"),
    CODIGO_492(492, "Rejei\u00e7\u00e3o: O verEvento informado inv\u00e1lido"),
    CODIGO_493(493, "Rejei\u00e7\u00e3o: Evento n\u00e3o atende o Schema XML espec\u00edfico"),
    CODIGO_494(494, "Rejei\u00e7\u00e3o: Chave de Acesso inexistente"),
    CODIGO_501(501, "Rejei\u00e7\u00e3o: Rejei\u00e7\u00e3o: Prazo de Cancelamento Superior ao Previsto na Legisla\u00e7\u00e3o"),
    CODIGO_502(502, "Rejei\u00e7\u00e3o: Erro Chave Acesso - Campo Id \u00f1 corresponde \u00e0 conct. dos campos corresp"),
    CODIGO_503(503, "Rejei\u00e7\u00e3o: S\u00e9rie utilizada fora da faixa permitida no SCAN (900-999)"),
    CODIGO_504(504, "Rejei\u00e7\u00e3o: Data de Entrada/Sa\u00edda posterior ao permitido"),
    CODIGO_505(505, "Rejei\u00e7\u00e3o: Data de Entrada/Sa\u00edda anterior ao permitido"),
    CODIGO_506(506, "Rejei\u00e7\u00e3o: Data de Sa\u00edda menor que a Data de Emiss\u00e3o"),
    CODIGO_507(507, "Rejei\u00e7\u00e3o: CNPJ destinat\u00e1rio/remetente \u00f1 deve ser inform. em opera\u00e7\u00e3o c/ exterior"),
    CODIGO_508(508, "Rejei\u00e7\u00e3o: CNPJ com conte\u00fado nulo s\u00f3 \u00e9 v\u00e1lido em opera\u00e7\u00e3o com exterior"),
    CODIGO_509(509, "Rejei\u00e7\u00e3o: Inform. c\u00f3d.munic\u00edpio diferente de \"9999999\" para opera\u00e7\u00e3o c/ exterior"),
    CODIGO_510(510, "Rejei\u00e7\u00e3o: Oper.c/ Exterior e C\u00f3d.Pa\u00eds destinat\u00e1rio \u00e9 1058(Brasil) ou \u00f1 informado"),
    CODIGO_511(511, "Rejei\u00e7\u00e3o: N\u00e3o \u00e9 Oper.c/ Exterior e C\u00f3d.Pa\u00eds destinat\u00e1rio difere de 1058 (Brasil)"),
    CODIGO_512(512, "Rejei\u00e7\u00e3o: CNPJ do Local de retirada inv\u00e1lido"),
    CODIGO_513(513, "Rejei\u00e7\u00e3o: C\u00f3digo Munic\u00edpio Local Retirada deve ser 9999999 para UF retirada = EX"),
    CODIGO_514(514, "Rejei\u00e7\u00e3o: CNPJ do Local de Entrega inv\u00e1lido"),
    CODIGO_515(515, "Rejei\u00e7\u00e3o: C\u00f3digo Munic. do Local de Entrega deve ser 9999999 p/ UF entrega=EX"),
    CODIGO_516(516, "Rejei\u00e7\u00e3o: Falha no schema XML - inexiste a tag raiz esperada para a mensagem"),
    CODIGO_517(517, "Rejei\u00e7\u00e3o: Falha no schema XML - inexiste atributo versao na tag raiz da mensagem"),
    CODIGO_518(518, "Rejei\u00e7\u00e3o: CFOP de entrada para NF-e de sa\u00edda"),
    CODIGO_519(519, "Rejei\u00e7\u00e3o: CFOP de sa\u00edda para NF-e de entrada"),
    CODIGO_520(520, "Rejei\u00e7\u00e3o: CFOP de Opera\u00e7\u00e3o com Exterior e UF destinat\u00e1rio difere de EX"),
    CODIGO_521(521, "Rejei\u00e7\u00e3o: CFOP n\u00e3o \u00e9 de Opera\u00e7\u00e3o com Exterior e UF destinat\u00e1rio \u00e9 EX"),
    CODIGO_522(522, "Rejei\u00e7\u00e3o: CFOP de opera\u00e7\u00e3o estadual e UF emitente <> da UF remetente contribuinte ICMS"),
    CODIGO_523(523, "Rejei\u00e7\u00e3o: CFOP n\u00e3o \u00e9 de Opera\u00e7\u00e3o Estadual e UF emitente igual a UF destinat\u00e1rio"),
    CODIGO_524(524, "Rejei\u00e7\u00e3o: CFOP de Opera\u00e7\u00e3o com Exterior e n\u00e3o informado NCM"),
    CODIGO_525(525, "Rejei\u00e7\u00e3o: CFOP de Importa\u00e7\u00e3o e n\u00e3o informado dados da DI"),
    CODIGO_526(526, "Rejei\u00e7\u00e3o: CFOP de Exporta\u00e7\u00e3o e n\u00e3o informado Local de Embarque"),
    CODIGO_527(527, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o de Exporta\u00e7\u00e3o com informa\u00e7\u00e3o de ICMS incompat\u00edvel"),
    CODIGO_528(528, "Rejei\u00e7\u00e3o: Valor do ICMS difere do produto BC e Al\u00edquota"),
    CODIGO_529(529, "Rejei\u00e7\u00e3o: NCM de informa\u00e7\u00e3o obrigat\u00f3ria para produto tributado pelo IPI"),
    CODIGO_530(530, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o com tributa\u00e7\u00e3o de ISSQN sem informar a Inscri\u00e7\u00e3o Municipal"),
    CODIGO_531(531, "Rejei\u00e7\u00e3o: Total da BC ICMS difere do somat\u00f3rio dos itens"),
    CODIGO_532(532, "Rejei\u00e7\u00e3o: Total do ICMS difere do somat\u00f3rio dos itens"),
    CODIGO_533(533, "Rejei\u00e7\u00e3o: Total da BC ICMS-ST difere do somat\u00f3rio dos itens"),
    CODIGO_534(534, "Rejei\u00e7\u00e3o: Total do ICMS-ST difere do somat\u00f3rio dos itens"),
    CODIGO_535(535, "Rejei\u00e7\u00e3o: Total do Frete difere do somat\u00f3rio dos itens"),
    CODIGO_536(536, "Rejei\u00e7\u00e3o: Total do Seguro difere do somat\u00f3rio dos itens"),
    CODIGO_537(537, "Rejei\u00e7\u00e3o: Total do Desconto difere do somat\u00f3rio dos itens"),
    CODIGO_538(538, "Rejei\u00e7\u00e3o: Total do IPI difere do somat\u00f3rio dos itens"),
    CODIGO_539(539, "Rejei\u00e7\u00e3o: Duplicidade de NF-e, com diferen\u00e7a na Chave de Acesso"),
    CODIGO_540(540, "Rejei\u00e7\u00e3o: CPF do Local de Retirada inv\u00e1lido"),
    CODIGO_541(541, "Rejei\u00e7\u00e3o: CPF do Local de Entrega inv\u00e1lido"),
    CODIGO_542(542, "Rejei\u00e7\u00e3o: CNPJ do Transportador inv\u00e1lido"),
    CODIGO_543(543, "Rejei\u00e7\u00e3o: CPF do Transportador inv\u00e1lido"),
    CODIGO_544(544, "Rejei\u00e7\u00e3o: IE do Transportador inv\u00e1lida"),
    CODIGO_545(545, "Rejei\u00e7\u00e3o: Falha schema XML - vers\u00e3o inform.na Dados do SOAPHeader difere da msg"),
    CODIGO_546(546, "Rejei\u00e7\u00e3o: Erro na Chave de Acesso - Campo Id - falta a literal NFe"),
    CODIGO_547(547, "Rejei\u00e7\u00e3o: D\u00edgito Verificador da Chave de Acesso da NF-e Referenciada inv\u00e1lido"),
    CODIGO_548(548, "Rejei\u00e7\u00e3o: CNPJ da NF referenciada inv\u00e1lido."),
    CODIGO_549(549, "Rejei\u00e7\u00e3o: CNPJ da NF referenciada de produtor inv\u00e1lido."),
    CODIGO_550(550, "Rejei\u00e7\u00e3o: CPF da NF referenciada de produtor inv\u00e1lido."),
    CODIGO_551(551, "Rejei\u00e7\u00e3o: IE da NF referenciada de produtor inv\u00e1lido."),
    CODIGO_552(552, "Rejei\u00e7\u00e3o: D\u00edgito Verificador da Chave de Acesso do CT-e Referenciado inv\u00e1lido"),
    CODIGO_553(553, "Rejei\u00e7\u00e3o: Tipo autorizador do recibo diverge do \u00d3rg\u00e3o Autorizador"),
    CODIGO_554(554, "Rejei\u00e7\u00e3o: S\u00e9rie difere da faixa 0-899"),
    CODIGO_555(555, "Rejei\u00e7\u00e3o: Tipo autorizador do protocolo diverge do \u00d3rg\u00e3o Autorizador"),
    CODIGO_556(556, "Rejei\u00e7\u00e3o: Justific.de entrada em conting.n\u00e3o deve ser informada p/tp.emis.normal"),
    CODIGO_557(557, "Rejei\u00e7\u00e3o: A Justificativa de entrada em conting\u00eancia deve ser informada"),
    CODIGO_558(558, "Rejei\u00e7\u00e3o: Data de entrada em conting\u00eancia posterior a data de emiss\u00e3o"),
    CODIGO_559(559, "Rejei\u00e7\u00e3o: UF do Transportador n\u00e3o informada"),
    CODIGO_560(560, "Rejei\u00e7\u00e3o: CNPJ base do emitente <> CNPJ base da primeira NF-e do lote recebido"),
    CODIGO_561(561, "Rejei\u00e7\u00e3o: M\u00eas de Emiss\u00e3o informado na Chave de Acesso difere do M\u00eas de Emiss\u00e3o d"),
    CODIGO_562(562, "Rejei\u00e7\u00e3o: C\u00f3digo Num\u00e9rico informado da Chave de Acesso <> C\u00f3digo Num\u00e9rico da NFe"),
    CODIGO_563(563, "Rejei\u00e7\u00e3o: J\u00e1 existe pedido de Inutiliza\u00e7\u00e3o com a mesma faixa de inutiliza\u00e7\u00e3o"),
    CODIGO_564(564, "Rejei\u00e7\u00e3o: Total do Produto / Servi\u00e7o difere do somat\u00f3rio dos itens"),
    CODIGO_565(565, "Rejei\u00e7\u00e3o: Falha no schema XML - inexiste a tag raiz esperada para o lote de NF-e"),
    CODIGO_567(567, "Rejei\u00e7\u00e3o: Falha schema XML - vers\u00e3o inform.na Dados do SOAPHeader difere do lote"),
    CODIGO_568(568, "Rejei\u00e7\u00e3o: Falha schema XML inexiste atributo vers\u00e3o na tag raiz do lote de NF-e"),
    CODIGO_569(569, "Rejei\u00e7\u00e3o: Data de entrada em conting\u00eancia muito atrasada"),
    CODIGO_570(570, "Rejei\u00e7\u00e3o: Tipo de emiss\u00e3o 3, 6 e 7 s\u00f3 \u00e9 valido nas conting\u00eancis SCAN/SVC"),
    CODIGO_571(571, "Rejei\u00e7\u00e3o:  O tpEmis informado diferente de 3 para conting\u00eancia SCAN"),
    CODIGO_572(572, "Rejei\u00e7\u00e3o: Erro Atributo ID do evento erro concatena\u00e7\u00e3o dos campos (\u201cID\u201d + tpEvento + chNFe + nSeq)"),
    CODIGO_573(573, "Rejei\u00e7\u00e3o: Duplicidade de Evento"),
    CODIGO_574(574, "Rejei\u00e7\u00e3o: O autor do evento diverge do emissor da NF-e"),
    CODIGO_575(575, "Rejei\u00e7\u00e3o: O autor do evento diverge do destinat\u00e1rio da NF-e"),
    CODIGO_576(576, "Rejei\u00e7\u00e3o: O autor do evento n\u00e3o \u00e9 um \u00f3rg\u00e3o autorizado a gerar o evento"),
    CODIGO_577(577, "Rejei\u00e7\u00e3o: A data do evento n\u00e3o pode ser menor que a data de emiss\u00e3o da NF-e"),
    CODIGO_578(578, "Rejei\u00e7\u00e3o: A data do evento n\u00e3o pode ser maior que a data do processamento"),
    CODIGO_579(579, "Rejei\u00e7\u00e3o: A data do evento n\u00e3o pode ser menor que a data de autoriza\u00e7\u00e3o para NF-e n\u00e3o emitida em conting\u00eancia"),
    CODIGO_580(580, "Rejei\u00e7\u00e3o: O evento exige uma NF-e autorizada"),
    CODIGO_582(582, "Rejei\u00e7\u00e3o: UF n\u00e3o atendida pela SVC-[AN/RS] "),
    CODIGO_584(584, "Rejei\u00e7\u00e3o: tpEmis informado \u00e9 incompat\u00edvel com a SVC-[AN/RS]"),
    CODIGO_586(586, "Rejei\u00e7\u00e3o: Servi\u00e7o n\u00e3o dispon\u00edvel na SVC"),
    CODIGO_587(587, "Rejei\u00e7\u00e3o: Usar somente o namespace padr\u00e3o da NF-e"),
    CODIGO_588(588, "Rejei\u00e7\u00e3o: N\u00e3o \u00e9 permitida a presen\u00e7a de caracteres de edi\u00e7\u00e3o no in\u00edcio/fim da mensagem ou entre as tags da mensagem"),
    CODIGO_589(589, "Rejei\u00e7\u00e3o: N\u00famero do NSU informado superior ao maior NSU da base de dados da SEFAZ"),
    CODIGO_590(590, "Rejei\u00e7\u00e3o: Informado CST para emissor do Simples Nacional"),
    CODIGO_591(591, "Rejei\u00e7\u00e3o: Informado CSOSN para emissor que n\u00e3o \u00e9 do Simples Nacional (CRT diferente de 1)"),
    CODIGO_592(592, "Rejei\u00e7\u00e3o: A NF-e deve ter pelo menos um item de produto sujeito ao ICMS"),
    CODIGO_593(593, "Rejei\u00e7\u00e3o: CNPJ-Base consultado difere do CNPJ-Base do Certificado Digital"),
    CODIGO_594(594, "Rejei\u00e7\u00e3o: O n\u00famero de sequencia do evento informado \u00e9 maior que o permitido"),
    CODIGO_595(595, "Rejei\u00e7\u00e3o: Rejei\u00e7\u00e3o: A vers\u00e3o do leiaute da NF-e utilizada n\u00e3o \u00e9 mais v\u00e1lida"),
    CODIGO_596(596, "Rejei\u00e7\u00e3o: Rejei\u00e7\u00e3o: Ambiente de homologa\u00e7\u00e3o indispon\u00edvel para recep\u00e7\u00e3o de NF-e da vers\u00e3o 1.10."),
    CODIGO_597(597, "Rejei\u00e7\u00e3o: CFOP de Importa\u00e7\u00e3o e n\u00e3o informado dados de IPI"),
    CODIGO_598(598, "Rejei\u00e7\u00e3o: NF-e emitida em ambiente de homologa\u00e7\u00e3o com raz\u00e3o social <> de NF-e (Emitida homologa\u00e7\u00e3o - S/vlr fiscal)"),
    CODIGO_599(599, "Rejei\u00e7\u00e3o: CFOP de Importa\u00e7\u00e3o e n\u00e3o informado dados de II"),
    CODIGO_601(601, "Rejei\u00e7\u00e3o: Total do II difere do somat\u00f3rio dos itens"),
    CODIGO_602(602, "Rejei\u00e7\u00e3o: Total do PIS difere do somat\u00f3rio dos itens sujeitos ao ICMS"),
    CODIGO_603(603, "Rejei\u00e7\u00e3o: Total do COFINS difere do somat\u00f3rio dos itens sujeitos ao ICMS"),
    CODIGO_604(604, "Rejei\u00e7\u00e3o: Total do vOutro difere do somat\u00f3rio dos itens"),
    CODIGO_605(605, "Rejei\u00e7\u00e3o: Total do vServ difere do somat\u00f3rio do vProd dos itens sujeitos ao ISSQN"),
    CODIGO_606(606, "Rejei\u00e7\u00e3o: Total do vBC do ISS difere do somat\u00f3rio dos itens"),
    CODIGO_607(607, "Rejei\u00e7\u00e3o: Total do ISS difere do somat\u00f3rio dos itens"),
    CODIGO_608(608, "Rejei\u00e7\u00e3o: Total do PIS difere do somat\u00f3rio dos itens sujeitos ao ISSQN"),
    CODIGO_609(609, "Rejei\u00e7\u00e3o: Total do COFINS difere do somat\u00f3rio dos itens sujeitos ao ISSQN"),
    CODIGO_610(610, "Rejei\u00e7\u00e3o: Total da NF difere do somat\u00f3rio dos Valores comp\u00f5e o valor Total da NF"),
    CODIGO_611(611, "Rejei\u00e7\u00e3o: cEAN inv\u00e1lido"),
    CODIGO_612(612, "Rejei\u00e7\u00e3o: cEANTrib inv\u00e1lido"),
    CHAVE_DE_ACESSO_DIFERENTE_NO_DB_SEFAZ(613, "Rejei\u00e7\u00e3o: Chave de Acesso difere da existente em BD"),
    CODIGO_614(614, "Rejei\u00e7\u00e3o: Chave de Acesso inv\u00e1lida (C\u00f3digo UF inv\u00e1lido)"),
    CODIGO_615(615, "Rejei\u00e7\u00e3o: Chave de Acesso inv\u00e1lida (Ano < 05 ou Ano maior que Ano corrente)"),
    CODIGO_616(616, "Rejei\u00e7\u00e3o: Chave de Acesso inv\u00e1lida (M\u00eas < 1 ou M\u00eas > 12)"),
    CODIGO_617(617, "Rejei\u00e7\u00e3o: Chave de Acesso inv\u00e1lida (CNPJ zerado ou d\u00edgito inv\u00e1lido)"),
    CODIGO_618(618, "Rejei\u00e7\u00e3o: Chave de Acesso inv\u00e1lida (modelo diferente de 55 e 65 )"),
    CODIGO_619(619, "Rejei\u00e7\u00e3o: Chave de Acesso inv\u00e1lida (n\u00famero NF = 0)"),
    CODIGO_620(620, "Rejei\u00e7\u00e3o: Chave de Acesso difere da existente em BD"),
    CODIGO_621(621, "Rejei\u00e7\u00e3o: CPF Emitente n\u00e3o cadastrado"),
    CODIGO_622(622, "Rejei\u00e7\u00e3o: IE emitente n\u00e3o vinculada ao CPF"),
    CODIGO_623(623, "Rejei\u00e7\u00e3o: CPF Destinat\u00e1rio n\u00e3o cadastrado"),
    CODIGO_624(624, "Rejei\u00e7\u00e3o: IE Destinat\u00e1rio n\u00e3o vinculada ao CPF"),
    CODIGO_625(625, "Rejei\u00e7\u00e3o: Inscri\u00e7\u00e3o SUFRAMA deve ser informada na venda com isen\u00e7\u00e3o para ZFM"),
    CODIGO_626(626, "Rejei\u00e7\u00e3o: O CFOP de opera\u00e7\u00e3o isenta para ZFM diferente do previsto"),
    CODIGO_627(627, "Rejei\u00e7\u00e3o: O valor do ICMS desonerado deve ser informado"),
    CODIGO_628(628, "Rejei\u00e7\u00e3o: Total da NF superior ao valor limite estabelecido pela SEFAZ [Limite]"),
    CODIGO_629(629, "Rejei\u00e7\u00e3o: Vlr Produto difere do produto Valor Unit\u00e1rio de Comercializa\u00e7\u00e3o e quantidade comercial"),
    CODIGO_630(630, "Rejei\u00e7\u00e3o: Vlr Produto difere do produto Valor Unit\u00e1rio de Tributa\u00e7\u00e3o e quantidade tribut\u00e1vel"),
    CODIGO_631(631, "Rejei\u00e7\u00e3o: CNPJ-Base do Destinat\u00e1rio difere do CNPJ-Base do Certificado Digital"),
    CODIGO_632(632, "Rejei\u00e7\u00e3o: Solicita\u00e7\u00e3o fora de prazo, a NF-e n\u00e3o est\u00e1 mais dispon\u00edvel para download"),
    CODIGO_633(633, "Rejei\u00e7\u00e3o: NF-e indispon\u00edvel para download devido a aus\u00eancia de Manifesta\u00e7\u00e3o do Destinat\u00e1rio"),
    CODIGO_634(634, "Rejei\u00e7\u00e3o: Destinat\u00e1rio da NF-e n\u00e3o tem o mesmo CNPJ raiz do solicitante do download"),
    CODIGO_635(635, "Rejei\u00e7\u00e3o: NF-e com mesmo n\u00famero e s\u00e9rie j\u00e1 transmitida e aguardando processamento"),
    CODIGO_650(650, "Rejei\u00e7\u00e3o: Evento de \"Ci\u00eancia da Opera\u00e7\u00e3o\" para NF-e Cancelada ou Denegada"),
    CODIGO_651(651, "Rejei\u00e7\u00e3o: Evento de \"Desconhecimento da Opera\u00e7\u00e3o\" para NF-e Cancelada ou Denegada"),
    CODIGO_653(653, "Rejei\u00e7\u00e3o: NF-e Cancelada, arquivo indispon\u00edvel para download"),
    CODIGO_654(654, "Rejei\u00e7\u00e3o: NF-e Denegada, arquivo indispon\u00edvel para download"),
    CODIGO_655(655, "Rejei\u00e7\u00e3o: Evento de Ci\u00eancia da Opera\u00e7\u00e3o informado ap\u00f3s a manifesta\u00e7\u00e3o final do destinat\u00e1rio"),
    CODIGO_656(656, "Rejei\u00e7\u00e3o: Consumo indevido"),
    CODIGO_657(657, "Rejei\u00e7\u00e3o: C\u00f3digo do \u00d3rg\u00e3o diverge do \u00f3rg\u00e3o autorizador"),
    CODIGO_658(658, "Rejei\u00e7\u00e3o: UF do destinat\u00e1rio da Chave de Acesso diverge da UF autorizadora"),
    CODIGO_660(660, "Rejei\u00e7\u00e3o: CFOP de Combust\u00edvel e n\u00e3o informado grupo de combust\u00edvel da NF-e"),
    CODIGO_661(661, "Rejei\u00e7\u00e3o: NF-e j\u00e1 existente para o n\u00famero da DPEC informada"),
    CODIGO_662(662, "Rejei\u00e7\u00e3o: Numera\u00e7\u00e3o da DPEC est\u00e1 inutilizada na Base de Dados da SEFAZ"),
    CODIGO_663(663, "Rejei\u00e7\u00e3o: Al\u00edq. ICMS maior que 4% na sa\u00edda interestadual com produtos importados"),
    CODIGO_678(678, "Rejei\u00e7\u00e3o: NF referenciada com UF diferente da UF da NF-e complementar"),
    CODIGO_679(679, "Rejei\u00e7\u00e3o: Modelo da NF-e referenciada diferente de 55"),
    CODIGO_680(680, "Rejei\u00e7\u00e3o: Duplicidade de NF-e referenciada (chave de acesso ref mais de uma vez)"),
    CODIGO_681(681, "Rejei\u00e7\u00e3o: Duplicidade de NF Modelo 1 referenciada (CNPJ, Modelo S\u00e9rie e N\u00famero)"),
    CODIGO_682(682, "Rejei\u00e7\u00e3o: Duplicidade de NF de produtor referenciada (IE, Modelo, S\u00e9rie e N\u00famero)"),
    CODIGO_683(683, "Rejei\u00e7\u00e3o: Modelo do CT-e referenciado diferente de 57"),
    CODIGO_684(684, "Rejei\u00e7\u00e3o: Duplicidade de Cupom Fiscal referenciado (Modelo, N\u00famero e Ordem e COO)"),
    CODIGO_685(685, "Rejei\u00e7\u00e3o: Total do valor aproximado dos tributos difere do somat\u00f3rio dos itens"),
    CODIGO_686(686, "Rejei\u00e7\u00e3o: NF complementar referencia uma NF-e cancelada"),
    CODIGO_687(687, "Rejei\u00e7\u00e3o: NF complementar referencia uma NF-e denegada"),
    CODIGO_688(688, "Rejei\u00e7\u00e3o: NF referenciada de produtor com IE inexistente (nREF: xxx)"),
    CODIGO_689(689, "Rejei\u00e7\u00e3o: NF referenciada de produtor com IE n\u00e3o vinculada ao CNPJ/CPF informado (nREF: xxx)"),
    CODIGO_690(690, "Rejei\u00e7\u00e3o: Pedido de cancelamento para NF-e com CT-e ou MDF-e"),
    CODIGO_691(691, "Rejei\u00e7\u00e3o: Chave de Acesso da NFe diverge da Chave de Acesso do EPEC"),
    CODIGO_692(692, "Rejei\u00e7\u00e3o: Existe EPEC registrado para esta S\u00e9rie e N\u00famero"),
    CODIGO_693(693, "Rejei\u00e7\u00e3o: Al\u00edquota de ICMS superior a definida para a opera\u00e7\u00e3o interestadual"),
    CODIGO_694(694, "Rejei\u00e7\u00e3o: N\u00e3o informado o grupo de ICMS para a UF de destino"),
    CODIGO_695(695, "Rejei\u00e7\u00e3o: Informado indevidamente o grupo de ICMS para a UF de destino"),
    CODIGO_696(696, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o com n\u00e3o contribuinte deve indicar opera\u00e7\u00e3o com consumidor final"),
    CODIGO_697(697, "Rejei\u00e7\u00e3o: Al\u00edquota interestadual do ICMS com origem diferente do previsto"),
    CODIGO_698(698, "Rejei\u00e7\u00e3o: Al\u00edquota interestadual do ICMS incompat\u00edvel com as UF"),
    CODIGO_699(699, "Rejei\u00e7\u00e3o: Percentual do ICMS Interestadual para a UF de destino difere do previsto para o ano da Data de Emiss\u00e3o"),
    CODIGO_701(701, "Rejei\u00e7\u00e3o: NF-e n\u00e3o pode utilizar ver\u00e3o 3.00"),
    CODIGO_702(702, "Rejei\u00e7\u00e3o: NFC-e n\u00e3o \u00e9 aceita pela UF do Emitente"),
    CODIGO_703(703, "Rejei\u00e7\u00e3o: Data-hora de emiss\u00e3o posterior ao hor\u00e1rio de recebimento"),
    CODIGO_704(704, "Rejei\u00e7\u00e3o: NFC-e com data-hora de emiss\u00e3o atrasada"),
    CODIGO_705(705, "Rejei\u00e7\u00e3o: NFC-e com data de entrada/saida"),
    CODIGO_706(706, "Rejei\u00e7\u00e3o: NFC-e para opera\u00e7\u00e3o de entrada"),
    CODIGO_707(707, "Rejei\u00e7\u00e3o: NFC-e para opera\u00e7\u00e3o interestadual ou com o exterior"),
    CODIGO_708(708, "Rejei\u00e7\u00e3o: NFC-e nao pode referenciar um documento fiscal"),
    CODIGO_709(709, "Rejei\u00e7\u00e3o: NFC-e com formato de DANFE inv\u00e1lido"),
    CODIGO_710(710, "Rejei\u00e7\u00e3o: NF-e com formado de DANFE inv\u00e1lido"),
    CODIGO_711(711, "Rejei\u00e7\u00e3o: NF-e com conting\u00eancia off-line"),
    CODIGO_712(712, "Rejei\u00e7\u00e3o: NFC-e com conting\u00eancia off-line para a UF"),
    CODIGO_713(713, "Rejei\u00e7\u00e3o: Tipo de emiss\u00e3o diferente de 6 ou 7 para conting\u00eancia da SVC acessada"),
    CODIGO_714(714, "Rejei\u00e7\u00e3o: NFC-e com conting\u00eancia DPEC inexistente"),
    CODIGO_715(715, "Rejei\u00e7\u00e3o: NFC-e com finalidade inv\u00e1lida"),
    CODIGO_716(716, "Rejei\u00e7\u00e3o: NFC-e em opera\u00e7o\u00e3 n\u00e3o destinada a consumidor final"),
    CODIGO_717(717, "Rejei\u00e7\u00e3o: NFC-e em opera\u00e7\u00e3o n\u00e3o presencial"),
    CODIGO_718(718, "Rejei\u00e7\u00e3o: NFC-e n\u00e3o deve informar IE de substituto tribut\u00e1rio"),
    CODIGO_719(719, "Rejei\u00e7\u00e3o: NF-e sem identifica\u00e7\u00e3o do destinat\u00e1rio"),
    CODIGO_720(720, "Rejei\u00e7\u00e3o: Na opera\u00e7\u00e3o com exterior deve ser informada tag id Estrangeiro"),
    CODIGO_721(721, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o interestadual deve informar CNPJ ou CPF"),
    CODIGO_722(722, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o interna com idEstrangeiro informado deve ser presencial"),
    CODIGO_723(723, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o interna com idEstrangeiro informado deve ser para consumidor final"),
    CODIGO_724(724, "Rejei\u00e7\u00e3o: NF-e sem o nome do destinat\u00e1rio"),
    CODIGO_725(725, "Rejei\u00e7\u00e3o: NFC-e com CFOP inv\u00e1lido"),
    CODIGO_726(726, "Rejei\u00e7\u00e3o: NF-e sem a informa\u00e7\u00e3o de endere\u00e7o do destinat\u00e1rio"),
    CODIGO_727(727, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o com exterior e UF diferente de EX"),
    CODIGO_728(728, "Rejei\u00e7\u00e3o: NF-e sem informa\u00e7\u00e3o da IE do destinat\u00e1rio"),
    CODIGO_729(729, "Rejei\u00e7\u00e3o: NFC-e sem informa\u00e7\u00e3o da IE do destinat\u00e1rio"),
    CODIGO_730(730, "Rejei\u00e7\u00e3o: NFC-e com inscri\u00e7\u00e3o SUFRAMA"),
    CODIGO_731(731, "Rejei\u00e7\u00e3o: CFOP de opera\u00e7\u00e3o com exterior e idDest <> 3"),
    CODIGO_732(732, "Rejei\u00e7\u00e3o: CFOP de opera\u00e7\u00e3o com interestadual e idDest <> 2"),
    CODIGO_733(733, "Rejei\u00e7\u00e3o: CFOP de opera\u00e7\u00e3o interna e idDest <> 1"),
    CODIGO_734(734, "Rejei\u00e7\u00e3o: NFC-e com unidade de comercializa\u00e7\u00e3o inv\u00e1lida"),
    CODIGO_735(735, "Rejei\u00e7\u00e3o: NFC-e com unidade de tributa\u00e7\u00e3o inv\u00e1lida"),
    CODIGO_736(736, "Rejei\u00e7\u00e3o: NFC-e com grupo de ve\u00edculos novos"),
    CODIGO_737(737, "Rejei\u00e7\u00e3o: NFC-e com grupo de medicamentos"),
    CODIGO_738(738, "Rejei\u00e7\u00e3o: NFC-e com grupo de armamentos"),
    CODIGO_739(739, "Rejei\u00e7\u00e3o: NFC-e com grupo de combust\u00edveis"),
    CODIGO_740(740, "Rejei\u00e7\u00e3o: NFC-e com CST 51 - diferimento"),
    CODIGO_741(741, "Rejei\u00e7\u00e3o: NFC-e com partilha de CIMS entre UF"),
    CODIGO_742(742, "Rejei\u00e7\u00e3o: NFC-e com grupo do IPI"),
    CODIGO_743(743, "Rejei\u00e7\u00e3o: NFC-e com grupo do II"),
    CODIGO_745(745, "Rejei\u00e7\u00e3o: NF-e sem grupo do PIS"),
    CODIGO_746(746, "Rejei\u00e7\u00e3o: NFC-e com grupo do PIS-ST"),
    CODIGO_748(748, "Rejei\u00e7\u00e3o: NF-e sem grupo do COFINS"),
    CODIGO_749(749, "Rejei\u00e7\u00e3o: NF-e sem grupo do COFINS-ST"),
    CODIGO_750(750, "Rejei\u00e7\u00e3o: NFC-e com valor total superior ao permitido para destinat\u00e1rio n\u00e3o identificado (c\u00f3digo)"),
    CODIGO_751(751, "Rejei\u00e7\u00e3o: NFC-e com valor total superior ao permitido para destinat\u00e1rio n\u00e3o identificado (nome)"),
    CODIGO_752(752, "Rejei\u00e7\u00e3o: NFC-e com valor total superior ao permitido para destinat\u00e1rio n\u00e3o identificado (endere\u00e7o)"),
    CODIGO_753(753, "Rejei\u00e7\u00e3o: NFC-e sem frete"),
    CODIGO_754(754, "Rejei\u00e7\u00e3o: NFC-e com dados do transportador"),
    CODIGO_755(755, "Rejei\u00e7\u00e3o: NFC-e com dados de reten\u00e7\u00e3o do ICMS no transporte"),
    CODIGO_756(756, "Rejei\u00e7\u00e3o: NFC-e com dados do ve\u00edculo de transporte"),
    CODIGO_757(757, "Rejei\u00e7\u00e3o: NFC-e com dados de reboque do ve\u00edculo de transporte"),
    CODIGO_758(758, "Rejei\u00e7\u00e3o: NFC-e com dados do vag\u00e3o de transporte"),
    CODIGO_759(759, "Rejei\u00e7\u00e3o: NFC-e co dados da balsa de transporte"),
    CODIGO_760(760, "Rejei\u00e7\u00e3o: NFC-e com dados de cobran\u00e7a (fatura, duplicata)"),
    CODIGO_762(762, "Rejei\u00e7\u00e3o: NFC-e com dados de compra (empenho, pedido, contrato)"),
    CODIGO_763(763, "Rejei\u00e7\u00e3o: NFC-e com dados de aquisi\u00e7\u00e3od e cana"),
    CODIGO_765(765, "Rejei\u00e7\u00e3o: Lote s\u00f3 poder\u00e1 conter NF-e ou NFC-e"),
    CODIGO_766(766, "Rejei\u00e7\u00e3o: NFC-e com CST 50-suspen\u00e7\u00e3o"),
    CODIGO_767(767, "Rejei\u00e7\u00e3o: NFC-e com somat\u00f3rio dos pagamentos diferente do total da Nota Fiscal"),
    CODIGO_768(768, "Rejei\u00e7\u00e3o: NF-e n\u00e3o deve possuir o grupo de formas de pagamento"),
    CODIGO_769(769, "Rejei\u00e7\u00e3o: NFC-e deve possuir o grupo de formas de pagamento"),
    CODIGO_771(771, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o interestadual e UF de destino com EX"),
    CODIGO_772(772, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o interestadual e UF de destino igual \u00e0 UF do emitente"),
    CODIGO_773(773, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o interna e UF de destino difere da UF do emitente"),
    CODIGO_774(774, "Rejei\u00e7\u00e3o: NFC-e com indicador de item n\u00e3o participante do total"),
    CODIGO_775(775, "Rejei\u00e7\u00e3o: Modelo da NFC-e diferente de 65"),
    CODIGO_777(777, "Rejei\u00e7\u00e3o: NFC-e deve informar NCM completo"),
    CODIGO_778(778, "Rejei\u00e7\u00e3o: Informado NCM inexistente"),
    CODIGO_779(779, "Rejei\u00e7\u00e3o: NFC-e com NCM incompat\u00edvel"),
    CODIGO_780(780, "Rejei\u00e7\u00e3o: Total da NFC-e superior ao valor limite estabelecido pela SEFAZ"),
    CODIGO_781(781, "Rejei\u00e7\u00e3o: Emissor n\u00e3o habilitado para emiss\u00e3o de NFC-e"),
    CODIGO_782(782, "Rejei\u00e7\u00e3o: NFC-e n\u00e3o \u00e9 autorizada pelo SCAN"),
    CODIGO_783(783, "Rejei\u00e7\u00e3o: NFC-e n\u00e3o \u00e9 autorizada pelo SVC"),
    CODIGO_784(784, "Rejei\u00e7\u00e3o: NF-e com indicativo de NFC-e com entrega a domicilio"),
    CODIGO_785(785, "Rejei\u00e7\u00e3o: NFC-e com entrega a domicilio n\u00e3o permitida pela UF"),
    CODIGO_786(786, "Rejei\u00e7\u00e3o: NFC-e de entrega a domicilio sem dados dos transportador"),
    CODIGO_787(787, "Rejei\u00e7\u00e3o: NFC-e de entrega a domicilio sem a identifica\u00e7\u00e3o do destinat\u00e1rio"),
    CODIGO_788(788, "Rejei\u00e7\u00e3o: NFC-e de entrega a domic\u00edlio sem o endere\u00e7o do destinat\u00e1rio"),
    CODIGO_789(789, "Rejei\u00e7\u00e3o: NFC-e para destinat\u00e1rio contribuinte de ICMS"),
    CODIGO_790(790, "Rejei\u00e7\u00e3o: Opera\u00e7\u00e3o com exterior para destinat\u00e1rio contribuinte do ICMS"),
    CODIGO_791(791, "Rejei\u00e7\u00e3o: NF-e com indica\u00e7\u00e3o de destinat\u00e1rio isento de IE, com a informa\u00e7\u00e3o da IE do destinatario"),
    CODIGO_792(792, "Rejei\u00e7\u00e3o: Informada a IE do destinat\u00e1rio para opera\u00e7\u00e3o com destinat\u00e1rio do exterior"),
    CODIGO_793(793, "Rejei\u00e7\u00e3o: Valor do ICMS relativo ao Fundo de Combate \u00e0 Pobreza na UF de destino difere do calculado"),
    CODIGO_794(794, "Rejei\u00e7\u00e3o: NF-e com indicativo de NFC-e com entrega a domic\u00edlio"),
    CODIGO_795(795, "Rejei\u00e7\u00e3o: Total do ICMS Desonerado difere do somatorio dos itens"),
    CODIGO_796(796, "Rejei\u00e7\u00e3o: Empresa sem Chave de Seguran\u00e7a para o QR-Code"),
    CODIGO_798(798, "Rejei\u00e7\u00e3o: Valor total do ICMS relativo Fundo de Combate \u00e0 Pobreza (FCP) da UF de destino difere do somat\u00f3rio do valor dos itens"),
    CODIGO_799(799, "Rejei\u00e7\u00e3o: Valor total do ICMS Interestadual da UF de estino difere do somat\u00f3rio dos itens"),
    CODIGO_800(800, "Rejei\u00e7\u00e3o: Valor total do ICMS Interestadual da UF do remetente difere do somat\u00f3rio dos itens"),
    CODIGO_999(999, "Rejei\u00e7\u00e3o: Erro n\u00e3o catalogado"),
    CODIGO_9302(9302, "CNPJ Inv\u00e1lido (Zeros, nulo, DV)");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFTipo {

    ENTRADA("0", "Entrada"),
    SAIDA("1", "Sa\u00edda");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFTipoEmissao {

    EMISSAO_NORMAL("1", "Normal"),
    CONTINGENCIA_FS_IA("2", "Conting\u00eancia FS"),
    CONTINGENCIA_SCAN("3", "Conting\u00eancia SCAN"),
    CONTINGENCIA_DPEC("4", "Conting\u00eancia DPEC"),
    CONTINGENCIA_FSDA("5", "Conting\u00eancia FSDA"),
    CONTINGENCIA_SVCAN("6", "Conting\u00eancia SVCAN"),
    CONTINGENCIA_SVCRS("7", "Conting\u00eancia SVCRS"),
    CONTIGENCIA_OFFLINE("9", "Contig\u00eancia offline NFC-e");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFTipoImpressao {

    SEM_GERACAO_DANFE("0", "Sem gera\u00e7\u00e3o de DANFe"),
    DANFE_NORMAL_RETRATO("1", "DANFe normal retrato"),
    DANFE_NORMAL_PAISAGEM("2", "DANFe normal paisagem"),
    DANFE_SIMPLIFICADO("3", "DANFe simplificado"),
    DANFE_NFCE("4", "DANFe NFCe"),
    DANFE_NFCE_MENSAGEM_ELETRONICA("5", "DANFe NFCe mensagem eletr\u00f4nica");

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFUnidadeFederativa {

    AC("AC", "Acre", "12", "http://hml.sefaznet.ac.gov.br/nfce/qrcode", "http://hml.sefaznet.ac.gov.br/nfce/qrcode"),
    AL("AL", "Alagoas", "27"),
    AP("AP", "Amap\u00E1", "16", "https://www.sefaz.ap.gov.br/nfcehml/nfce.php", "https://www.sefaz.ap.gov.br/nfce/nfce.php"),
    AM("AM", "Amazonas", "13", "http://homnfce.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp", "http://sistemas.sefaz.am.gov.br/nfceweb/consultarNFCe.jsp"),
    BA("BA", "Bahia", "29", "http://hnfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx", "http://nfe.sefaz.ba.gov.br/servicos/nfce/modulos/geral/NFCEC_consulta_chave_acesso.aspx"),
    CE("CE", "Cear\u00E1", "23"),
    DF("DF", "Distrito Federal", "53", "http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx", "http://dec.fazenda.df.gov.br/ConsultarNFCe.aspx"),
    GO("GO", "Goi\u00E1s", "52", "http://homolog.sefaz.go.gov.br/nfeweb/jsp/ConsultaDANFENFCe.jsf", "http://nfe.sefaz.go.gov.br/nfeweb/jsp/ConsultaDANFENFCe.jsf"),
    ES("ES", "Esp\u00EDrito Santo", "32"),
    MA("MA", "Maranh\u00E3o", "21"),
    MT("MT", "Mato Grosso", "51", "http://homologacao.sefaz.mt.gov.br/nfce/consultanfce", "http://www.sefaz.mt.gov.br/nfce/consultanfce"),
    MS("MS", "Mato Grosso do Sul", "50"),
    MG("MG", "Minas Gerais", "31"),
    PA("PA", "Par\u00E1", "15", "https://appnfc.sefa.pa.gov.br/portal-homologacao/view/consultas/nfce/nfceForm.seam", "https://appnfc.sefa.pa.gov.br/portal/view/consultas/nfce/nfceForm.seam"),
    PB("PB", "Paraiba", "25", "www.receita.pb.gov.br/nfcehom", "www.receita.pb.gov.br/nfce"),
    PR("PR", "Paran\u00E1", "41", "http://www.dfeportal.fazenda.pr.gov.br/dfe-portal/rest/servico/consultaNFCe", "http://www.dfeportal.fazenda.pr.gov.br/dfe-portal/rest/servico/consultaNFCe"),
    PE("PE", "Pernambuco", "26", "http://nfcehomolog.sefaz.pe.gov.br/nfce-web/consultarNFCe", "http://nfce.sefaz.pe.gov.br/nfce-web/consultarNFCe"),
    PI("PI", "Piau\u00ED", "22", "http://webas.sefaz.pi.gov.br/nfceweb-homologacao/consultarNFCe.jsf", "http://webas.sefaz.pi.gov.br/nfceweb/consultarNFCe.jsf"),
    RJ("RJ", "Rio de Janeiro", "33", "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode", "http://www4.fazenda.rj.gov.br/consultaNFCe/QRCode?"),
    RN("RN", "Rio Grande do Norte", "24", "http://hom.nfce.set.rn.gov.br/consultarNFCe.aspx", "http://nfce.set.rn.gov.br/consultarNFCe.aspx"),
    RS("RS", "Rio Grande do Sul", "43", "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx", "https://www.sefaz.rs.gov.br/NFCE/NFCE-COM.aspx"),
    RO("RO", "Rond\u00F4nia", "11", "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp", "http://www.nfce.sefin.ro.gov.br/consultanfce/consulta.jsp"),
    RR("RR", "Roraima", "14", "http://200.174.88.103:8080/nfce/servlet/qrcode", "https://www.sefaz.rr.gov.br/nfce/servlet/qrcode"),
    SP("SP", "S\u00E3o Paulo", "35", "https://www.homologacao.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx", "https://www.nfce.fazenda.sp.gov.br/NFCeConsultaPublica/Paginas/ConsultaQRCode.aspx"),
    SC("SC", "Santa Catarina", "42"),
    SE("SE", "Sergipe", "28", "http://www.hom.nfe.se.gov.br/portal/consultarNFCe.jsp", "http://www.nfce.se.gov.br/portal/consultarNFCe.jsp"),
    TO("TO", "Tocantins", "17"),
    NACIONAL("NC", "Nacional", "90"),
    RFB("RFB", "RFB", "91"),
    EX("EX", "Exterior", "99");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFFormaImportacaoIntermediacao {

    IMPORTACAO_CONTA_PROPRIA("1", "Importa\u00e7\u00e3o conta pr\u00f3pria"),
    IMPORTACAO_CONTA_ORDEM("2", "Importa\u00e7\u00e3o conta ordem"),
    IMPORTACAO_ENCOMENDA("3", "Importa\u00e7\u00e3o encomenda");

//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFFormaPagamentoMoeda {

    DINHEIRO("01", "Dinheiro"),
    CHEQUE("02", "Cheque"),
    CARTAO_CREDITO("03", "Cart\u00e3o de cr\u00e9dito"),
    CARTAO_DEBITO("04", "Cart\u00e3o de d\u00e9bito"),
    CARTAO_LOJA("05", "Cart\u00e3o da loja"),
    VALE_ALIMENTACAO("10", "Vale alimenta\u00e7\u00e3o"),
    VALE_REFEICAO("11", "Vale refei\u00e7\u00e3o"),
    VALE_PRESENTE("12", "Vale presente"),
    VALE_COMBUSTIVEL("13", "Vale combust\u00edvel"),
    OUTRO("99", "Outro");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFIdentificadorLocalDestinoOperacao {

    OPERACAO_INTERNA("1", "Opera\u00e7\u00e3o interna"),
    OPERACAO_INTERESTADUAL("2", "Opera\u00e7\u00e3o interestadual"),
    OPERACAO_COM_EXTERIOR("3", "Opera\u00e7\u00e3o com o exterior");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFIndicadorIEDestinatario {

    CONTRIBUINTE_ICMS("1", "Contribuinte ICMS"),
    CONTRIBUINTE_ISENTO_INSCRICAO_CONTRIBUINTES_ICMS("2", "Contribuinte isento inscri\u00e7\u00e3o contribuintes ICMS"),
    NAO_CONTRIBUINTE("9", "N\u00e3o contribuinte");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFIndicadorPresencaComprador {

    NAO_APLICA("0", "N\u00e3o se aplica"),
    OPERACAO_PRESENCIAL("1", "Opera\u00e7\u00e3o presencial"),
    OPERACAO_NAO_PRESENCIAL_INTERNET("2", "Opera\u00e7\u00e3o n\u00e3o presencial - Internet"),
    OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO("3", "Opera\u00e7\u00e3o n\u00e3o presencial - Teleatendimento"),
    NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO("4", "NFC-e em opera\u00e7\u00e3o com entrega a domic\u00edlio"),
    OPERACAO_NAO_PRESENCIAL_OUTROS("9", "Opera\u00e7\u00e3o n\u00e3o presencial - Outros");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');


public enum NFNotaInfoRegimeEspecialTributacao {

    MICROEMPRESA_MUNICIPAL("1", "Microempresa municipal"),
    ESTIMATIVA("2", "Estimativa"),
    SOCIEDADE_PROFISSIONAIS("3", "Sociedade profissionais"),
    COOPERATIVA("4", "Cooperativa"),
    MICROEMPRESARIO_INDIVIDUAL_MEI("5", "Microempres\u00e1rio individual MEI"),
    MICROEMPRESARIO_E_EMPRESA_PEQUENOPORTE("6", "Microempres\u00e1rio e empresa de pequeno porte");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFOperacaoConsumidorFinal {

    NAO("0", "N\u00e3o"),
    SIM("1", "Sim");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFOperadoraCartao {

    VISA("01", "Visa"),
    MASTERCARD("02", "Mastercard"),
    AMERICAN_EXPRESS("03", "American Express"),
    SOROCRED("04", "Sorocred"),
    OUTROS("99", "Outros");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFTipoIntegracaoPagamento {

    INTEGRADO("1", "Integrado"),
    SEPARADO("2", "Separado");

	//===============
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user)
    VALUES (1001,'TIPO NOTA FISCAL', 'TIPO NOTA FISCAL', 1477075035443, 'System');

public enum NFViaTransporteInternacional {

    MARITIMA("1", "Mar\u00edtima"),
    FLUVIAL("2", "Fluvial"),
    LACUSTRE("3", "Lacustre"),
    AEREA("4", "A\u00e9rea"),
    POSTAL("5", "Postal"),
    FERROVIARIA("6", "Ferrovi\u00e1ria"),
    RODOVIARIA("7", "Rodovi\u00e1ria"),
    CONDUTO_REDE_TRANSMISSAO("8", "Conduto rede transmiss\u00e3o"),
    MEIOS_PROPRIOS("9", "Meios pr\u00f3prios"),
    ENTRADA_SAIDA("10", "Entrada/Sa\u00edda"),
    COURIER("11", "Courier"),
    HANDCARRY("12", "Handcarry");

function NFProdutoCompoeValorNota() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});

    NAO("0", "N\u00e3o"),
    SIM("1", "Sim");

    private final String codigo;
    private final String descricao;

	return a;
 };

     public enum NFViaTransporteInternacional {

    MARITIMA("1", "Mar\u00edtima"),
    FLUVIAL("2", "Fluvial"),
    LACUSTRE("3", "Lacustre"),
    AEREA("4", "A\u00e9rea"),
    POSTAL("5", "Postal"),
    FERROVIARIA("6", "Ferrovi\u00e1ria"),
    RODOVIARIA("7", "Rodovi\u00e1ria"),
    CONDUTO_REDE_TRANSMISSAO("8", "Conduto rede transmiss\u00e3o"),
    MEIOS_PROPRIOS("9", "Meios pr\u00f3prios"),
    ENTRADA_SAIDA("10", "Entrada/Sa\u00edda"),
    COURIER("11", "Courier"),
    HANDCARRY("12", "Handcarry");


public enum NFFormaImportacaoIntermediacao {

    IMPORTACAO_CONTA_PROPRIA("1", "Importa\u00e7\u00e3o conta pr\u00f3pria"),
    IMPORTACAO_CONTA_ORDEM("2", "Importa\u00e7\u00e3o conta ordem"),
    IMPORTACAO_ENCOMENDA("3", "Importa\u00e7\u00e3o encomenda");



function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoCombustivelTipo {

    ALCOOL("01", "\u00c1lcool"),
    GASOLINA("02", "Gasolina"),
    DIESEL("03", "Diesel"),
    GASOGENIO("04", "Gasog\u00eanio"),
    GAS_METANO("05", "G\u00e1s metano"),
    ELETRICO_FONTE_INTERNA("06", "El\u00e9trico (fonte interna)"),
    ELETRICO_FONTE_EXTERNA("07", "El\u00e9trico (fonte externa)"),
    GASOL_GAS_NATURAL_COMBUSTIVEL("08", "Gasol/G\u00e1s natural/Combust\u00edvel"),
    ALCOOL_GAS_NATURAL("09", "\u00c1lcool/G\u00e1s natural"),
    DIESEL_GAS_NATURAL("10", "Diesel/G\u00e1s natural"),
    VIDE_CAMPO_OBSERVACAO("11", "Vide campo observa\u00e7\u00e3o"),
    ALCOOL_GAS_NATURAL_VEICULAR("12", "\u00c1lcool/G\u00e1s natural veicular"),
    GASOLINA_GAS_NATURAL_VEICULAR("13", "Gasolina/G\u00e1s natural veicular"),
    DIESEL_GAS_NATURAL_VEICULAR("14", "Diesel/G\u00e1s natural veicular"),
    GAS_NATURAL_VEICULAR("15", "G\u00e1s natural veicular"),
    ALCOOL_GASOLINA("16", "\u00c1lcool/Gasolina"),
    GASOLINA_ALCOOL_GAS_NATURAL("17", "Gasolina/\u00c1lcool/G\u00e1s natural"),
    GASOLINA_ELETRICO("18", "Gasolina/El\u00e9trico");



function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});

    public enum NFNotaInfoTipoVeiculo {

    AUTOMOVEL("06", "Autom\u00f3vel"),
    CAMINHAO("14", "Caminh\u00e3o"),
    CAMINHONETA("13", "Caminhoneta"),
    CARGA_CAM("24", "Carga"),
    CICLOMOTO("02", "Ciclomotor"),
    ESP_ONIBUS("22", "Especial \u00d4nibus"),
    MICROONIBUS("07", "Micro\u00f4nibus"),
    MISTO_CAM("23", "Misto"),
    MOTOCICLO("04", "Motociclo"),
    MOTONETA("03", "Motoneta"),
    ONIBUS("08", "\u00d4nibus"),
    REBOQUE("10", "Reboque"),
    TRICICLO("05", "Triciclo"),
    TRATOR("17", "Trator");


function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
public enum NFNotaInfoEspecieVeiculo {

    PASSAGEIRO("1", "Passageiro"),
    CARGA("2", "Carga"),
    MISTO("3", "Misto"),
    CORRIDA("4", "Corrida"),
    TRACAO("5", "Tra\u00e7\u00e3o"),
    ESPECIAL("6", "Especial"),
    COLECAO("7", "Cole\u00e7\u00e3o");

function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
public enum NFNotaInfoItemProdutoVeiculoCondicaoChassi {

    NORMAL("N", "Normal"),
    REMARCADO("R", "Remarcado");

function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoItemProdutoVeiculoCondicao {

    ACABADO("1", "Acabado"),
    INACABADO("2", "Inacabado"),
    SEMI_ACABADO("3", "Semi-acabado");


function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoVeiculoCor {

    AMARELA("01", "Amarela"),
    AZUL("02", "Azul"),
    BEGE("03", "Bege"),
    BRANCA("04", "Branca"),
    CINZA("05", "Cinza"),
    DOURADA("06", "Dourada"),
    GRENA("07", "Gren\u00e1"),
    LARANJA("08", "Laranja"),
    MARROM("09", "Marrom"),
    PRATA("10", "Prata"),
    PRETA("11", "Preta"),
    ROSA("12", "Rosa"),
    ROXA("13", "Roxa"),
    VERDE("14", "Verde"),
    VERMELHA("15", "Vermelha"),
    FANTASIA("16", "Fantasia");


function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoItemProdutoVeiculoRestricao {

    NAO_HA("0", "N\u00e3o h\u00e1"),
    ALIENACAO_FIDUCIARIA("1", "Aliena\u00e7\u00e3o fiduci\u00e1ria"),
    ARRENDAMENTO_MERCANTIL("2", "Arrendamento mercantil"),
    RESERVA_DOMINIO("3", "Reserva dom\u00ednio"),
    PENHOR("4", "Penhor"),
    OUTRAS("9", "Outras");



    function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoItemProdutoArmamentoTipo {

    PERMITIDO("0", "Permitido"),
    RESTRITO("1", "Restrito");


    function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFOrigem {

    NACIONAL("0", "Nacional"),
    ESTRANGEIRA_IMPORTACAO_DIRETA("1", "Estrangeira importa\u00e7\u00e3o direta"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO("2", "Estrangeira adquirida mercado interno"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_SUPERIOR_40_P("3", "Nacional mercadoria ou bem conte\u00fado importa\u00e7\u00e3o superior 40 P"),
    NACIONAL_PRODUCAO_EM_CONFORMIDADE_COM_PROCESSOS_PRODUTIVOS_BASICOS("4", "Nacional produ\u00e7\u00e3o em conformidade com processos produtivos b\u00e1sicos"),
    NACIONAL_MERCADORIA_OU_BEM_CONTEUDO_IMPORTACAO_INFERIOR_40_P("5", "Nacional mercadoria ou bem conte\u00fado importa\u00e7\u00e3o inferior 40 P"),
    ESTRANGEIRA_IMPORTACAO_DIRETA_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("6", "Estrangeira importa\u00e7\u00e3o direta sem similar nacional constante em lista Camex"),
    ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO_SEM_SIMILAR_NACIONAL_CONSTANTE_EM_LISTA_CAMEX("7", "Estrangeira adquirida mercado interno sem similar nacional constante em lista Camex"),
    NACIONAL_MERCADORIA_OU_BEM_COM_CONTEUDO_IMPORTACAO_SUPERIOR_70_P("8", "Nacional mercadoria ou bem conte\u00fado importa\u00e7\u00e3o superior 70 P");



function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoImpostoTributacaoICMS {

    TRIBUTACAO_INTEGRALMENTE("00", "Tributada integralmente"),
    TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("10", "Tributada com cobran\u00e7a de ICMS por ST"),
    COM_REDUCAO_BASE_CALCULO("20", "Com redu\u00e7\u00e3o da base de c\u00e1lculo"),
    ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA("30", "Isenta ou n\u00e3o tributada com cobran\u00e7a de ICMS por ST"),
    ISENTA("40", "Isenta"),
    NAO_TRIBUTADO("41", "N\u00e3o tributada"),
    SUSPENSAO("50", "Suspens\u00e3o"),
    DIFERIMENTO("51", "Diferimento"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA("60", "ICMS cobrado anteriormente por ST"),
    COM_REDUCAO_BASE_CALCULO_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA_ICMS_SUBSTITUICAO_TRIBUTARIA("70", "Com redu\u00e7\u00e3o da base de c\u00e1lculo/Cobran\u00e7a ICMS por ST/ICMS ST"),
    OUTROS("90", "Outros");


function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoItemModalidadeBCICMS {

    MVA("0", "Margem de valor agregado"),
    PAUTA("1", "Pauta"),
    PRECO_TABELADO_MAXIMO("2", "Pre\u00e7o tabelado m\u00e1ximo"),
    VALOR_OPERACAO("3", "Valor da opera\u00e7\u00e3o");


    function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoItemModalidadeBCICMSST {

    PRECO_TABELADO("0", "Pre\u00e7o Tabelado"),
    LISTA_NEGATIVA("1", "Lista Negativa"),
    LISTA_POSITIVA("2", "Lista Positiva"),
    LISTA_NEUTRA("3", "Lista Neutra"),
    MARGEM_VALOR_AGREGADO("4", "Margem Valor Agregado"),
    PAUTA("5", "Pauta");


function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaMotivoDesoneracaoICMS {

    TAXI("1", "T\u00e1xi"),
    PRODUTOR_AGROPECUARIO("3", "Produtor agropecu\u00e1rio"),
    FROTISTA_LOCADORA("4", "Frotista locadora"),
    DIPLOMATICO_CONSULAR("5", "Diplom\u00e1tico consular"),
    UTILITARIOS_MOTOCICLETAS_AMAZONIA_OCIDENTAL_AREAS_LIVRE_COMERCIO("6", "Utilit\u00e1rios motocicletas Amaz\u00f4nia Ocidental \u00e1reas livre com\u00e9rcio"),
    SUFRAMA("7", "Suframa"),
    VENDA_ORGAOS_PUBLICOS("8", "Venda \u00f3rg\u00e3os p\u00fablicos"),
    OUTROS("9", "Outros"),
    DEFICIENTE_CONDUTOR("10", "Deficiente condutor"),
    DEFICIENTE_NAO_CONDUTOR("11", "Deficiente n\u00e3o condutor"),
    ORGAO_DE_FOMENTO_DESENVOLVIMENTO_AGROPECUARIO("12", "\u00d5rg\u00e3o de fomento desenvolvimento agropecu\u00e1rio");



function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
	public enum NFNotaSituacaoOperacionalSimplesNacional {

    TRIBUTADA_COM_PERMISSAO_CREDITO("101", "Tributada com permiss\u00e3o de cr\u00e9dito"),
    TRIBUTADA_SEM_PERMISSAO_CREDITO("102", "Tributada sem permiss\u00e3o de cr\u00e9dito"),
    ISENCAO_ICMS_FAIXA_RECEITA_BRUTA("103", "Isen\u00e7\u00e3o ICMS faixa receita bruta"),
    TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("201", "Tributada Simples Nacional com permiss\u00e3o de cr\u00e9dito e cobran\u00e7a ICMS ST"),
    TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("202", "Tributada Simples Nacional sem permiss\u00e3o de cr\u00e9dito e cobran\u00e7a ICMS ST"),
    TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("203", "Tributada Simples Nacional para faixa receita bruta e cobran\u00e7a ICMS ST"),
    IMUNE("300", "Imune"),
    NAO_TRIBUTADA("400", "N\u00e3o tributada"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO("500", "ICMS cobrado anteriormente por ST subs\u00eddio ou por antecipa\u00e7\u00e3o"),
    OUTROS("900", "Outros");



function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoSituacaoTributariaIPI {

    ENTRADA_RECUPERACAO_CREDITO("00", "Entrada recupera\u00e7\u00e3o cr\u00e9dito"),
    ENTRADA_TRIBUTADA_ALIQUOTA_ZERO("01", "Entrada tributada al\u00edquota zero"),
    ENTRADA_ISENTA("02", "Entrada isenta"),
    ENTRADA_NAO_TRIBUTADA("03", "Entrada n\u00e3o tributada"),
    ENTRADA_IMUNE("04", "Entrada imune"),
    ENTRADA_COM_SUSPENSAO("05", "Entrada com suspens\u00e3o"),
    OUTRAS_ENTRADAS("49", "Outras entradas"),
    SAIDA_TRIBUTADA("50", "Sa\u00edda tributada"),
    SAIDA_TRIBUTADA_COM_ALIQUOTA_ZERO("51", "Sa\u00edda tributada com al\u00edquota zero"),
    SAIDA_ISENTA("52", "Sa\u00edda isenta"),
    SAIDA_NAO_TRIBUTADA("53", "Sa\u00edda n\u00e3o tributada"),
    SAIDA_IMUNE("54", "Sa\u00edda imune"),
    SAIDA_COM_SUSPENSAO("55", "Sa\u00edda com suspens\u00e3o"),
    OUTRAS_SAIDAS("99", "Outras sa\u00eddas");


function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoItemIndicadorExigibilidadeISS {

    EXIGIVEL("1", "Exig\u00edvel"),
    NAO_INCIDENCIA("2", "N\u00e3o incid\u00eancia"),
    ISENCAO("3", "Isen\u00e7\u00e3o"),
    EXPORTACAO("4", "Exporta\u00e7\u00e3o"),
    IMUNIDADE("5", "Imunidade"),
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6", "Exigibilidade suspensa por decis\u00e3o judicial"),
    EXIGIBILIDADE_SUSPENSA_POR_PROCESSO_ADMINISTRATIVO("7", "Exigibilidade suspensa por processo administrativo");

function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoItemIndicadorIncentivoFiscal {

    SIM("1", "Sim"),
    NAO("2", "N\u00e3o");

function NFNotaInfo() {
    var a = [];
    a.push({field: {campo: "id",tipo: "Integer",requerid: true,primaryKey: true,forenkey: false,model: true,xml: true}});
    public enum NFNotaInfoSituacaoTributariaCOFINS {

    OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO("01", "Opera\u00e7\u00e3o tribut\u00e1vel cumulativo/n\u00e3o cumulativo"),
    OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA("02", "Opera\u00e7\u00e3o tribut\u00e1vel al\u00edquota diferenciada"),
    OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO("03", "Opera\u00e7\u00e3o tribut\u00e1vel quantidade vendida por al\u00edquota por unidade produto"),
    OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO("04", "Opera\u00e7\u00e3o tribut\u00e1vel monof\u00e1sica al\u00edquota zero"),
    OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA("05", "Opera\u00e7\u00e3o tribut\u00e1vel ST"),
    OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO("06", "Opera\u00e7\u00e3o tribut\u00e1vel al\u00edquota zero"),
    OPERACAO_ISENTA_CONTRIBUICAO("07", "Opera\u00e7\u00e3o isenta de contribui\u00e7\u00e3o"),
    OPERACAO_SEM_INCIDENCIA_CONTRIBUICAO("08", "Opera\u00e7\u00e3o sem incid\u00eancia de contribui\u00e7\u00e3o"),
    OPERACAO_COM_SUSPENSAO_CONTRIBUICAO("09", "Opera\u00e7\u00e3o com suspens\u00e3o de contribui\u00e7\u00e3o"),
    OUTRAS_OPERACOES_SAIDA("49", "Outras opera\u00e7\u00f5es de sa\u00edda"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO("50", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("51", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita n\u00e3o tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO("52", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita exporta\u00e7\u00e3o"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO("53", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributada e n\u00e3o tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_NO_MERCADO_INTERNO_EXPORTACAO("54", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributadas no mercado interno exporta\u00e7\u00e3o"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_NAO_TRIBUTADA_NO_MERCADO_INTERNO_EXPORTACAO("55", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas n\u00e3o tributada no mercado interno exporta\u00e7\u00e3o"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("56", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributadas e n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO("60", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente receita tributada mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("61", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente \u00e0 receita n\u00e3o tributada mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO("62", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente receita exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO("63", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADA_MERCADO_INTERNO_EXPORTACAO("64", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("65", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("66", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas e n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OUTRAS_OPERACOES("67", "Cr\u00e9dito presumido outras opera\u00e7\u00f5es"),
    OPERACAO_AQUISICAO_SEM_DIREITO_CREDITO("70", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o sem direito cr\u00e9dito"),
    OPERACAO_AQUISICAO_COM_ISENCAO("71", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o com isen\u00e7\u00e3o"),
    OPERACAO_AQUISICAO_COM_SUSPENSAO("72", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o com suspens\u00e3o"),
    OPERACAO_AQUISICAO_ALIQUOTA_ZERO("73", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o al\u00edquota zero"),
    OPERACAO_AQUISICAO_SEM_INCIDENCIA_CONTRIBUICAO("74", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o sem incid\u00eancia de contribui\u00e7\u00e3o"),
    OPERACAO_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA("75", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o por substitui\u00e7\u00e3o tribut\u00e1ria"),
    OUTRAS_OPERACOES_ENTRADA("98", "Outras opera\u00e7\u00f5es de entrada"),
    OUTRAS_OPERACOES("99", "Outras opera\u00e7\u00f5es");



    INSERT INTO pagina(id ,pagina,parentid, tabelaenumvalue, create_date, create_user)
    VALUES (3,'Advocacia', 0, 100, 1477075035443, 'System');

INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user,pagina)
    VALUES (154,'TIPO OAB', 'TIPO OAB', 1477075035443, 'System',3);
INSERT INTO doisvalortype(id,tipo, descricao,  create_date, create_user,pagina)
    VALUES (155,'ORGAO', 'ORGAO', 1477075035443, 'System',3);

INSERT INTO doisvalor(value,nome, descricao, doisvalortype, pagina,create_date, create_user )
    VALUES

('1', 'Definitivo','Definitivo',154,3, 1477075035443, 'System'),
('2', 'Estagiário','Estagiário',154,3, 1477075035443, 'System'),
('3', 'Suplementar','Suplementar',154,3, 1477075035443, 'System'),
('4', 'Transferência','Transferência',154,3, 1477075035443, 'System');

