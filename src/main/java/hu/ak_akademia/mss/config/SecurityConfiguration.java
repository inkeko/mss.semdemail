package hu.ak_akademia.mss.config;

import hu.ak_akademia.mss.service.MssUserDetailService;
import hu.ak_akademia.mss.service.PasswordEncryption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final MssUserDetailService mssUserDetailService;

    public SecurityConfiguration(MssUserDetailService mssUserDetailService) {
        this.mssUserDetailService = mssUserDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(c -> c.ignoringAntMatchers("/h2-console/**", "/resources/**", "/static/**"))
                .authorizeRequests(a -> a
                        .antMatchers("/h2-console/**", "/resources/**").permitAll()
                        .antMatchers("/register/**", "/login/**").permitAll()
//                        .antMatchers("/home/**").hasAnyRole("CLIENT"))
                        /*
                         * use the above and don't add the string "ROLE_" in front of the text because Spring Security does it implicitly
                         * or use below and add the String "ROLE_".
                         * */
                        .antMatchers("/home/**").hasAnyAuthority("ROLE_CLIENT","ROLE_DOCTOR"))
                .formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/login").passwordParameter("password").usernameParameter("username")
                .defaultSuccessUrl("/home", true).permitAll()
//                .and().logout().logoutUrl("/login?logout").logoutSuccessUrl("/").clearAuthentication(true).permitAll()
                .and()
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .deleteCookies()
                        .invalidateHttpSession(true)
                        .permitAll()
                        .logoutSuccessUrl("/")
                )
                .headers(h -> h.frameOptions().sameOrigin())
                .userDetailsService(mssUserDetailService)
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncryption();
    }


}
