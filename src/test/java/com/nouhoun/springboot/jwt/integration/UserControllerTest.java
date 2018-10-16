package com.nouhoun.springboot.jwt.integration;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nouhoun.springboot.jwt.integration.config.JwtTokenUtil;
import com.nouhoun.springboot.jwt.integration.config.JwtUser;
import com.nouhoun.springboot.jwt.integration.config.JwtUserFactory;
import com.nouhoun.springboot.jwt.integration.config.service.JwtUserDetailsService;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;
import com.nouhoun.springboot.jwt.integration.domain.security.Authority;
import com.nouhoun.springboot.jwt.integration.domain.security.AuthorityName;
import com.nouhoun.springboot.jwt.integration.domain.security.User;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@SpringBootTest(classes = SpringbootJwtApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)

public class UserControllerTest {
	
	@Before
	public void setUp() {
		Authority au1 = new Authority(Long.MIN_VALUE);
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(au1);
		
		Notificacoes au1s = new Notificacoes();
		List<Notificacoes> notificacoes = new ArrayList<Notificacoes>();
		notificacoes.add(au1s);
		

		
	    User alex = new User(1, "username","password", "name","email",Boolean.TRUE, new Date(),
	    		authorities, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
				notificacoes, 1, 10, 5, new Double(10),
				new Double(5.5));
	    
	    
	 
//	    Mockito.when(jwtUserDetailsService.loadUserByUsername(alex.getUsername()))
//	      .thenReturn(alex);
	}

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void shouldGetUnauthorizedWithoutRole() throws Exception {

        mvc.perform(get("/user"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "USER")
    public void getPersonsSuccessfullyWithUserRole() throws Exception {

        Authority authority = new Authority();
        authority.setId(1L);
        authority.setName(AuthorityName.ROLE_ADMIN);
        List<Authority> authorities = Arrays.asList(authority);

        User user = new User();
        user.setUsername("username");
        user.setAuthorities(authorities);
        user.setEnabled(Boolean.TRUE);
        user.setLastPasswordResetDate(new Date(System.currentTimeMillis() + 1000 * 1000));

        JwtUser jwtUser = JwtUserFactory.create(user);

        when(jwtTokenUtil.getUsernameFromToken(any())).thenReturn(user.getUsername());

        when(jwtUserDetailsService.loadUserByUsername(eq(user.getUsername()))).thenReturn(jwtUser);

        mvc.perform(get("/user").header("Authorization", "Bearer nsodunsodiuv"))
                .andExpect(status().is2xxSuccessful());
    }

}
