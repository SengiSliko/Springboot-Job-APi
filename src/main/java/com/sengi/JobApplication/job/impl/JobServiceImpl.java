package com.sengi.JobApplication.job.impl;

import com.sengi.JobApplication.job.Job;
import com.sengi.JobApplication.job.JobRepository;
import com.sengi.JobApplication.job.JobService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

   // private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    JobRepository jobRepository;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    @Transactional
    public void createAJob(Job job) {
        job.setId(null); // Ensure the ID is null for new entities
        jobRepository.save(job);
    }

    @Override
    public Job getJobByID(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {

        try{
            jobRepository.deleteById(id);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);


            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }


        return false;
    }
}
