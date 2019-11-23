package com.okravtsiv.gateway.config;

import com.okravtsiv.gateway.filters.FilterInterceptor;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class GatewaySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/eureka/**", "/discovery", "/authservice/**", "/actuator/**", "/configservice/**", "/operation-service/**", "/product-service/**", "/order-service/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public RequestInterceptor getUserFeignClientInterceptor() {
        return new FeignClientInterceptor();
    }

    @Bean
    public FilterInterceptor simpleFilter() {
        return new FilterInterceptor();
    }
}
