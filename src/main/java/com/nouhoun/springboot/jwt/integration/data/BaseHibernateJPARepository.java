package com.nouhoun.springboot.jwt.integration.data;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Generic CRUD Repository class functionality with Hibernate Session Factory
 *
 * Created by Y.Kamesh on 8/2/2015.
 */
@Repository
@Transactional
public abstract class BaseHibernateJPARepository<T extends Entity, ID extends Serializable> implements BaseJPARepository<T, ID> {

	//@Autowired
 //   private Session sessionFactory;

    protected Class<T> clazz;


    @SuppressWarnings("unchecked")
    public void setupEntityClass(Class clazz) {
        this.clazz = clazz;
    }


//    public void delete(T object) {
//    	((Object) sessionFactory).getCurrentSession().delete(object);
//    }
//
//
//    @Transactional
//    public T insert(T object) {
//    	
//    	Session sess = sessionFactory.
//    	 Transaction tx;
//    	 tx = sess.beginTransaction();
//    	 try {
//    	     
//    	     //do some work
//    		 sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
//    		 sessionFactory.getCurrentSession().save(object);
//    		 sessionFactory.getCurrentSession().flush();
//    	     tx.commit();
//    	 }
//    	 catch (Exception e) {
//    	     if (tx!=null) tx.rollback();
//    	     throw e;
//    	 }
//    	 finally {
//    	     sess.close();
//    	 }
//    	
//
//        return object;
//    }
//
//
//    @Transactional
//    public T update(T object) {
//    	sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
//    	sessionFactory.getCurrentSession().update(object);
//    	sessionFactory.getCurrentSession().flush();
//        return object;
//    }
//
//
//    @Transactional
//    public T insertOrUpdate(T object) {
//    	sessionFactory.getCurrentSession().setFlushMode(FlushMode.AUTO);
//    	sessionFactory.getCurrentSession().saveOrUpdate(object);
//    	sessionFactory.getCurrentSession().flush();
//        return object;
//    }
//
//
//    @Transactional(readOnly = true)
//    public T findById(ID id) {
//        return (T) sessionFactory.getCurrentSession().get(clazz, id);
//    }
//
//
//    public Collection<T> findAllByPage(int pageNum, int countPerPage, Order order) {
//        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
//        c.setMaxResults(countPerPage);
//        c.setFirstResult(pageNum * countPerPage);
//        return c.list();
//    }
}
