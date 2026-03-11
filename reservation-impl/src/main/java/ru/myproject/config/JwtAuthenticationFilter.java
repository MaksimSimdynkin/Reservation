package ru.myproject.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.myproject.entity.AppUsers;
import ru.myproject.repository.RepositoryAppUsers;

import java.io.IOException;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final AuthUtil authUtil;
    private final RepositoryAppUsers repository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("JwtAuthenticationFilter начал свою работу: {}", request.getRequestURI());

        final String authHeder = request.getHeader("Authorization");
        if(authHeder == null || !authHeder.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        final String user;
        final String token;

        token = authHeder.substring(7);
        user = authUtil.getUserNameFromToken(token);

        if (user != null && SecurityContextHolder.getContext().getAuthentication() == null){
            AppUsers users = repository.findByEmail(user).orElseThrow();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(users, null, users.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(request,response);
    }
}
