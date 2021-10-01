package br.com.agenda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.agenda.service.AutenticacaoService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    AutenticacaoService userDetailService;
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailService).passwordEncoder(encoder());
    }
	
	@Override
    public void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().
		authorizeRequests().
//		antMatchers(HttpMethod.GET,"/contatos/*").
//		permitAll().
		antMatchers(HttpMethod.POST,"/contatos/**").
		permitAll().
		anyRequest().
		authenticated().
		and().
		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
	
	@Override
    public void configure(WebSecurity http) throws Exception{
    }
	
	@Bean
	public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
