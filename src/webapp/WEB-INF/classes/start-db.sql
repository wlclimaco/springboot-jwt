insert into pessoa (id, data_cadastro, nome, cpf) VALUES (nextval('pessoa_id_seq'), now(),'Pessoa 1', '16047094910');
insert into pessoa (id, data_cadastro, nome, cpf) VALUES (nextval('pessoa_id_seq'), now(),'Pessoa 2', '56023704949');
insert into pessoa (id, data_cadastro, nome, cpf) VALUES (nextval('pessoa_id_seq'), now(),'Pessoa 3', '42047094918');
insert into pessoa (id, data_cadastro, nome, cpf) VALUES (nextval('pessoa_id_seq'), now(),'Pessoa 4', '81047094912');
insert into pessoa (id, data_cadastro, nome, cpf) VALUES (nextval('pessoa_id_seq'), now(),'Pessoa 5', '06247094914');


INSERT INTO cnae(codigo, cnae, descricao, abreviado, parentid, tabelaenumvalue, emprid, processid, create_date, create_user)
    VALUES 
('01.11-2','Cultivo de cereais para gr�os','','',null,999999,1,0,1469492499626,'system'),

('01.12-0','Cultivo de algod�o herb�ceo','','',null,999999,1,0,1469492499626,'system'),

('01.13-9','Cultivo de cana-de a��car','','',null,999999,1,0,1469492499626,'system'),

('01.14-7','Cultivo de fumo','','',null,999999,1,0,1469492499626,'system'),

('01.15-5','Cultivo de soja','','',null,999999,1,0,1469492499626,'system'),

('01.19-8','Cultivo de outros produtos de lavoura tempor�ria','','',null,999999,1,0,1469492499626,'system'),

('01.21-0','Cultivo de hortali�as, legumes e outros produtos da horticultura','','',null,999999,1,0,1469492499626,'system'),

('01.22-8','Cultivo de flores, plantas ornamentais e produtos de viveiro','','',null,999999,1,0,1469492499626,'system'),

('01.31-7','Cultivo de frutas c�tricas','','',null,999999,1,0,1469492499626,'system'),

('01.32-5','Cultivo de caf�','','',null,999999,1,0,1469492499626,'system'),

('01.33-3','Cultivo de cacau','','',null,999999,1,0,1469492499626,'system'),

('01.34-1','Cultivo de uva','','',null,999999,1,0,1469492499626,'system'),

('01.39-2','Cultivo de outros produtos de lavoura permanente','','',null,999999,1,0,1469492499626,'system'),

('01.41-4','Cria��o de bovinos','','',null,999999,1,0,1469492499626,'system'),

('01.42-2','Cria��o de outros animais de grande porte','','',null,999999,1,0,1469492499626,'system'),

('01.43-0','Cria��o de ovinos','','',null,999999,1,0,1469492499626,'system'),

('01.44-9','Cria��o de su�nos','','',null,999999,1,0,1469492499626,'system'),

('01.45-7','Cria��o de aves','','',null,999999,1,0,1469492499626,'system'),

('01.46-5','Cria��o de outros animais','','',null,999999,1,0,1469492499626,'system'),

('01.50-3','Produ��o mista: lavoura e pecu�ria','','',null,999999,1,0,1469492499626,'system'),

('01.61-9','Atividades de servi�os relacionados com a agricultura','','',null,999999,1,0,1469492499626,'system'),

('01.62-7','Atividades de servi�os relacionados com a pecu�ria, exceto atividades veterin�rias','','',null,999999,1,0,1469492499626,'system'),

('01.70-8','Ca�a, repovoamento cineg�tico e atividades dos servi�os relacionados','','',null,999999,1,0,1469492499626,'system'),

('02.11-9','Silvicultura','','',null,999999,1,0,1469492499626,'system'),

('02.12-7','Explora��o florestal','','',null,999999,1,0,1469492499626,'system'),

('02.13-5','Atividades dos servi�os relacionados com a silvicultura e a explora��o florestal','','',null,999999,1,0,1469492499626,'system'),

('05.11-8','Pesca e servi�os relacionados','','',null,999999,1,0,1469492499626,'system'),

('05.12-6','Aq�icultura e servi�os relacionados','','',null,999999,1,0,1469492499626,'system'),

('10.00-6','Extra��o de carv�o mineral','','',null,999999,1,0,1469492499626,'system'),

('11.10-0','Extra��o de petr�leo e g�s natura','','',null,999999,1,0,1469492499626,'system'),

('11.20-7','Servi�os relacionados com a extra��o de petr�leo e g�s - exceto a prospec��o realizada por terceiros','','',null,999999,1,0,1469492499626,'system'),

('13.10-2','Extra��o de min�rio de ferro','','',null,999999,1,0,1469492499626,'system'),

('13.21-8','Extra��o de min�rio de alum�nio','','',null,999999,1,0,1469492499626,'system'),

('13.22-6','Extra��o de min�rio de estanho','','',null,999999,1,0,1469492499626,'system'),

('13.23-4','Extra��o de min�rio de mangan�s','','',null,999999,1,0,1469492499626,'system'),

('13.24-2','Extra��o de min�rio de metais preciosos','','',null,999999,1,0,1469492499626,'system'),

('13.25-0','Extra��o de minerais radioativos','','',null,999999,1,0,1469492499626,'system'),

('13.29-3','Extra��o de outros minerais met�licos Não-ferrosos','','',null,999999,1,0,1469492499626,'system'),

('14.10-9','Extra��o de pedra, areia e argila','','',null,999999,1,0,1469492499626,'system'),

('14.21-4','Extra��o de minerais para fabrica��o de adubos, fertilizantes e produtos qu�micos','','',null,999999,1,0,1469492499626,'system'),

('14.22-2','Extra��o e refino de sal marinho e sal-gema','','',null,999999,1,0,1469492499626,'system'),

('14.29-0','Extra��o de outros minerais Não-met�licos','','',null,999999,1,0,1469492499626,'system'),

('15.11-3','Abate de reses, prepara��o de produtos de carne','','',null,999999,1,0,1469492499626,'system'),

('15.12-1','Abate de aves e outros pequenos animais e prepara��o de produtos de carne','','',null,999999,1,0,1469492499626,'system'),

('15.13-0','Prepara��o de carne, banha e produtos de salsicharia Não associadas ao abate','','',null,999999,1,0,1469492499626,'system'),

('15.14-8','Prepara��o e preserva��o do pescado e fabrica��o de conservas de peixes, crust�ceos e moluscos','','',null,999999,1,0,1469492499626,'system'),

('15.21-0','Processamento, preserva��o e produ��o de conservas de frutas','','',null,999999,1,0,1469492499626,'system'),

('15.22-9','Processamento, preserva��o e produ��o de conservas de legumes e outros vegetais','','',null,999999,1,0,1469492499626,'system'),

('15.23-7','Produ��o de sucos de frutas e de legumes','','',null,999999,1,0,1469492499626,'system'),

('15.31-8','Produ��o de �leos vegetais em bruto','','',null,999999,1,0,1469492499626,'system'),

('15.32-6','Refino de �leos vegetais','','',null,999999,1,0,1469492499626,'system'),

('15.33-4','Prepara��o de margarina e outras gorduras vegetais e de �leos de origem animal Não comest�veis','','',null,999999,1,0,1469492499626,'system'),

('15.41-5','Prepara��o do leite','','',null,999999,1,0,1469492499626,'system'),

('15.42-3','Fabrica��o de produtos do latic�nio','','',null,999999,1,0,1469492499626,'system'),

('15.43-1','Fabrica��o de sorvetes','','',null,999999,1,0,1469492499626,'system'),

('15.51-2','Beneficiamento de arroz e fabrica��o de produtos do arroz','','',null,999999,1,0,1469492499626,'system'),

('15.52-0','Moagem de trigo e fabrica��o de derivados','','',null,999999,1,0,1469492499626,'system'),

('15.53-9','Fabrica��o de farinha de mandioca e derivados','','',null,999999,1,0,1469492499626,'system'),

('15.54-7','Fabrica��o de fub� e farinha de milho','','',null,999999,1,0,1469492499626,'system'),

('15.55-5','Fabrica��o de amidos e f�culas   de vegetais e fabrica��o de �leos de milho','','',null,999999,1,0,1469492499626,'system'),

('15.56-3','Fabrica��o de ra��es balanceadas para animais','','',null,999999,1,0,1469492499626,'system'),

('15.59-8','Beneficiamento, moagem  e prepara��o de outros produtos de origem vegetal','','',null,999999,1,0,1469492499626,'system'),

('15.61-0','Usinas de a��car','','',null,999999,1,0,1469492499626,'system'),

('15.62-8','Refino e moagem de a��car','','',null,999999,1,0,1469492499626,'system'),

('15.71-7','Torrefa��o e moagem de caf�','','',null,999999,1,0,1469492499626,'system'),

('15.72-5','Fabrica��o de caf� sol�vel','','',null,999999,1,0,1469492499626,'system'),

('15.81-4','Fabrica��o de produtos de padaria, confeitaria e pastelaria','','',null,999999,1,0,1469492499626,'system'),

('15.82-2','Fabrica��o de biscoitos e bolachas','','',null,999999,1,0,1469492499626,'system'),

