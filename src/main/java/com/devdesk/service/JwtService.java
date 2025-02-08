package com.devdesk.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	//@Value("jwt.secertKey")
	private String secretKey;
	
	
	public JwtService() {
		secretKey = generateSecretKey();
	}


	private String generateSecretKey() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey secretKey = keyGen.generateKey();
			return Base64.getEncoder().encodeToString(secretKey.getEncoded());
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error while generating secret key : ",e);
		}
		catch (Exception e) {
			System.out.println("Exception occured while generating secret key for JWT Token");
			e.printStackTrace();
		}
		return "";
	}
	
	public String generateToken(String username) {
		Map<String,Object> claims = new HashMap<>();
		
		return Jwts.builder()
				   .setClaims(claims)
				   .setSubject(username)
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis() + 1000*60*3))
				   .signWith(getKey(),SignatureAlgorithm.HS256).compact();
	}

	private Key getKey() {
		byte keyBytes[] = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String getUserNameFromToken(String jwtToken) {
		return extractClaim(jwtToken,Claims::getSubject);
	}


	private <T> T extractClaim(String jwtToken, Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(jwtToken);
		return claimResolver.apply(claims);
	}


	private Claims extractAllClaims(String jwtToken) {
		return Jwts.parserBuilder()
				   .setSigningKey(getKey())
				   .build().parseClaimsJwt(jwtToken).getBody();
	}
	
	public Date getExpirationDateFromToken(String jwtToken) {
		return extractClaim(jwtToken, Claims::getExpiration);
	}
	
	private Boolean isTokenExpired(String jwtToken) {
		return getExpirationDateFromToken(jwtToken).before(new Date());
	}
	
	public boolean validateToken(String jwtToken, UserDetails userDetails) {
		final String usernameFromToken = getUserNameFromToken(jwtToken);
		return (usernameFromToken.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
	}
	
}
