package mx.habil.security;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@Data public class HabilUserDetails implements UserDetails{
	private static final long serialVersionUID = 20141104001L;
	
	private String username;
	private String password;
	private String commonName;
	private Collection<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
}
