package com.sengi.JobApplication.job;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class jobController {
    private JobService jobService;

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job> >findAll(){
        return  ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/hello")
    public ResponseEntity<String> createjob(@RequestBody Job job){
        try {
            jobService.createAJob(job);
            return new ResponseEntity<>("Job added successfully", HttpStatus.OK);
        } catch (Exception e) {
            // Log and handle the error
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){

        Job job = jobService.getJobByID(id);
        if(job != null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(job,HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> UpdateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated successfull",HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
