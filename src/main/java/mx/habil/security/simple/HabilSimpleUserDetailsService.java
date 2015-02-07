package mx.habil.security.simple;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import mx.habil.security.HabilUserDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@CommonsLog
public class HabilSimpleUserDetailsService implements UserDetailsService{
	private @Getter @Setter Map<String, HabilUserDetails> users;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		log.debug("begin");
		if(users==null){
			throw new HabilSimpleDataAccessException("No está inicializado el mapa con los usuarios.");
		}
		
		UserDetails user = users.get(username);
		if(user==null){
			throw new UsernameNotFoundException("No se encontró el usuario en el repositorio.");
		}
		log.debug("user:"+user);
		log.debug("end");
		return user;
	}
	
	
	class HabilSimpleDataAccessException extends RuntimeException{
		private static final long serialVersionUID = 1L;

		public HabilSimpleDataAccessException(String msg){
			super(msg);
		}
		public HabilSimpleDataAccessException(String msg, Throwable tr){
			super(msg,tr);
		}
	}
}
