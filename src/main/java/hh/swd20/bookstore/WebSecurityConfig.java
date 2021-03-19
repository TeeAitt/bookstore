package hh.swd20.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import hh.swd20.bookstore.webcontroller.UserDetailServiceImpl;


// With "WebSecurityConfig" the web application can be secured.
@Configuration  	// Configuration annotation tells the Spring boot that this is a config file.
@EnableWebSecurity	// Websecurity annotation enables the Spring web security.
@EnableGlobalMethodSecurity(prePostEnabled = true)  // This enables global method security. With it the delete method can be secured from unauthorized use (check BookController).
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// This autowires the UserDetailServiceImpl class which is used for bringing the user infromation for the authentication service (WebSecurityConfig).
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {  // With the "configure" method you can configure what end point needs authentication and what do not.
		http		// The "http" tells how the configured address starts.
		.authorizeRequests().antMatchers("/css/**").permitAll()  // With .antMatchers different end points can be defined, i.e. "/addbook", "/categorylist". The .permitAll means authentication is not needed.
		.and()      // With ".and" multiple rules can be applied. 
		.authorizeRequests().anyRequest().authenticated()   // This means that all other end points need an authentication, expect those excluded by .antMatchers and .permitAll
		.and()
	.formLogin()    // With .formLogin the login page can be configured.
		.loginPage("/login")
		.defaultSuccessUrl("/bookstore", true)
		.permitAll() // login page is available for everyone.
		.and()
	.logout()
		.permitAll();
	}
	
	// With this the user information will be brought and the user password will be encrypted by using BCryptPasswordEncoder.
	@Autowired	// userDetailsService brings the user information for the authentication service.
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	
	/**		This is only for demo purposes.
	*
	* // With "UserDetailsService" the WebSecurityConfig can be tested. Though it's only suitable for testing, not for production.
	* @Bean
	* @Override
	* public UserDetailsService userDetailsService() {
	*	List<UserDetails> users = new ArrayList();		// With this the test user "user" is created with a password and role, and at the end added into the "users" list.
	*	UserDetails user = User.withDefaultPasswordEncoder()  //
	*			.username("user")
	*			.password("user")
	*			.roles("USER")
	*			.build();
	*		
	*	users.add(user);
	*	
	*	user = User.withDefaultPasswordEncoder()
	*			.username("admin")
	*			.password("admin")
	*			.roles("USER", "ADMIN") // You can add more than one role.
	*			.build();
	*	
	*	users.add(user);
	*	
	*	return new InMemoryUserDetailsManager(users);  // With this the "users" list is added as a parameter.
	* }
	* 
	**/
	
}
