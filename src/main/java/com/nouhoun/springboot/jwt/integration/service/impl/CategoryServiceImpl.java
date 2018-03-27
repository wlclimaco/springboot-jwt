package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nouhoun.springboot.jwt.integration.data.BaseJPAServiceImpl;
import com.nouhoun.springboot.jwt.integration.domain.Category;
import com.nouhoun.springboot.jwt.integration.repository.CategoryRepository;
import com.nouhoun.springboot.jwt.integration.service.CategoryService;

import javassist.NotFoundException;

/**
 * Created by Y.Kamesh on 8/2/2015.
 */
@Service
@Transactional
public class CategoryServiceImpl extends BaseJPAServiceImpl<Category, Long> implements CategoryService {
    private static Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private @Autowired
    CategoryRepository categoryRepository;

    @PostConstruct
    public void setupService() {
        LOG.info("setting up categoryService...");
        this.baseJpaRepository = categoryRepository;
        this.entityClass = Category.class;
        this.baseJpaRepository.setupEntityClass(Category.class);
        LOG.info("categoryService created...");
    }


    @Override
    public boolean isCategoryPresent(String categoryName) {
        if (categoryRepository.findByCategoryName(categoryName) != null) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean isPriorityPresent(Integer categoryPriority) {
        if (categoryRepository.findByCategoryPriority(categoryPriority) != null) {
            return true;
        } else
            return false;
    }


	@Override
	public Category findByCategoryName(String categoryName)
			throws com.nouhoun.springboot.jwt.exception.NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Category> findSubCategories(Category parentCategory)
			throws com.nouhoun.springboot.jwt.exception.NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

   
}
