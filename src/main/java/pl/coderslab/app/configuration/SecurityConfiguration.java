package pl.coderslab.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.coderslab.app.release.NewRelease;
import pl.coderslab.app.role.RoleRepository;
import pl.coderslab.app.user.SpringDataUserDetailsService;
import pl.coderslab.app.user.UserRepository;
import pl.coderslab.app.user.UserService;
import pl.coderslab.app.user.UserServiceImpl;

@Configuration
@ComponentScan(basePackages = "pl.coderslab.app")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab.app")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    UserService userService() {
        return new UserServiceImpl(userRepository,roleRepository,passwordEncoder());
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Bean
    public NewRelease newRelease() {
        return new NewRelease();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/logout").permitAll()
                .antMatchers("/*").permitAll()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/", true)
                .loginPage("/signin").permitAll()
                .and()
                .csrf().disable()
                .logout().logoutSuccessUrl("/");
    }
}
