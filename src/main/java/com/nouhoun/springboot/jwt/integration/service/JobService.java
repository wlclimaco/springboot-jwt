package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.data.BaseService;
import com.nouhoun.springboot.jwt.integration.domain.Job;

/**
 * Created by Y.Kamesh on 8/2/2015.
 */
public interface JobService extends BaseService<Job, Long> {
    /**
     *
     * @param count
     * @return
     */
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerPriority(int count);

    /**
     *
     * @param count
     * @return
     */
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerPriority(int count);

    /**
     *
     * @param count
     * @return
     */
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count);

    /**
     *
     * @param count
     * @return
     */
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count);
}