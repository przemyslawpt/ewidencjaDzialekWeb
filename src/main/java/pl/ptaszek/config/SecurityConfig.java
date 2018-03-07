package pl.ptaszek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Konfiguracja Security check ktora nie pozwala na otwieranie stron bez
 * zalogowania sie do systemu.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("asia")
				.password("asia").roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/lib/bootstrap/**", "/css/**", "/img/**", "/js/**").permitAll()
				.anyRequest().authenticated().and().authorizeRequests()
				.antMatchers("/konwersja", "/podgladDzialka", "/dodajDzialka", "/dodajDzialka", "/welcome",
						"/loginCheck", "/listaDzialek", "/zapiszDzialka", "/wyszukajDzialka")
				.hasRole("USER").and().formLogin().loginPage("/zaloguj").failureUrl("/zaloguj")
				.loginProcessingUrl("/zaloguj").permitAll().and().logout().logoutSuccessUrl("/listaDzialek");
	}

}