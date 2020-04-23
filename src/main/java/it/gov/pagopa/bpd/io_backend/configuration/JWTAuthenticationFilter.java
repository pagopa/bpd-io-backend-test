package it.gov.pagopa.bpd.io_backend.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private static final Pattern authorizationPattern = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+)=*$");

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        resolveFromAuthorizationHeader(httpServletRequest);
//                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


    private String resolveFromAuthorizationHeader(HttpServletRequest request) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer")) {
            Matcher matcher = authorizationPattern.matcher(authorization);

            if (!matcher.matches()) {

//            BearerTokenError error = new BearerTokenError(BearerTokenErrorCodes.INVALID_TOKEN,
//            HttpStatus.UNAUTHORIZED,
//            "Bearer token is malformed",
//            "https://tools.ietf.org/html/rfc6750#section-3.1");
                throw new RuntimeException();
            }
            return matcher.group("token");
        }
        return null;
    }
}
