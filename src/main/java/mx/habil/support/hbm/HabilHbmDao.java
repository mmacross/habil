package mx.habil.support.hbm;

import java.io.Serializable;

import mx.habil.support.HabilDao;
import mx.habil.support.HabilDaoException;
import mx.habil.support.HabilDto;

public interface HabilHbmDao<T extends HabilDto, I extends Serializable> extends HabilDao<T, I>{
	public void refrescar(T dto) throws HabilDaoException;
}
