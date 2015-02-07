package mx.habil.support;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public abstract class HabilQl {
	
	private @Getter @Setter Map<String,String> queries;
	
	public String getQuery(String id){
		log.debug("begin");
		String query = (String)queries.get(id);
		if(query==null){
			throw new NullPointerException(id+" no está registrado.");
		}
		log.debug("end");
		return query;
	}
	
	
}
