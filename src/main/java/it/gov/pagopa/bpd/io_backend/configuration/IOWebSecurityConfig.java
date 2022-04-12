package it.gov.pagopa.bpd.io_backend.configuration;

import it.gov.pagopa.bpd.io_backend.filter.SubscriptionKeyFilter;
import it.gov.pagopa.bpd.io_backend.filter.SubscriptionKeyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class IOWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SubscriptionKeyProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        SubscriptionKeyFilter subscriptionKeyFilter =
                new SubscriptionKeyFilter(new AntPathRequestMatcher("/c/**"));
        subscriptionKeyFilter.setAuthenticationManager(authenticationManager());

        http.csrf().disable().cors().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().headers().cacheControl();

        http.authorizeRequests()
            .antMatchers("/**").permitAll()
            .antMatchers("/c/**").authenticated().and().addFilterBefore(
                    subscriptionKeyFilter,
                    AnonymousAuthenticationFilter.class)
                .authenticationProvider(authProvider);
    }

}
