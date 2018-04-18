package com.nouhoun.springboot.jwt.integration;



import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.nouhoun.springboot.jwt.integration.controller.UserController;
import com.nouhoun.springboot.jwt.integration.domain.Role;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@SpringBootTest(classes = SpringbootJwtApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)

public class UserControllerTest {


    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    
    @Autowired
	WebApplicationContext context;
 
    @MockBean
    private UserService userService;
    
	@InjectMocks
	UserController controller;
    
    @Before
	public void setUp() {
    	MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.addFilter(springSecurityFilterChain).build();
	}
    
    @Test
	public void greetingUnauthorized() throws Exception {
		// @formatter:off
		mvc.perform(get("/user/fetchAll")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized())
				.andExpect(jsonPath("$.error", is("unauthorized")));
		// @formatter:on
	}

	private String getAccessToken(String username, String password) throws Exception {
		String authorization = "Basic dGVzdGp3dGNsaWVudGlkOlhZN2ttem9OemwxMDA=";
		String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

//		
//	    MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//	    params.add("grant_type", "password");
//	    params.add("client_id", "fooClientIdPassword");
//	    params.add("username", username);
//	    params.add("password", password);
//	 
//	    ResultActions result 
//	      = mvc.perform(post("/oauth/token")
//	        .params(params)
//	        .with(httpBasic("fooClientIdPassword","secret"))
//	        .accept("application/json;charset=UTF-8"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().contentType("application/json;charset=UTF-8"));
//	 
//	    String resultString = result.andReturn().getResponse().getContentAsString();
		
		// @formatter:off
		String content = mvc
				.perform(
						post("/oauth/token")
								.header("Authorization", authorization)
								.contentType(
									"application/x-www-form-urlencoded")
								.accept(MediaType.APPLICATION_JSON)
								.param("username", "wlclimaco@gmail.com")
								.param("password", "jwtpass")
								.param("grant_type", "password")
								.param("scope", "read write")
								.param("client_id", "testjwtclientid")
								.param("client_secret", "XY7kmzoNzl100"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(contentType))
				.andExpect(jsonPath("$.access_token", is(notNullValue())))
				.andExpect(jsonPath("$.token_type", is(equalTo("bearer"))))
				.andExpect(jsonPath("$.refresh_token", is(notNullValue())))
				.andExpect(jsonPath("$.expires_in", is(greaterThan(4000))))
				.andExpect(jsonPath("$.scope", is(equalTo("read write"))))
				.andReturn().getResponse().getContentAsString();

		// @formatter:on

		return content.substring(17, 53);
	}

	@Test
	public void greetingAuthorized() throws Exception {
		String accessToken = getAccessToken("roy", "spring");

		// @formatter:off
		mvc.perform(get("/user/fetchAll")
				.header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.content", is("Hello, Roy!")));
		// @formatter:on

		// @formatter:off
		mvc.perform(get("/user/fetchAll")
				.header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(2)))
				.andExpect(jsonPath("$.content", is("Hello, Roy!")));
		// @formatter:on

		// @formatter:off
		mvc.perform(get("/user/fetchAll")
				.header("Authorization", "Bearer " + accessToken))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(3)))
				.andExpect(jsonPath("$.content", is("Hello, Roy!")));
		// @formatter:on
	}

	@Test
	public void usersEndpointAuthorized() throws Exception {
		// @formatter:off
		mvc.perform(get("/users")
				.header("Authorization", "Bearer " + getAccessToken("roy", "spring")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)));
		// @formatter:on
	}

	@Test
	public void usersEndpointAccessDenied() throws Exception {
		// @formatter:off
		mvc.perform(get("/users")
				.header("Authorization", "Bearer " + getAccessToken("craig", "spring")))
				.andExpect(status().is(403));
		// @formatter:on
	}
    
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
