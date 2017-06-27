package com.example.spring.security.example;

import com.example.spring.security.example.model.User;
import com.example.spring.security.example.model.UserAuthority;
import com.example.spring.security.example.repository.UserAuthRepository;
import com.example.spring.security.example.repository.UserRepository;
import com.example.spring.security.example.service.SystemUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application extends AbstractSecurityWebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SystemUserDetailService systemUserDetailService;

    @Override
    protected UserDetailsService userDetailsService() {
        return this.systemUserDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll();
    }
}

@Component
class InitRunner implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public InitRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UserAuthority admin = new UserAuthority("ADMIN");
        UserAuthority guest = new UserAuthority("GUEST");
        User adminUser = new User("admin", "password",
                true, false,
                true, true);
        adminUser.getAuthorities().add(admin);
        User guestUser = new User("guest", "password",
                true, false,
                true, true);
        guestUser.getAuthorities().add(guest);
        this.userRepository.save(adminUser);
        this.userRepository.save(guestUser);
    }
}
