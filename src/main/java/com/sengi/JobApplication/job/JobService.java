package com.sengi.JobApplication.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    Void createAJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);

    // Job
}
