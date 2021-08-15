package br.com.serdin.config;

import br.com.serdin.Enum.TipoUsuario;
import br.com.serdin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = TipoUsuario.ADMIN.getDesc();

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // acessos públicos liberados
                .antMatchers( "/css/**", "/Dashboard/**", "/img/**").permitAll()
                .antMatchers("/").hasAuthority(ADMIN)
                .antMatchers("/logout").permitAll()

                // Login
                .anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/", true)
                .failureUrl("/login-error").permitAll().and().logout().logoutSuccessUrl("/logout").and().exceptionHandling()
                .accessDeniedPage("/acesso-negado").and().rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
