package com.nouhoun.springboot.jwt.integration;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Confirmacao;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Dias;
import com.nouhoun.springboot.jwt.integration.domain.Jogo.Status;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.JogoPorData.StatusJogoPorData;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.Admin;
import com.nouhoun.springboot.jwt.integration.domain.UserJogo2.StatusUser;
import com.nouhoun.springboot.jwt.integration.service.JogoService;



@RunWith(SpringJUnit4ClassRunner.class)
public class JogoServiceTest {


    @Mock
	private JogoService jogoService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        List<Jogo> dataList = new ArrayList<Jogo>();
        
        dataList.add(listJogo(1,2));
        dataList.add(listJogo(2,2));
        Mockito.when(jogoService.findAllJogo()).thenReturn(dataList);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void findAllUser() {
        List<Jogo> batchData = jogoService.findJogoByUser(2);
        assertEquals(0, batchData.size());

    }
    
//===========================================================================================
//    @Before
//    public void setupFindAllJogo() {
//        MockitoAnnotations.initMocks(this);
//        Mockito.when(jogoService.findAllJogo()).thenReturn(Arrays.asList(listJogo(1,2)));
//
//    }
    
    @Test
    public void findAllJogo() {
        List<Jogo> batchData = jogoService.findAllJogo();
        assertEquals(2, batchData.size());

    }
//===========================================================================================
//    @Before
//    public void setupFindJogoById() {
//        MockitoAnnotations.initMocks(this);
//        Mockito.when(jogoService.findJogoById(1)).thenReturn(listJogo(1,2));
//
//    }
    
    @Test
    public void findJogoById() {
        Jogo batchData = jogoService.findJogoById(1);
  //      assertEquals(1, batchData.getId());

    }
    
 public Jogo listJogo(Integer id,Integer user_id){
    	
	 Jogo jogo = new Jogo();

	 jogo.setId(id);
	 jogo.setNome("nome");
	 jogo.setDescricao("descricao");
	 jogo.setUsersJogo(Arrays.asList(new User(user_id,"Washington", "wlclimaco@gmail.com", "Luis", "Luis", 1,1)));
	 jogo.setUsersJogo2(Arrays.asList(new UserJogo2(user_id, id, StatusUser.CONFIRMADO , Admin.SIM)) );
	 jogo.setUser_id(user_id);
	 jogo.setMaximoConfirmados(1);
	 jogo.setJogos(Arrays.asList(new JogoPorData(new Date(),new Date(),id, user_id, StatusJogoPorData.ACONFIRMAR, 10,5,1)));
	 jogo.setAceitaExterno("aceitaExterno");
	 jogo.setConfirmacao(Confirmacao.ANUAL);
	 jogo.setQuadraId(1);
	 jogo.setHoraInicial("10:30");
	 jogo.setHoraFinal("11:30");
	 jogo.setDia(Dias.DOMINGO);
	 jogo.setStatus(Status.ACONFIRMAR);

    	return jogo;
    }

}
