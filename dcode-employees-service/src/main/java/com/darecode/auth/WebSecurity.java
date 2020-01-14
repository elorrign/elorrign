package com.darecode.auth;

//@Configuration
//@EnableWebSecurity
//public class WebSecurity  extends WebSecurityConfigurerAdapter {

//	private GoogleTokenVerifier googleTokenVerifier;

	
	//@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		
//		httpSecurity
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//			.cors().and()
//			.csrf().disable()
//			.authorizeRequests().antMatchers("index.html").permitAll()
//			.antMatchers("/employees/**").authenticated().and()
//				.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		
		
//		   httpSecurity
//        .authorizeRequests()
//           .antMatchers("index.html").permitAll()
         //  .antMatchers("/user/**").hasRoles("USER", "ADMIN") // can pass multiple roles
         //  .antMatchers("/admin/**").access("hasRole('ADMIN') and hasIpAddress('123.123.123.123')") // pass SPEL using access method
      //     .anyRequest().authenticated().and().addFilter(new JWTAuthenticationFilter(authenticationManager()));
//           .and()
//       .formLogin()
//           .loginUrl("/login")
//           .permitAll();
//		 ;
//	}


	//TODO: Implement https://developers.google.com/identity/risc
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//		return source;
//	}
//}