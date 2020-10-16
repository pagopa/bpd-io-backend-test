package it.gov.pagopa.bpd.io_backend.filter;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SubscriptionKeyFilter extends AbstractAuthenticationProcessingFilter {

    public SubscriptionKeyFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException {

        String authorization = httpServletRequest.getHeader("ocp-apim-subscription-key");
        if (!StringUtils.hasText(authorization)) {
            throw new AuthenticationCredentialsNotFoundException("Token not found in Authorization Header");
        }

        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
               "test", new ArrayList<>()));
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

}