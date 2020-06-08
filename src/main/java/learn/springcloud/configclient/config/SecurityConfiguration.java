package learn.springcloud.configclient.config;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println(" ********************************** in configure **********************************");
        http.authorizeRequests()
                .antMatchers("/merchant/**").hasRole("MERCHANT")
                .antMatchers("/user/**").hasRole("USER")

                .antMatchers("/ledger/**").hasRole("LEDGER")
                .antMatchers("/ledgerApi/**").hasRole("LEDGER")
                .antMatchers("/category/**").hasRole("LEDGER") 

                .antMatchers("/").permitAll()
                .and().formLogin();
                http.csrf().disable();
                http.logout().logoutSuccessUrl("/").permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