('15.83-0','Produ��o de derivados do cacau e elabora��o de chocolates, balas, gomas de mascar','','',null,999999,1,0,1469492499626,'system'),

('15.84-9','Fabrica��o de massas aliment�cias','','',null,999999,1,0,1469492499626,'system'),

('15.85-7','Prepara��o de especiarias, molhos, temperos e condimentos','','',null,999999,1,0,1469492499626,'system'),

('15.86-5','Prepara��o de produtos  diet�ticos, alimentos para crian�as e outros alimentos conservados','','',null,999999,1,0,1469492499626,'system'),

('15.89-0','Fabrica��o de outros produtos aliment�cios','','',null,999999,1,0,1469492499626,'system'),

('15.91-1','Fabrica��o, retifica��o, homogeneiza��o e mistura de aguardentes e outras bebidas destiladas','','',null,999999,1,0,1469492499626,'system'),

('15.92-0','Fabrica��o de vinho','','',null,999999,1,0,1469492499626,'system'),

('15.93-8','Fabrica��o de malte, cervejas e chopes','','',null,999999,1,0,1469492499626,'system'),

('15.94-6','Engarrafamento e gaseifica��o de �guas minerais','','',null,999999,1,0,1469492499626,'system'),

('15.95-4','Fabrica��o de refrigerantes e refrescos','','',null,999999,1,0,1469492499626,'system'),

('16.00-4','Fabrica��o de produtos do fumo','','',null,999999,1,0,1469492499626,'system'),

('17.11-6','Beneficiamento de algod�o','','',null,999999,1,0,1469492499626,'system'),

('17.19-1','Beneficiamento de outras fibras t�xteis naturais','','',null,999999,1,0,1469492499626,'system'),

('17.21-3','Fia��o de algod�o','','',null,999999,1,0,1469492499626,'system'),

('17.22-1','Fia��o de outras fibras t�xteis naturais','','',null,999999,1,0,1469492499626,'system'),

('17.23-0','Fia��o de fibras artificiais ou sint�ticas','','',null,999999,1,0,1469492499626,'system'),

('17.24-8','Fabrica��o de linhas e fios para coser e bordar','','',null,999999,1,0,1469492499626,'system'),

('17.31-0','Tecelagem de algod�o','','',null,999999,1,0,1469492499626,'system'),

('17.32-9','Tecelagem de fios de fibras t�xteis naturais','','',null,999999,1,0,1469492499626,'system'),

('17.33-7','Tecelagem de fios e filamentos cont�nuos artificiais ou sint�ticos','','',null,999999,1,0,1469492499626,'system'),

('17.41-8','Fabrica��o de artigos de tecido de uso dom�stico, incluindo tecelagem','','',null,999999,1,0,1469492499626,'system'),

('17.49-3','Fabrica��o de outros artefatos t�xteis, incluindo tecelagem','','',null,999999,1,0,1469492499626,'system'),

('17.50-7','Servi�os de acabamento em fios, tecidos e artigos t�xteis produzidos por terceiros','','',null,999999,1,0,1469492499626,'system'),

('17.61-2','Fabrica��o de artefatos t�xteis a partir de tecidos � exclusive vestu�rio','','',null,999999,1,0,1469492499626,'system'),

('17.62-0','Fabrica��o de artefatos de tape�aria','','',null,999999,1,0,1469492499626,'system'),

('17.63-9','Fabrica��o de artefatos de cordoaria','','',null,999999,1,0,1469492499626,'system'),

('17.64-7','Fabrica��o de tecidos especiais - inclusive artefatos','','',null,999999,1,0,1469492499626,'system'),

('17.69-8','Fabrica��o de outros artigos t�xteis - exclusive vestu�rio','','',null,999999,1,0,1469492499626,'system'),

('17.71-0','Fabrica��o de tecidos de malha','','',null,999999,1,0,1469492499626,'system'),

('17.72-8','Fabrica��o de meias','','',null,999999,1,0,1469492499626,'system'),

('17.79-5','Fabrica��o de outros artigos do vestu�rio produzidos em malharias (tricotagens)','','',null,999999,1,0,1469492499626,'system'),

('18.11-2','Confec��o de pe�as interiores do vestu�rio','','',null,999999,1,0,1469492499626,'system'),

('18.12-0','Confec��o de outras pe�as do vestu�rio','','',null,999999,1,0,1469492499626,'system'),

('18.13-9','Confec��o de roupas profissionais','','',null,999999,1,0,1469492499626,'system'),

('18.21-0','Fabrica��o de acess�rios do vestu�rio','','',null,999999,1,0,1469492499626,'system'),

('18.22-8','Fabrica��o de acess�rios para seguran�a industrial e pessoal','','',null,999999,1,0,1469492499626,'system'),

('19.10-0','Curtimento e outras prepara��es de couro','','',null,999999,1,0,1469492499626,'system'),

('19.21-6','Fabrica��o de malas, bolsas, valises e outros artefatos para viagem, de qualquer material','','',null,999999,1,0,1469492499626,'system'),

('19.29-1','Fabrica��o de outros artefatos de couro','','',null,999999,1,0,1469492499626,'system'),

('19.31-3','Fabrica��o de cal�ados de couro','','',null,999999,1,0,1469492499626,'system'),

('19.32-1','Fabrica��o de t�nis de qualquer material','','',null,999999,1,0,1469492499626,'system'),

('19.33-0','Fabrica��o de cal�ados de pl�stico','','',null,999999,1,0,1469492499626,'system'),

('19.39-9','Fabrica��o de cal�ados de outros materiais','','',null,999999,1,0,1469492499626,'system'),

('20.10-9','Desdobramento de madeira','','',null,999999,1,0,1469492499626,'system'),

('20.21-4','Fabrica��o de madeira laminada e de chapas de madeira compensada, prensada ou aglomerada','','',null,999999,1,0,1469492499626,'system'),

('20.22-2','Fabrica��o de esquadrias de madeira, de casas de madeira pr�-fabricadas, de estruturas de madeira e artigos de carpintaria','','',null,999999,1,0,1469492499626,'system'),

('20.23-0','Fabrica��o de artefatos de tanoaria e embalagens de madeira','','',null,999999,1,0,1469492499626,'system'),

('20.29-0','Fabrica��o de artefatos diversos de madeira, palha, corti�a e material tran�ado - exclusive m�veis','','',null,999999,1,0,1469492499626,'system'),

('21.10-5','Fabrica��o de celulose e outras pastas para a fabrica��o de papel','','',null,999999,1,0,1469492499626,'system'),

('21.21-0','Fabrica��o de papel','','',null,999999,1,0,1469492499626,'system'),

('21.22-9','Fabrica��o de papel�o liso, cartolina e cart�o','','',null,999999,1,0,1469492499626,'system'),

('21.31-8','Fabrica��o de embalagens de papel','','',null,999999,1,0,1469492499626,'system'),

('21.32-6','Fabrica��o de embalagens  de papel�o - inclusive a fabrica��o de papel�o corrugado','','',null,999999,1,0,1469492499626,'system'),

('21.41-5','Fabrica��o de artefatos de papel, papel�o, cartolina e cart�o para escrit�rio','','',null,999999,1,0,1469492499626,'system'),

('21.42-3','Fabrica��o de fitas e formul�rios cont�nuos - impressos ou Não','','',null,999999,1,0,1469492499626,'system'),

('21.49-0','Fabrica��o de outros artefatos de pastas, papel, papel�o, cartolina e cart�o','','',null,999999,1,0,1469492499626,'system'),

('22.11-0','Edi��o ; edi��o e impress�o de jornais','','',null,999999,1,0,1469492499626,'system'),

('22.12-8','Edi��o; edi��o e impress�o de revistas','','',null,999999,1,0,1469492499626,'system'),

('22.13-6','Edi��o; edi��o e impress�o de livros','','',null,999999,1,0,1469492499626,'system'),

('22.14-4','Edi��o de discos, fitas e outros materiais gravados','','',null,999999,1,0,1469492499626,'system'),

('22.19-5','Edi��o ; edi��o e impress�o de outros produtos gr�ficos','','',null,999999,1,0,1469492499626,'system'),

('22.21-7','Impress�o de jornais, revistas e livros','','',null,999999,1,0,1469492499626,'system'),

('22.22-5','Servi�o de impress�o de material escolar e de material para usos industrial e comercial','','',null,999999,1,0,1469492499626,'system'),

('22.29-2','Execu��o de outros servi�os gr�ficos','','',null,999999,1,0,1469492499626,'system'),

('22.31-4','Reprodu��o de discos e fitas','','',null,999999,1,0,1469492499626,'system'),

('22.32-2','Reprodu��o de fitas de v�deos','','',null,999999,1,0,1469492499626,'system'),

('22.33-0','Reprodu��o de filmes','','',null,999999,1,0,1469492499626,'system'),

('22.34-9','Reprodu��o de programas de inform�tica em disquetes e fitas','','',null,999999,1,0,1469492499626,'system'),

('23.10-8','Coquerias','','',null,999999,1,0,1469492499626,'system'),

('23.20-5','Refino de petr�leo','','',null,999999,1,0,1469492499626,'system'),

('23.30-2','Elabora��o de combust�veis nucleares','','',null,999999,1,0,1469492499626,'system'),

('23.40-0','Produ��o de �lcool','','',null,999999,1,0,1469492499626,'system'),

