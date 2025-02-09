package com.sengi.JobApplication.job;

import jakarta.persistence.*;

@Entity
@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String title;
    private String description;
    private String maxSalary;
    private String minSalary;
    private String location;

    public Job(){

    }
    public Job(String location, String minSalary, String maxSalary, String description, String title, Long id) {
        this.location = location;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
