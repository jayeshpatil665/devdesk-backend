package com.devdesk.security.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.devdesk.service.JwtService;
import com.devdesk.service.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	ApplicationContext context;

	@Autowired
	JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requesttokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		//JWT token is in the form of "Bearer token". removing Bearer word to get only token.
		if(requesttokenHeader != null && requesttokenHeader.startsWith("Bearer ")) {
			if(requesttokenHeader.startsWith("Bearer "))
				jwtToken = requesttokenHeader.substring(7);
			
			try {
				username = jwtService.getUserNameFromToken(jwtToken);
			}catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
				request.setAttribute("error", e.getMessage());
			}catch (ExpiredJwtException e) {
				System.out.println("JWT token has expired");
				request.setAttribute("error", e.getMessage());
			}catch (Exception e) {
				System.out.println("GOTCHA");
				request.setAttribute("error", e.getMessage());
			}
		}else {
			//System.out.println("JWT Token does not begin with Bearer String");
		}
		
		//once got token validate it
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = context.getBean(JwtUserDetailsService.class).loadUserByUsername(username);
			
			//if token is valid configure spring security to manually set authentication
			if(jwtService.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
																userDetails, null, userDetails.getAuthorities());
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				//After setting the Authentication in the context, we specify
				//that the current user is authenticated. So it passes the
				//Spring security Configurations successfully
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}else {
				System.out.println("Token didn't match with user");
			}
		}
		filterChain.doFilter(request, response);//continue filter chain
	}

}
