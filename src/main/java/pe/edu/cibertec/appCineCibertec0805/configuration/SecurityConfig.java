package pe.edu.cibertec.appCineCibertec0805.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;
import pe.edu.cibertec.appCineCibertec0805.service.UsuarioDetalleService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private final UsuarioDetalleService usuarioDetalleService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(usuarioDetalleService)
		.passwordEncoder(new BCryptPasswordEncoder());
		super.configure(auth);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/resources/**",
					"/static/**",
					"/css/**",
					"/js/**");
		super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.authorizeRequests()
		.antMatchers("/auth/login","/auth/registroUsuario")
		.permitAll()
		.antMatchers("/home").hasAuthority("admin").anyRequest()
		.authenticated()
		.and()
		.csrf()
		.disable()
		.formLogin().loginPage("/auth/login")
		.defaultSuccessUrl("/home")
		.usernameParameter("nomusuario")
		.passwordParameter("password")
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/auth/login")
		.and().exceptionHandling()
		.accessDeniedPage("/access-denied");
		
	}
// @Bean
//	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
//			http
//			.authorizeHttpRequests()
//			/*.antMatchers("/auth/login",
//					"/auth/registroUsuario",
//					"/auth/guardarUsuario",
//					"/resources/**",
//					"/static/**",
//					"/css/**",
//					"/js/**")*/
//			.antMatchers("/auth/login")
//			.permitAll()
//			.antMatchers("/auth/registroUsuario")
//			.permitAll()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin().loginPage("/auth/login")
//			.defaultSuccessUrl("/home")
//			.usernameParameter("nomusuario")
//			.passwordParameter("password")
//			.and()
//			.authenticationProvider(authenticationProvider());
//		
//		return http.build();
//	}
//
//	
//	@Bean
//	private AuthenticationProvider authenticationProvider() {
//		// TODO Auto-generated method stub
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider
//		.setUserDetailsPasswordService(usuarioDetalleService);
//		authenticationProvider
//		.setPasswordEncoder(new BCryptPasswordEncoder());
//		return authenticationProvider;
//	}
}