('24.11-2','Fabrica��o de cloro e �lcalis','','',null,999999,1,0,1469492499626,'system'),

('24.12-0','Fabrica��o de intermedi�rios para fertilizantes','','',null,999999,1,0,1469492499626,'system'),

('24.13-9','Fabrica��o de fertilizantes fosfatados, nitrogenados e pot�ssicos','','',null,999999,1,0,1469492499626,'system'),

('24.14-7','Fabrica��o de gases industriais','','',null,999999,1,0,1469492499626,'system'),

('24.19-8','Fabrica��o de outros produtos inorg�nicos','','',null,999999,1,0,1469492499626,'system'),

('24.21-0','Fabrica��o de produtos petroqu�micos b�sicos','','',null,999999,1,0,1469492499626,'system'),

('24.22-8','Fabrica��o de intermedi�rios para resinas e fibras','','',null,999999,1,0,1469492499626,'system'),

('24.29-5','Fabrica��o de outros produtos qu�micos org�nicos','','',null,999999,1,0,1469492499626,'system'),

('24.31-7','Fabrica��o de resinas termopl�sticas','','',null,999999,1,0,1469492499626,'system'),

('24.32-5','Fabrica��o de resinas termofixas','','',null,999999,1,0,1469492499626,'system'),

('24.33-3','Fabrica��o de elast�meros','','',null,999999,1,0,1469492499626,'system'),

('24.41-4','Fabrica��o de fibras, fios, cabos e filamentos cont�nuos artificiais','','',null,999999,1,0,1469492499626,'system'),

('24.42-2','Fabrica��o de fibras, fios, cabos e filamentos cont�nuos sint�ticos','','',null,999999,1,0,1469492499626,'system'),

('24.51-1','Fabrica��o de produtos farmoqu�micos','','',null,999999,1,0,1469492499626,'system'),

('24.52-0','Fabrica��o de medicamentos para uso humano','','',null,999999,1,0,1469492499626,'system'),

('24.53-8','Fabrica��o de medicamentos para uso veterin�rio','','',null,999999,1,0,1469492499626,'system'),

('24.54-6','Fabrica��o de materiais para usos m�dicos, hospitalares e odontol�gicos','','',null,999999,1,0,1469492499626,'system'),

('24.61-9','Fabrica��o de inseticidas','','',null,999999,1,0,1469492499626,'system'),

('24.62-7','Fabrica��o de fungicidas','','',null,999999,1,0,1469492499626,'system'),

('24.63-5','Fabrica��o de herbicidas','','',null,999999,1,0,1469492499626,'system'),

('24.69-4','Fabrica��o de outros defensivos agr�colas','','',null,999999,1,0,1469492499626,'system'),

('24.71-6','Fabrica��o de sab�es, sabonetes e detergentes sint�ticos','','',null,999999,1,0,1469492499626,'system'),

('24.72-4','Fabrica��o de produtos de limpeza e polimento','','',null,999999,1,0,1469492499626,'system'),

('24.73-2','Fabrica��o de artigos de perfumaria e cosm�ticos','','',null,999999,1,0,1469492499626,'system'),

('24.81-3','Fabrica��o de tintas, vernizes, esmaltes e lacas','','',null,999999,1,0,1469492499626,'system'),

('24.82-1','Fabrica��o de tintas de impress�o','','',null,999999,1,0,1469492499626,'system'),

('24.83-0','Fabrica��o de impermeabilizantes, solventes e produtos afins','','',null,999999,1,0,1469492499626,'system'),

('24.91-0','Fabrica��o de adesivos e selantes','','',null,999999,1,0,1469492499626,'system'),

('24.92-9','Fabrica��o de explosivos','','',null,999999,1,0,1469492499626,'system'),

('24.93-7','Fabrica��o de catalisadores','','',null,999999,1,0,1469492499626,'system'),

