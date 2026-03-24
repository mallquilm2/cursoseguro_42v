package edu.cibertec.cursoseguro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        /* Método para accesos al login/logout con BD, perfil ADMIN.
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin((form -> form.permitAll()))
                .logout(logout -> logout.permitAll());
    return http.build();
    */
        //Permisos por rutas específicas y por ROL
        /*
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers("/cursoGrabar").hasRole("ADMIN")
                        .requestMatchers("/cursoEliminar").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll());
        return http.build();
        */

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ).csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.DELETE, "/cursos/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/cursos*").hasRole("ADMIN")
                        .requestMatchers("/**").permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();


    }


}
