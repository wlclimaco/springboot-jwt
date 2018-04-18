package com.nouhoun.springboot.jwt.integration;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nouhoun.springboot.jwt.integration.domain.Jogo;
import com.nouhoun.springboot.jwt.integration.domain.Role;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.JogoService;
import com.nouhoun.springboot.jwt.integration.service.JogoUserService;
import com.nouhoun.springboot.jwt.integration.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
public class JogoServiceTest {

//	public void updateJogo(Jogo empresa);
//	public void deleteJogo(Jogo empresa);
//	public List<Jogo> findJogoByUser(Jogo empresa);
//	public Jogo findJogoById(Integer empresa);
//	public List<Jogo> findAllJogo();
//	public List<Jogo> findJogoByUser(User user);
//	public List<JogoPorData> findJogoPorDataUserConfirmDTO(Integer JogoId, Date dataJogo);
//	void saveJogo(List<Jogo> jogos);
//	void saveUpdateJogo(Jogo jogos);
//	void saveJogoPorData(List<JogoPorData> jogos);
//	void saveJogoPorData(JogoPorData jogoPorData);
//	public void updateStatus(Status indisponivel, Integer id);
    @Mock
	private UserService userService;
    
    @Mock
	private JogoUserService jogoUserService;
	
    @Mock
	private JogoService jogoService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        List<Jogo> dataList = new ArrayList<Jogo>();
        
        dataList.add(listJogo(1));
        dataList.add(listJogo(2));
        Mockito.when(jogoService.findJogoByUser(listJogo(1))).thenReturn(dataList);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void findAllUser() {
        List<Jogo> batchData = jogoService.findJogoByUser(listJogo(1));
        assertEquals(1, batchData.size());

    }
    
    @Before
    public void setUp2() {
    	User data = new User();

    	data.setId(1);
    	data.setUsername("User Name");
    	data.setEmail("wlclimaco@gmail.com");
    	data.setPassword("password");
    	data.setName("name");
    	data.setLastName("lastName");
    	data.setActive(1);
    	List<Role> roles = new ArrayList<Role>();
    	roles.add(new Role("TESTE_ADMIN"));
    	roles.add(new Role("TESTE_PROD"));
    	data.setRoles(roles);
    	data.setIv("iv");
    	data.setSalt("salt");
    	//data.setNotificacoes(notificacoes);;
    	data.setKeySize(10);
    	data.setIterations(10);
    	data.setLoginCount(2);
    	data.setCurrentLoginAt(new Date());
    	data.setLastLoginAt(new Date());
    	data.setCurrentLoginIp("currentLoginIp");
    	data.setLastLoginIp("lastLoginIp");
    	data.setUpdatedAt(new Date());
    	data.setEnabled(Boolean.TRUE);
    	data.setIsGoleiro(Boolean.TRUE);
    	data.setFoto("foto");
    	data.setReceberNotificacoes(Boolean.TRUE);
    	data.setEmpresaId(1);
     
        Mockito.when(userService.findUserByEmail("wlclimaco@gmail.com"))
          .thenReturn(data);
    }

    @Test
    public void findUserByEmail() {
    	
    	
        User batchData = userService.findUserByEmail("wlclimaco@gmail.com");
        assertEquals("wlclimaco@gmail.com", batchData.getEmail());

    }
    
 public Jogo listJogo(Integer id){
    	
	 Jogo jogo = new Jogo();
//    	empresa.setId(id);
//    	empresa.setNome("nome");
//    	empresa.setNomeResponsavel("nomeResponsavel");
//    	empresa.setEmail(email);;
//    	empresa.setTelefone("telefone");
//    	Endereco endereco = new Endereco();
//    	endereco.setId(id + 1000);
//    	endereco.setBairro("bairro");
//    	endereco.setCidade("cidade");
//    	endereco.setEstadoId(1);
//    	endereco.setLat("5441454141");
//    	endereco.setLongi("5417854");  	
//    	empresa.setEndereco(endereco);
//    	empresa.setEnderecoId(1);
//    	Quadra quadra = new Quadra();
//    	quadra.setCobertura(Cobertura.NAO  );
//    	quadra.setComBola(1);
//    	quadra.setDescricao("descricao");
//    	quadra.setEmpresaId(id);
//    	quadra.setNome("nome");
//    	quadra.setTempoJogo("90");
//    	quadra.setTipo(Tipo.GRAMA);
//    	quadra.setValor((float) 1.2);
//    	
//    	empresa.setQuadras(Arrays.asList(quadra));
    	
    	return jogo;
    }

}
