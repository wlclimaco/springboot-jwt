package com.nouhoun.springboot.jwt.integration.repository.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nouhoun.springboot.jwt.integration.data.BaseHibernateJPARepository;
import com.nouhoun.springboot.jwt.integration.domain.Job;
import com.nouhoun.springboot.jwt.integration.repository.JobRepository;

/**
 * Created by Y.Kamesh on 8/2/2015.
 */
@Repository
public class JobRepositoryImpl extends BaseHibernateJPARepository<Job, Long> implements JobRepository {
    private static Logger LOG = LoggerFactory.getLogger(JobRepositoryImpl.class);

    @PostConstruct
    public void setUp() {
        LOG.info("jobRepository created..!");
    }

    @Override
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerPriority(int count) {
//        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
//        c.setMaxResults(count);
//        c.add(Restrictions.eq("status", Job.Status.NEW));
//        c.addOrder(Order.asc("categoryPriority"));
//        c.addOrder(Order.asc("submitTime"));
        return null;//c.list();
    }

    @Override
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerPriority(int count) {
//        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
//        c.setMaxResults(count);
//        c.add(Restrictions.eq("status", Job.Status.FAILED));
//        c.add(Restrictions.lt("retryCount", 4));
//        c.addOrder(Order.desc("categoryPriority"));
//        c.addOrder(Order.asc("submitTime"));
//        return c.list();
    	 return null;
    }

    @Override
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count) {
//        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
//        c.setMaxResults(count);
//        c.add(Restrictions.eq("status", Job.Status.NEW));
//        c.addOrder(Order.asc("submitTime"));
//        return c.list();
    	 return null;
    }

    @Override
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count) {
//        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
//        c.setMaxResults(count);
//        c.add(Restrictions.eq("status", Job.Status.FAILED));
//        c.addOrder(Order.asc("submitTime"));
//        return c.list();
    	 return null;
    }

	@Override
	public Job insert(Job object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job update(Job object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job insertOrUpdate(Job object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Job object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Job> findAllByPage(int pageNum, int countPerPage, Order order) {
		// TODO Auto-generated method stub
		return null;
	}
}
