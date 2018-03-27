package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.data.BaseService;
import com.nouhoun.springboot.jwt.integration.domain.Job;
import com.nouhoun.springboot.jwt.integration.domain.User;

/**
 * @author: kameshr
 */
public interface MailJobService extends BaseService<Job, Long> {

    /**
     * Sends the confirmation mail to user.
     *
     * @param user
     */
    public void sendConfirmationMail(User user);
}
