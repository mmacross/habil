package mx.habil.support;

import java.io.Serializable;
import java.util.Collection;

public interface HabilDao<T extends HabilDto, I extends Serializable> {
	public void save(T dto) throws HabilDaoException;
	public void saveOrUpdate(T dto) throws HabilDaoException;
	public void delete(T dto) throws HabilDaoException;
	public void deleteAll(Collection<T> cltDto) throws HabilDaoException;
	public void update(T dto) throws HabilDaoException;	
	public T findByPk(I id);
}
