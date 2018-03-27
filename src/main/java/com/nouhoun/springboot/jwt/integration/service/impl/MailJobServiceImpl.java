package com.nouhoun.springboot.jwt.integration.service.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.data.BaseJPAServiceImpl;
import com.nouhoun.springboot.jwt.integration.domain.Job;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.repository.JobRepository;
import com.nouhoun.springboot.jwt.integration.service.MailJobService;

/**
 * @author: kameshr
 */
@Service
@Transactional
public class MailJobServiceImpl extends BaseJPAServiceImpl<Job, Long> implements MailJobService {
    private static Logger LOG = LoggerFactory.getLogger(MailJobServiceImpl.class);

    protected @Autowired
    JobRepository jobRepository;

    @PostConstruct
    public void setupService() {
        LOG.info("setting up mailJobService...");
        this.baseJpaRepository = jobRepository;
        this.entityClass = Job.class;
        this.baseJpaRepository.setupEntityClass(Job.class);
        LOG.info("mailJobService created...");
    }

    @Override
    public void sendConfirmationMail(User user) {

    }
}
