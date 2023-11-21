/*package com.sellby.sellby.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.URLEncoder;

@EnableOAuth2Sso
@Configuration
@Order(value = 0)
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/api/v1/**")
                .permitAll()
                .antMatchers("/", "/login**", "/error**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .deleteCookies()
                .invalidateHttpSession(true)
                .and()
                .csrf().ignoringAntMatchers("/api/v1/**");
    }

    @Bean
    public ResourceServerProperties resourceServerProperties() {
        // Create and configure the ResourceServerProperties bean
        ResourceServerProperties properties = new ResourceServerProperties();
        properties.setTokenInfoUri("your-token-info-uri"); // Set your token info URI

        return properties;
    }
}*/
