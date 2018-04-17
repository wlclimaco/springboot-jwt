package com.nouhoun.springboot.jwt.integration;



import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.nouhoun.springboot.jwt.integration.controller.UserController;
import com.nouhoun.springboot.jwt.integration.domain.Role;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {


    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private UserService userService;
    
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
         
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
     
        List<User> allEmployees = Arrays.asList(data);
     
        Mockito.when(userService.findAllUser())
        .thenReturn(allEmployees);
        
//        mvc.perform(get("/api/employees")
//        		      .contentType(MediaType.APPLICATION_JSON))
//        		      .andExpect(status().isOk())
//        		      .andExpect(content()
//        		      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//        		      .andExpect(jsonPath("$[0].name", is("bob")));
     
        mvc.perform(get("/user/fetchAll")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
 //         .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
   //       .andExpect(jsonPath("$[0].name", is(data.getName())));
    }

}
