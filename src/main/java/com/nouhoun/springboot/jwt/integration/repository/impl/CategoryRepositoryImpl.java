package com.nouhoun.springboot.jwt.integration.repository.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.data.BaseHibernateJPARepository;
import com.nouhoun.springboot.jwt.integration.domain.Category;
import com.nouhoun.springboot.jwt.integration.repository.CategoryRepository;

/**
 * Created by Y.Kamesh on 8/2/2015.
 */
@Repository
public class CategoryRepositoryImpl extends BaseHibernateJPARepository<Category, Long> implements CategoryRepository {
    private static Logger LOG = LoggerFactory.getLogger(CategoryRepositoryImpl.class);

    @PostConstruct
    public void setUp() {
        LOG.info("categoryRepository created..!");
    }

    @Override
    public Category findByCategoryName(String categoryName) {
//        return (Category) sessionFactory.getCurrentSession().createQuery("from Category c where c.name = :categoryName")
//                .setParameter("categoryName", categoryName).uniqueResult();
    	 return null;
    }

    @Override
    public Category findByCategoryPriority(Integer categoryPriority) {
//        return (Category) sessionFactory.getCurrentSession().createQuery("from Category c where c.priority = :categoryPriority")
//                .setParameter("categoryPriority", categoryPriority).uniqueResult();
    	 return null;
    }

    @Override
    public List<Category> findSubCategories(Category parentCategory) {
//        return (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category c where c.parentCategory = :parentCategory")
//                .setParameter("parentCategory", parentCategory).list();
    	 return null;
    }

	@Override
	public Category insert(Category object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category insertOrUpdate(Category object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Category object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Category> findAllByPage(int pageNum, int countPerPage, Order order) {
		// TODO Auto-generated method stub
		return null;
	}
}
