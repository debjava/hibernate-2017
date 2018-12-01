//package com.ddlab.rnd.service.user;
//
//import java.io.Serializable;
//import java.util.List;
//
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ddlab.rnd.dao.ICoreDAO;
//import com.ddlab.rnd.entity.IEntity;
//import com.ddlab.rnd.service.ICoreService;
//
//
//@Transactional
//public abstract class AbstractUserService<E extends IEntity, K extends Serializable, D extends ICoreDAO<E, K>> implements ICoreService<E, K> {
//	
//	public abstract D getDao();
//	
//	public void save(E e) {
//		System.out.println("AbstractUserService : getDAO-11111111------------>"+getDao());
//		getDao().save(e);
//	}
//
//	public void saveAll(List<E> entities) {
//		
//	}
//
//	public void delete(E e) {
//		System.out.println("AbstractUserService : Coming to delete()....................");
//		getDao().delete(e);
//	}
//
//	public void deleteAll(List<E> entities) {
//		System.out.println("AbstractUserService : Coming to deleteAll()....................");
//	}
//
//	public List<E> getAll() {
//		System.out.println("AbstractUserService : Coming to getAll()....................");
//		return getDao().getAll();
//	}
//
//	public E getById(K id) {
//		System.out.println("AbstractUserService : Coming to getById()....................");
//		return getDao().getById(id);
//	}
//
//}