('24.94-5','Fabrica��o de aditivos de uso industrial','','',null,999999,1,0,1469492499626,'system'),
('24.95-3','Fabrica��o de chapas, filmes, pap�is e outros materiais e produtos qu�micos para fotografia','','',null,999999,1,0,1469492499626,'system'),
('24.96-1','Fabrica��o de discos e fitas virgens','','',null,999999,1,0,1469492499626,'system'),
('24.99-6','Fabrica��o de outros produtos qu�micos Não especificados ou Não classificados','','',null,999999,1,0,1469492499626,'system'),
('25.11-9','Fabrica��o de pneum�ticos e de c�maras-de-ar','','',null,999999,1,0,1469492499626,'system'),
('25.12-7','Recondicionamento de pneum�ticos','','',null,999999,1,0,1469492499626,'system'),
('25.19-4','Fabrica��o de artefatos diversos de borracha','','',null,999999,1,0,1469492499626,'system'),
('25.21-6','Fabrica��o de laminados planos e tubulares pl�stico','','',null,999999,1,0,1469492499626,'system'),
('25.22-4','Fabrica��o de embalagem de pl�stico','','',null,999999,1,0,1469492499626,'system'),
('25.29-1','Fabrica��o de artefatos diversos de pl�stico','','',null,999999,1,0,1469492499626,'system'),
('26.11-5','Fabrica��o de vidro plano e de seguran�a','','',null,999999,1,0,1469492499626,'system'),','','',null,999999,1,0,1469492499626,'system'),
('26.12-3','Fabrica��o de embalagens de vidro','','',null,999999,1,0,1469492499626,'system'),
('26.19-0','Fabrica��o de artigos de vidro','','',null,999999,1,0,1469492499626,'system'),
('26.20-4','Fabrica��o de cimento','','',null,999999,1,0,1469492499626,'system'),
('26.30-1','Fabrica��o de artefatos de concreto, cimento, fibrocimento, gesso e estuque','','',null,999999,1,0,1469492499626,'system'),
('26.41-7','Fabrica��o de produtos cer�micos Não-refrat�rios para uso estrutural na constru��o civil','','',null,999999,1,0,1469492499626,'system'),
('26.42-5','Fabrica��o de produtos cer�micos refrat�rios','','',null,999999,1,0,1469492499626,'system'),
('26.49-2','Fabrica��o de produtos cer�micos Não-refrat�rios para usos diversos','','',null,999999,1,0,1469492499626,'system'),
('26.91-3','Britamento, aparelhamento e outros trabalhos em pedras (Não associado a extra��o)','','',null,999999,1,0,1469492499626,'system'),
('26.92-1','Fabrica��o de cal virgem, cal hidratada e gesso','','',null,999999,1,0,1469492499626,'system'),
('26.99-9','Fabrica��o de outros produtos de minerais Não-met�licos','','',null,999999,1,0,1469492499626,'system'),
('27.11-1','Produ��o de laminados planos de a�o','','',null,999999,1,0,1469492499626,'system'),
('27.12-0','Produ��o de laminados Não-planos de a�o','','',null,999999,1,0,1469492499626,'system'),
('27.21-9','Produ��o de gusa','','',null,999999,1,0,1469492499626,'system'),
('27.22-7','Produ��o de ferro, a�o e ferro-ligas em formas prim�rias e semi-acabados','','',null,999999,1,0,1469492499626,'system'),
('27.29-4','Produ��o de relaminados, trefilados e retrefilados de a�o - exclusive tubos','','',null,999999,1,0,1469492499626,'system'),
('27.31-6','Fabrica��o de tubos de a�o com costura','','',null,999999,1,0,1469492499626,'system'),
('27.39-1','Fabrica��o de outros tubos de ferro e a�o','','',null,999999,1,0,1469492499626,'system'),
('27.41-3','Metalurgia do alum�nio e suas ligas','','',null,999999,1,0,1469492499626,'system'),
('27.42-1','Metalurgia dos metais preciosos','','',null,999999,1,0,1469492499626,'system'),
('27.49-9','Metalurgia de outros metais Não-ferrosos e suas ligas','','',null,999999,1,0,1469492499626,'system'),
('27.51-0','Fabrica��o de pe�as fundidas de ferro e a�o','','',null,999999,1,0,1469492499626,'system'),
('27.52-9','Fabrica��o de pe�as fundidas de metais Não-ferrosos e suas ligas','','',null,999999,1,0,1469492499626,'system'),
('28.11-8','Fabrica��o de estruturas met�licas para edif�cios, pontes, torres de transmiss�o, andaimes e outros fins','','',null,999999,1,0,1469492499626,'system'),
('28.12-6','Fabrica��o de esquadrias de metal','','',null,999999,1,0,1469492499626,'system'),
('28.13-4','Fabrica��o de obras de caldeiraria pesada','','',null,999999,1,0,1469492499626,'system'),
('28.21-5','Fabrica��o de tanques, reservat�rios met�licos e caldeiras para aquecimento central','','',null,999999,1,0,1469492499626,'system'),
('28.22-3','Fabrica��o de caldeiras geradoras de vapor - exclusive para aquecimento central e para ve�culos','','',null,999999,1,0,1469492499626,'system'),
('28.31-2','Produ��o de forjados de a�o','','',null,999999,1,0,1469492499626,'system'),
('28.32-0','Produ��o de forjados de metais Não-ferrosos e suas ligas','','',null,999999,1,0,1469492499626,'system'),
('28.33-9','Fabrica��o de artefatos estampados de metal','','',null,999999,1,0,1469492499626,'system'),
('28.34-7','Metalurgia do p�','','',null,999999,1,0,1469492499626,'system'),
('28.39-8','T�mpera, cementa��o e tratamento t�rmico do a�o, servi�os de usinagem, galvanot�cnica e solda','','',null,999999,1,0,1469492499626,'system'),
('28.41-0','Fabrica��o de artigos de cutelaria','','',null,999999,1,0,1469492499626,'system'),
('28.42-8','Fabrica��o de artigos de serralheria - exclusive esquadrias','','',null,999999,1,0,1469492499626,'system'),
('28.43-6','Fabrica��o de ferramentas manuais','','',null,999999,1,0,1469492499626,'system'),
('28.91-6','Fabrica��o de embalagens met�licas','','',null,999999,1,0,1469492499626,'system'),
('28.92-4','Fabrica��o de artefatos de trefilados','','',null,999999,1,0,1469492499626,'system'),
('28.93-2','Fabrica��o de artigos de funilaria e de artigos de metal para usos dom�stico e pessoal','','',null,999999,1,0,1469492499626,'system'),
('28.99-1','Fabrica��o de outros produtos elaborados de metal','','',null,999999,1,0,1469492499626,'system'),
('29.11-4','Fabrica��o de motores estacion�rios de combust�o interna, turbinas e outras m�quinas motrizes Não-el�tricas - exclusive para avi�es e ve�culos rodovi�rios','','',null,999999,1,0,1469492499626,'system'),
('29.12-2','Fabrica��o de bombas e carneiros hidr�ulicos','','',null,999999,1,0,1469492499626,'system'),
('29.13-0','Fabrica��o de v�lvulas, torneiras e registros','','',null,999999,1,0,1469492499626,'system'),
('29.14-9','Fabrica��o de compressores','','',null,999999,1,0,1469492499626,'system'),
('29.15-7','Fabrica��o de equipamentos de transmiss�o para fins industriais - inclusive rolamentos','','',null,999999,1,0,1469492499626,'system'),
('29.21-1','Fabrica��o de fornos industriais, aparelhos e equipamentos Não-el�tricos para instala��es t�rmicas','','',null,999999,1,0,1469492499626,'system'),
('29.22-0','Fabrica��o de estufas e fornos el�tricos para fins industriais','','',null,999999,1,0,1469492499626,'system'),
('29.23-8','Fabrica��o de m�quinas, equipamentos e aparelhos para transporte e eleva��o de cargas e pessoas','','',null,999999,1,0,1469492499626,'system'),
('29.24-6','Fabrica��o de m�quinas e aparelhos de refrigera��o e ventila��o de uso industrial','','',null,999999,1,0,1469492499626,'system'),
('29.25-4','Fabrica��o de aparelhos de ar condicionado','','',null,999999,1,0,1469492499626,'system'),
('29.29-7','Fabrica��o de outras m�quinas e equipamentos de uso geral','','',null,999999,1,0,1469492499626,'system'),
('29.31-9','Fabrica��o de m�quinas e equipamentos para agricultura, avicultura e obten��o de produtos animais','','',null,999999,1,0,1469492499626,'system'),
('29.32-7','Fabrica��o de tratores agr�colas','','',null,999999,1,0,1469492499626,'system'),
('29.40-8','Fabrica��o de m�quinas-ferramenta','','',null,999999,1,0,1469492499626,'system'),
('29.51-3','Fabrica��o de m�quinas e equipamentos para a ind�stria de prospec��o e extra��o de petr�leo','','',null,999999,1,0,1469492499626,'system'),
('29.52-1','Fabrica��o de outras m�quinas e equipamentos para a extra��o de min�rios e ind�stria da constru��o','','',null,999999,1,0,1469492499626,'system'),
('29.53-0','Fabrica��o de tratores de esteira e tratores de uso na constru��o e minera��o','','',null,999999,1,0,1469492499626,'system'),
('29.54-8','Fabrica��o de m�quinas e equipamentos de terraplanagem e pavimenta��o','','',null,999999,1,0,1469492499626,'system'),
('29.61-0','Fabrica��o de m�quinas para a ind�stria metal�rgica - exclusive m�quinas-ferramenta','','',null,999999,1,0,1469492499626,'system'),
('29.62-9','Fabrica��o de m�quinas e equipamentos para as ind�strias alimentar, de bebida e fumo','','',null,999999,1,0,1469492499626,'system'),
('29.63-7','Fabrica��o de m�quinas e equipamentos para a ind�stria t�xtil','','',null,999999,1,0,1469492499626,'system'),
('29.64-5','Fabrica��o de m�quinas e equipamentos para as ind�strias do  vestu�rio e de couro e cal�ados','','',null,999999,1,0,1469492499626,'system'),
('29.65-3','Fabrica��o de m�quinas e equipamentos para as ind�strias de celulose, papel e papel�o e artefatos','','',null,999999,1,0,1469492499626,'system'),
('29.69-6','Fabrica��o de outras m�quinas e equipamentos de uso espec�fico','','',null,999999,1,0,1469492499626,'system'),
('29.71-8','Fabrica��o de armas de fogo e muni��es','','',null,999999,1,0,1469492499626,'system'),
('29.72-6','Fabrica��o de equipamento b�lico pesado','','',null,999999,1,0,1469492499626,'system'),
('29.81-5','Fabrica��o de fog�es, refrigeradores e m�quinas de lavar e secar para uso dom�stico','','',null,999999,1,0,1469492499626,'system'),
('29.89-0','Fabrica��o de outros aparelhos eletrodom�sticos','','',null,999999,1,0,1469492499626,'system'),
('30.11-2','Fabrica��o de m�quinas de escrever e calcular, copiadoras e outros equipamentos Não-eletr�nicos para escrit�rio','','',null,999999,1,0,1469492499626,'system'),
('30.12-0','Fabrica��o de m�quinas de escrever e calcular, copiadoras e outros equipamentos eletr�nicos destinados � automa��o gerencial e comercial','','',null,999999,1,0,1469492499626,'system'),
('30.21-0','Fabrica��o de computadores','','',null,999999,1,0,1469492499626,'system'),
('30.22-8','Fabrica��o de equipamentos perif�ricos para m�quinas eletr�nicas para tratamento de informa��es','','',null,999999,1,0,1469492499626,'system'),
('31.11-9','Fabrica��o de geradores de corrente cont�nua ou alternada','','',null,999999,1,0,1469492499626,'system'),
('31.12-7','Fabrica��o de transformadores, indutores, conversores, sincronizadores e semelhantes','','',null,999999,1,0,1469492499626,'system'),
('31.13-5','Fabrica��o de motores el�tricos','','',null,999999,1,0,1469492499626,'system'),
('31.21-6','Fabrica��o de subesta��es, quadros de comando, reguladores de voltagem e outros aparelhos e equipamentos para distribui��o e controle de energia','','',null,999999,1,0,1469492499626,'system'),
('31.22-4','Fabrica��o de material el�trico para instala��es em circuito de consumo','','',null,999999,1,0,1469492499626,'system'),
('31.30-5','Fabrica��o de fios, cabos e condutores el�tricos isolados','','',null,999999,1,0,1469492499626,'system'),
('31.41-0','Fabrica��o de pilhas, baterias e acumuladores el�tricos - exclusive para ve�culos','','',null,999999,1,0,1469492499626,'system'),
('31.42-9','Fabrica��o de baterias e acumuladores para ve�culos','','',null,999999,1,0,1469492499626,'system'),
('31.51-8','Fabrica��o de l�mpadas','','',null,999999,1,0,1469492499626,'system'),
('31.52-6','Fabrica��o de lumin�rias e equipamentos de ilumina��o - exclusive para ve�culos','','',null,999999,1,0,1469492499626,'system'),
('31.60-7','Fabrica��o de material el�trico para ve�culos - exclusive baterias','','',null,999999,1,0,1469492499626,'system'),
('31.91-7','Fabrica��o de eletrodos, contatos e outros artigos de carv�o e grafita para uso el�trico, eletroim�s e isoladores','','',null,999999,1,0,1469492499626,'system'),
('31.92-5','Fabrica��o de aparelhos e utens�lios para sinaliza��o e alarme','','',null,999999,1,0,1469492499626,'system'),
('31.99-2','Fabrica��o de outros aparelhos ou equipamentos el�tricos','','',null,999999,1,0,1469492499626,'system'),
('32.10-7','Fabrica��o de material eletr�nico b�sico','','',null,999999,1,0,1469492499626,'system'),
('32.21-2','Fabrica��o de equipamentos transmissores de r�dio e televis�o e de equipamentos para esta��es telef�nicas, para radiotelefonia e radiotelegrafia - inclusive de microondas e repetidoras','','',null,999999,1,0,1469492499626,'system'),
('32.22-0','Fabrica��o de aparelhos telef�nicos, sistemas de intercomunica��o e semelhantes','','',null,999999,1,0,1469492499626,'system'),
('32.30-1','Fabrica��o de aparelhos receptores de r�dio e televis�o e de reprodu��o, grava��o ou amplifica��o de som e v�deo','','',null,999999,1,0,1469492499626,'system'),
('33.10-3','Fabrica��o de aparelhos e instrumentos para usos m�dico-hospitalares, odontol�gicos e de laborat�rios e aparelhos ortop�dicos','','',null,999999,1,0,1469492499626,'system'),
('33.20-0','Fabrica��o de aparelhos e instrumentos de medida, teste e controle - exclusive equipamentos para controle de processos industriais','','',null,999999,1,0,1469492499626,'system'),
('33.30-8','Fabrica��o de m�quinas, aparelhos e equipamentos de sistemas eletr�nicos dedicados a automa��o industrial e controle do processo produtivo','','',null,999999,1,0,1469492499626,'system'),
('33.40-5','Fabrica��o de aparelhos, instrumentos e materiais �pticos, fotogr�ficos e cinematogr�ficos','','',null,999999,1,0,1469492499626,'system'),
('33.50-2','Fabrica��o de cron�metros e rel�gios','','',null,999999,1,0,1469492499626,'system'),
('34.10-0','Fabrica��o de autom�veis, camionetas e utilit�rios','','',null,999999,1,0,1469492499626,'system'),
('34.20-7','Fabrica��o de caminh�es e �nibus','','',null,999999,1,0,1469492499626,'system'),
('34.31-2','Fabrica��o de cabines, carrocerias e reboques para caminh�o ','','',null,999999,1,0,1469492499626,'system'),
('34.32-0','Fabrica��o de carrocerias para �nibus','','',null,999999,1,0,1469492499626,'system'),
('34.39-8','Fabrica��o de cabines, carrocerias e reboques para outros ve�culos','','',null,999999,1,0,1469492499626,'system'),
('34.41-0','Fabrica��o de pe�as e acess�rios para o sistema motor','','',null,999999,1,0,1469492499626,'system'),
('34.42-8','Fabrica��o de pe�as e acess�rios para os sistemas de marcha e transmiss�o','','',null,999999,1,0,1469492499626,'system'),
('34.43-6','Fabrica��o de pe�as e acess�rios para o sistema de freios','','',null,999999,1,0,1469492499626,'system'),
('34.44-4','Fabrica��o de pe�as e acess�rios para o sistema de dire��o e suspens�o','','',null,999999,1,0,1469492499626,'system'),
('34.49-5','Fabrica��o de pe�as e acess�rios de metal para ve�culos automotores Não classificados em outra classe','','',null,999999,1,0,1469492499626,'system'),
('34.50-9','Recondicionamento ou recupera��o de motores para ve�culos automotores','','',null,999999,1,0,1469492499626,'system'),
('35.11-4','Constru��o e repara��o de embarca��es e estruturas flutuantes','','',null,999999,1,0,1469492499626,'system'),
('35.12-2','Constru��o e repara��o de embarca��es para esporte e lazer','','',null,999999,1,0,1469492499626,'system'),
('35.21-1','Constru��o e montagem de locomotivas, vag�es e outros materiais rodantes','','',null,999999,1,0,1469492499626,'system'),
('35.22-0','Fabrica��o de pe�as e acess�rios para ve�culos ferrovi�rios','','',null,999999,1,0,1469492499626,'system'),
('35.23-8','Repara��o de ve�culos ferrovi�rios','','',null,999999,1,0,1469492499626,'system'),
('35.31-9','Constru��o e montagem de aeronaves','','',null,999999,1,0,1469492499626,'system'),
('35.32-7','Repara��o de aeronaves','','',null,999999,1,0,1469492499626,'system'),
('35.91-2','Fabrica��o de motocicletas','','',null,999999,1,0,1469492499626,'system'),
('35.92-0','Fabrica��o de bicicletas e triciclos Não-motorizados','','',null,999999,1,0,1469492499626,'system'),
('35.99-8','Fabrica��o de outros equipamentos de transporte','','',null,999999,1,0,1469492499626,'system'),
('36.11-0','Fabrica��o de m�veis com predomin�ncia de madeira','','',null,999999,1,0,1469492499626,'system'),
('36.12-9','Fabrica��o de m�veis com predomin�ncia de metal','','',null,999999,1,0,1469492499626,'system'),
('36.13-7','Fabrica��o de m�veis de outros materiais','','',null,999999,1,0,1469492499626,'system'),
('36.14-5','Fabrica��o de colch�es','','',null,999999,1,0,1469492499626,'system'),
('36.91-9','Lapida��o de pedras preciosas e semi-preciosas, fabrica��o de artefatos de ourivesaria e joalheria','','',null,999999,1,0,1469492499626,'system'),
('36.92-7','Fabrica��o de instrumentos musicais','','',null,999999,1,0,1469492499626,'system'),
('36.93-5','Fabrica��o de artefatos para ca�a, pesca e esporte','','',null,999999,1,0,1469492499626,'system'),
('36.94-3','Fabrica��o de brinquedos e de jogos recreativos','','',null,999999,1,0,1469492499626,'system'),
('36.95-1','Fabrica��o de canetas, l�pis, fitas impressoras para m�quinas e outros artigos para escrit�rio','','',null,999999,1,0,1469492499626,'system'),
('36.96-0','Fabrica��o de aviamentos para costura','','',null,999999,1,0,1469492499626,'system'),
('36.97-8','Fabrica��o de escovas, pinc�is e vassouras','','',null,999999,1,0,1469492499626,'system'),
('36.99-4','Fabrica��o de produtos diversos','','',null,999999,1,0,1469492499626,'system'),
('37.10-9','Reciclagem de sucatas met�licas','','',null,999999,1,0,1469492499626,'system'),
('37.20-6','Reciclagem de sucatas Não-met�licas','','',null,999999,1,0,1469492499626,'system'),
('40.10-0','Produ��o e distribui��o de energia el�trica','','',null,999999,1,0,1469492499626,'system'),
('40.20-7','Produ��o e distribui��o de g�s atrav�s de tubula��es','','',null,999999,1,0,1469492499626,'system'),
('40.30-4','Produ��o e distribui��o de vapor e �gua quente','','',null,999999,1,0,1469492499626,'system'),
('41.00-9','Capta��o, tratamento e distribui��o de �gua','','',null,999999,1,0,1469492499626,'system'),
('45.11-0','Demoli��o e prepara��o do terreno','','',null,999999,1,0,1469492499626,'system'),
('45.12-8','Perfura��es e execu��o de funda��es destinadas � constru��o civil','','',null,999999,1,0,1469492499626,'system'),
('45.13-6','Grandes movimenta��es de terra','','',null,999999,1,0,1469492499626,'system'),
('45.21-7','Edifica��es (residenciais, industriais, comerciais e de servi�os)','','',null,999999,1,0,1469492499626,'system'),
('45.22-5','Obras vi�rias','','',null,999999,1,0,1469492499626,'system'),
('45.23-3','Grandes estruturas e obras de arte','','',null,999999,1,0,1469492499626,'system'),
('45.24-1','Obras de urbaniza��o e paisagismo','','',null,999999,1,0,1469492499626,'system'),
('45.25-0','Montagem de estruturas  ','','',null,999999,1,0,1469492499626,'system'),
('45.29-2','Obras de outros tipos','','',null,999999,1,0,1469492499626,'system'),
('45.31-4','Constru��o de barragens e represas para gera��o de energia el�trica','','',null,999999,1,0,1469492499626,'system'),
('45.32-2','Constru��o de esta��es e redes de distribui��o de energia el�trica','','',null,999999,1,0,1469492499626,'system'),
('45.33-0','Constru��o de esta��es e redes de telefonia e comunica��o','','',null,999999,1,0,1469492499626,'system'),
('45.34-9','Constru��o de obras de preven��o e recupera��o do meio ambiente','','',null,999999,1,0,1469492499626,'system'),
('45.41-1','Instala��es el�tricas','','',null,999999,1,0,1469492499626,'system'),
('45.42-0','Instala��es de sistemas de ar condicionado, de ventila��o e refrigera��o','','',null,999999,1,0,1469492499626,'system'),
('45.43-8','Instala��es hidr�ulicas, sanit�rias, de g�s e de sistema de preven��o contra inc�ndio','','',null,999999,1,0,1469492499626,'system'),
('45.49-7','Outras obras de instala��es','','',null,999999,1,0,1469492499626,'system'),
('45.51-9','Alvenaria e reboco','','',null,999999,1,0,1469492499626,'system'),
('45.52-7','Impermeabiliza��o e servi�os de pintura em geral','','',null,999999,1,0,1469492499626,'system'),
('45.59-4','Outras obras de acabamento','','',null,999999,1,0,1469492499626,'system'),
('45.60-8','Aluguel de equipamentos de constru��o e demoli��o com oper�rios','','',null,999999,1,0,1469492499626,'system'),
('50.10-5','Com�rcio a varejo e por atacado de ve�culos automotores','','',null,999999,1,0,1469492499626,'system'),
('50.20-2','Manuten��o e repara��o de ve�culos automotores','','',null,999999,1,0,1469492499626,'system'),
('50.30-0','Com�rcio a varejo e por atacado de pe�as e acess�rios para ve�culos automotores','','',null,999999,1,0,1469492499626,'system'),
('50.41-5','Com�rcio a varejo e por atacado de motocicletas, partes, pe�as e acess�rios','','',null,999999,1,0,1469492499626,'system'),
('50.42-3','Manuten��o e repara��o de motocicletas','','',null,999999,1,0,1469492499626,'system'),
('50.50-4','Com�rcio a varejo de combust�veis','','',null,999999,1,0,1469492499626,'system'),
('51.11-0','Representantes comerciais e agentes do com�rcio de mat�rias-primas agr�colas, animais vivos, mat�rias primas t�xteis e produtos semi-acabados','','',null,999999,1,0,1469492499626,'system'),
('51.12-8','Representantes comerciais e agentes do com�rcio de combust�veis, minerais, metais e produtos qu�micos industriais','','',null,999999,1,0,1469492499626,'system'),
('51.13-6','Representantes comerciais e agentes do com�rcio de madeira, material de constru��o e ferragens','','',null,999999,1,0,1469492499626,'system'),
('51.14-4','Representantes comerciais e agentes do com�rcio de m�quinas, equipamentos industriais, embarca��es e aeronaves','','',null,999999,1,0,1469492499626,'system'),
('51.15-2','Representantes comerciais e agentes do com�rcio de m�veis e artigos de uso dom�stico','','',null,999999,1,0,1469492499626,'system'),
('51.16-0','Representantes comerciais e agentes do com�rcio de t�xteis, vestu�rio, cal�ados e artigos de couro','','',null,999999,1,0,1469492499626,'system'),
('51.17-9','Representantes comerciais e agentes do com�rcio de produtos aliment�cios, bebidas e fumo','','',null,999999,1,0,1469492499626,'system'),
('51.18-7','Representantes comerciais e agentes do com�rcio especializado em produtos Não especificados anteriormente','','',null,999999,1,0,1469492499626,'system'),
('51.19-5','Representantes comerciais e agentes do com�rcio de mercadorias em geral (Não especializados)','','',null,999999,1,0,1469492499626,'system'),
('51.21-7','Com�rcio atacadista de produtos agr�colas "in natura"; produtos aliment�cios para animais','','',null,999999,1,0,1469492499626,'system'),
('51.22-5','Com�rcio atacadista de animais vivos','','',null,999999,1,0,1469492499626,'system'),
('51.31-4','Com�rcio atacadista de leite e produtos do leite','','',null,999999,1,0,1469492499626,'system'),
('51.32-2','Com�rcio atacadista de cereais beneficiados, farinhas, amidos e f�culas','','',null,999999,1,0,1469492499626,'system'),
('51.33-0','Com�rcio atacadista de hortifrutigranjeiros','','',null,999999,1,0,1469492499626,'system'),
('51.34-9','Com�rcio atacadista de carnes e produtos da carne','','',null,999999,1,0,1469492499626,'system'),
('51.35-7','Com�rcio atacadista de pescados','','',null,999999,1,0,1469492499626,'system'),
('51.36-5','Com�rcio atacadista de bebidas','','',null,999999,1,0,1469492499626,'system'),
('51.37-3','Com�rcio atacadista de produtos do fumo','','',null,999999,1,0,1469492499626,'system'),
('51.39-0','Com�rcio atacadista de outros produtos aliment�cios, Não especificados anteriormente','','',null,999999,1,0,1469492499626,'system'),
('51.41-1','Com�rcio atacadista de fios t�xteis, tecidos, artefatos de tecidos e de armarinho','','',null,999999,1,0,1469492499626,'system'),
('51.42-0','Com�rcio atacadista de artigos do vestu�rio e complementos','','',null,999999,1,0,1469492499626,'system'),
('51.43-8','Com�rcio atacadista de cal�ados','','',null,999999,1,0,1469492499626,'system'),
('51.44-6','Com�rcio atacadista de eletrodom�sticos e outros equipamentos de usos pessoal e dom�stico','','',null,999999,1,0,1469492499626,'system'),
('51.45-4','Com�rcio atacadista de produtos farmac�uticos, m�dicos, ortop�dicos e odontol�gicos','','',null,999999,1,0,1469492499626,'system'),
('51.46-2','Com�rcio atacadista de cosm�ticos e produtos de perfumaria','','',null,999999,1,0,1469492499626,'system'),
('51.47-0','Com�rcio atacadista de artigos de escrit�rio e de papelaria;  livros, jornais, e outras publica��es','','',null,999999,1,0,1469492499626,'system'),
('51.49-7','Com�rcio atacadista de outros artigos de usos pessoal e dom�stico, Não especificados anteriormente','','',null,999999,1,0,1469492499626,'system'),
('51.51-9','Com�rcio atacadista de combust�veis','','',null,999999,1,0,1469492499626,'system'),
('51.52-7','Com�rcio atacadista de produtos extrativos de origem mineral','','',null,999999,1,0,1469492499626,'system'),
('51.53-5','Com�rcio atacadista de madeira, material de constru��o, ferragens e ferramentas','','',null,999999,1,0,1469492499626,'system'),
('51.54-3','Com�rcio atacadista de produtos qu�micos','','',null,999999,1,0,1469492499626,'system'),
('51.55-1','Com�rcio atacadista de res�duos e sucatas','','',null,999999,1,0,1469492499626,'system'),
('51.59-4','Com�rcio atacadista de outros produtos intermedi�rios Não agropecu�rios, Não especificados anteriormente','','',null,999999,1,0,1469492499626,'system'),
('51.61-6','Com�rcio atacadista de m�quinas, aparelhos e equipamentos para uso agropecu�rio','','',null,999999,1,0,1469492499626,'system'),
('51.62-4','Com�rcio atacadista de m�quinas e equipamentos para o com�rcio','','',null,999999,1,0,1469492499626,'system'),
('51.63-2','Com�rcio atacadista de m�quinas e equipamentos para escrit�rio','','',null,999999,1,0,1469492499626,'system'),
('51.69-1','Com�rcio atacadista de m�quinas, aparelhos e equipamentos para usos industrial, t�cnico e profissional, e outros usos, Não especificados anteriormente','','',null,999999,1,0,1469492499626,'system'),
('51.91-8','Com�rcio atacadista de mercadorias em geral (Não especializado)','','',null,999999,1,0,1469492499626,'system'),
('51.92-6','Com�rcio atacadista especializado em mercadorias Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('52.11-6','Com�rcio varejista de mercadorias em geral, com predomin�ncia de produtos aliment�cios, com �rea de venda superior a 5000 metros quadrados - hipermercados','','',null,999999,1,0,1469492499626,'system'),
('52.12-4','Com�rcio varejista de mercadorias em geral, com predomin�ncia de produtos aliment�cios, com �rea de venda entre 300 e 5000 metros quadrados - supermercados','','',null,999999,1,0,1469492499626,'system'),
('52.13-2','Com�rcio varejista de mercadorias em geral, com predomin�ncia de produtos aliment�cios, com �rea de venda inferior a 300 metros quadrados - exclusive lojas e conveni�ncia','','',null,999999,1,0,1469492499626,'system'),
('52.14-0','Com�rcio varejista de mercadorias em geral, com predomin�ncia de produtos aliment�cios ind�strializados - lojas de conveni�ncia','','',null,999999,1,0,1469492499626,'system'),
('52.15-9','Com�rcio varejista Não especializado, sem predomin�ncia de produtos aliment�cios','','',null,999999,1,0,1469492499626,'system'),
('52.21-3','Com�rcio varejista de produtos de padaria, de latic�nio, frios e conservas','','',null,999999,1,0,1469492499626,'system'),
('52.22-1','Com�rcio varejista de balas, bombons e semelhantes','','',null,999999,1,0,1469492499626,'system'),
('52.23-0','Com�rcio varejista de carnes - a�ougues','','',null,999999,1,0,1469492499626,'system'),
('52.24-8','Com�rcio varejista de bebidas','','',null,999999,1,0,1469492499626,'system'),
('52.29-9','Com�rcio varejista de outros produtos aliment�cios Não especificados anteriormente e de produtos do fumo','','',null,999999,1,0,1469492499626,'system'),
('52.31-0','Com�rcio varejista de tecidos e artigos de armarinho','','',null,999999,1,0,1469492499626,'system'),
('52.32-9','Com�rcio varejista de artigos do vestu�rio e complementos','','',null,999999,1,0,1469492499626,'system'),
('52.33-7','Com�rcio varejista de cal�ados, artigos de couro e viagem','','',null,999999,1,0,1469492499626,'system'),
('52.41-8','Com�rcio varejista de produtos farmac�uticos, artigos m�dicos e ortop�dicos, de perfumaria e cosm�ticos','','',null,999999,1,0,1469492499626,'system'),
('52.42-6','Com�rcio varejista de m�quinas e aparelhos de usos dom�stico e pessoal, discos e instrumentos musicais','','',null,999999,1,0,1469492499626,'system'),
('52.43-4','Com�rcio varejista de m�veis, artigos de ilumina��o e outros artigos para resid�ncia','','',null,999999,1,0,1469492499626,'system'),
('52.44-2','Com�rcio varejista de material de constru��o, ferragens, ferramentas manuais e produtos metal�rgicos; vidros, espelhos e vitrais; tintas e madeiras','','',null,999999,1,0,1469492499626,'system'),
('52.45-0','Com�rcio varejista de equipamentos para escrit�rio; inform�tica e comunica��o, inclusive suprimentos','','',null,999999,1,0,1469492499626,'system'),
('52.46-9','Com�rcio varejista de livros, jornais, revistas e papelaria','','',null,999999,1,0,1469492499626,'system'),
('52.47-7','Com�rcio varejista de g�s liquefeito de petr�leo (GLP)','','',null,999999,1,0,1469492499626,'system'),
('52.49-3','Com�rcio varejista de outros produtos Não especificados anteriormente','','',null,999999,1,0,1469492499626,'system'),
('52.50-7','Com�rcio varejista de artigos usados, em lojas','','',null,999999,1,0,1469492499626,'system'),
('52.61-2','Com�rcio varejista de artigos em geral, por cat�logo, televis�o, internet e outros meios de comunica��o','','',null,999999,1,0,1469492499626,'system'),
('52.69-8','Com�rcio varejista realizado em vias p�blicas, postos m�veis e outros tipos Não realizados em lojas','','',null,999999,1,0,1469492499626,'system'),
('52.71-0','Repara��o e manuten��o de m�quinas e de aparelhos eletrodom�sticos','','',null,999999,1,0,1469492499626,'system'),
('52.72-8','Repara��o de cal�ados','','',null,999999,1,0,1469492499626,'system'),
('52.79-5','Repara��o de outros objetos pessoais e dom�sticos','','',null,999999,1,0,1469492499626,'system'),
('55.11-5','Estabelecimentos hoteleiros, com restaurante','','',null,999999,1,0,1469492499626,'system'),
('55.12-3','Estabelecimentos hoteleiros, sem restaurante','','',null,999999,1,0,1469492499626,'system'),
('55.19-0','Outros tipos de alojamento','','',null,999999,1,0,1469492499626,'system'),','','',null,999999,1,0,1469492499626,'system'),('55.21-2','Restaurantes e estabelecimentos de bebidas, com servi�o completo','','',null,999999,1,0,1469492499626,'system'),
('55.22-0','Lanchonetes e similares','','',null,999999,1,0,1469492499626,'system'),
('55.23-9','Cantinas (servi�os de alimenta��o privativos)','','',null,999999,1,0,1469492499626,'system'),
('55.24-7','Fornecimento de comida preparada','','',null,999999,1,0,1469492499626,'system'),
('55.29-8','Outros servi�os de alimenta��o','','',null,999999,1,0,1469492499626,'system'),
('60.10-0','Transporte ferrovi�rio interurbano','','',null,999999,1,0,1469492499626,'system'),
('60.21-6','Transporte ferrovi�rio de passageiros, urbano','','',null,999999,1,0,1469492499626,'system'),
('60.22-4','Transporte metrovi�rio','','',null,999999,1,0,1469492499626,'system'),
('60.23-2','Transporte rodovi�rio de passageiros, regular, urbano','','',null,999999,1,0,1469492499626,'system'),
('60.24-0','Transporte rodovi�rio de passageiros, regular, Não urbano','','',null,999999,1,0,1469492499626,'system'),
('60.25-9','Transporte rodovi�rio de passageiros, Não regular','','',null,999999,1,0,1469492499626,'system'),
('60.26-7','Transporte rodovi�rio de cargas, em geral','','',null,999999,1,0,1469492499626,'system'),
('60.27-5','Transporte rodovi�rio de produtos perigosos','','',null,999999,1,0,1469492499626,'system'),
('60.28-3','Transporte rodovi�rio de mudan�as','','',null,999999,1,0,1469492499626,'system'),
('60.29-1','Transporte regular em bondes, funiculares, telef�ricos ou trens pr�prios para explora��o de pontos tur�sticos','','',null,999999,1,0,1469492499626,'system'),
('60.30-5','Transporte dutovi�rio','','',null,999999,1,0,1469492499626,'system'),
('61.11-5','Transporte mar�timo de cabotagem','','',null,999999,1,0,1469492499626,'system'),
('61.12-3','Transporte mar�timo de longo curso','','',null,999999,1,0,1469492499626,'system'),
('61.21-2','Transporte por navega��o interior de passageiros','','',null,999999,1,0,1469492499626,'system'),
('61.22-0','Transporte por navega��o interior de carga','','',null,999999,1,0,1469492499626,'system'),
('61.23-9','Transporte aquavi�rio urbano','','',null,999999,1,0,1469492499626,'system'),
('62.10-3','Transporte a�reo, regular','','',null,999999,1,0,1469492499626,'system'),
('62.20-0','Transporte a�reo, Não regular','','',null,999999,1,0,1469492499626,'system'),
('62.30-8','Transporte espacial','','',null,999999,1,0,1469492499626,'system'),
('63.11-8','Carga e descarga','','',null,999999,1,0,1469492499626,'system'),
('63.12-6','Armazenamento e dep�sitos de cargas','','',null,999999,1,0,1469492499626,'system'),
('63.21-5','Atividades auxiliares aos transportes terrestres','','',null,999999,1,0,1469492499626,'system'),
('63.22-3','Atividades auxiliares aos transportes aquavi�rios','','',null,999999,1,0,1469492499626,'system'),
('63.23-1','Atividades auxiliares aos transportes a�reos','','',null,999999,1,0,1469492499626,'system'),
('63.30-4','Atividades de ag�ncias de viagens e organizadores de viagem','','',null,999999,1,0,1469492499626,'system'),
('63.40-1','Atividades relacionadas � organiza��o do transporte de cargas','','',null,999999,1,0,1469492499626,'system'),
('64.11-4','Atividades de Correio Nacional','','',null,999999,1,0,1469492499626,'system'),
('64.12-2','Outras atividades de correio','','',null,999999,1,0,1469492499626,'system'),
('64.20-3','Telecomunica��es','','',null,999999,1,0,1469492499626,'system'),
('65.10-2','Banco Central','','',null,999999,1,0,1469492499626,'system'),
('65.21-8','Bancos comerciais','','',null,999999,1,0,1469492499626,'system'),
('65.22-6','Bancos m�ltiplos (com carteira comercial)','','',null,999999,1,0,1469492499626,'system'),
('65.23-4','Caixas econ�micas','','',null,999999,1,0,1469492499626,'system'),
('65.24-2','Cr�dito cooperativo ','','',null,999999,1,0,1469492499626,'system'),
('65.31-5','Bancos m�ltiplos (sem carteira comercial)','','',null,999999,1,0,1469492499626,'system'),
('65.32-3','Bancos de investimento','','',null,999999,1,0,1469492499626,'system'),
('65.33-1','Bancos de desenvolvimento','','',null,999999,1,0,1469492499626,'system'),
('65.34-0','Cr�dito imobili�rio','','',null,999999,1,0,1469492499626,'system'),
('65.35-8','Sociedades de cr�dito, financiamento e investimento','','',null,999999,1,0,1469492499626,'system'),
('65.40-4','Arrendamento mercantil','','',null,999999,1,0,1469492499626,'system'),
('65.51-0','Ag�ncias de desenvolvimento','','',null,999999,1,0,1469492499626,'system'),
('65.59-5','Outras atividades de concess�o de cr�dito','','',null,999999,1,0,1469492499626,'system'),
('65.91-9','Fundos m�tuos de investimento','','',null,999999,1,0,1469492499626,'system'),
('65.92-7','Sociedades de capitaliza��o','','',null,999999,1,0,1469492499626,'system'),
('65.99-4','Outras atividades de intermedia��o financeira, Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('66.11-7','Seguros de vida','','',null,999999,1,0,1469492499626,'system'),
('66.12-5','Seguros Não-vida','','',null,999999,1,0,1469492499626,'system'),
('66.13-3','Resseguros','','',null,999999,1,0,1469492499626,'system'),
('66.21-4','Previd�ncia privada fechada','','',null,999999,1,0,1469492499626,'system'),
('66.22-2','Previd�ncia privada aberta','','',null,999999,1,0,1469492499626,'system'),
('66.30-3','Planos de sa�de','','',null,999999,1,0,1469492499626,'system'),
('67.11-3','Administra��o de mercados burs�teis','','',null,999999,1,0,1469492499626,'system'),
('67.12-1','Atividades de intermedi�rios em transa��es de t�tulos e valores mobili�rios','','',null,999999,1,0,1469492499626,'system'),
('67.19-9','Outras atividades auxiliares da intermedia��o financeira, Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('67.20-2','Atividades auxiliares dos seguros e da previd�ncia privada','','',null,999999,1,0,1469492499626,'system'),
('70.10-6','Incorpora��o e compra e venda de im�veis','','',null,999999,1,0,1469492499626,'system'),
('70.20-3','Aluguel de im�veis','','',null,999999,1,0,1469492499626,'system'),
('70.31-9','Corretagem e avalia��o de im�veis','','',null,999999,1,0,1469492499626,'system'),
('70.32-7','Administra��o de im�veis por conta de terceiros','','',null,999999,1,0,1469492499626,'system'),
('70.40-8','Condom�nios prediais','','',null,999999,1,0,1469492499626,'system'),
('71.10-2','Aluguel de autom�veis','','',null,999999,1,0,1469492499626,'system'),
('71.21-8','Aluguel de outros meios de transporte terrestre','','',null,999999,1,0,1469492499626,'system'),
('71.22-6','Aluguel de embarca��es','','',null,999999,1,0,1469492499626,'system'),
('71.23-4','Aluguel de aeronaves','','',null,999999,1,0,1469492499626,'system'),
('71.31-5','Aluguel de m�quinas e equipamentos agr�colas','','',null,999999,1,0,1469492499626,'system'),
('71.32-3','Aluguel de m�quinas e equipamentos para constru��o e engenharia civil','','',null,999999,1,0,1469492499626,'system'),
('71.33-1','Aluguel de m�quinas e equipamentos para escrit�rios','','',null,999999,1,0,1469492499626,'system'),
('71.39-0','Aluguel de m�quinas e equipamentos de outros tipos, Não especificados anteriormente','','',null,999999,1,0,1469492499626,'system'),
('71.40-4','Aluguel de objetos pessoais e dom�sticos','','',null,999999,1,0,1469492499626,'system'),
('72.10-9','Consultoria em sistemas de inform�tica','','',null,999999,1,0,1469492499626,'system'),
('72.20-6','Desenvolvimento de programas de inform�tica','','',null,999999,1,0,1469492499626,'system'),
('72.30-3','Processamento de dados','','',null,999999,1,0,1469492499626,'system'),
('72.40-0','Atividades de banco de dados','','',null,999999,1,0,1469492499626,'system'),
('72.50-8','Manuten��o e repara��o de m�quinas de escrit�rio e de inform�tica','','',null,999999,1,0,1469492499626,'system'),
('72.90-7','Outras atividades de inform�tica, Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('73.10-5','Pesquisa e desenvolvimento das ci�ncias f�sicas e naturais','','',null,999999,1,0,1469492499626,'system'),
('73.20-2','Pesquisa e desenvolvimento das ci�ncias sociais e humanas','','',null,999999,1,0,1469492499626,'system'),
('74.11-0','Atividades jur�dicas','','',null,999999,1,0,1469492499626,'system'),
('74.12-8','Atividades de contabilidade e auditoria','','',null,999999,1,0,1469492499626,'system'),
('74.13-6','Pesquisas de mercado e de opini�o p�blica','','',null,999999,1,0,1469492499626,'system'),
('74.14-4','Gest�o de participa��es societ�rias (holdings)','','',null,999999,1,0,1469492499626,'system'),
('74.15-2','Sedes de empresas e unidades administrativas locais','','',null,999999,1,0,1469492499626,'system'),
('74.16-0','Atividades de assessoria em gest�o empresarial','','',null,999999,1,0,1469492499626,'system'),
('74.20-9','Servi�os de arquitetura e engenharia e de assessoramento t�cnico especializado','','',null,999999,1,0,1469492499626,'system'),
('74.30-6','Ensaios de materiais e de produtos; an�lise de qualidade','','',null,999999,1,0,1469492499626,'system'),
('74.40-3','Publicidade','','',null,999999,1,0,1469492499626,'system'),
('74.50-0','Sele��o, agenciamento e loca��o de m�o-de-obra ','','',null,999999,1,0,1469492499626,'system'),
('74.60-8','Atividades de investiga��o, vigil�ncia e seguran�a','','',null,999999,1,0,1469492499626,'system'),
('74.70-5','Atividades de limpeza em pr�dios e domic�lios','','',null,999999,1,0,1469492499626,'system'),
('74.91-8','Atividades fotogr�ficas','','',null,999999,1,0,1469492499626,'system'),
('74.92-6','Atividades de envasamento e empacotamento, por conta de terceiros','','',null,999999,1,0,1469492499626,'system'),
('74.99-3','Outras atividades de servi�os prestados principalmente �s empresas, Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('75.11-6','Administra��o p�blica em geral','','',null,999999,1,0,1469492499626,'system'),
('75.12-4','Regula��o das atividades sociais e culturais','','',null,999999,1,0,1469492499626,'system'),
('75.13-2','Regula��o das atividades econ�micas','','',null,999999,1,0,1469492499626,'system'),
('75.14-0','Atividades de apoio � administra��o p�blica','','',null,999999,1,0,1469492499626,'system'),
('75.21-3','Rela��es exteriores','','',null,999999,1,0,1469492499626,'system'),
('75.22-1','Defesa','','',null,999999,1,0,1469492499626,'system'),
('75.23-0','Justi�a','','',null,999999,1,0,1469492499626,'system'),
('75.24-8','Seguran�a e ordem p�blica','','',null,999999,1,0,1469492499626,'system'),
('75.25-6','Defesa Civil','','',null,999999,1,0,1469492499626,'system'),
('75.30-2','Seguridade social','','',null,999999,1,0,1469492499626,'system'),
('80.11-0','Educa��o pr�-escolar','','',null,999999,1,0,1469492499626,'system'),
('80.12-8','Educa��o fundamental','','',null,999999,1,0,1469492499626,'system'),
('80.21-7','Educa��o m�dia de forma��o geral','','',null,999999,1,0,1469492499626,'system'),
('80.22-5','Educa��o m�dia de forma��o t�cnica e profissional','','',null,999999,1,0,1469492499626,'system'),
('80.30-6','Educa��o superior','','',null,999999,1,0,1469492499626,'system'),
('80.91-8','Ensino em auto-escolas e cursos de pilotagem','','',null,999999,1,0,1469492499626,'system'),
('80.92-6','Educa��o supletiva','','',null,999999,1,0,1469492499626,'system'),
('80.93-4','Educa��o continuada ou permanente e aprendizagem profissional','','',null,999999,1,0,1469492499626,'system'),
('80.94-2','Ensino � dist�ncia','','',null,999999,1,0,1469492499626,'system'),
('80.95-0','Educa��o especial','','',null,999999,1,0,1469492499626,'system'),
('85.11-1','Atividades de atendimento hospitalar','','',null,999999,1,0,1469492499626,'system'),
('85.12-0','Atividades de atendimento a urg�ncias e emerg�ncias','','',null,999999,1,0,1469492499626,'system'),
('85.13-8','Atividades de aten��o ambulatorial','','',null,999999,1,0,1469492499626,'system'),
('85.14-6','Atividades de servi�os de complementa��o diagn�stica ou terap�utica','','',null,999999,1,0,1469492499626,'system'),
('85.15-4','Atividades de outros profissionais da �rea de sa�de','','',null,999999,1,0,1469492499626,'system'),
('85.16-2','Outras atividades relacionadas com a aten��o � sa�de','','',null,999999,1,0,1469492499626,'system'),
('85.20-0','Servi�os veterin�rios','','',null,999999,1,0,1469492499626,'system'),
('85.31-6','Servi�os sociais com alojamento','','',null,999999,1,0,1469492499626,'system'),
('85.32-4','Servi�os sociais sem alojamento','','',null,999999,1,0,1469492499626,'system'),
('90.00-0','Limpeza urbana e esgoto; e atividades conexas','','',null,999999,1,0,1469492499626,'system'),
('91.11-1','Atividades de organiza��es empresariais e patronais','','',null,999999,1,0,1469492499626,'system'),
('91.12-0','Atividades de organiza��es profissionais','','',null,999999,1,0,1469492499626,'system'),
('91.20-0','Atividades de organiza��es sindicais','','',null,999999,1,0,1469492499626,'system'),
('91.91-0','Atividades de organiza��es religiosas','','',null,999999,1,0,1469492499626,'system'),
('91.92-8','Atividades de organiza��es pol�ticas','','',null,999999,1,0,1469492499626,'system'),
('91.99-5','Outras atividades associativas, Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('92.11-8','Produ��o de filmes cinematogr�ficos e fitas de v�deo','','',null,999999,1,0,1469492499626,'system'),
('92.12-6','Distribui��o de filmes e de v�deos','','',null,999999,1,0,1469492499626,'system'),
('92.13-4','Proje��o de filmes e de v�deos','','',null,999999,1,0,1469492499626,'system'),
('92.21-5','Atividades de r�dio','','',null,999999,1,0,1469492499626,'system'),
('92.22-3','Atividades de televis�o','','',null,999999,1,0,1469492499626,'system'),
('92.31-2','Atividades de teatro, m�sica e outras atividades art�sticas e liter�rias','','',null,999999,1,0,1469492499626,'system'),
('92.32-0','Gest�o de salas de espet�culos','','',null,999999,1,0,1469492499626,'system'),
('92.39-8','Outras atividades de espet�culos, Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('92.40-1','Atividades de ag�ncias de not�cias','','',null,999999,1,0,1469492499626,'system'),
('92.51-7','Atividades de bibliotecas e arquivos','','',null,999999,1,0,1469492499626,'system'),
('92.52-5','Atividades de museus e conserva��o do patrim�nio hist�rico','','',null,999999,1,0,1469492499626,'system'),
('92.53-3','Atividades de jardins bot�nicos, zool�gicos, parques nacionais e reservas ecol�gicas','','',null,999999,1,0,1469492499626,'system'),
('92.61-4','Atividades desportivas','','',null,999999,1,0,1469492499626,'system'),
('92.62-2','Outras atividades relacionadas ao lazer','','',null,999999,1,0,1469492499626,'system'),
('93.01-7','Lavanderias e tinturarias','','',null,999999,1,0,1469492499626,'system'),
('93.02-5','Cabeleireiros e outros tratamentos de beleza','','',null,999999,1,0,1469492499626,'system'),
('93.03-3','Atividades funer�rias e conexas','','',null,999999,1,0,1469492499626,'system'),
('93.04-1','Atividades de manuten��o do f�sico corporal','','',null,999999,1,0,1469492499626,'system'),
('93.09-2','Outras atividades de servi�os pessoais, Não especificadas anteriormente','','',null,999999,1,0,1469492499626,'system'),
('95.00-1','Servi�os dom�sticos','','',null,999999,1,0,1469492499626,'system'),
('99.00-7','Organismos internacionais e outras institui��es extraterritoriais','','',null,999999,1,0,1469492499626,'system');

