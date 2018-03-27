package com.nouhoun.springboot.jwt.integration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
                
                http.
    			authorizeRequests()
    				.antMatchers("/").permitAll()
    				.antMatchers("/actuator/**", "/api-docs/**").permitAll()
                    .antMatchers("/springjwt/**" ).authenticated()
    				.antMatchers("/login").permitAll()
    				.antMatchers("/ws/**").permitAll()
    				.antMatchers("/ws/info/**").permitAll()
    				.antMatchers("/registration").permitAll()
    				.antMatchers("/upload").permitAll()
    				.antMatchers("/upload2").permitAll()
    				.antMatchers("/api/**").permitAll()
    				.antMatchers("/api/upload/multi").permitAll()
    				.antMatchers("/empresa/**").permitAll()
    				.antMatchers("/admin/**").permitAll()
    				.antMatchers("/jogo/**").permitAll()
    				.antMatchers("/user/**").permitAll()
    				.antMatchers("/quadra/**").permitAll()
    				.antMatchers("/notificacao/**").permitAll()
    				.antMatchers("/header").permitAll();
    			//	.antMatchers("/raxa/**").hasAuthority("ADMIN").anyRequest();
    			//	.authenticated().and().csrf().disable().formLogin()
    		//		.loginPage("/login").failureUrl("/login?error=true")
    		//		.defaultSuccessUrl("/admin/home2")
    		//		.usernameParameter("email")
    		//		.passwordParameter("password")
    		//		.and().logout()
    		//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    		//		.logoutSuccessUrl("/").and().exceptionHandling()
    		//		.accessDeniedPage("/access-denied");
    }
}
