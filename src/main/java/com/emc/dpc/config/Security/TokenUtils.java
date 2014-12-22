package com.emc.dpc.config.Security;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenUtils {

	String getToken(UserDetails userDetails);
    String getToken(UserDetails userDetails, Long expiration);
    boolean validate(String token);
    UserDetails getUserFromToken(String token);
}
