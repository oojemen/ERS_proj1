package com.revature.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

  private JwtConfig jwtConfig;



    private final TokenGenerator tokenGenerator;

    private final CustomUDService customUDService;


    public JwtAuthFilter(TokenGenerator tokenGenerator, CustomUDService customUDService) {
        this.tokenGenerator = tokenGenerator;
        this.customUDService = customUDService;
    }



/*
    public JwtAuthFilter(AuthenticationManager authenticationManager, JwtConfig jwtConfig, TokenGenerator tokenGenerator) {
        super(authenticationManager);
        this.jwtConfig = jwtConfig;
    }


 */


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       // getJWTFromRequest(request);
        String token = getJWTFromRequest(request);

       // String header = request.getHeader(jwtConfig.getHeader());


        if (token != null && tokenGenerator.validateToken(token)){

            String username = tokenGenerator.getUsernameFromToken(token);

            System.out.println(username);


            UserDetails userDetails = customUDService.loadUserByUsername(username);

            System.out.println(userDetails.getAuthorities());


            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            authenticationToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);



/*
        if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
            // Token is missing or invalid, continue with the next filter
            chain.doFilter(request, response);
            return;
        }

 */
    }

    private String getJWTFromRequest(HttpServletRequest request){

        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}