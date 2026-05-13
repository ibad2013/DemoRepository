package com.mecaps.blogApp.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final CustomerUserDeatailsService customerUserDeatailsService;

    public JwtAuthFilter(JwtService jwtService, CustomerUserDeatailsService customerUserDeatailsService) {
        this.jwtService = jwtService;
        this.customerUserDeatailsService = customerUserDeatailsService;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String token = null;
        String email =  null;
        if(authorization != null && authorization.startsWith("Bearer ")){
            token = authorization.substring(7);
            email = jwtService.getEmail(token);
        }
        if (token != null && email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            String tokenType = jwtService.getTokenType(token);
            if(!"accesstoken".equals(tokenType)){
                throw new RuntimeException("Invalid token type");
            }



            UserDetails userDetails = customerUserDeatailsService.loadUserByUsername(email);

              if(jwtService.IsTokenValid(token)){
                  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                          new UsernamePasswordAuthenticationToken(userDetails , null,
                                  userDetails.getAuthorities());
                  SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
              }
        }


        filterChain.doFilter(request,response);
    }

}