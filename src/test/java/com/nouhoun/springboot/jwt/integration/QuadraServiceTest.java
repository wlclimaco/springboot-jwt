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

import com.nouhoun.springboot.jwt.integration.domain.Role;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.JogoService;
import com.nouhoun.springboot.jwt.integration.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
public class QuadraServiceTest {


    @Mock
	private UserService userService;
	
    @Mock
	private JogoService jogoService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        List<User> dataList = new ArrayList<User>();
        
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
    	dataList.add(data);
//===========================================================================
    	User data2 = new User();
    	data2.setId(1);
    	data2.setUsername("User Name");
    	data2.setEmail("wlclimaco@gmail2.com");
    	data2.setPassword("password");
    	data2.setName("name");
    	data2.setLastName("lastName");
    	data2.setActive(1);
    	roles = new ArrayList<Role>();
    	roles.add(new Role("TESTE_ADMIN"));
    	roles.add(new Role("TESTE_PROD"));
    	data2.setRoles(roles);
    	data2.setIv("iv");
    	data2.setSalt("salt");
    	//data2.setNotificacoes(notificacoes);;
    	data2.setKeySize(10);
    	data2.setIterations(10);
    	data2.setLoginCount(2);
    	data2.setCurrentLoginAt(new Date());
    	data2.setLastLoginAt(new Date());
    	data2.setCurrentLoginIp("currentLoginIp");
    	data2.setLastLoginIp("lastLoginIp");
    	data2.setUpdatedAt(new Date());
    	data2.setEnabled(Boolean.TRUE);
    	data2.setIsGoleiro(Boolean.TRUE);
    	data2.setFoto("foto");
    	data2.setReceberNotificacoes(Boolean.TRUE);
    	data2.setEmpresaId(1);
    	dataList.add(data2);
//===========================================================================

        
        
        dataList.add(data);
        dataList.add(data2);
        Mockito.when(userService.findAllUser()).thenReturn(dataList);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void findAllUser() {
        List<User> batchData = userService.findAllUser();
        assertEquals(4, batchData.size());

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

}
