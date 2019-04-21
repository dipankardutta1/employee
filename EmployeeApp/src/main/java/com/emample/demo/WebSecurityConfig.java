package com.emample.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	  private DataSource dataSource;
	
	
	
	@Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery("select username, password, true from user where username=?")
	        .authoritiesByUsernameQuery("select distinct T5.username,T1.menu_url " + 
	        		"from menu T1 inner join menu_role_map T2 on T1.id=T2.menu_id " + 
	        		"inner join role T3 on T2.role_id=T3.id " + 
	        		"inner join user_role_map T4 on T3.id = T4.role_id "+
	        		"inner join user T5 on T4.user_id = T5.id " +
	        		"where T5.username=?")
	        .passwordEncoder(new BCryptPasswordEncoder());
	  }
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").access("hasAuthority('admin')")   /*hasRole('recruitment')*/
		.antMatchers("/employee").access("hasAuthority('employee')")
		.antMatchers("/dashboard").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl("/dashboard", true)
		.failureUrl("/login?denied")
		.usernameParameter("username").passwordParameter("password")
		.and()
		.logout().logoutSuccessUrl("/login?logout") 
		.and()
		.exceptionHandling().accessDeniedPage("/login?denied")
		.and().csrf().disable();
		
	}
	
	/*@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}*/

}
