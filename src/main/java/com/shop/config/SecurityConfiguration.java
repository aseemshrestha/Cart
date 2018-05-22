package com.shop.config;


/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.shop.repository.UserRepository;
import com.shop.service.CustomUserDetailService;

@EnableGlobalMethodSecurity( prePostEnabled = true )
@EnableWebSecurity
@Configuration
@EnableJpaRepositories( basePackageClasses = UserRepository.class )
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

    @Autowired
    private CustomUserDetailService userDetailService;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailService)
            .passwordEncoder(getPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {//.antMatchers("**//*secure/**")
        httpSecurity
            .authorizeRequests()
            .authenticated()
            .anyRequest()
            .permitAll()
            .and()
            .formLogin()
            .loginPage("/ //signup")
            .permitAll();

        httpSecurity.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/assets/**");
    }

    private PasswordEncoder getPasswordEncoder()
    {
        return new PasswordEncoder() {

            public String encode(CharSequence charSequence)
            {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s)
            {

                return true;
            }

        };
    }

}
*/
