package mx.habil.support.hbm;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import mx.habil.support.HabilDaoException;
import mx.habil.support.HabilDto;
import mx.habil.support.HabilQl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@CommonsLog
@Repository
@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
public abstract class HabilHbmDaoSupport<T extends HabilDto, I extends Serializable> extends HibernateDaoSupport implements HabilHbmDao<T, I>{
	

	private @Getter @Setter HabilQl ql;
	private final transient Class<T> entityClass;
	
	protected HabilHbmDaoSupport(final Class<T> entityClass) {
		log.debug("begin");
        this.entityClass = entityClass;
        log.debug("end");
    }
	
	public void save(@Valid T dto) throws HabilDaoException{
		log.debug("begin");
		getHibernateTemplate().save(dto);
		log.debug("end");
	}
	
	public void saveOrUpdate(@Valid T dto) throws HabilDaoException{
		log.debug("begin");				
		getHibernateTemplate().saveOrUpdate(dto);
		log.debug("end");
	}
	
	public void delete(T dto) throws HabilDaoException{
		log.debug("begin");
		
		getHibernateTemplate().delete(dto);
		log.debug("end");
	}
	
	public void deleteAll(Collection<T> cltDto) throws HabilDaoException{
		log.debug("begin");
		getHibernateTemplate().deleteAll(cltDto);
		log.debug("end");
	}
	
	public void update(@Valid T dto) throws HabilDaoException{
		log.debug("begin");
		getHibernateTemplate().update(dto);
		log.debug("end");
	}
	
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public void refrescar(T dto) throws HabilDaoException{
		log.debug("begin");
		getHibernateTemplate().refresh(dto);
		log.debug("end");
	}
	
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public T findByPk(I id){
		log.debug("begin");
		T result = null;
		result = getHibernateTemplate().get(entityClass, id);
		log.debug("end");
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	protected List<T> findByNamedParam(String queryString, String[] paramNames, Object[]values){
		log.debug("begin");
		List<T> result = (List<T>)getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
		log.debug("end");
		return result;
	}
		
}
