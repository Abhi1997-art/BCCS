
 package com.service.banking.config;
  
  import org.springframework.context.annotation.Configuration; 
  import org.springframework.http.HttpMethod;
  import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
  import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
  import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
  
  import com.service.banking.jwt.JWTAuthorizationFilter;
  
  @EnableWebSecurity
  @Configuration
  public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  
  http.csrf().disable() .addFilterAfter(new JWTAuthorizationFilter(),
  UsernamePasswordAuthenticationFilter.class) .authorizeRequests()
  .antMatchers(HttpMethod.POST, "/service/login").permitAll()
  //.antMatchers(HttpMethod.GET, "/dashboard/**").permitAll()
  .anyRequest().authenticated();
 
  }
  
  @Override
  public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/service/dashboard/**");
      web.ignoring().antMatchers("/service/hod_authority/**");
      web.ignoring().antMatchers("/service/stock/**");
    //  web.ignoring().antMatchers("/testkkkkkk/**");
      web.ignoring().antMatchers("/service/printing/**");
      web.ignoring().antMatchers("/service/gst/**");
      web.ignoring().antMatchers("/service/accounts/**");
      web.ignoring().antMatchers("/service/mad/**");
      web.ignoring().antMatchers("/service/superadmin/**");
      web.ignoring().antMatchers("/service/transaction/**");
      web.ignoring().antMatchers("/service/report/**");
	web.ignoring().antMatchers("/v2/api-docs","/configuration/ui","/swagger-resources/**","/configuration/security","/swagger-ui.html","/webjars/**");
     

  }
  
  
  }
